PGDMP                         y            Urna    13.2    13.2 D               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16461    Urna    DATABASE     f   CREATE DATABASE "Urna" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Urna";
                postgres    false            �            1259    16661 	   candidato    TABLE     �   CREATE TABLE public.candidato (
    id_candidato integer NOT NULL,
    id_legenda integer NOT NULL,
    id_partidario integer NOT NULL,
    numero integer NOT NULL,
    votos_candidato integer DEFAULT 0
);
    DROP TABLE public.candidato;
       public         heap    postgres    false            �            1259    16659    candidato_id_candidato_seq    SEQUENCE     �   CREATE SEQUENCE public.candidato_id_candidato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.candidato_id_candidato_seq;
       public          postgres    false    215                       0    0    candidato_id_candidato_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.candidato_id_candidato_seq OWNED BY public.candidato.id_candidato;
          public          postgres    false    214            �            1259    16619    diretor    TABLE     �   CREATE TABLE public.diretor (
    id_diretor integer NOT NULL,
    id_partidario integer NOT NULL,
    expiracao_do_cargo date NOT NULL
);
    DROP TABLE public.diretor;
       public         heap    postgres    false            �            1259    16617    diretor_id_diretor_seq    SEQUENCE     �   CREATE SEQUENCE public.diretor_id_diretor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.diretor_id_diretor_seq;
       public          postgres    false    209                       0    0    diretor_id_diretor_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.diretor_id_diretor_seq OWNED BY public.diretor.id_diretor;
          public          postgres    false    208            �            1259    16632    eleicao    TABLE     �   CREATE TABLE public.eleicao (
    id_eleicao integer NOT NULL,
    cargo character varying(200) NOT NULL,
    regiao character varying(200) NOT NULL,
    data_da_eleicao date NOT NULL,
    turno character varying(200) NOT NULL
);
    DROP TABLE public.eleicao;
       public         heap    postgres    false            �            1259    16630    eleicao_id_eleicao_seq    SEQUENCE     �   CREATE SEQUENCE public.eleicao_id_eleicao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.eleicao_id_eleicao_seq;
       public          postgres    false    211            	           0    0    eleicao_id_eleicao_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.eleicao_id_eleicao_seq OWNED BY public.eleicao.id_eleicao;
          public          postgres    false    210            �            1259    16572    eleitor    TABLE     �   CREATE TABLE public.eleitor (
    id_eleitor integer NOT NULL,
    nome character varying(200) NOT NULL,
    nascimento date NOT NULL,
    cpf character varying(14) NOT NULL,
    titulo character varying(14) NOT NULL
);
    DROP TABLE public.eleitor;
       public         heap    postgres    false            �            1259    16570    eleitor_id_eleitor_seq    SEQUENCE     �   CREATE SEQUENCE public.eleitor_id_eleitor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.eleitor_id_eleitor_seq;
       public          postgres    false    201            
           0    0    eleitor_id_eleitor_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.eleitor_id_eleitor_seq OWNED BY public.eleitor.id_eleitor;
          public          postgres    false    200            �            1259    16580    fiscal    TABLE     }   CREATE TABLE public.fiscal (
    id_fiscal integer NOT NULL,
    id_eleitor integer NOT NULL,
    expiracao_do_cargo date
);
    DROP TABLE public.fiscal;
       public         heap    postgres    false            �            1259    16578    fiscal_id_fiscal_seq    SEQUENCE     �   CREATE SEQUENCE public.fiscal_id_fiscal_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.fiscal_id_fiscal_seq;
       public          postgres    false    203                       0    0    fiscal_id_fiscal_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.fiscal_id_fiscal_seq OWNED BY public.fiscal.id_fiscal;
          public          postgres    false    202            �            1259    16643    legenda    TABLE     �   CREATE TABLE public.legenda (
    id_legenda integer NOT NULL,
    id_partido integer NOT NULL,
    id_eleicao integer NOT NULL,
    votos_legenda integer DEFAULT 0
);
    DROP TABLE public.legenda;
       public         heap    postgres    false            �            1259    16641    legenda_id_legenda_seq    SEQUENCE     �   CREATE SEQUENCE public.legenda_id_legenda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.legenda_id_legenda_seq;
       public          postgres    false    213                       0    0    legenda_id_legenda_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.legenda_id_legenda_seq OWNED BY public.legenda.id_legenda;
          public          postgres    false    212            �            1259    16601 
   partidario    TABLE     �   CREATE TABLE public.partidario (
    id_partidario integer NOT NULL,
    id_eleitor integer NOT NULL,
    id_partido integer NOT NULL,
    cargo_no_partido character varying(200) NOT NULL
);
    DROP TABLE public.partidario;
       public         heap    postgres    false            �            1259    16599    partidario_id_partidario_seq    SEQUENCE     �   CREATE SEQUENCE public.partidario_id_partidario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.partidario_id_partidario_seq;
       public          postgres    false    207                       0    0    partidario_id_partidario_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.partidario_id_partidario_seq OWNED BY public.partidario.id_partidario;
          public          postgres    false    206            �            1259    16593    partido    TABLE        CREATE TABLE public.partido (
    id_partido integer NOT NULL,
    numero integer NOT NULL,
    nome character varying(200)
);
    DROP TABLE public.partido;
       public         heap    postgres    false            �            1259    16591    partido_id_partido_seq    SEQUENCE     �   CREATE SEQUENCE public.partido_id_partido_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.partido_id_partido_seq;
       public          postgres    false    205                       0    0    partido_id_partido_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.partido_id_partido_seq OWNED BY public.partido.id_partido;
          public          postgres    false    204            U           2604    16664    candidato id_candidato    DEFAULT     �   ALTER TABLE ONLY public.candidato ALTER COLUMN id_candidato SET DEFAULT nextval('public.candidato_id_candidato_seq'::regclass);
 E   ALTER TABLE public.candidato ALTER COLUMN id_candidato DROP DEFAULT;
       public          postgres    false    214    215    215            Q           2604    16622    diretor id_diretor    DEFAULT     x   ALTER TABLE ONLY public.diretor ALTER COLUMN id_diretor SET DEFAULT nextval('public.diretor_id_diretor_seq'::regclass);
 A   ALTER TABLE public.diretor ALTER COLUMN id_diretor DROP DEFAULT;
       public          postgres    false    208    209    209            R           2604    16635    eleicao id_eleicao    DEFAULT     x   ALTER TABLE ONLY public.eleicao ALTER COLUMN id_eleicao SET DEFAULT nextval('public.eleicao_id_eleicao_seq'::regclass);
 A   ALTER TABLE public.eleicao ALTER COLUMN id_eleicao DROP DEFAULT;
       public          postgres    false    211    210    211            M           2604    16575    eleitor id_eleitor    DEFAULT     x   ALTER TABLE ONLY public.eleitor ALTER COLUMN id_eleitor SET DEFAULT nextval('public.eleitor_id_eleitor_seq'::regclass);
 A   ALTER TABLE public.eleitor ALTER COLUMN id_eleitor DROP DEFAULT;
       public          postgres    false    200    201    201            N           2604    16583    fiscal id_fiscal    DEFAULT     t   ALTER TABLE ONLY public.fiscal ALTER COLUMN id_fiscal SET DEFAULT nextval('public.fiscal_id_fiscal_seq'::regclass);
 ?   ALTER TABLE public.fiscal ALTER COLUMN id_fiscal DROP DEFAULT;
       public          postgres    false    203    202    203            S           2604    16646    legenda id_legenda    DEFAULT     x   ALTER TABLE ONLY public.legenda ALTER COLUMN id_legenda SET DEFAULT nextval('public.legenda_id_legenda_seq'::regclass);
 A   ALTER TABLE public.legenda ALTER COLUMN id_legenda DROP DEFAULT;
       public          postgres    false    213    212    213            P           2604    16604    partidario id_partidario    DEFAULT     �   ALTER TABLE ONLY public.partidario ALTER COLUMN id_partidario SET DEFAULT nextval('public.partidario_id_partidario_seq'::regclass);
 G   ALTER TABLE public.partidario ALTER COLUMN id_partidario DROP DEFAULT;
       public          postgres    false    206    207    207            O           2604    16596    partido id_partido    DEFAULT     x   ALTER TABLE ONLY public.partido ALTER COLUMN id_partido SET DEFAULT nextval('public.partido_id_partido_seq'::regclass);
 A   ALTER TABLE public.partido ALTER COLUMN id_partido DROP DEFAULT;
       public          postgres    false    204    205    205                       0    16661 	   candidato 
   TABLE DATA           e   COPY public.candidato (id_candidato, id_legenda, id_partidario, numero, votos_candidato) FROM stdin;
    public          postgres    false    215   �O       �          0    16619    diretor 
   TABLE DATA           P   COPY public.diretor (id_diretor, id_partidario, expiracao_do_cargo) FROM stdin;
    public          postgres    false    209   P       �          0    16632    eleicao 
   TABLE DATA           T   COPY public.eleicao (id_eleicao, cargo, regiao, data_da_eleicao, turno) FROM stdin;
    public          postgres    false    211   6P       �          0    16572    eleitor 
   TABLE DATA           L   COPY public.eleitor (id_eleitor, nome, nascimento, cpf, titulo) FROM stdin;
    public          postgres    false    201   Q       �          0    16580    fiscal 
   TABLE DATA           K   COPY public.fiscal (id_fiscal, id_eleitor, expiracao_do_cargo) FROM stdin;
    public          postgres    false    203   �R       �          0    16643    legenda 
   TABLE DATA           T   COPY public.legenda (id_legenda, id_partido, id_eleicao, votos_legenda) FROM stdin;
    public          postgres    false    213   �R       �          0    16601 
   partidario 
   TABLE DATA           ]   COPY public.partidario (id_partidario, id_eleitor, id_partido, cargo_no_partido) FROM stdin;
    public          postgres    false    207   �R       �          0    16593    partido 
   TABLE DATA           ;   COPY public.partido (id_partido, numero, nome) FROM stdin;
    public          postgres    false    205   7S                  0    0    candidato_id_candidato_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.candidato_id_candidato_seq', 1, false);
          public          postgres    false    214                       0    0    diretor_id_diretor_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.diretor_id_diretor_seq', 1, false);
          public          postgres    false    208                       0    0    eleicao_id_eleicao_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.eleicao_id_eleicao_seq', 13, true);
          public          postgres    false    210                       0    0    eleitor_id_eleitor_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.eleitor_id_eleitor_seq', 18, true);
          public          postgres    false    200                       0    0    fiscal_id_fiscal_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.fiscal_id_fiscal_seq', 1, false);
          public          postgres    false    202                       0    0    legenda_id_legenda_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.legenda_id_legenda_seq', 1, false);
          public          postgres    false    212                       0    0    partidario_id_partidario_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.partidario_id_partidario_seq', 14, true);
          public          postgres    false    206                       0    0    partido_id_partido_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.partido_id_partido_seq', 10, true);
          public          postgres    false    204            f           2606    16666    candidato candidato_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.candidato
    ADD CONSTRAINT candidato_pkey PRIMARY KEY (id_candidato);
 B   ALTER TABLE ONLY public.candidato DROP CONSTRAINT candidato_pkey;
       public            postgres    false    215            `           2606    16624    diretor diretor_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.diretor
    ADD CONSTRAINT diretor_pkey PRIMARY KEY (id_diretor);
 >   ALTER TABLE ONLY public.diretor DROP CONSTRAINT diretor_pkey;
       public            postgres    false    209            b           2606    16640    eleicao eleicao_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.eleicao
    ADD CONSTRAINT eleicao_pkey PRIMARY KEY (id_eleicao);
 >   ALTER TABLE ONLY public.eleicao DROP CONSTRAINT eleicao_pkey;
       public            postgres    false    211            X           2606    16577    eleitor eleitor_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.eleitor
    ADD CONSTRAINT eleitor_pkey PRIMARY KEY (id_eleitor);
 >   ALTER TABLE ONLY public.eleitor DROP CONSTRAINT eleitor_pkey;
       public            postgres    false    201            Z           2606    16585    fiscal fiscal_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.fiscal
    ADD CONSTRAINT fiscal_pkey PRIMARY KEY (id_fiscal);
 <   ALTER TABLE ONLY public.fiscal DROP CONSTRAINT fiscal_pkey;
       public            postgres    false    203            d           2606    16648    legenda legenda_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.legenda
    ADD CONSTRAINT legenda_pkey PRIMARY KEY (id_legenda);
 >   ALTER TABLE ONLY public.legenda DROP CONSTRAINT legenda_pkey;
       public            postgres    false    213            ^           2606    16606    partidario partidario_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.partidario
    ADD CONSTRAINT partidario_pkey PRIMARY KEY (id_partidario);
 D   ALTER TABLE ONLY public.partidario DROP CONSTRAINT partidario_pkey;
       public            postgres    false    207            \           2606    16598    partido partido_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_pkey PRIMARY KEY (id_partido);
 >   ALTER TABLE ONLY public.partido DROP CONSTRAINT partido_pkey;
       public            postgres    false    205            m           2606    16667 #   candidato candidato_id_legenda_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidato
    ADD CONSTRAINT candidato_id_legenda_fkey FOREIGN KEY (id_legenda) REFERENCES public.legenda(id_legenda) ON DELETE CASCADE;
 M   ALTER TABLE ONLY public.candidato DROP CONSTRAINT candidato_id_legenda_fkey;
       public          postgres    false    2916    213    215            n           2606    16672 &   candidato candidato_id_partidario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidato
    ADD CONSTRAINT candidato_id_partidario_fkey FOREIGN KEY (id_partidario) REFERENCES public.partidario(id_partidario) ON DELETE CASCADE;
 P   ALTER TABLE ONLY public.candidato DROP CONSTRAINT candidato_id_partidario_fkey;
       public          postgres    false    207    2910    215            j           2606    16625 "   diretor diretor_id_partidario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.diretor
    ADD CONSTRAINT diretor_id_partidario_fkey FOREIGN KEY (id_partidario) REFERENCES public.partidario(id_partidario) ON DELETE CASCADE;
 L   ALTER TABLE ONLY public.diretor DROP CONSTRAINT diretor_id_partidario_fkey;
       public          postgres    false    207    2910    209            g           2606    16586    fiscal fiscal_id_eleitor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.fiscal
    ADD CONSTRAINT fiscal_id_eleitor_fkey FOREIGN KEY (id_eleitor) REFERENCES public.eleitor(id_eleitor) ON DELETE CASCADE;
 G   ALTER TABLE ONLY public.fiscal DROP CONSTRAINT fiscal_id_eleitor_fkey;
       public          postgres    false    201    2904    203            l           2606    16654    legenda legenda_id_eleicao_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.legenda
    ADD CONSTRAINT legenda_id_eleicao_fkey FOREIGN KEY (id_eleicao) REFERENCES public.eleicao(id_eleicao) ON DELETE CASCADE;
 I   ALTER TABLE ONLY public.legenda DROP CONSTRAINT legenda_id_eleicao_fkey;
       public          postgres    false    213    211    2914            k           2606    16649    legenda legenda_id_partido_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.legenda
    ADD CONSTRAINT legenda_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES public.partido(id_partido) ON DELETE CASCADE;
 I   ALTER TABLE ONLY public.legenda DROP CONSTRAINT legenda_id_partido_fkey;
       public          postgres    false    205    2908    213            h           2606    16607 %   partidario partidario_id_eleitor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.partidario
    ADD CONSTRAINT partidario_id_eleitor_fkey FOREIGN KEY (id_eleitor) REFERENCES public.eleitor(id_eleitor) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.partidario DROP CONSTRAINT partidario_id_eleitor_fkey;
       public          postgres    false    207    201    2904            i           2606    16612 %   partidario partidario_id_partido_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.partidario
    ADD CONSTRAINT partidario_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES public.partido(id_partido) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.partidario DROP CONSTRAINT partidario_id_partido_fkey;
       public          postgres    false    207    205    2908                   x������ � �      �      x������ � �      �   �   x�m�1�0Eg�\��	P`eaUTebq�A� ���aX�k/FZPR�lyz�kHU\��	�xd�x�82���+�e`O��;�Q*�[pڂ:���Q��r'g;n��њr�;��3i�Oĵ@��׿�yt�yH�`�^�BWH5�.�q������o۬y�Yx�H�&�~�o�������O꫚�L�r�M�\�0VJ���r�      �   �  x�e�K�1D��S�*����eìFB�Ć���0�
[��7�\�t����a�$?E���cَ�����q��KN!Lz,��d9����� �7Q��|��㻲��f|_����h�'m&� j�H�Gb^o�,�?/5�����6 ��c,m ��ZF�Ô��D9�}�k]�|\�O��@�Xo��ڨbD9��j�ߥ���	䝧�(��"�r���Uwy�r8u��ҩ�6�4X&1����T�Q��*�|J��y;��*�$Ib%Jq��x�x��,�Æo�K��D��0����-�5^'o��ϰ�ko���먀�{��:����E�9Zy�o��7\s�|��c Ұ-g���Mn��޹pF|&��/�R��      �      x������ � �      �      x������ � �      �   J   x���4�4�tL���LL��24�44�4A0�4�@�M9�P4paHjq~iQjfPĄ�Ђ(�$���� ��      �   �   x�U�M� ��3��F�Zۭ0F�n&06$�@�o�I���������(+Y�$S�].����9U�2k�@�W���
�[9�j���+���3�{�v�~c���:G��Q�-#�.���L�(�Po��-��q�ՙ��b㰸�S���	^7���M�     