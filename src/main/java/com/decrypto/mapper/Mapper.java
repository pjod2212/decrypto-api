package com.decrypto.mapper;

import com.decrypto.dto.DistribucionComitentesDTO;
import com.decrypto.dto.MercadoRequestDTO;
import com.decrypto.dto.PercentageDTO;
import com.decrypto.entity.Comitente;
import com.decrypto.entity.Mercado;
import com.decrypto.entity.Pais;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class Mapper {

    public Mercado createMercado(MercadoRequestDTO mercadoRequestDTO, List<Comitente> comitentes) {
        return  Mercado.builder()
                .codigo(mercadoRequestDTO.getMercado().getCodigo())
                .pais(Pais.builder()
                        .id(mercadoRequestDTO.getMercado().getPais())
                        .build())
                .descripcion(mercadoRequestDTO.getMercado().getDescripcion())
                .comitentes(new HashSet<>(comitentes))
                .build();
    }

    public Mercado updateMercado(MercadoRequestDTO mercadoRequestDTO, List<Comitente> comitentes) {
        return  Mercado.builder()
                .id(mercadoRequestDTO.getMercado().getId())
                .codigo(mercadoRequestDTO.getMercado().getCodigo())
                .pais(Pais.builder()
                        .id(mercadoRequestDTO.getMercado().getPais())
                        .build())
                .descripcion(mercadoRequestDTO.getMercado().getDescripcion())
                .comitentes(new HashSet<>(comitentes))
                .build();
    }

    public List<DistribucionComitentesDTO> fillDistribucionComitentes(List<Tuple> tuples) {
        Map<String, DistribucionComitentesDTO> countryToDTO = new HashMap<>();

        tuples.forEach(tuple -> {
            String country = tuple.get("country", String.class);
            String market = tuple.get("market", String.class);
            BigDecimal percentage = tuple.get("percentage", BigDecimal.class);

            // Verifico si ya existe un DTO para el país actual
            DistribucionComitentesDTO dto = countryToDTO.get(country);
            if (dto == null) {
                // Si no existe, crear un nuevo DTO
                dto = new DistribucionComitentesDTO();
                dto.setCountry(country);
                dto.setMarket(new ArrayList<>());
                countryToDTO.put(country, dto);
            }

            PercentageDTO percentageDTO = new PercentageDTO();
            percentageDTO.setPercentage(String.format("%.2f", percentage));

            Map<String, PercentageDTO> marketMap = new HashMap<>();
            marketMap.put(market, percentageDTO);

            dto.getMarket().add(marketMap);
        });

        return new ArrayList<>(countryToDTO.values());
    }

}
