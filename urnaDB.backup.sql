--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-06 01:11:05

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
-- TOC entry 213 (class 1259 OID 16816)
-- Name: candidato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidato (
    id_candidato integer NOT NULL,
    id_legenda integer NOT NULL,
    id_partidario integer NOT NULL,
    numero integer NOT NULL
);


ALTER TABLE public.candidato OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16814)
-- Name: candidato_id_candidato_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.candidato_id_candidato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.candidato_id_candidato_seq OWNER TO postgres;

--
-- TOC entry 3090 (class 0 OID 0)
-- Dependencies: 212
-- Name: candidato_id_candidato_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.candidato_id_candidato_seq OWNED BY public.candidato.id_candidato;


--
-- TOC entry 209 (class 1259 OID 16787)
-- Name: eleicao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eleicao (
    id_eleicao integer NOT NULL,
    cargo character varying(200) NOT NULL,
    regiao character varying(200) NOT NULL,
    data_da_eleicao date NOT NULL,
    turno character varying(200) NOT NULL
);


ALTER TABLE public.eleicao OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16785)
-- Name: eleicao_id_eleicao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.eleicao_id_eleicao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.eleicao_id_eleicao_seq OWNER TO postgres;

--
-- TOC entry 3091 (class 0 OID 0)
-- Dependencies: 208
-- Name: eleicao_id_eleicao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.eleicao_id_eleicao_seq OWNED BY public.eleicao.id_eleicao;


--
-- TOC entry 201 (class 1259 OID 16740)
-- Name: eleitor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eleitor (
    id_eleitor integer NOT NULL,
    nome character varying(200) NOT NULL,
    nascimento date NOT NULL,
    cpf character varying(14) NOT NULL,
    titulo character varying(14) NOT NULL
);


ALTER TABLE public.eleitor OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16738)
-- Name: eleitor_id_eleitor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.eleitor_id_eleitor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.eleitor_id_eleitor_seq OWNER TO postgres;

--
-- TOC entry 3092 (class 0 OID 0)
-- Dependencies: 200
-- Name: eleitor_id_eleitor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.eleitor_id_eleitor_seq OWNED BY public.eleitor.id_eleitor;


--
-- TOC entry 203 (class 1259 OID 16748)
-- Name: fiscal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fiscal (
    id_fiscal integer NOT NULL,
    id_eleitor integer NOT NULL,
    expiracao_do_cargo date
);


ALTER TABLE public.fiscal OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16746)
-- Name: fiscal_id_fiscal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fiscal_id_fiscal_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fiscal_id_fiscal_seq OWNER TO postgres;

--
-- TOC entry 3093 (class 0 OID 0)
-- Dependencies: 202
-- Name: fiscal_id_fiscal_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fiscal_id_fiscal_seq OWNED BY public.fiscal.id_fiscal;


--
-- TOC entry 211 (class 1259 OID 16798)
-- Name: legenda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.legenda (
    id_legenda integer NOT NULL,
    id_partido integer NOT NULL,
    id_eleicao integer NOT NULL
);


ALTER TABLE public.legenda OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16796)
-- Name: legenda_id_legenda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.legenda_id_legenda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.legenda_id_legenda_seq OWNER TO postgres;

--
-- TOC entry 3094 (class 0 OID 0)
-- Dependencies: 210
-- Name: legenda_id_legenda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.legenda_id_legenda_seq OWNED BY public.legenda.id_legenda;


--
-- TOC entry 215 (class 1259 OID 16834)
-- Name: login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.login (
    id_login integer NOT NULL,
    id_eleitor integer NOT NULL,
    cpf character varying(14) NOT NULL,
    senha character varying(20) NOT NULL,
    tipo integer NOT NULL
);


ALTER TABLE public.login OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16832)
-- Name: login_id_login_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.login_id_login_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.login_id_login_seq OWNER TO postgres;

--
-- TOC entry 3095 (class 0 OID 0)
-- Dependencies: 214
-- Name: login_id_login_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.login_id_login_seq OWNED BY public.login.id_login;


--
-- TOC entry 207 (class 1259 OID 16769)
-- Name: partidario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.partidario (
    id_partidario integer NOT NULL,
    id_eleitor integer NOT NULL,
    id_partido integer NOT NULL,
    cargo_no_partido character varying(200) NOT NULL
);


ALTER TABLE public.partidario OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16767)
-- Name: partidario_id_partidario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.partidario_id_partidario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.partidario_id_partidario_seq OWNER TO postgres;

--
-- TOC entry 3096 (class 0 OID 0)
-- Dependencies: 206
-- Name: partidario_id_partidario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.partidario_id_partidario_seq OWNED BY public.partidario.id_partidario;


--
-- TOC entry 205 (class 1259 OID 16761)
-- Name: partido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.partido (
    id_partido integer NOT NULL,
    numero integer NOT NULL,
    nome character varying(200)
);


