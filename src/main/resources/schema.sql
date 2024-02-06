-- decrypto.comitente definition

CREATE TABLE IF NOT EXISTS `comitente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bun1la1l2642aco9yrsafi257` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- decrypto.pais definition

CREATE TABLE IF NOT EXISTS `pais` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6yjd7o5t29ban947untn2ir2b` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- decrypto.mercado definition

CREATE TABLE IF NOT EXISTS `mercado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `pais_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9r0500v9uxkdb1l8npun4n2f` (`codigo`),
  KEY `FKihtgtm94ub1rlfm8r632ruk4y` (`pais_id`),
  CONSTRAINT `FKihtgtm94ub1rlfm8r632ruk4y` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- decrypto.mercado_comitente definition

CREATE TABLE IF NOT EXISTS `mercado_comitente` (
  `mercado_id` bigint(20) NOT NULL,
  `comitente_id` bigint(20) NOT NULL,
  PRIMARY KEY (`mercado_id`,`comitente_id`),
  KEY `FKkcqglf49g3i33h9vgm8q67dsl` (`comitente_id`),
  CONSTRAINT `FKicnhnjdlm4w84uv4b73uuhmi8` FOREIGN KEY (`mercado_id`) REFERENCES `mercado` (`id`),
  CONSTRAINT `FKkcqglf49g3i33h9vgm8q67dsl` FOREIGN KEY (`comitente_id`) REFERENCES `comitente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;