INSERT INTO carreras (carrera_codigo, carrera_nombre, carrera_duracion, carrera_estado) VALUES ('ABC', 'Ingeniería Informática', 5, b'1');
INSERT INTO carreras (carrera_codigo, carrera_nombre, carrera_duracion, carrera_estado) VALUES ('DEF', 'Licenciatura en Administración', 4, b'1');

INSERT INTO alumnos (alumno_dni, alumno_nombre, alumno_apellido, alumno_email, alumno_telef, alumno_fechnac, alumno_dom, alumno_LU, alumno_estado) VALUES ('44477373','Juan','Pérez','juan@example.com','1234567890','1990-05-15','Calle 123','ALU123',b'1');
INSERT INTO alumnos (alumno_dni, alumno_nombre, alumno_apellido, alumno_email, alumno_telef, alumno_fechnac, alumno_dom, alumno_LU, alumno_estado) VALUES ('29456744','Fabricio','Gómez','maria@example.com','0987654321','1992-08-25','Avenida 456','ALU456',b'1');
INSERT INTO alumnos (alumno_dni, alumno_nombre, alumno_apellido, alumno_email, alumno_telef, alumno_fechnac, alumno_dom, alumno_LU, alumno_estado) VALUES ('31908374','Nicolas','Blanco','juan@example.com','1234567890','1990-05-15','Calle 123','ALU123',b'1');
INSERT INTO alumnos (alumno_dni, alumno_nombre, alumno_apellido, alumno_email, alumno_telef, alumno_fechnac, alumno_dom, alumno_LU, alumno_estado) VALUES ('46231455','Jesus','Sutton','juan@example.com','1234567890','1990-05-15','Calle 123','ALU123',b'1');
INSERT INTO alumnos (alumno_dni, alumno_nombre, alumno_apellido, alumno_email, alumno_telef, alumno_fechnac, alumno_dom, alumno_LU, alumno_estado) VALUES ('31654321','Andres','Robledo','maria@example.com','0987654321','1992-08-25','Avenida 456','ALU456',b'1');
INSERT INTO alumnos (alumno_dni, alumno_nombre, alumno_apellido, alumno_email, alumno_telef, alumno_fechnac, alumno_dom, alumno_LU, alumno_estado) VALUES ('34653321','Andrea','Mortensen','maria@example.com','0987654321','1992-08-25','Avenida 456','ALU456',b'1');
INSERT INTO alumnos (alumno_dni, alumno_nombre, alumno_apellido, alumno_email, alumno_telef, alumno_fechnac, alumno_dom, alumno_LU, alumno_estado) VALUES ('41345678','Gonzalo','Rodriguez','juan@example.com','1234567890','1990-05-15','Calle 123','ALU123',b'1');
INSERT INTO alumnos (alumno_dni, alumno_nombre, alumno_apellido, alumno_email, alumno_telef, alumno_fechnac, alumno_dom, alumno_LU, alumno_estado) VALUES ('39654321','Fabiana','Soto','maria@example.com','0987654321','1992-08-25','Avenida 456','ALU456',b'1');

INSERT INTO docente (Docente_leg, Docente_name, Docente_surn, Docente_email, Docente_telef, Docente_estado) VALUES ('D123', 'Pedro', 'González', 'pedro@example.com', '5678901234', b'1');
INSERT INTO docente (Docente_leg, Docente_name, Docente_surn, Docente_email, Docente_telef, Docente_estado) VALUES ('D456', 'Ana', 'Martínez', 'ana@example.com', '4321098765', b'1');

INSERT INTO materias (Mat_cod, Mat_nom, Mat_cur, Mat_hor, Mat_modal, Mat_estado, Docente_id, carrera_id) VALUES ('123', 'JUDAISMO II', '4', 80, 'PRESENCIAL', b'1', 1, 1);
INSERT INTO materias (Mat_cod, Mat_nom, Mat_cur, Mat_hor, Mat_modal, Mat_estado, Docente_id, carrera_id) VALUES ('123', 'JUDAISMO II', '4', 80, 'PRESENCIAL', b'1', 1, 1);