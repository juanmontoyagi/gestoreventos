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

INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Casa de la Cultura', 'Calle 24 # 8-55', 'Bogotá');
INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Teatro Colón', 'Calle 10 # 5-32', 'Bogotá');
INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Teatro Jorge Eliécer Gaitán', 'Carrera 7 # 22-47', 'Bogotá');
INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Teatro Mayor Julio Mario Santo Domingo', 'Calle 170 # 67-51', 'Bogotá');
INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Teatro Nacional Fanny Mikey', 'Calle 71 # 10-25', 'Bogotá');
INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Teatro Pablo Tobón Uribe', 'Carrera 40 # 51-24', 'Medellín');
INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Teatro Metropolitano', 'Carrera 41 # 57-30', 'Medellín');
INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Teatro Lido', 'Carrera 46 # 51-15', 'Medellín');
INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Teatro Pablo Tobón Uribe', 'Carrera 40 # 51-24', 'Medellín');
INSERT INTO ubicacion (nombre, direccion, ciudad) VALUES ('Teatro Metropolitano', 'Carrera 41 # 57-30', 'Medellín');

INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Juan', 'juan@email.com', 18, true);
INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Pedro', 'pedro@email.com', 23, true);
INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Alberto', 'alberto@email.com', 23, true);
INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Sandra', 'sandra@email.com', 26, false);
INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Alejandra', 'alejandra@email.com', 28, false);
INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Ana', 'ana@email.com', 21, false);
INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Maria', 'maria@email.com', 30, false);
INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Fernando', 'fernando@email.com', 32, true);
INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Michelle', 'michelle@email.com', 22, false);
INSERT INTO usuario (nombre, correo, edad, genero) VALUES ('Oscar', 'oscar@email.com', 28, true);

INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de rock', 'Concierto de rock en el teatro', '2021-10-10', 100);
INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de salsa', 'Concierto de salsa en el teatro', '2021-10-11', 100);
INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de jazz', 'Concierto de jazz en el teatro', '2021-10-12', 100);
INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de pop', 'Concierto de pop en el teatro', '2021-10-13', 100);
INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de reggaeton', 'Concierto de reggaeton en el teatro', '2021-10-14', 100);
INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de vallenato', 'Concierto de vallenato en el teatro', '2021-10-15', 100);
INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de merengue', 'Concierto de merengue en el teatro', '2021-10-16', 100);
INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de cumbia', 'Concierto de cumbia en el teatro', '2021-10-17', 100);
INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de reggae', 'Concierto de reggae en el teatro', '2021-10-18', 100);
INSERT INTO evento (titulo, descripcion, fecha, capacidad) VALUES ('Concierto de bachata', 'Concierto de bachata en el teatro', '2021-10-19', 100);

INSERT INTO comentario (autor, evento, texto, fecha) VALUES (1, 1, 'Me encanta el rock', '2021-10-10');
INSERT INTO comentario (autor, evento, texto, fecha) VALUES (2, 1, 'Me encanta el rock', '2021-10-10');
INSERT INTO comentario (autor, evento, texto, fecha) VALUES (3, 1, 'Me encanta el rock', '2021-10-10');
INSERT INTO comentario (autor, evento, texto, fecha) VALUES (4, 1, 'Me encanta el rock', '2021-10-10');
INSERT INTO comentario (autor, evento, texto, fecha) VALUES (5, 1, 'Me encanta el rock', '2021-10-10');
INSERT INTO comentario (autor, evento, texto, fecha) VALUES (6, 1, 'Me encanta el rock', '2021-10-10');
INSERT INTO comentario (autor, evento, texto, fecha) VALUES (7, 1, 'Me encanta el rock', '2021-10-10');
INSERT INTO comentario (autor, evento, texto, fecha) VALUES (8, 1, 'Me encanta el rock', '2021-10-10');
INSERT INTO comentario (autor, evento, texto, fecha) VALUES (9, 1, 'Me encanta el rock', '2021-10-10');
INSERT INTO comentario (autor, evento, texto, fecha) VALUES (10, 1, 'Me encanta el rock', '2021-10-10');


