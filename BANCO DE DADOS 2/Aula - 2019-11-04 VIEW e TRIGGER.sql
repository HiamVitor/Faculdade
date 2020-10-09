**************************************************
**************************************************
**************************************************
**************************************************
CREATE OR REPLACE VIEW <NOME DA VIEW> AS
<SELECT>



-----------------------------------------------------
CREATE TABLE ESTADOS(
I_ESTADO INTEGER NOT NULL,
NOME VARCHAR(100),
SIGLA CHAR(2),
CONSTRAINT PK_ESTADOS PRIMARY KEY(I_ESTADO));


INSERT INTO ESTADOS VALUES(1, 'Rio Grande do Sul', 'RS');
INSERT INTO ESTADOS VALUES(3, 'Paraná', 'PR');
INSERT INTO ESTADOS VALUES(2, 'Santa Catarina', 'SC');

----------------------------------------------------


CREATE OR REPLACE VIEW VW_ESTADOS AS 
SELECT * FROM ESTADOS;

SELECT * FROM VW_ESTADOS;








ALTER TABLE ESTADOS
ADD COLUNA_TESTE INTEGER NULL;

SELECT * FROM VW_ESTADOS;

CREATE OR REPLACE VIEW VW_ESTADOS AS 
SELECT * FROM ESTADOS;

SELECT * FROM VW_ESTADOS;

ALTER TABLE ESTADOS
DROP COLUMN COLUNA_TESTE;

SELECT * FROM VW_ESTADOS;

CREATE OR REPLACE VIEW VW_ESTADOS AS 
SELECT * FROM ESTADOS;

SELECT * FROM VW_ESTADOS;



SELECT NOME, SIGLA FROM VW_ESTADOS;









-------------------------------------------------------
CREATE OR REPLACE VIEW VW_ESTADOS AS 
SELECT  NOME AS NOME_ESTADO,
	   SIGLA AS SIGLA_ESTADO
  FROM ESTADOS;

SELECT * FROM VW_ESTADOS;
SELECT NOME,* FROM VW_ESTADOS;
SELECT NOME_ESTADO,* FROM VW_ESTADOS;
SELECT NOME_ESTADO,VW_ESTADOS.* FROM VW_ESTADOS;
SELECT * FROM VW_ESTADOS WHERE I_ESTADO > 1;

-------------------------------------------------------
CREATE OR REPLACE VIEW VW_ESTADOS AS 
SELECT I_ESTADO AS COD_ESTADO,
	   NOME AS NOME_ESTADO,
	   SIGLA AS SIGLA_ESTADO
  FROM ESTADOS;

SELECT * FROM VW_ESTADOS
  WHERE I_ESTADO > 1;

SELECT * FROM VW_ESTADOS
  WHERE COD_ESTADO > 1;
 

-------------------------------------------------------
CREATE OR REPLACE VIEW VW_ESTADOS AS 
SELECT ESTADOS.I_ESTADO,
	   ESTADOS.NOME,
	   ESTADOS.SIGLA
  FROM ESTADOS; 


SELECT * FROM VW_ESTADOS;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
CONSTRUIR UMA VIEW PARA APRESENTAR O CÓDIGO DA VENDA, 
DATA DA VENDA,VALOR DA VENDA, VALOR FINAL DA VENDA, 
PERCENTUAL DE DESCONTO E VALOR DO DESCONTO(
VALOR DA VENDA MENOS O VALOR FINAL DA VENDA)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
CREATE OR REPLACE VIEW VW_VENDAS AS
SELECT VENDAS.I_VENDA,
	   VENDAS.DATA_VENDA,
	   VENDAS.VALOR_VENDA,
	   VENDAS.VALOR_FINAL,
	   ((VENDAS.DESCONTO * 100)/ VENDAS.VALOR_VENDA) 
	   AS PERC_DESCONTO,
	   (VENDAS.VALOR_VENDA - VENDAS.VALOR_FINAL)
	    AS VLR_DESC
  FROM VENDAS;

SELECT * FROM VW_VENDAS;

