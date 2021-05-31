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
-- Name: log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.log (
    id_log integer NOT NULL,
    nombre text
);


ALTER TABLE public.log OWNER TO postgres;

--
-- Name: log_emergencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.log_emergencia (
    id_log_emergencia text NOT NULL,
    "id_log" integer,
    "id_emergencia" integer,
    nombre_usuario text
);


ALTER TABLE public.log_emergencia OWNER TO postgres;

--
-- Name: log_tarea; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.log_tarea (
    id_log_tarea integer NOT NULL,
    "id_log" integer,
    "id_tarea" integer,
    nombre_usuario text
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
-- Data for Name: emergencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

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
-- Name: log log_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_pkey PRIMARY KEY (id_log);


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


--
-- PostgreSQL database dump complete
--


ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT fk_emergencia_institucion FOREIGN KEY ("id_institucion") REFERENCES public.institucion(id_institucion);



ALTER TABLE ONLY public.log_emergencia 
    ADD CONSTRAINT fk_log_emergencia_log FOREIGN KEY ("id_log") REFERENCES public.log(id_log);


ALTER TABLE ONLY public.log_emergencia 
    ADD CONSTRAINT fk_log_emergencia_emergencia FOREIGN KEY ("id_emergencia") REFERENCES public.emergencia(id_emergencia);




ALTER TABLE ONLY public.log_tarea
    ADD CONSTRAINT fk_log_tarea_tarea FOREIGN KEY ("id_tarea") REFERENCES public.tarea(id_tarea);


ALTER TABLE ONLY public.log_tarea
    ADD CONSTRAINT fk_log_tarea_log FOREIGN KEY ("id_log") REFERENCES public.log(id_log);



ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT fk_tarea_estado FOREIGN KEY ("id_estado") REFERENCES public.estado_tarea(id_estado_tarea);




ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT fk_tarea_emergencia FOREIGN KEY ("id_emergencia") REFERENCES public.emergencia(id_emergencia);
