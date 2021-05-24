-- Se crea el presente archivo para cargar la base de datos con datos.

--Tabla "voluntarios"
INSERT INTO public.voluntario(id_voluntario, nombre_voluntario, disponibilidad_voluntario, fnacimiento_voluntario) VALUES(1, 'Sebastian Alejandro Astete Ramirez', TRUE, '1993-08-03');
INSERT INTO public.voluntario(id_voluntario, nombre_voluntario, disponibilidad_voluntario, fnacimiento_voluntario) VALUES(2, 'Javier Cornejo', TRUE, '1993-08-03');
INSERT INTO public.voluntario(id_voluntario, nombre_voluntario, disponibilidad_voluntario, fnacimiento_voluntario) VALUES(3, 'Wladimir Duran', TRUE, '1993-08-03');
INSERT INTO public.voluntario(id_voluntario, nombre_voluntario, disponibilidad_voluntario, fnacimiento_voluntario) VALUES(4, 'Carlos Castillo', TRUE, '1993-08-03');
INSERT INTO public.voluntario(id_voluntario, nombre_voluntario, disponibilidad_voluntario, fnacimiento_voluntario) VALUES(5, 'Maximiliano Eduardo Peña ', TRUE, '1993-08-03');
INSERT INTO public.voluntario(id_voluntario, nombre_voluntario, disponibilidad_voluntario, fnacimiento_voluntario) VALUES(6, 'Miguel de Cervantes', TRUE, '1993-08-03');
INSERT INTO public.voluntario(id_voluntario, nombre_voluntario, disponibilidad_voluntario, fnacimiento_voluntario) VALUES(7, 'Panchoso', TRUE, '1993-08-03');
INSERT INTO public.voluntario(id_voluntario, nombre_voluntario, disponibilidad_voluntario, fnacimiento_voluntario) VALUES(8, 'Martin Wolfeschlegelsteinhausenbergerdorff', FALSE, '1883-11-13');

--Tabla "rankings"
INSERT INTO public.ranking(id_ranking, valoracion_ranking, id_voluntario) VALUES(1, 82, 1);
INSERT INTO public.ranking(id_ranking, valoracion_ranking, id_voluntario) VALUES(2, 85, 2);
INSERT INTO public.ranking(id_ranking, valoracion_ranking, id_voluntario) VALUES(3, 62, 3);
INSERT INTO public.ranking(id_ranking, valoracion_ranking, id_voluntario) VALUES(4, 46, 4);
INSERT INTO public.ranking(id_ranking, valoracion_ranking, id_voluntario) VALUES(5, 19, 5);
INSERT INTO public.ranking(id_ranking, valoracion_ranking, id_voluntario) VALUES(6, 77, 6);
INSERT INTO public.ranking(id_ranking, valoracion_ranking, id_voluntario) VALUES(7, 88, 7);
INSERT INTO public.ranking(id_ranking, valoracion_ranking, id_voluntario) VALUES(8, 99, 8);



-- Tabla habilidad.
INSERT INTO public.habilidad(id_habilidad, nombre_habilidad, descripcion_habilidad, valoracion_habilidad) VALUES (1,'Cocinero','Preparar y cocinar el almuerzo para las personas damnificadas','85');
INSERT INTO public.habilidad(id_habilidad, nombre_habilidad, descripcion_habilidad, valoracion_habilidad) VALUES (2,'Recolector','Despejar zonas destruidas, principalmente despejar escombros','80');
INSERT INTO public.habilidad(id_habilidad, nombre_habilidad, descripcion_habilidad, valoracion_habilidad) VALUES (3,'Medico auxiliar','Curar heridos','92');
INSERT INTO public.habilidad(id_habilidad, nombre_habilidad, descripcion_habilidad, valoracion_habilidad) VALUES (4,'Constructor','Construir o reconstruir estructuras destruidas','56');
INSERT INTO public.habilidad(id_habilidad, nombre_habilidad, descripcion_habilidad, valoracion_habilidad) VALUES (5,'Auxiliar del aseo','Limpiar zonas destruidas','79');
INSERT INTO public.habilidad(id_habilidad, nombre_habilidad, descripcion_habilidad, valoracion_habilidad) VALUES (6,'Reponedor','Reponer provisiones','83');
INSERT INTO public.habilidad(id_habilidad, nombre_habilidad, descripcion_habilidad, valoracion_habilidad) VALUES (7,'Conductor','Operar cualquier vehículo, ya sea un vehiculo comercial o personal','69');
INSERT INTO public.habilidad(id_habilidad, nombre_habilidad, descripcion_habilidad, valoracion_habilidad) VALUES (8,'Trabajo manual de cargas','Se Trasladan cargas pesadas de un lugar a otro','83');
INSERT INTO public.habilidad(id_habilidad, nombre_habilidad, descripcion_habilidad, valoracion_habilidad) VALUES (9,'Rescatista','Buscar y encontrar heridos o desaparecidos en las zonas afectadas','97');