ALTER TABLE public.partido OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16759)
-- Name: partido_id_partido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.partido_id_partido_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.partido_id_partido_seq OWNER TO postgres;

--
-- TOC entry 3097 (class 0 OID 0)
-- Dependencies: 204
-- Name: partido_id_partido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.partido_id_partido_seq OWNED BY public.partido.id_partido;


--
-- TOC entry 217 (class 1259 OID 16847)
-- Name: voto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voto (
    id_voto integer NOT NULL,
    id_eleitor integer NOT NULL,
    id_legenda integer NOT NULL,
    id_candidato integer
);


ALTER TABLE public.voto OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16845)
-- Name: voto_id_voto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.voto_id_voto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voto_id_voto_seq OWNER TO postgres;

--
-- TOC entry 3098 (class 0 OID 0)
-- Dependencies: 216
-- Name: voto_id_voto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voto_id_voto_seq OWNED BY public.voto.id_voto;


--
-- TOC entry 2905 (class 2604 OID 16819)
-- Name: candidato id_candidato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidato ALTER COLUMN id_candidato SET DEFAULT nextval('public.candidato_id_candidato_seq'::regclass);


--
-- TOC entry 2903 (class 2604 OID 16790)
-- Name: eleicao id_eleicao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eleicao ALTER COLUMN id_eleicao SET DEFAULT nextval('public.eleicao_id_eleicao_seq'::regclass);


--
-- TOC entry 2899 (class 2604 OID 16743)
-- Name: eleitor id_eleitor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eleitor ALTER COLUMN id_eleitor SET DEFAULT nextval('public.eleitor_id_eleitor_seq'::regclass);


--
-- TOC entry 2900 (class 2604 OID 16751)
-- Name: fiscal id_fiscal; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fiscal ALTER COLUMN id_fiscal SET DEFAULT nextval('public.fiscal_id_fiscal_seq'::regclass);


--
-- TOC entry 2904 (class 2604 OID 16801)
-- Name: legenda id_legenda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.legenda ALTER COLUMN id_legenda SET DEFAULT nextval('public.legenda_id_legenda_seq'::regclass);


--
-- TOC entry 2906 (class 2604 OID 16837)
-- Name: login id_login; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login ALTER COLUMN id_login SET DEFAULT nextval('public.login_id_login_seq'::regclass);


--
-- TOC entry 2902 (class 2604 OID 16772)
-- Name: partidario id_partidario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partidario ALTER COLUMN id_partidario SET DEFAULT nextval('public.partidario_id_partidario_seq'::regclass);


--
-- TOC entry 2901 (class 2604 OID 16764)
-- Name: partido id_partido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partido ALTER COLUMN id_partido SET DEFAULT nextval('public.partido_id_partido_seq'::regclass);


--
-- TOC entry 2907 (class 2604 OID 16850)
-- Name: voto id_voto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voto ALTER COLUMN id_voto SET DEFAULT nextval('public.voto_id_voto_seq'::regclass);


--
-- TOC entry 3080 (class 0 OID 16816)
-- Dependencies: 213
-- Data for Name: candidato; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.candidato (id_candidato, id_legenda, id_partidario, numero) VALUES (1, 1, 1, 22);
INSERT INTO public.candidato (id_candidato, id_legenda, id_partidario, numero) VALUES (2, 3, 3, 99);


--
-- TOC entry 3076 (class 0 OID 16787)
-- Dependencies: 209
-- Data for Name: eleicao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.eleicao (id_eleicao, cargo, regiao, data_da_eleicao, turno) VALUES (1, 'Governador', 'Minas Gerais', '2022-10-10', 'Primeiro');


--
-- TOC entry 3068 (class 0 OID 16740)
-- Dependencies: 201
-- Data for Name: eleitor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (2, 'Melissa Bomtempo Reis', '2000-06-14', '388.531.530-08', '801314030183 ');
INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (1, 'Testoninho Sikva', '1951-01-01', '000.000.001-91', '708220650175 ');
INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (3, 'Pablo Moreira Tengu', '1997-02-03', '000.000.002-72', '321015540116 ');
INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (4, 'Curuvyono Ceon Keundir', '1977-05-03', '329.024.030-46', '778178160116 ');
INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (5, 'Muday Kihoacor', '1944-11-17', '410.435.150-46', '370353830183 ');
INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (6, 'José Jair João', '1993-02-01', '225.893.730-23', '008765580183 ');
INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (7, 'Daniela Milena Sueli Araújo', '1989-03-01', '731.550.899-62', '157037230116 ');
INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (8, 'Amanda Moreira Ribeiro', '1956-11-23', '000.000.003-53', '848686070116 ');
INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (9, 'Letícia Rita Liberato', '1969-11-11', '196.347.110-57', ' 848686070116');
INSERT INTO public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) VALUES (10, 'Janaina Pereira Mourais', '1977-05-10', '910.265.730-92', ' 230320280175');


