

-- Tabla "institucion".
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(1, 'Bomberos', 'Institucion capaz de apagar cualquier incendio');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(2, 'Cruz roja', 'Atencion medica a todo el pais');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(3, 'Voluntariado usach', 'Prestar ayuda en limpieza');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(4, 'Las hermanitas de chicureo', 'orar y calmar, ayuda general.');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(5, 'Santa Maria', 'Servicios');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(6, 'Manos mormonas', 'Ayudar a cualquier persona');
INSERT INTO public.institucion(id_institucion, nombre_institucion, descripcion_institucion) VALUES(7, 'Fundacion san vicente de paul', 'Servicio comunitario y mas');

-- Tabla "emergencia".
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(1, 'Incendio forestal', 'Necesitamos voluntarios para apagar las llamas del bosque de machuca', 2);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(2, 'Accidente temblor', 'Edificio derrumbado tras temblor', 3);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(3, 'Limpieza de calles', 'Las calles de la pintana se encuentras llenas de basura', 3);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(4, 'Trasladar personas', 'Ocurrio un desvorde de un rio, y se deben trasladar los habitantes cercanos a este', 6);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(5, 'Recolectar escombros', 'Limpieza de escombros en zonas rurales', 1);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(6, 'Alimentar a gente necesitada', 'Cocinar para las personas que se encuentren en situacion de calle', 6);
INSERT INTO public.emergencia(id_emergencia, nombre_emergencia, descripcion_emergencia, id_institucion) VALUES(7, 'Personas desaparecidas', 'Un grupo de personas ha desaparecido tras incendio en su campamento', 7);




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



INSERT INTO public.log (id_log, nombre) VALUES (1,'crear');
INSERT INTO public.log (id_log, nombre) VALUES (2,'iniciar');
INSERT INTO public.log (id_log, nombre) VALUES (3,'cancelar');
INSERT INTO public.log (id_log, nombre) VALUES (4,'finalizar');


INSERT INTO public.log_emergencia (id_log_emergencia, id_log,id_emergencia,nombre_usuario) VALUES (1,1,1,'default');
INSERT INTO public.log_emergencia (id_log_emergencia, id_log,id_emergencia,nombre_usuario) VALUES (2,1,2,'default');
INSERT INTO public.log_emergencia (id_log_emergencia, id_log,id_emergencia,nombre_usuario) VALUES (3,1,3,'default');
INSERT INTO public.log_emergencia (id_log_emergencia, id_log,id_emergencia,nombre_usuario) VALUES (4,1,4,'default');
INSERT INTO public.log_emergencia (id_log_emergencia, id_log,id_emergencia,nombre_usuario) VALUES (5,1,5,'default');
INSERT INTO public.log_emergencia (id_log_emergencia, id_log,id_emergencia,nombre_usuario) VALUES (6,1,6,'default');
INSERT INTO public.log_emergencia (id_log_emergencia, id_log,id_emergencia,nombre_usuario) VALUES (7,1,7,'default');



INSERT INTO public.log_tarea (id_log_tarea, id_log,id_tarea,nombre_usuario) VALUES (1,1,1,'default');
INSERT INTO public.log_tarea (id_log_tarea, id_log,id_tarea,nombre_usuario) VALUES (2,1,2,'default');
INSERT INTO public.log_tarea (id_log_tarea, id_log,id_tarea,nombre_usuario) VALUES (3,1,3,'default');
INSERT INTO public.log_tarea (id_log_tarea, id_log,id_tarea,nombre_usuario) VALUES (4,1,4,'default');
INSERT INTO public.log_tarea (id_log_tarea, id_log,id_tarea,nombre_usuario) VALUES (5,1,5,'default');
INSERT INTO public.log_tarea (id_log_tarea, id_log,id_tarea,nombre_usuario) VALUES (6,1,6,'default');
INSERT INTO public.log_tarea (id_log_tarea, id_log,id_tarea,nombre_usuario) VALUES (7,1,7,'default');


