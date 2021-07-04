--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2 (Ubuntu 13.2-1.pgdg20.04+1)
-- Dumped by pg_dump version 13.2 (Ubuntu 13.2-1.pgdg20.04+1)




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

DROP DATABASE voluntariadodb;
--
-- TOC entry 3025 (class 1262 OID 18230)
-- Name: cusosdb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE voluntariadodb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'es_CL.UTF-8' LC_CTYPE = 'es_CL.UTF-8';


ALTER DATABASE voluntariadodb OWNER TO postgres;

\connect voluntariadodb









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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: emergencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emergencia (
    id_emergencia integer NOT NULL,
    nombre_emergencia text,
    descripcion_emergencia text,
    estado_emergencia int,
    "id_institucion" integer
);


ALTER TABLE public.emergencia OWNER TO postgres;

--
-- Name: estado_tarea; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado_tarea (
    id_estado_tarea integer NOT NULL,
    descripcion text
);


ALTER TABLE public.estado_tarea OWNER TO postgres;

--
-- Name: institucion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.institucion (
    id_institucion integer NOT NULL,
    nombre_institucion text,
    descripcion_institucion text
);


ALTER TABLE public.institucion OWNER TO postgres;



--
-- Name: log_emergencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.log_emergencia (
    id_log_emergencia text NOT NULL,
    accion text,
    "id_emergencia" integer,
    nombre_coordinador text
);


ALTER TABLE public.log_emergencia OWNER TO postgres;

--
-- Name: log_tarea; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.log_tarea (
    id_log_tarea integer NOT NULL,
    accion text,
    "id_tarea" integer,
    nombre_coordinador text
);


ALTER TABLE public.log_tarea OWNER TO postgres;

--
-- Name: tarea; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarea (
    id_tarea integer NOT NULL,
    nombre_tarea text,
    descripcion_tarea text,
    cant_vol_requeridos integer,
    cant_vol_inscritos integer,
    inicio date,
    fin date,
    "id_estado" integer,
    "id_emergencia" integer
);


ALTER TABLE public.tarea OWNER TO postgres;

--
-- Name: eme_habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eme_habilidad (
    id_eme_habilidad integer NOT NULL,
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

--
-- Name: institucion; Type: TABLE; Schema: public; Owner: postgres
--


--
-- Name: ranking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ranking (
    id_ranking integer NOT NULL,
    valoracion_ranking integer,
    "id_voluntario" integer,
    "id_tarea" integer
);


ALTER TABLE public.ranking OWNER TO postgres;

--
-- Name: tarea; Type: TABLE; Schema: public; Owner: postgres
--



--
-- Name: tarea_habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarea_habilidad (
    id_tarea_habilidad integer NOT NULL,
    "id_tarea" integer,
    "id_habilidad" integer
);


ALTER TABLE public.tarea_habilidad OWNER TO postgres;

--
-- Name: vol_habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vol_habilidad (
    id_vol_habilidad integer NOT NULL,
    "id_voluntario" integer,
    "id_habilidad" integer
);


ALTER TABLE public.vol_habilidad OWNER TO postgres;

--
-- Name: voluntario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voluntario (
    id_voluntario integer NOT NULL,
    nombre_voluntario text,
    disponibilidad_voluntario boolean,
    fnacimiento_voluntario date
);






-- Name: emergencia emergencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT emergencia_pkey PRIMARY KEY (id_emergencia);


--
-- Name: estado_tarea estado_tarea_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_tarea
    ADD CONSTRAINT estado_tarea_pkey PRIMARY KEY (id_estado_tarea);


--
-- Name: institucion institucion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institucion
    ADD CONSTRAINT institucion_pkey PRIMARY KEY (id_institucion);


--
-- Name: log_emergencia log_emergencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.log_emergencia
    ADD CONSTRAINT log_emergencia_pkey PRIMARY KEY (id_log_emergencia);



--
-- Name: log_tarea log_tarea_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.log_tarea
    ADD CONSTRAINT log_tarea_pkey PRIMARY KEY (id_log_tarea);


--
-- Name: tarea tarea_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT tarea_pkey PRIMARY KEY (id_tarea);


ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT eme_habilidad_pkey PRIMARY KEY (id_eme_habilidad);


--
-- Name: habilidad habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.habilidad
    ADD CONSTRAINT habilidad_pkey PRIMARY KEY (id_habilidad);


--
-- Name: ranking ranking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT ranking_pkey PRIMARY KEY (id_ranking);


--
-- Name: tarea_habilidad tarea_habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT tarea_habilidad_pkey PRIMARY KEY (id_tarea_habilidad);


--
-- Name: vol_habilidad vol_habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT vol_habilidad_pkey PRIMARY KEY (id_vol_habilidad);


--
-- Name: voluntario voluntario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voluntario
    ADD CONSTRAINT voluntario_pkey PRIMARY KEY (id_voluntario);


--
-- PostgreSQL database dump complete
--


ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT fk_emergencia_institucion FOREIGN KEY ("id_institucion") REFERENCES public.institucion(id_institucion);




ALTER TABLE ONLY public.log_emergencia 
    ADD CONSTRAINT fk_log_emergencia_emergencia FOREIGN KEY ("id_emergencia") REFERENCES public.emergencia(id_emergencia);




ALTER TABLE ONLY public.log_tarea
    ADD CONSTRAINT fk_log_tarea_tarea FOREIGN KEY ("id_tarea") REFERENCES public.tarea(id_tarea);




ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT fk_tarea_estado FOREIGN KEY ("id_estado") REFERENCES public.estado_tarea(id_estado_tarea);




ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT fk_tarea_emergencia FOREIGN KEY ("id_emergencia") REFERENCES public.emergencia(id_emergencia);



ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_emergencia_eme_habilidad FOREIGN KEY ("id_emergencia") REFERENCES public.emergencia(id_emergencia);


ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_habilidad_eme_habilidad FOREIGN KEY ("id_habilidad") REFERENCES public.habilidad(id_habilidad);




ALTER TABLE ONLY public.ranking 
    ADD CONSTRAINT fk_ranking_voluntario FOREIGN KEY ("id_voluntario") REFERENCES public.voluntario(id_voluntario);



ALTER TABLE ONLY public.ranking 
    ADD CONSTRAINT fk_ranking_tarea FOREIGN KEY ("id_tarea") REFERENCES public.tarea(id_tarea);







ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT fk_tarea_habilidad_tarea FOREIGN KEY ("id_tarea") REFERENCES public.tarea(id_tarea);


ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT fk_tarea_habilidad_habilidad FOREIGN KEY ("id_habilidad") REFERENCES public.habilidad(id_habilidad);



ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT fk_vol_habilidad_voluntario FOREIGN KEY ("id_voluntario") REFERENCES public.voluntario(id_voluntario);

ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT fk_vol_habilidad_habilidad FOREIGN KEY ("id_habilidad") REFERENCES public.habilidad(id_habilidad);
