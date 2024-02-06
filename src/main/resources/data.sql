INSERT INTO pais (id, nombre) VALUES (1, 'Argentina')
ON DUPLICATE KEY UPDATE nombre = nombre;

INSERT INTO pais(id,nombre) VALUES(2,'Uruguay')
ON DUPLICATE KEY UPDATE nombre = nombre;

INSERT INTO comitente (id, descripcion) VALUES (1, 'comitente 1')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (2, 'comitente 2')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (3, 'comitente 3')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (4, 'comitente 4')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (5, 'comitente 5')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (6, 'comitente 6')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (7, 'comitente 7')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (8, 'comitente 8')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (9, 'comitente 9')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO comitente (id, descripcion) VALUES (10, 'comitente 10')
ON DUPLICATE KEY UPDATE descripcion = descripcion;

INSERT INTO mercado (id, codigo, descripcion, pais_id) VALUES (1, 'MAE', 'Mercado abierto electrónico', 1)
ON DUPLICATE KEY UPDATE codigo = codigo;

INSERT INTO mercado (id, codigo, descripcion, pais_id) VALUES (2, 'ROFEX', 'Fondos comunes de inversión', 1)
ON DUPLICATE KEY UPDATE codigo = codigo;

INSERT INTO mercado (id, codigo, descripcion, pais_id) VALUES (3, 'UFEX', 'Mercado de futuros y opciones de Uruguay', 2)
ON DUPLICATE KEY UPDATE codigo = codigo;

INSERT INTO mercado_comitente (mercado_id, comitente_id) VALUES(1, 1)
ON DUPLICATE KEY UPDATE mercado_id = mercado_id;