SELECT * FROM VW_VENDAS, itens_vendas
  where vw_vendas.i_venda = itens_vendas.i_venda and
        perc_desconto <= 10;

---------------------------------------------------------

CREATE OR REPLACE VIEW VW_VENDAS AS
SELECT VENDAS.I_VENDA,
       VENDAS.I_CLIENTE,
	   VENDAS.DATA_VENDA,
	   VENDAS.VALOR_VENDA,
	   VENDAS.VALOR_FINAL,
	   ((VENDAS.DESCONTO * 100)/ VENDAS.VALOR_VENDA) AS PERC_DESCONTO,
	   (VENDAS.VALOR_VENDA - VENDAS.VALOR_FINAL) AS VLR_DESC
  FROM VENDAS;
------------------------------------------------------------------
SELECIONAR O NOME DO CLIENTE, CODIGO DA VENDA, DATA DA VENDA E
VALOR DO DESCONTO, ATRAVÉS DA VIEW VW_VENDAS E DA TABELA DE CLIENTES.
------------------------------------------------------------------

SELECT CLIENTES.NOME,
       VW_VENDAS.I_VENDA,
       VW_VENDAS.DATA_VENDA,
       VW_VENDAS.VLR_DESC
  FROM VW_VENDAS, CLIENTES
 WHERE VW_VENDAS.I_CLIENTE = CLIENTES.I_CLIENTE;



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
CONSTRUIR UMA VIEW PARA SELECIONAR O CÓDIGO E NOME DOS CLIENTES
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
CREATE OR REPLACE VIEW VW_CLIENTES AS
SELECT CLIENTES.I_CLIENTE,
	   CLIENTES.NOME
  FROM CLIENTES;

SELECT * FROM VW_CLIENTES;


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
CONSTRUIR UMA VIEW PARA SELECIONAR O CÓDIGO DO CLIENTE, 
CÓDIGO DA VENDA NOS ITENS DA VENDA,O NOME DO PRODUTO DO ITEM 
DA VENDA, A QUANTIDADE DE CADA PRODUTO DO ITEM DA VENDA 
E O VALOR DE CADA ITEM DA VENDA.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

CREATE OR REPLACE VIEW VW_VENDAS_ITENS AS
SELECT VENDAS.I_CLIENTE,
	   ITENS_VENDAS.I_VENDA,
	   PRODUTOS.NOME,
	   ITENS_VENDAS.QUANTIDADE,
	   (ITENS_VENDAS.VALOR_VENDA * ITENS_VENDAS.QUANTIDADE) AS 
	   VALOR_ITEM
  FROM VENDAS,
  	   ITENS_VENDAS,
  	   PRODUTOS
 WHERE VENDAS.I_VENDA = ITENS_VENDAS.I_VENDA AND
 	   ITENS_VENDAS.I_PRODUTO = PRODUTOS.I_PRODUTO;

---------------------------------------------------------------
OU
---------------------------------------------------------------
CREATE OR REPLACE VIEW VW_VENDAS_ITENS AS
SELECT VENDAS.I_CLIENTE,
	   ITENS_VENDAS.I_VENDA,
	   PRODUTOS.NOME,
	   ITENS_VENDAS.QUANTIDADE,
	   (ITENS_VENDAS.VALOR_VENDA * ITENS_VENDAS.QUANTIDADE) AS 
	   VALOR_ITEM
  FROM VENDAS INNER JOIN ITENS_VENDAS 
       ON(VENDAS.I_VENDA = ITENS_VENDAS.I_VENDA) INNER JOIN
  	   PRODUTOS ON(ITENS_VENDAS.I_PRODUTO = PRODUTOS.I_PRODUTO);



SELECT * FROM VW_VENDAS_ITENS;



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% EXERCÍCIO 005
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
SELECIONAR A PARTIR DAS VIEWs CRIADAS O NOME DO CLIENTE, 
O NOME DOS PRODUTOS COMPRADOS POR CADA CLIENTE E A QUANTIDADE 
DE CADA PRODUTO.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

