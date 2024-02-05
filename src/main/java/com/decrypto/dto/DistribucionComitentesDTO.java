package com.decrypto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistribucionComitentesDTO {

    private String country;
    private List<Map<String, PercentageDTO>> market;

}
