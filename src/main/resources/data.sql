INSERT INTO pais (id, nombre) VALUES (1, 'Argentina')
ON DUPLICATE KEY UPDATE nombre = nombre;

INSERT INTO pais(id,nombre) VALUES(2,'Uruguay')
ON DUPLICATE KEY UPDATE nombre = nombre;

INSERT INTO comitente (id, descripcion) VALUES (1, 'MAE')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (2, 'ROFEX')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (3, 'UFEX')
ON DUPLICATE KEY UPDATE descripcion = descripcion;