SELECT VW_CLIENTES.NOME,
	   VW_VENDAS_ITENS.NOME,
	   SUM(VW_VENDAS_ITENS.QUANTIDADE)
  FROM VW_CLIENTES,
       VW_VENDAS_ITENS
 WHERE VW_CLIENTES.I_CLIENTE = VW_VENDAS_ITENS.I_CLIENTE
 GROUP BY VW_CLIENTES.NOME,
	   VW_VENDAS_ITENS.NOME


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% EXERCÍCIO 006
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
SELECIONAR A PARTIR DAS VIEWs CRIADAS O CÓDIGO DA VENDA, 
O NOME DO PRODUTO E QUANTIDADE DE CADA PRODUTO EM CADA VENDA, 
ALÉM DO VALOR DE VENDA PARA CADA VENDA.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

SELECT VW_VENDAS_ITENS.I_VENDA,
	   VW_VENDAS_ITENS.NOME,
	   VW_VENDAS_ITENS.QUANTIDADE,
	   VW_VENDAS_ITENS.VALOR_ITEM
  FROM VW_VENDAS_ITENS;



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% EXERCÍCIO 007
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
SELECIONAR O NOME DO CLIENTE, A DATA EM QUE ELE REALIZOU COMPRAS, 
O VALOR DAS TOTAL DAS COMPRAS PARA CADA DATA, QUANTIDADE DE ITENS 
DE CADA PRODUTO PARA CADA DATA.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
SELECT CLIENTES.NOME,
	   VENDAS.DATA_VENDA,
	   PRODUTOS.NOME,
	   SUM(VENDAS.VALOR_FINAL),
	   SUM(ITENS_VENDAS.QUANTIDADE)
  FROM CLIENTES INNER JOIN 
       VENDAS ON(CLIENTES.I_CLIENTE = VENDAS.I_CLIENTE) INNER JOIN
       ITENS_VENDAS ON(VENDAS.I_VENDA = ITENS_VENDAS.I_VENDA) INNER JOIN
       PRODUTOS ON(ITENS_VENDAS.I_PRODUTO = PRODUTOS.I_PRODUTO)
 GROUP BY CLIENTES.NOME,
	      VENDAS.DATA_VENDA,
	      PRODUTOS.NOME
-------------------------------------------------------------------
OU
-------------------------------------------------------------------

SELECT CLIENTES.NOME,
	   VENDAS.DATA_VENDA,
	   PRODUTOS.NOME,
	   SUM(VENDAS.VALOR_FINAL),
	   SUM(ITENS_VENDAS.QUANTIDADE)
  FROM CLIENTES,
       VENDAS,
       ITENS_VENDAS,
       PRODUTOS 
 WHERE CLIENTES.I_CLIENTE = VENDAS.I_CLIENTE AND
	   VENDAS.I_VENDA = ITENS_VENDAS.I_VENDA AND 
	   ITENS_VENDAS.I_PRODUTO = PRODUTOS.I_PRODUTO
 GROUP BY CLIENTES.NOME,
	      VENDAS.DATA_VENDA,
	      PRODUTOS.NOME



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% EXERCÍCIO 008
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
CRIAR AS VIEWs REFERENTES AOS EXERCÍCIOS 004, 005, 006 E 007
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
-------------------------------------
- 004
-------------------------------------
CREATE OR REPLACE VIEW VW_004 AS
SELECT VW_CLIENTES.NOME,
	   VW_VENDAS_ITENS.I_VENDA,
 	   SUM(VW_VENDAS_ITENS.VALOR_VENDA) AS SOMA
  FROM VW_CLIENTES,
  	   VW_VENDAS_ITENS
 WHERE VW_CLIENTES.I_CLIENTE = VW_VENDAS_ITENS.I_CLIENTE
 GROUP BY VW_CLIENTES.NOME,
	      VW_VENDAS_ITENS.I_VENDA;

SELECT * FROM VW_004;


SELECT * FROM VW_004
WHERE SOMA > 100;

