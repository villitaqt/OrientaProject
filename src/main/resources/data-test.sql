-- Inserción de usuarios
INSERT INTO usuarios (id, nombre_usuario, contrasena, full_name, role) VALUES
                                                                           (1, 'admin', 'admin123', 'Administrador', 'ADMIN'),
                                                                           (2, 'estudiante1', 'pass123', 'Estudiante Uno', 'STUDENT'),
                                                                           (3, 'estudiante2', 'pass123', 'Estudiante Dos', 'STUDENT'),
                                                                           (4, 'experto1', 'pass123', 'Experto Uno', 'EXPERT'),
                                                                           (5, 'experto2', 'pass123', 'Experto Dos', 'EXPERT');

-- Inserción de estudiantes
INSERT INTO estudiantes (usuario_id, studentode) VALUES
                                             (2, 'Informática'),
                                             (3, 'Psicología');

-- Inserción de expertos
INSERT INTO expertos (usuario_id, expertise_field) VALUES
                                              (4, 'Orientación Vocacional'),
                                              (5, 'Psicopedagogía');

-- Inserción de carreras
INSERT INTO carreras (nombre, descripcion) VALUES
                                                   ( 'Ingeniería en Sistemas', 'Diseño y desarrollo de software.'),
                                                   ( 'Medicina', 'Diagnóstico y tratamiento de enfermedades.'),
                                                   ( 'Derecho', 'Estudio y aplicación de normas jurídicas.'),
                                                   ( 'Arquitectura', 'Diseño y planificación de edificaciones.'),
                                                   ( 'Psicología', 'Estudio del comportamiento humano.'),
                                                   ( 'Administración de Empresas', 'Gestión de recursos organizacionales.'),
                                                   ( 'Ingeniería Civil', 'Construcción de infraestructuras.'),
                                                   ( 'Marketing', 'Estrategias comerciales y publicidad.'),
                                                   ( 'Biotecnología', 'Desarrollo de tecnología basada en biología.'),
                                                   ( 'Contaduría Pública', 'Gestión financiera y fiscal.');