--
-- TOC entry 3070 (class 0 OID 16748)
-- Dependencies: 203
-- Data for Name: fiscal; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3078 (class 0 OID 16798)
-- Dependencies: 211
-- Data for Name: legenda; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.legenda (id_legenda, id_partido, id_eleicao) VALUES (1, 3, 1);
INSERT INTO public.legenda (id_legenda, id_partido, id_eleicao) VALUES (3, 6, 1);


--
-- TOC entry 3082 (class 0 OID 16834)
-- Dependencies: 215
-- Data for Name: login; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (1, 1, '000.000.001-91', 'teste1', 0);
INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (3, 3, '000.000.002-72', 'teste3', 0);
INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (4, 4, '329.024.030-46', '778178160116', 0);
INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (5, 5, '410.435.150-46', '370353830183', 0);
INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (6, 6, '225.893.730-23', '123456', 0);
INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (7, 7, '731.550.899-62', '123456', 0);
INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (2, 2, '388.531.530-08', 'teste2', 1);
INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (8, 8, '000.000.003-53', '000353', 0);
INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (9, 9, '196.347.110-57', '117013', 0);
INSERT INTO public.login (id_login, id_eleitor, cpf, senha, tipo) VALUES (10, 10, '910.265.730-92', '910.265.730-92', 0);


--
-- TOC entry 3074 (class 0 OID 16769)
-- Dependencies: 207
-- Data for Name: partidario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.partidario (id_partidario, id_eleitor, id_partido, cargo_no_partido) VALUES (1, 4, 3, 'Afiliado');
INSERT INTO public.partidario (id_partidario, id_eleitor, id_partido, cargo_no_partido) VALUES (2, 5, 3, 'Afiliado');
INSERT INTO public.partidario (id_partidario, id_eleitor, id_partido, cargo_no_partido) VALUES (3, 10, 6, 'Afiliada');


--
-- TOC entry 3072 (class 0 OID 16761)
-- Dependencies: 205
-- Data for Name: partido; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.partido (id_partido, numero, nome) VALUES (1, 11, 'Partido Verde');
INSERT INTO public.partido (id_partido, numero, nome) VALUES (2, 15, 'Partido Amarelo');
INSERT INTO public.partido (id_partido, numero, nome) VALUES (3, 22, 'Partido Carmesim');
INSERT INTO public.partido (id_partido, numero, nome) VALUES (4, 44, 'Partido Roda');
INSERT INTO public.partido (id_partido, numero, nome) VALUES (5, 70, 'Partido Cinza');
INSERT INTO public.partido (id_partido, numero, nome) VALUES (6, 99, 'Partido Diferente');
INSERT INTO public.partido (id_partido, numero, nome) VALUES (7, 55, 'Partido Ciano');


--
-- TOC entry 3084 (class 0 OID 16847)
-- Dependencies: 217
-- Data for Name: voto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.voto (id_voto, id_eleitor, id_legenda, id_candidato) VALUES (1, 1, 3, NULL);


--
-- TOC entry 3099 (class 0 OID 0)
-- Dependencies: 212
-- Name: candidato_id_candidato_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.candidato_id_candidato_seq', 2, true);


--
-- TOC entry 3100 (class 0 OID 0)
-- Dependencies: 208
-- Name: eleicao_id_eleicao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.eleicao_id_eleicao_seq', 1, true);


--
-- TOC entry 3101 (class 0 OID 0)
-- Dependencies: 200
-- Name: eleitor_id_eleitor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.eleitor_id_eleitor_seq', 10, true);


--
-- TOC entry 3102 (class 0 OID 0)
-- Dependencies: 202
-- Name: fiscal_id_fiscal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fiscal_id_fiscal_seq', 1, false);


--
-- TOC entry 3103 (class 0 OID 0)
-- Dependencies: 210
-- Name: legenda_id_legenda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.legenda_id_legenda_seq', 3, true);


--
-- TOC entry 3104 (class 0 OID 0)
-- Dependencies: 214
-- Name: login_id_login_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.login_id_login_seq', 10, true);


--
-- TOC entry 3105 (class 0 OID 0)
-- Dependencies: 206
-- Name: partidario_id_partidario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.partidario_id_partidario_seq', 3, true);


--
-- TOC entry 3106 (class 0 OID 0)
-- Dependencies: 204
-- Name: partido_id_partido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.partido_id_partido_seq', 8, true);


--
-- TOC entry 3107 (class 0 OID 0)
-- Dependencies: 216
-- Name: voto_id_voto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voto_id_voto_seq', 1, true);