-------------------------------------
- 005
-------------------------------------
CREATE OR REPLACE VIEW VW_005 AS
SELECT VW_CLIENTES.NOME AS NOME_CLI,
	   VW_VENDAS_ITENS.NOME AS NOME_PROD,
	   SUM(VW_VENDAS_ITENS.QUANTIDADE) AS SOMA
  FROM VW_CLIENTES,
       VW_VENDAS_ITENS
 WHERE VW_CLIENTES.I_CLIENTE = VW_VENDAS_ITENS.I_CLIENTE
 GROUP BY VW_CLIENTES.NOME,
	   VW_VENDAS_ITENS.NOME;
 
SELECT * FROM VW_005;

-------------------------------------
- 006
-------------------------------------
CREATE OR REPLACE VIEW VW_006 AS
SELECT VW_VENDAS_ITENS.I_VENDA,
	   VW_VENDAS_ITENS.NOME,
	   VW_VENDAS_ITENS.QUANTIDADE,
	   VW_VENDAS_ITENS.VALOR_VENDA
  FROM VW_VENDAS_ITENS;

SELECT * FROM VW_006;  


-------------------------------------
- 007
-------------------------------------
CREATE OR REPLACE VIEW VW_007 AS
SELECT CLIENTES.NOME AS NOME_CLI,
	   VENDAS.DATA_VENDA,
	   PRODUTOS.NOME AS NOME_PROD,
	   SUM(VENDAS.VALOR_FINAL) AS SOMA_VLR,
	   SUM(ITENS_VENDAS.QUANTIDADE) AS SOMA_QTD
  FROM CLIENTES,
       VENDAS,
       ITENS_VENDAS,
       PRODUTOS 
 WHERE CLIENTES.I_CLIENTE = VENDAS.I_CLIENTE AND
	   VENDAS.I_VENDA = ITENS_VENDAS.I_VENDA AND 
	   ITENS_VENDAS.I_PRODUTO = PRODUTOS.I_PRODUTO
 GROUP BY CLIENTES.NOME,
	      VENDAS.DATA_VENDA,
	      PRODUTOS.NOME;

SELECT * FROM VW_007;



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
EXERCÍCIO 009
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
CRIAR UMA VIEW PARA BUSCAR DADOS DA VIEW VW_VENDAS_ITENS E 
DA TABELA DE CLIENTES. A NOVA VIEW DEVERÁ BUSCAR O CÓDIGO DO 
CLIENTE, O NOME DO CLIENTE, O NOME DOS PRODUTOS COMPRADOS POR
 CADA CLIENTE, BEM COMO A QUANTIDADE DE CADA PRODUTO.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
CREATE OR REPLACE VIEW VW_VENDAS_CLIENTES AS
SELECT CLIENTES.I_CLIENTE,
	   CLIENTES.NOME AS NOME_CLI,
	   VW_VENDAS_ITENS.NOME AS NOME_PROD,
	   SUM(VW_VENDAS_ITENS.QUANTIDADE) AS QTD_PROD
  FROM CLIENTES,
  	   VW_VENDAS_ITENS
 WHERE CLIENTES.I_CLIENTE = VW_VENDAS_ITENS.I_CLIENTE
 GROUP BY CLIENTES.I_CLIENTE,
 	   CLIENTES.NOME,
 	   VW_VENDAS_ITENS.NOME;

SELECT * FROM VW_VENDAS_CLIENTES;





















&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
TRIGGER
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
------------------------------------------------------------------
SINTAXE
------------------------------------------------------------------

CREATE TRIGGER nome { BEFORE | AFTER } { evento [ OR ... ] }
   ON tabela [ FOR [ EACH ] { ROW | STATEMENT } ]
   EXECUTE PROCEDURE nome_da_função ( argumentos )

-----------------------------------------------------------------

CREATE TABLE ESTADOS(
I_ESTADO INTEGER NOT NULL,
NOME VARCHAR(100),
SIGLA CHAR(2),
CONSTRAINT PK_ESTADOS PRIMARY KEY(I_ESTADO));


CREATE TABLE AUDIT_ESTADOS(
I_ESTADO INTEGER,
NOME VARCHAR(100),
SIGLA CHAR(2),
DATA_OPERACAO DATE NOT NULL,
USUARIO VARCHAR(50) NOT NULL,
OPERACAO CHAR(1) NOT NULL );