-- Tabla intermedia "vol_habilidad".
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (1,3,4);
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (2,2,1);
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (3,4,2);
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (4,1,3);
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (5,3,6);
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (6,3,3);
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (7,7,4);
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (8,3,1);
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (9,2,3);
INSERT INTO public.vol_habilidad(id_vol_habilidad, id_voluntario, id_habilidad) VALUES (10,6,6);

-- Tabla "institucion".
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(1, 'Bomberos', 'Institucion capaz de apagar cualquier incendio');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(2, 'Cruz roja', 'Atencion medica a todo el pais');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(3, 'Voluntariado usach', 'Prestar ayuda en limpieza');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(4, 'Las hermanitas pobres de chicureo', 'Orar y calmar');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(5, 'Santa Maria', 'Servicios');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(6, 'Los mormones', 'Ayudar a cualquier persona');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(7, 'Fundacion san vicente de paul', 'Servicio comunitario y mas');

-- Tabla "emergencia".
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(1, 'Fuego bosque', 'Necesitamos voluntarios para apagar las llamas del bosque de machuca', 2);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(2, 'Accidente temblor', 'Edificio derrumbado tras temblor', 3);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(3, 'Limpieza de calles', 'Las calles de la pintana se encuentras llenas de basura', 3);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(4, 'Trasladar personas', 'Ocurrio un desvorde de un rio, y se deben trasladar los habitantes cercanos a este', 6);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(5, 'Recolectar escombros', 'Limpieza de escombros en zonas rurales', 1);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(6, 'Alimenta a gente necesitada', 'Cocinar para las personas que se encuentren en situacion de calle', 6);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(7, 'Personjas desaparecidas', 'Un grupo de personas ha desaparecido tras incendio en su campamento', 7);


-- Tabla "eme_habilidad".
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(1, 1, 9);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(2, 6, 1);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(3, 4, 7);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(4, 3, 2);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(5, 3, 5);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(6, 2, 9);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(7, 2, 4);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(8, 7, 9);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(9, 5, 5);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(10, 1, 8);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(11, 2, 3);
INSERT INTO public.eme_habilidad(id_eme_habilidad, id_emergencia, id_habilidad) VALUES(12, 6, 6);


--Tabla "estado_tarea"
INSERT INTO public.estado_tarea (id_estado_tarea, descripcion) VALUES (1,'Tarea pausada');
INSERT INTO public.estado_tarea (id_estado_tarea, descripcion) VALUES (2,'Tarea en proceso');
INSERT INTO public.estado_tarea (id_estado_tarea, descripcion) VALUES (3,'Tarea en espera');

-- Tabla tarea
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (1, 'Escombros', 'Quitar los escombros del sector', 10, 4, '1993-04-26', '1993-05-6',1,1);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (2, 'Cenizas', 'Quitar los Cenizas del sector', 10, 4, '1993-04-26', '1993-05-6',2,2);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (3, 'Aseo', 'Limpieza del sector', 10, 4, '1993-04-26', '1993-05-6',3,3);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (4, 'Alimentos', 'Acopio de alimentos', 10, 4, '1993-04-26', '1993-05-6',1,4);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (5, 'Primeros Auxilios', 'Ayuda con primeros auxilios', 10, 4, '1993-04-26', '1993-05-6',1,1);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (6, 'Transporte', 'Carga de objetos de un punto a otro', 10, 4, '1993-04-26', '1993-05-6',3,3);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (7, 'Escombros', 'Quitar los escombros del sector', 10, 4, '1993-04-26', '1993-05-6',2,4);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (8, 'Escombros', 'Quitar los escombros del sector', 10, 4, '1993-04-26', '1993-05-6',3,3);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (9, 'Escombros', 'Quitar los escombros del sector', 10, 4, '1993-04-26', '1993-05-6',2,2);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (10, 'Escombros', 'Quitar los escombros del sector', 10, 4, '1993-04-26', '1993-05-6',1,1);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (11, 'Escombros', 'Quitar los escombros del sector', 10, 4, '1993-04-26', '1993-05-6',3,4);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (12, 'Escombros', 'Quitar los escombros del sector', 10, 4, '1993-04-26', '1993-05-6',2,2);
INSERT INTO public.tarea(id_tarea, nombre_tarea, descripcion_tarea, cant_vol_requeridos, cant_vol_inscritos, inicio, fin, id_estado, id_emergencia) VALUES (13, 'Escombros', 'Quitar los escombros del sector', 10, 4, '1993-04-26', '1993-05-6',1,1);



--Tabla "tarea_habilidad"
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (1,1, 1);
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (2,2, 2);
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (3,3, 3);
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (4,4, 4);
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (5,5, 5);
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (6,6, 6);
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (7,7, 7);
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (8,8, 8);
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (9,9, 9);
INSERT INTO public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (10,10, 1);
