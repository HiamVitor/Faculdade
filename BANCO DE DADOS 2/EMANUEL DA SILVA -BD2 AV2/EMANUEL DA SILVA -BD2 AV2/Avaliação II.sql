CREATE TABLE PESSOA (
I_PESSOAS INTEGER NOT NULL,
NOME VARCHAR(50) NOT NULL,
CPF CHAR(11) NOT NULL,
CONSTRAINT PK_PESSOA PRIMARY KEY (I_PESSOAS)
);

CREATE TABLE VENDA (
I_VENDAS INTEGER NOT NULL,
I_PESSOAS INTEGER NOT NULL,
DT_VENDA DATE NOT NULL,
DT_VENCTO DATE NOT NULL,
PAGO CHAR(1) NOT NULL,
VALOR_VENDA NUMERIC(12,2) NOT NULL,
VALOR_PAGO NUMERIC(12,2) NOT NULL,
DESCONTO NUMERIC(12,2) NOT NULL,
CONSTRAINT PK_VENDA PRIMARY KEY (I_VENDAS)
);

CREATE TABLE ITEM (
I_VENDAS INTEGER NOT NULL,
I_PRODUTOS INTEGER NOT NULL,
QUANTIDADE INTEGER NOT NULL,
VALOR_UNITARIO NUMERIC(12,4) NOT NULL,
CONSTRAINT PK_ITEM PRIMARY KEY (I_VENDAS,I_PRODUTOS)
);

CREATE TABLE PRODUTO (
I_PRODUTOS INTEGER NOT NULL,
I_FABRICANTES INTEGER NOT NULL,
NOME VARCHAR(50) NOT NULL,
DESCRICAO VARCHAR(200) NOT NULL,
VALOR NUMERIC(12,4) NOT NULL,
UNIDADE VARCHAR(10) NOT NULL,
CONSTRAINT PK_PRODUTO PRIMARY KEY (I_PRODUTOS)
);

CREATE TABLE FABRICANTE (
I_FABRICANTES INTEGER NOT NULL,
CNPJ CHAR(14) NOT NULL,
NOME_FANT VARCHAR(100) NOT NULL,
CONSTRAINT PK_FABRICANTE PRIMARY KEY (I_FABRICANTES)
);

ALTER TABLE ITEM ADD
	CONSTRAINT FK_VEN_ITEM FOREIGN KEY (I_VENDAS)
		REFERENCES VENDA (I_VENDAS)
		
ALTER TABLE ITEM ADD
	CONSTRAINT FK_PROD_ITEM FOREIGN KEY (I_PRODUTOS)
		REFERENCES PRODUTO (I_PRODUTOS)

ALTER TABLE VENDA ADD
	CONSTRAINT FK_VEN_PESS FOREIGN KEY (I_PESSOAS)
		REFERENCES PESSOA (I_PESSOAS)

ALTER TABLE PRODUTO ADD
	CONSTRAINT FK_FAB_PROD FOREIGN KEY (I_FABRICANTES)
		REFERENCES FABRICANTE (I_FABRICANTES)