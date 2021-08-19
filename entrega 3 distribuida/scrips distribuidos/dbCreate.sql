--
-- PostgreSQL database dump
--





--
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE voluntariadodb0;
--
-- TOC entry 3025 (class 1262 OID 18230)
-- Name: cusosdb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE voluntariadodb0 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'es_CL.UTF-8' LC_CTYPE = 'es_CL.UTF-8';


ALTER DATABASE voluntariadodb0 OWNER TO postgres;

\connect voluntariadodb0




SET default_tablespace = '';

SET default_table_access_method = heap;




--
-- Name: emergencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emergencia (
    id_emergencia integer NOT NULL,
    nombre_tabla text,
    nombre_emergencia text,
    descripcion_emergencia text
);

ALTER TABLE public.emergencia OWNER TO postgres;


--
-- Name: eme_habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eme_habilidad (
    id_eme_habilidad integer NOT NULL,
    nombre_tabla text,
    "id_emergencia" integer,
    "id_habilidad" integer
);


ALTER TABLE public.eme_habilidad OWNER TO postgres;

--
-- Name: emergencia; Type: TABLE; Schema: public; Owner: postgres
--

--
-- Name: habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.habilidad (
    id_habilidad integer NOT NULL,
    nombre_habilidad text,
    descripcion_habilidad text,
    valoracion_habilidad integer
);


ALTER TABLE public.habilidad OWNER TO postgres;


-- Name: emergencia emergencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT emergencia_pkey PRIMARY KEY (id_emergencia);



ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT eme_habilidad_pkey PRIMARY KEY (id_eme_habilidad);

--
-- Name: habilidad habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.habilidad
    ADD CONSTRAINT habilidad_pkey PRIMARY KEY (id_habilidad);



--
-- PostgreSQL database dump complete
--


ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_emergencia_eme_habilidad FOREIGN KEY ("id_emergencia") REFERENCES public.emergencia(id_emergencia);


ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_habilidad_eme_habilidad FOREIGN KEY ("id_habilidad") REFERENCES public.habilidad(id_habilidad);







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










DROP DATABASE voluntariadodb1;
--
-- TOC entry 3025 (class 1262 OID 18230)
-- Name: cusosdb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE voluntariadodb1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'es_CL.UTF-8' LC_CTYPE = 'es_CL.UTF-8';


ALTER DATABASE voluntariadodb1 OWNER TO postgres;

\connect voluntariadodb1




SET default_tablespace = '';

SET default_table_access_method = heap;



--
-- Name: emergencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emergencia (
    id_emergencia integer NOT NULL,
    nombre_tabla text,
    nombre_emergencia text,
    descripcion_emergencia text
);

ALTER TABLE public.emergencia OWNER TO postgres;


--
-- Name: eme_habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eme_habilidad (
    id_eme_habilidad integer NOT NULL,
    nombre_tabla text,
    "id_emergencia" integer,
    "id_habilidad" integer
);


ALTER TABLE public.eme_habilidad OWNER TO postgres;

--
-- Name: emergencia; Type: TABLE; Schema: public; Owner: postgres
--

--
-- Name: habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.habilidad (
    id_habilidad integer NOT NULL,
    nombre_habilidad text,
    descripcion_habilidad text,
    valoracion_habilidad integer
);


ALTER TABLE public.habilidad OWNER TO postgres;


-- Name: emergencia emergencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT emergencia_pkey PRIMARY KEY (id_emergencia);



ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT eme_habilidad_pkey PRIMARY KEY (id_eme_habilidad);

--
-- Name: habilidad habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.habilidad
    ADD CONSTRAINT habilidad_pkey PRIMARY KEY (id_habilidad);



--
-- PostgreSQL database dump complete
--


ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_emergencia_eme_habilidad FOREIGN KEY ("id_emergencia") REFERENCES public.emergencia(id_emergencia);


ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_habilidad_eme_habilidad FOREIGN KEY ("id_habilidad") REFERENCES public.habilidad(id_habilidad);







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




DROP DATABASE voluntariadodb2;
--
-- TOC entry 3025 (class 1262 OID 18230)
-- Name: cusosdb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE voluntariadodb2 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'es_CL.UTF-8' LC_CTYPE = 'es_CL.UTF-8';


ALTER DATABASE voluntariadodb2 OWNER TO postgres;

\connect voluntariadodb2




SET default_tablespace = '';

SET default_table_access_method = heap;



--
-- Name: emergencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emergencia (
    id_emergencia integer NOT NULL,
    nombre_tabla text,
    nombre_emergencia text,
    descripcion_emergencia text
);

ALTER TABLE public.emergencia OWNER TO postgres;


--
-- Name: eme_habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eme_habilidad (
    id_eme_habilidad integer NOT NULL,
    nombre_tabla text,
    "id_emergencia" integer,
    "id_habilidad" integer
);


ALTER TABLE public.eme_habilidad OWNER TO postgres;

--
-- Name: emergencia; Type: TABLE; Schema: public; Owner: postgres
--

--
-- Name: habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.habilidad (
    id_habilidad integer NOT NULL,
    nombre_habilidad text,
    descripcion_habilidad text,
    valoracion_habilidad integer
);


ALTER TABLE public.habilidad OWNER TO postgres;


-- Name: emergencia emergencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT emergencia_pkey PRIMARY KEY (id_emergencia);



ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT eme_habilidad_pkey PRIMARY KEY (id_eme_habilidad);

--
-- Name: habilidad habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.habilidad
    ADD CONSTRAINT habilidad_pkey PRIMARY KEY (id_habilidad);



--
-- PostgreSQL database dump complete
--


ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_emergencia_eme_habilidad FOREIGN KEY ("id_emergencia") REFERENCES public.emergencia(id_emergencia);


ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_habilidad_eme_habilidad FOREIGN KEY ("id_habilidad") REFERENCES public.habilidad(id_habilidad);







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