--
-- TOC entry 2921 (class 2606 OID 16821)
-- Name: candidato candidato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidato
    ADD CONSTRAINT candidato_pkey PRIMARY KEY (id_candidato);


--
-- TOC entry 2917 (class 2606 OID 16795)
-- Name: eleicao eleicao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eleicao
    ADD CONSTRAINT eleicao_pkey PRIMARY KEY (id_eleicao);


--
-- TOC entry 2909 (class 2606 OID 16745)
-- Name: eleitor eleitor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eleitor
    ADD CONSTRAINT eleitor_pkey PRIMARY KEY (id_eleitor);


--
-- TOC entry 2911 (class 2606 OID 16753)
-- Name: fiscal fiscal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fiscal
    ADD CONSTRAINT fiscal_pkey PRIMARY KEY (id_fiscal);


--
-- TOC entry 2919 (class 2606 OID 16803)
-- Name: legenda legenda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.legenda
    ADD CONSTRAINT legenda_pkey PRIMARY KEY (id_legenda);


--
-- TOC entry 2923 (class 2606 OID 16839)
-- Name: login login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id_login);


--
-- TOC entry 2915 (class 2606 OID 16774)
-- Name: partidario partidario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partidario
    ADD CONSTRAINT partidario_pkey PRIMARY KEY (id_partidario);


--
-- TOC entry 2913 (class 2606 OID 16766)
-- Name: partido partido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_pkey PRIMARY KEY (id_partido);


--
-- TOC entry 2925 (class 2606 OID 16852)
-- Name: voto voto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voto
    ADD CONSTRAINT voto_pkey PRIMARY KEY (id_voto);


--
-- TOC entry 2931 (class 2606 OID 16822)
-- Name: candidato candidato_id_legenda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidato
    ADD CONSTRAINT candidato_id_legenda_fkey FOREIGN KEY (id_legenda) REFERENCES public.legenda(id_legenda) ON DELETE CASCADE;


--
-- TOC entry 2932 (class 2606 OID 16827)
-- Name: candidato candidato_id_partidario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidato
    ADD CONSTRAINT candidato_id_partidario_fkey FOREIGN KEY (id_partidario) REFERENCES public.partidario(id_partidario) ON DELETE CASCADE;


--
-- TOC entry 2926 (class 2606 OID 16754)
-- Name: fiscal fiscal_id_eleitor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fiscal
    ADD CONSTRAINT fiscal_id_eleitor_fkey FOREIGN KEY (id_eleitor) REFERENCES public.eleitor(id_eleitor) ON DELETE CASCADE;


--
-- TOC entry 2930 (class 2606 OID 16809)
-- Name: legenda legenda_id_eleicao_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.legenda
    ADD CONSTRAINT legenda_id_eleicao_fkey FOREIGN KEY (id_eleicao) REFERENCES public.eleicao(id_eleicao) ON DELETE CASCADE;


--
-- TOC entry 2929 (class 2606 OID 16804)
-- Name: legenda legenda_id_partido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.legenda
    ADD CONSTRAINT legenda_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES public.partido(id_partido) ON DELETE CASCADE;


--
-- TOC entry 2933 (class 2606 OID 16840)
-- Name: login login_id_eleitor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_id_eleitor_fkey FOREIGN KEY (id_eleitor) REFERENCES public.eleitor(id_eleitor) ON DELETE CASCADE;


--
-- TOC entry 2927 (class 2606 OID 16775)
-- Name: partidario partidario_id_eleitor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partidario
    ADD CONSTRAINT partidario_id_eleitor_fkey FOREIGN KEY (id_eleitor) REFERENCES public.eleitor(id_eleitor) ON DELETE CASCADE;


--
-- TOC entry 2928 (class 2606 OID 16780)
-- Name: partidario partidario_id_partido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partidario
    ADD CONSTRAINT partidario_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES public.partido(id_partido) ON DELETE CASCADE;


--
-- TOC entry 2936 (class 2606 OID 16863)
-- Name: voto voto_id_candidato_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voto
    ADD CONSTRAINT voto_id_candidato_fkey FOREIGN KEY (id_candidato) REFERENCES public.candidato(id_candidato) ON DELETE CASCADE;


--
-- TOC entry 2934 (class 2606 OID 16853)
-- Name: voto voto_id_eleitor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voto
    ADD CONSTRAINT voto_id_eleitor_fkey FOREIGN KEY (id_eleitor) REFERENCES public.eleitor(id_eleitor) ON DELETE CASCADE;


--
-- TOC entry 2935 (class 2606 OID 16858)
-- Name: voto voto_id_legenda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voto
    ADD CONSTRAINT voto_id_legenda_fkey FOREIGN KEY (id_legenda) REFERENCES public.legenda(id_legenda) ON DELETE CASCADE;


-- Completed on 2021-04-06 01:11:05

--
-- PostgreSQL database dump complete
--