CREATE OR REPLACE FUNCTION audit_estados() RETURNS TRIGGER 
AS $audit_estados$
    BEGIN
        IF (TG_OP = 'DELETE') THEN
            INSERT INTO audit_estados SELECT OLD.*, now(), user, 'D';
            RETURN OLD;
        ELSIF (TG_OP = 'UPDATE') THEN
            INSERT INTO audit_estados SELECT NEW.*, now(), user, 'U';
            RETURN NEW;
        ELSIF (TG_OP = 'INSERT') THEN
            INSERT INTO audit_estados SELECT NEW.*, now(), user, 'I';
            RETURN NEW;
        END IF;
        RETURN NULL; 
    END;
$audit_estados$ LANGUAGE plpgsql;


CREATE TRIGGER audit_estados
AFTER INSERT OR UPDATE OR DELETE ON estados
    FOR EACH ROW EXECUTE PROCEDURE audit_estados();

-----------------------------------------------------------------


 CREATE TABLE empregados(
  codigo int4 NOT NULL,
  nome varchar,
  salario int4,
  departamento_cod int4,
  ultima_data timestamp,
  ultimo_usuario varchar(50),
  CONSTRAINT empregados_pkey PRIMARY KEY (codigo) ) 

  CREATE FUNCTION empregados_gatilho() RETURNS trigger AS $empregados_gatilho$
    BEGIN
        -- Verificar se foi fornecido o nome e o salário do empregado
        IF NEW.nome IS NULL THEN
            RAISE EXCEPTION 'O nome do empregado não pode ser nulo';
        END IF;
        IF NEW.salario IS NULL THEN
            RAISE EXCEPTION '% não pode ter um salário nulo', NEW.nome;
        END IF;
        --  
        -- Quem paga para trabalhar?
        --      
        IF NEW.salario < 0 THEN
            RAISE EXCEPTION '% não pode ter um salário negativo', NEW.nome;
        END IF;
        --  
        --
        -- Registrar quem alterou a folha de pagamento e quando
        --
        NEW.ultima_data := 'now';
        NEW.ultimo_usuario := current_user;
        RETURN NEW;
    END;
  $empregados_gatilho$ LANGUAGE plpgsql;


  CREATE TRIGGER empregados_gatilho BEFORE INSERT OR UPDATE ON empregados
    FOR EACH ROW EXECUTE PROCEDURE empregados_gatilho();


INSERT INTO empregados (codigo,nome, salario) VALUES (5,'João',1000);
INSERT INTO empregados (codigo,nome, salario) VALUES (6,'José',1500);
INSERT INTO empregados (codigo,nome, salario) VALUES (7,'Maria',2500);
SELECT * FROM empregados;
INSERT INTO empregados (codigo,nome, salario) VALUES (5,NULL,1000);
NEW – Para INSERT e UPDATE
OLD – Para DELETE


  CREATE TABLE empregados (
    nome  varchar NOT NULL,
    salario     integer
  );

  CREATE TABLE empregados_audit(
    operacao    char(1)   NOT NULL,
    usuario     varchar      NOT NULL,
    data        timestamp NOT NULL,
    nome    varchar      NOT NULL,
    salario     integer
  );


  CREATE OR REPLACE FUNCTION processa_emp_audit() RETURNS TRIGGER AS $emp_audit$
    BEGIN
        --
        -- Cria uma linha na tabela emp_audit para refletir a operação
        -- realizada na tabela emp. Utiliza a variável especial TG_OP
        -- para descobrir a operação sendo realizada.
        --
        IF (TG_OP = 'DELETE') THEN
            INSERT INTO emp_audit SELECT 'E', user, now(), OLD.*;
            RETURN OLD;
        ELSIF (TG_OP = 'UPDATE') THEN
            INSERT INTO emp_audit SELECT 'A', user, now(), NEW.*;
            RETURN NEW;
        ELSIF (TG_OP = 'INSERT') THEN
            INSERT INTO emp_audit SELECT 'I', user, now(), NEW.*;
            RETURN NEW;
        END IF;
        RETURN NULL; -- o resultado é ignorado uma vez que este é um gatilho AFTER
    END;
    $emp_audit$ language plpgsql;

