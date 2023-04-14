USE railway;

DROP TABLE productos;

CREATE TABLE productos (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  rutaimagen VARCHAR(255),
  region VARCHAR(100),
  cosecha VARCHAR(100),
  altura VARCHAR(50),
  humedad INT,
  proceso VARCHAR(100),
  preparacion VARCHAR(100),
  variedad VARCHAR(100),
  nota VARCHAR(500),
  puntuacion INT,
  precio DOUBLE,
  inventario INT
);

INSERT INTO productos (nombre, rutaimagen, region, cosecha, altura, humedad, proceso, preparacion, variedad, precio, inventario, nota, puntuacion)
VALUES
('Café orgánico', 'product_1.png', 'Norte', 'Verano', '1500 msnm', 12, 'Lavado', 'Tostado medio', 'Arábica', 10.50, 100,'nota 1',50),
('Café gourmet', 'product_2.png', 'Sur', 'Invierno', '1200 msnm', 10, 'Natural', 'Tostado claro', 'Arábica', 15.00, 50,'nota 2',60),
('Café de especialidad', 'product_3.png', 'Centro', 'Otoño', '1300 msnm', 11, 'Honey', 'Tostado oscuro', 'Arábica', 12.75, 75,'nota 3',70),
('Café robusta', 'product_4.png', 'Este', 'Primavera', '1000 msnm', 13, 'Lavado', 'Tostado medio', 'Robusta', 8.25, 200,'nota 4',80),
('Té verde', 'product_5.png', 'Norte', 'Verano', '500 msnm', 8, 'Proceso chino', 'Infusión a 75°C', 'Sencha', 7.50, 150,'nota 5',90),
('Té negro', 'product_6.png', 'Sur', 'Invierno', '600 msnm', 9, 'Proceso indio', 'Infusión a 90°C', 'Assam', 9.25, 100,'nota 6',96),
('Té blanco', 'product_7.png', 'Centro', 'Otoño', '800 msnm', 7, 'Proceso chino', 'Infusión a 75°C', 'Bai Hao Yin Zhen', 12.00, 50,'nota 7',97),
('Té oolong', 'product_1.png', 'Este', 'Primavera', '1000 msnm', 11, 'Proceso taiwanés', 'Infusión a 85°C', 'Tie Guan Yin', 13.75, 25,'nota 8',98),
('Chocolate negro', 'product_2.png', 'Norte', 'Invierno', '-', 1, 'Conchado', 'Tableta', '70% cacao', 5.50, 75,'nota 9',99),
('Chocolate con leche', 'product_3.png', 'Sur', 'Verano', '-', 2, 'Conchado', 'Tableta', '50% cacao', 4.50, 100,'nota 10',100);

SELECT * FROM productos;