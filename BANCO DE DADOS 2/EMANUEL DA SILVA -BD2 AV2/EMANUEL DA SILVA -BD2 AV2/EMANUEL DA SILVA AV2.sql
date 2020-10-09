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

EX1.1----------------------------------------------------------

DO $$
Declare 

	cur_ven cursor FOR 
	select DESCONTO,VALOR_PAGO,VALOR_VENDA
	from VENDA;

	v_venda INTEGER;
	vltotal NUMERIC(12,2);

	begin
		open cur_ven;
		loop
		fetch cur_ven into v_venda exit when not found;

		select DESCONTO,VALOR_PAGO,VALOR_VENDA from VENDA where I_VENDAS = v_venda;

		vltotal = VENDA.DESCONTO + VENDA.VALOR_PAGO; 

		if vltotal < VENDA.VALOR_VENDA then 
		update VENDAS set PAGO = 'P' where I_VENDAS = v_venda;
		end if

		vltotal = 0;
		
		end loop;
		close cur_ven;
		commit;
	end $$


EX1.2----------------------------------------------------------

DO $$
Declare 

	cur_ven cursor FOR 
	select quantidade,VALOR_UNITARIO from ITEM;

	v_item INTEGER;
	vltotalitem NUMERIC(12,2);
	vendatotalvl NUMERIC(12,2);
	vendatotalquantidade NUMERIC(12,2);

	begin
		open cur_ven;
		loop
		fetch cur_ven into v_item exit when not found;

		select quantidade,VALOR_UNITARIO,I_VENDAS from item where item.I_VENDAS = VENDAS.I_VENDAS;
		select sum(VALOR_UNITARIO) from item where item.I_VENDAS = VENDAS.I_VENDAS into vendatotalvl;
		select sum(quantidade) from item where item.I_VENDAS = VENDAS.I_VENDAS into vendatotalquantidade;
		select VALOR_VENDA,I_VENDAS, from I_VENDAS where item.I_VENDAS = VENDAS.I_VENDAS;


		vltotalitem = vendatotalvl * vendatotalquantidade

		if (vltotalitem - venda.VALOR_VENDA) = 0 then RAISE NOTICE 'VENDA OKEY';
		else 
		update VENDAS set VALOR_VENDA = vltotalitem where I_VENDAS = v_item;
		end if;

	end loop;
	close cur_ven;
	commit;
end $$


EX1.3----------------------------------------------------------

DO $$
Declare 
	ALTER TABLE PESSOA ADD  (CREDITO_PRE_APROVADO NUMERIC(12,2) );

	cur_pes cursor FOR 
	select I_PESSOAS,CREDITO_PRE_APROVADO from PESSOA;

	vlpre_aprovado NUMERIC (12,2) := 0;
	v_pes integer;

	OPEN cur_pes;
	loop
  	FETCH cur_pes INTO v_pes exit when not found;

	select I_PESSOAS,CREDITO_PRE_APROVADO from PESSOA where I_PESSOAS = v_pes;

	select avg(VALOR_VENDA) into vlpre_aprovado from venda where venda.PAGO = 'S' and vendas.I_PESSOAS = v_pes;

	end loop;
	CLOSE cur_pes;
	commit
end $$

EX1.4----------------------------------------------------------

DO $$
Declare 
	cur_prod cursor for
	select produto.i_produto,item.I_PRODUTOS,item.I_VENDAS,item.quantidade,venda.I_PESSOAS,venda.VALOR_PAGO,venda.DT_VENDA
	where DT_VENDA >= 01-01-2017 and DT_VENDA <=12-31-2017;

	v_prod integer;
	v_quant integer = 0;
	v_cli VARCHAR(50);
	vlcomprado NUMERIC(12,2);

	OPEN cur_prod;
	loop
  	FETCH cur_prod INTO v_prod exit when not found;

	select quantidade into v_quant from item where v_prod = i_produto ;
	select nome into v_cli from PESSOA where v_cli - I_PESSOAS;

	select quantidade,VALOR_UNITARIO from item where v_prod = i_produtos;
	vlcomprado = VALOR_UNITARIO * quantidade;

	if item.quantidade > v_quant then v_quant := item.quantidade

	RAISE NOTICE 'PRODUTO % CLIENTE % QUANTIDADE COMPRADA % VALOR COMPRADO %',
	v_prod,v_cli,v_quant,vlcomprado;


end loop;
	CLOSE 
	commit
end $$