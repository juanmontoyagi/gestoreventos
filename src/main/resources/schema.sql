CREATE TABLE IF NOT EXISTS ubicacion (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    ciudad VARCHAR(255),
    capacidad INTEGER
);

CREATE TABLE IF NOT EXISTS usuario (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    correo VARCHAR(255),
    edad INTEGER,
    genero INTEGER
);

CREATE TABLE IF NOT EXISTS evento (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    descripcion VARCHAR(255),
    fecha VARCHAR(255),
    estado VARCHAR(255),
    ubicacionId INTEGER,
    asistentes VARCHAR(255),
    FOREIGN KEY (ubicacionId) REFERENCES ubicacion(id)
);

CREATE TABLE IF NOT EXISTS comentario (
    id INTEGER PRIMARY KEY,
    autorId INTEGER,
    eventoId INTEGER,
    texto VARCHAR(255),
    fecha VARCHAR(255),
    FOREIGN KEY (autorId) REFERENCES usuario(id),
    FOREIGN KEY (eventoId) REFERENCES evento(id)
);


