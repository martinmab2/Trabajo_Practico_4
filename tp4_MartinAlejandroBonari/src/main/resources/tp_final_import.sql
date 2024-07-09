INSERT INTO alumnos (alumno_dni, alumno_nombre, alumno_apellido, alumno_email, alumno_telef, alumno_fechnac, alumno_dom, alumno_LU, alumno_estado)
VALUES
(12345678, 'Juan', 'Pérez', 'juan@example.com', '1234567890', '1990-05-15', 'Calle 123', 'ALU123', 1),
(87654321, 'María', 'Gómez', 'maria@example.com', '0987654321', '1992-08-25', 'Avenida 456', 'ALU456', 1);

INSERT INTO carreras (carrera_codigo, carrera_nombre, carrera_duracion, carrera_estado)
VALUES
('ABC', 'Ingeniería Informática', 5, 1),
('DEF', 'Licenciatura en Administración', 4, 1);

INSERT INTO docente (Docente_leg, Docente_name, Docente_surn, Docente_email, Docente_telef, Docente_estado)
VALUES
('D123', 'Pedro', 'González', 'pedro@example.com', '5678901234', 1),
('D456', 'Ana', 'Martínez', 'ana@example.com', '4321098765', 1);

INSERT INTO materias (Mat_cod, Mat_nom, Mat_cur, Mat_hor, Mat_modal, Mat_estado, Docente_id, carrera_id)
VALUES
(123, 'Programación Avanzada', '202', 80, 'PRESENCIAL', 1, 1, 1),
(456, 'Gestión de Proyectos', '301', 60, 'VIRTUAL', 1, 2, 2);