CREATE TRIGGER emp_audit
  AFTER INSERT OR UPDATE OR DELETE ON empregados
    FOR EACH ROW EXECUTE PROCEDURE processa_emp_audit();



INSERT INTO empregados (nome, salario) VALUES ('João',1000);
INSERT INTO empregados (nome, salario) VALUES ('José',1500);
INSERT INTO empregados (nome, salario) VALUES ('Maria',250);
UPDATE empregados SET salario = 2500 WHERE nome = 'Maria';
DELETE FROM empregados WHERE nome = 'João';
SELECT * FROM empregados;
SELECT * FROM empregados_audit;


--------------------------------------------------------------


CREATE TABLE empregados (
    codigo          serial  PRIMARY KEY,
    nome    varchar    NOT NULL,
    salario     integer
  );


  CREATE TABLE empregados_audit(
    usuario         varchar      NOT NULL,
    data            timestamp NOT NULL,
    id              integer   NOT NULL,
    coluna          text      NOT NULL,
    valor_antigo    text      NOT NULL,
    valor_novo      text      NOT NULL
  );



  CREATE OR REPLACE FUNCTION processa_emp_audit() RETURNS TRIGGER AS $emp_audit$
    BEGIN
        --
        -- Não permitir atualizar a chave primária
        --
        IF (NEW.codigo <> OLD.codigo) THEN
            RAISE EXCEPTION 'Não é permitido atualizar o campo codigo';
        END IF;
        --
        -- Inserir linhas na tabela emp_audit para refletir as alterações
        -- realizada na tabela emp.
        --
        IF (NEW.nome <> OLD.nome) THEN
           INSERT INTO emp_audit SELECT current_user, current_timestamp,
                       NEW.id, 'nome', OLD.nome, NEW.nome;
        END IF;
        IF (NEW.salario <> OLD.salario) THEN
           INSERT INTO emp_audit SELECT current_user, current_timestamp,
                       NEW.codigo, 'salario', OLD.salario, NEW.salario;
        END IF;
        RETURN NULL; -- o resultado é ignorado uma vez que este é um gatilho AFTER
    END;
  $emp_audit$ language plpgsql;



  CREATE TRIGGER emp_audit
  AFTER UPDATE ON empregados
  FOR EACH ROW EXECUTE PROCEDURE processa_emp_audit();



INSERT INTO empregados (nome, salario) VALUES ('João',1000);
INSERT INTO empregados (nome, salario) VALUES ('José',1500);
INSERT INTO empregados (nome, salario) VALUES ('Maria',2500);
UPDATE empregados SET salario = 2500 WHERE id = 2;
UPDATE empregados SET nome = 'Maria Cecília' WHERE id = 3;
UPDATE empregados SET codigo=100 WHERE codigo=1;
ERRO:  Não é permitido atualizar o campo codigo
SELECT * FROM empregados;
SELECT * FROM empregados_audit;

---------------------------------------------------------------
Crie a mesma função que insira o nome da empresa e o nome do cliente retornando o id de ambos



create or replace function empresa_cliente_id(varchar,varchar) returns _int4 as $$
declare
	nempresa alias for $1;
	ncliente alias for $2;
	empresaid integer;
	clienteid integer;
begin
	insert into empresas(nome) values(nempresa);
	insert into clientes(fkempresa,nome)   values (currval (''empresas_id_seq''), ncliente);
	empresaid := currval(''empresas_id_seq'');
	clienteid := currval(''clientes_id_seq'');
	return ''{''|| empresaid ||'',''|| clienteid ||''}'';
end;
$$
language 'plpgsql';
Crie uma função onde passamos como parâmetro o id do cliente e seja retornado o seu nome

create or replace function id_nome_cliente(integer) returns text as $$ 
declare
     r record;
begin
     select into r * from clientes where id = $1;
     if not found then
         raise exception ''Cliente não existente !'';
     end if;
     return r.nome;
end;
$$
language 'plpgsql';