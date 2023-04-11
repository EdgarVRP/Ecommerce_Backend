USE railway;

DROP TABLE ventas;

CREATE TABLE ventas (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idUsuario INT NOT NULL,
  idProducto INT NOT NULL,
  fechaEntrega VARCHAR(100),
  fechaPago VARCHAR(100),
  precioVenta VARCHAR(100),
  tostado INT,
  molido INT,
  FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario),
  FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);

SELECT * FROM ventas;