PGDMP     )    !                y            Urna    13.2    13.2 3    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16461    Urna    DATABASE     f   CREATE DATABASE "Urna" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Urna";
                postgres    false            �            1259    16525 	   candidato    TABLE     �   CREATE TABLE public.candidato (
    id_candidato integer NOT NULL,
    id_eleitor integer NOT NULL,
    id_partido integer NOT NULL,
    numero integer
);
    DROP TABLE public.candidato;
       public         heap    postgres    false            �            1259    16523    candidato_id_candidato_seq    SEQUENCE     �   CREATE SEQUENCE public.candidato_id_candidato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.candidato_id_candidato_seq;
       public          postgres    false    209            �           0    0    candidato_id_candidato_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.candidato_id_candidato_seq OWNED BY public.candidato.id_candidato;
          public          postgres    false    208            �            1259    16507    diretor    TABLE     �   CREATE TABLE public.diretor (
    id_diretor integer NOT NULL,
    id_eleitor integer NOT NULL,
    id_partido integer NOT NULL,
    expcargo date NOT NULL
);
    DROP TABLE public.diretor;
       public         heap    postgres    false            �            1259    16505    diretor_id_diretor_seq    SEQUENCE     �   CREATE SEQUENCE public.diretor_id_diretor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.diretor_id_diretor_seq;
       public          postgres    false    207            �           0    0    diretor_id_diretor_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.diretor_id_diretor_seq OWNED BY public.diretor.id_diretor;
          public          postgres    false    206            �            1259    16543    eleicao    TABLE     D  CREATE TABLE public.eleicao (
    id_eleicao integer NOT NULL,
    cargo character varying(200) NOT NULL,
    regiao character varying(200) NOT NULL,
    dia date NOT NULL,
    turno character varying(200) NOT NULL,
    partidos_selecionados character varying(10000),
    candidatos_selecionados character varying(10000)
);
    DROP TABLE public.eleicao;
       public         heap    postgres    false            �            1259    16541    eleicao_id_eleicao_seq    SEQUENCE     �   CREATE SEQUENCE public.eleicao_id_eleicao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.eleicao_id_eleicao_seq;
       public          postgres    false    211            �           0    0    eleicao_id_eleicao_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.eleicao_id_eleicao_seq OWNED BY public.eleicao.id_eleicao;
          public          postgres    false    210            �            1259    16478    eleitor    TABLE     �   CREATE TABLE public.eleitor (
    id_eleitor integer NOT NULL,
    nome character varying(200) NOT NULL,
    nascimento date NOT NULL,
    cpf character varying(14) NOT NULL,
    titulo character varying(14) NOT NULL
);
    DROP TABLE public.eleitor;
       public         heap    postgres    false            �            1259    16476    eleitor_id_eleitor_seq    SEQUENCE     �   CREATE SEQUENCE public.eleitor_id_eleitor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.eleitor_id_eleitor_seq;
       public          postgres    false    201            �           0    0    eleitor_id_eleitor_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.eleitor_id_eleitor_seq OWNED BY public.eleitor.id_eleitor;
          public          postgres    false    200            �            1259    16486    fiscal    TABLE     r   CREATE TABLE public.fiscal (
    id_fical integer NOT NULL,
    id_eleitor integer NOT NULL,
    expcargo date
);
    DROP TABLE public.fiscal;
       public         heap    postgres    false            �            1259    16484    fiscal_id_fical_seq    SEQUENCE     �   CREATE SEQUENCE public.fiscal_id_fical_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.fiscal_id_fical_seq;
       public          postgres    false    203            �           0    0    fiscal_id_fical_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.fiscal_id_fical_seq OWNED BY public.fiscal.id_fical;
          public          postgres    false    202            �            1259    16499    partido    TABLE     v   CREATE TABLE public.partido (
    id_partido integer NOT NULL,
    numero integer,
    nome character varying(200)
);
    DROP TABLE public.partido;
       public         heap    postgres    false            �            1259    16497    partido_id_partido_seq    SEQUENCE     �   CREATE SEQUENCE public.partido_id_partido_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.partido_id_partido_seq;
       public          postgres    false    205            �           0    0    partido_id_partido_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.partido_id_partido_seq OWNED BY public.partido.id_partido;
          public          postgres    false    204            E           2604    16528    candidato id_candidato    DEFAULT     �   ALTER TABLE ONLY public.candidato ALTER COLUMN id_candidato SET DEFAULT nextval('public.candidato_id_candidato_seq'::regclass);
 E   ALTER TABLE public.candidato ALTER COLUMN id_candidato DROP DEFAULT;
       public          postgres    false    209    208    209            D           2604    16510    diretor id_diretor    DEFAULT     x   ALTER TABLE ONLY public.diretor ALTER COLUMN id_diretor SET DEFAULT nextval('public.diretor_id_diretor_seq'::regclass);
 A   ALTER TABLE public.diretor ALTER COLUMN id_diretor DROP DEFAULT;
       public          postgres    false    207    206    207            F           2604    16546    eleicao id_eleicao    DEFAULT     x   ALTER TABLE ONLY public.eleicao ALTER COLUMN id_eleicao SET DEFAULT nextval('public.eleicao_id_eleicao_seq'::regclass);
 A   ALTER TABLE public.eleicao ALTER COLUMN id_eleicao DROP DEFAULT;
       public          postgres    false    211    210    211            A           2604    16481    eleitor id_eleitor    DEFAULT     x   ALTER TABLE ONLY public.eleitor ALTER COLUMN id_eleitor SET DEFAULT nextval('public.eleitor_id_eleitor_seq'::regclass);
 A   ALTER TABLE public.eleitor ALTER COLUMN id_eleitor DROP DEFAULT;
       public          postgres    false    201    200    201            B           2604    16489    fiscal id_fical    DEFAULT     r   ALTER TABLE ONLY public.fiscal ALTER COLUMN id_fical SET DEFAULT nextval('public.fiscal_id_fical_seq'::regclass);
 >   ALTER TABLE public.fiscal ALTER COLUMN id_fical DROP DEFAULT;
       public          postgres    false    202    203    203            C           2604    16502    partido id_partido    DEFAULT     x   ALTER TABLE ONLY public.partido ALTER COLUMN id_partido SET DEFAULT nextval('public.partido_id_partido_seq'::regclass);
 A   ALTER TABLE public.partido ALTER COLUMN id_partido DROP DEFAULT;
       public          postgres    false    205    204    205            �          0    16525 	   candidato 
   TABLE DATA           Q   COPY public.candidato (id_candidato, id_eleitor, id_partido, numero) FROM stdin;
    public          postgres    false    209   ^:       �          0    16507    diretor 
   TABLE DATA           O   COPY public.diretor (id_diretor, id_eleitor, id_partido, expcargo) FROM stdin;
    public          postgres    false    207   �:       �          0    16543    eleicao 
   TABLE DATA           x   COPY public.eleicao (id_eleicao, cargo, regiao, dia, turno, partidos_selecionados, candidatos_selecionados) FROM stdin;
    public          postgres    false    211   �:       �          0    16478    eleitor 
   TABLE DATA           L   COPY public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) FROM stdin;
    public          postgres    false    201   �:       �          0    16486    fiscal 
   TABLE DATA           @   COPY public.fiscal (id_fical, id_eleitor, expcargo) FROM stdin;
    public          postgres    false    203   �;       �          0    16499    partido 
   TABLE DATA           ;   COPY public.partido (id_partido, numero, nome) FROM stdin;
    public          postgres    false    205   �;       �           0    0    candidato_id_candidato_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.candidato_id_candidato_seq', 2, true);
          public          postgres    false    208            �           0    0    diretor_id_diretor_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.diretor_id_diretor_seq', 1, false);
          public          postgres    false    206            �           0    0    eleicao_id_eleicao_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.eleicao_id_eleicao_seq', 1, true);
          public          postgres    false    210            �           0    0    eleitor_id_eleitor_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.eleitor_id_eleitor_seq', 5, true);
          public          postgres    false    200            �           0    0    fiscal_id_fical_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.fiscal_id_fical_seq', 1, false);
          public          postgres    false    202            �           0    0    partido_id_partido_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.partido_id_partido_seq', 5, true);
          public          postgres    false    204            P           2606    16530    candidato candidato_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.candidato
    ADD CONSTRAINT candidato_pkey PRIMARY KEY (id_candidato);
 B   ALTER TABLE ONLY public.candidato DROP CONSTRAINT candidato_pkey;
       public            postgres    false    209            N           2606    16512    diretor diretor_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.diretor
    ADD CONSTRAINT diretor_pkey PRIMARY KEY (id_diretor);
 >   ALTER TABLE ONLY public.diretor DROP CONSTRAINT diretor_pkey;
       public            postgres    false    207            R           2606    16551    eleicao eleicao_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.eleicao
    ADD CONSTRAINT eleicao_pkey PRIMARY KEY (id_eleicao);
 >   ALTER TABLE ONLY public.eleicao DROP CONSTRAINT eleicao_pkey;
       public            postgres    false    211            H           2606    16483    eleitor eleitor_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.eleitor
    ADD CONSTRAINT eleitor_pkey PRIMARY KEY (id_eleitor);
 >   ALTER TABLE ONLY public.eleitor DROP CONSTRAINT eleitor_pkey;
       public            postgres    false    201            J           2606    16491    fiscal fiscal_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.fiscal
    ADD CONSTRAINT fiscal_pkey PRIMARY KEY (id_fical);
 <   ALTER TABLE ONLY public.fiscal DROP CONSTRAINT fiscal_pkey;
       public            postgres    false    203            L           2606    16504    partido partido_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_pkey PRIMARY KEY (id_partido);
 >   ALTER TABLE ONLY public.partido DROP CONSTRAINT partido_pkey;
       public            postgres    false    205            V           2606    16531 #   candidato candidato_id_eleitor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidato
    ADD CONSTRAINT candidato_id_eleitor_fkey FOREIGN KEY (id_eleitor) REFERENCES public.eleitor(id_eleitor);
 M   ALTER TABLE ONLY public.candidato DROP CONSTRAINT candidato_id_eleitor_fkey;
       public          postgres    false    201    2888    209            W           2606    16536 #   candidato candidato_id_partido_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidato
    ADD CONSTRAINT candidato_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES public.partido(id_partido);
 M   ALTER TABLE ONLY public.candidato DROP CONSTRAINT candidato_id_partido_fkey;
       public          postgres    false    2892    209    205            T           2606    16513    diretor diretor_id_eleitor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.diretor
    ADD CONSTRAINT diretor_id_eleitor_fkey FOREIGN KEY (id_eleitor) REFERENCES public.eleitor(id_eleitor);
 I   ALTER TABLE ONLY public.diretor DROP CONSTRAINT diretor_id_eleitor_fkey;
       public          postgres    false    207    201    2888            U           2606    16518    diretor diretor_id_partido_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.diretor
    ADD CONSTRAINT diretor_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES public.partido(id_partido);
 I   ALTER TABLE ONLY public.diretor DROP CONSTRAINT diretor_id_partido_fkey;
       public          postgres    false    207    2892    205            S           2606    16492    fiscal fiscal_id_eleitor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.fiscal
    ADD CONSTRAINT fiscal_id_eleitor_fkey FOREIGN KEY (id_eleitor) REFERENCES public.eleitor(id_eleitor);
 G   ALTER TABLE ONLY public.fiscal DROP CONSTRAINT fiscal_id_eleitor_fkey;
       public          postgres    false    201    203    2888            �      x�3�4�4�44261�2�4�4��c���� >~      �      x������ � �      �   ;   x�3�(JMK�,)-J��*ͬRHIUp�r---u�t�8C�2��9c���+F��� �      �   �   x�]�1
�0Eg����%ۉ=��v�"�CH =�i���A�����^����G>��:�6+p��:����S��)���>af�ƃ�ⶐXI���[�Ux�	;��M�Ҋ.��SO]�ɹ��a&�!u/�-�:W�%�"c�E�8d      �      x������ � �      �   4   x�3�44�,I-.I�2�42�L.cN#C���	��	T�$�\1z\\\ ��A     