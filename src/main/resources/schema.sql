CREATE TABLE IF NOT EXISTS ubicacion (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    ciudad VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS usuario (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    correo VARCHAR(255),
    edad INTEGER,
    genero BOOLEAN
);

CREATE TABLE IF NOT EXISTS evento (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    descripcion VARCHAR(255),
    fecha VARCHAR(255),
    capacidad INTEGER
);

CREATE TABLE IF NOT EXISTS comentario (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    autor INTEGER,
    evento INTEGER,
    texto VARCHAR(255),
    fecha VARCHAR(255)
);
