USE railway;

DROP TABLE usuarios;

CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    telefono VARCHAR(20),
    nacimiento VARCHAR(10),
    calle VARCHAR(50),
    numero VARCHAR(10),
    colonia VARCHAR(50),
    municipio VARCHAR(50),
    estado VARCHAR(50),
    codigoPostal VARCHAR(50),
    carritoProductos VARCHAR(200),
    carritoMolido VARCHAR(200),
    carritoTostado VARCHAR(200),
    carritoCantidad VARCHAR(200),
    esAdmin VARCHAR(5),
    PRIMARY KEY (id)
);

INSERT INTO usuarios (nombre, apellido, email, password, esAdmin)
VALUES ('Admin', 'Admin', 'admin@gmail.com', 'adminadmin', 'YES');

SELECT * FROM usuarios;