BEGIN
	Errado INSERT INTO FUNCIONARIOS 
	VALUES(1,'JOÃO','DA SILVA','1', '1', 1000,'M', 1, NULL, 1, 1 );
	INSERT INTO FUNCIONARIOS 
	VALUES(2,'MARIA','VIEIRA','1', '1', 1255,'F', 1, NULL, 1, 1 );
	INSERT INTO FUNCIONARIOS 
	VALUES(3,'PEDRO','PEREIRA','1', '1', 1652,'M', 1, NULL, 1, 1 );
	INSERT INTO FUNCIONARIOS 
	VALUES(4,'CLAUDIA','FERREIRA','1','1',1244,'F',1, NULL, 1, 1 );


	INSERT INTO FUNCIONARIOS 
	VALUES(1,'JOÃO','DA SILVA','1', '1', 1000,'M',NULL, NULL, NULL, NULL);
	INSERT INTO FUNCIONARIOS 
	VALUES(2,'MARIA','VIEIRA','1', '1', 1255,'F',NULL, NULL, NULL, NULL );
	INSERT INTO FUNCIONARIOS 
	VALUES(3,'PEDRO','PEREIRA','1', '1', 1652,'M',NULL, NULL, NULL, NULL );
	INSERT INTO FUNCIONARIOS 
	VALUES(4,'CLAUDIA','FERREIRA','1','1',1244,'F',NULL, NULL, NULL, NULL );

	INSERT INTO PROJETOS 
	VALUES(1, 'PONTE DE LAGUNA', 'PONTES', NULL, NULL );
	INSERT INTO PROJETOS 
	VALUES(2, 'PONTE DO RIO CRICIÚMA', 'PONTES', NULL, NULL );
	INSERT INTO PROJETOS 
	VALUES(3, 'PAVIMENTAÇÃO', 'ASFALTO', NULL, NULL );


	INSERT INTO funcionarios_projetos VALUES(1, 1, 20);
	INSERT INTO funcionarios_projetos VALUES(1, 2, 10);
	INSERT INTO funcionarios_projetos VALUES(1, 3, 10);
	INSERT INTO funcionarios_projetos VALUES(2, 1, 35);
	INSERT INTO funcionarios_projetos VALUES(2, 2, 5);
	INSERT INTO funcionarios_projetos VALUES(3, 1, 10);
	INSERT INTO funcionarios_projetos VALUES(3, 3, 15);
	INSERT INTO funcionarios_projetos VALUES(4, 2, 30);
	INSERT INTO funcionarios_projetos VALUES(4, 3, 2);
	----
END;
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Dado tres notas (5.00, 9.21, 2.01), calcule a media dessas tres notas e informe se ocorreu a aprovacao do aluno,
quando este possuir media maior ou igual a 7, exame caso a media seja menor que 7 e maior ou
igual a 5 reprovado caso a media seja menor que 5.

do $$
declare
	v_media numeric(4,2);
begin
	v_media := round(((5+9.21+2.01)/3),2);
	if v_media >= 7 then
		raise notice 'ALUNO ESTA APROVADO COM A MEDIA: %',v_media;
	elsif v_media < 7 and v_media >= 5 then
		raise notice 'Aluno esta em exame com a media: %', v_media;
	else
		raise notice 'O aluno esta reprovado com media: %', v_media;
	end if;
end$$
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
Verificar a media de salarios dos funcionarios.
Para aqueles que possuirem salario igual ou superior a media, concedor um aumento de 8,5%, 
Para aqueles com salario inferior a media conceder um aumento de 10%.

do $$
declare 
	v_media_sal numeric(7,2);
begin
	select avg(salario) into v_media_sal
		from FUNCIONARIOS;

	update FUNCIONARIOS
		set salario = (salario * 1.085)
		where salario >= v_media_sal;

	update FUNCIONARIOS
		set salario = (salario * 1.1)
		where salario < v_media_sal;
	commit;
end$$

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

verificar a media de salario de todos os funcionarios e apresentar:
	- o percentual de diferença entre o salario medio feminino e media salarial de todos funcionarios.
	- o percentual de diferença entre o salario medio masculino e media salarial de todos funcionarios.
	- o percentual de diferença entre a media salarial feminina e media salarial masculina .

do $$
declare v_media numeric(7,2);
declare v_media_f numeric (7,2);
declare v_media_M numeric (7,2);
begin
	select avg(salario)
		into v_media
		from funcionarios;

	select avg(salario)
		into v_media_f
		from funcionarios
		where sexo = 'F';

	select avg(salario)
		into v_media_m
		from funcionarios
		where sexo = 'M';

	raise notice 'Difrence entre media salarial feminina e media total %',
		round ((((v_media_f - v_media) * 100) / v_media),2);

	raise notice 'Difrence entre media salarial masculina e media total %',
		round ((((v_media_m - v_media) * 100) / v_media),2);

	raise notice 'A edia salarial femina, em relacao a media salarial masculina é %',
		round ((((v_media_f - v_media_m) * 100) / v_media_m),2);
	
end$$

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

do $$
declare
	c_func cursor for
		select nome, salario from funcionarios;
		v_nome varchar(100) := '';
		v_salario decimal(12,2) := 0.00;
		vcont integer := 0;
begin
	open c_func;
		fetch c_func into v_nome, v_salario;
			vcont := vcont + 1;
			raise notice 'Nome: % salario: %',v_nome,v_salario;
		close c_func;

	raise notice 'Numero de linhas processadas na tabela de funcionario : %',vcont;
end $$

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

do $$
declare 
	c_prj cursor for
		select i_projeto, nome from projetos;
		vcodigo integer;
		vnome varchar(100);
		vmediahora decimal(12,2);
		vcont integer := 0;

	begin open c_prj;
		fetch c_prj into vcodigo, vnome;
			vcont := cont + 1;
			select avg(horas_semana) into vmediahora
			from funcionarios_projetos
			where i_projeto = vcodigo;

			raise noitece 'O projeto % - % possui uma media de % horas por semana.' vcodogio, vnome, vmediahora;
		close c_prj;
	end
	
	raise notice 'Numero de linhas processadas na tabela foi de %',vcont;
end $$

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

BEGIN

	VERIFICAR A MÉDIA DE SALÁRIO DOS FUNCIONÁRIOS POR PROJETO, 
	SENDO QUE PARA OS FUNCIONÁRIOS QUE:

	- TRABALHAM EM UM PROJETO NA MESMA CIDADE ONDE RESIDEM, 
	 CONCEDER UM AUMENTO SALARIAL REFERENTE A 10% DA MÉDIA 
	 SALARIAL DO PROJETO;

	- TRABALHAM EM UM PROJETO EM UMA CIDADE DIFERENTE DA QUE 
	 RESIDEM, CONCEDER UM AUMENTO SALARIAL REFERENTE A 
	 PERCENTUAL DE DIFERENÇA ENTRE O SEU SALÁRIO E A 
	 MÉDIA SALARIAL DO PROJETO. 

	DO $$
	DECLARE
	 	CUR_FUNC CURSOR FOR
		SELECT I_FUNCIONARIO, I_PROJETO
			FROM FUNCIONARIOS_PROJETOS
		ORDER BY I_PROJETO;
		V_FUNC INTEGER;
		V_CIDADE_FUNC INTEGER;
		V_CIDADE_PROJ INTEGER;
		V_PROJ INTEGER;
		V_MEDIA DECIMAL(12,2);
		V_SALARIO DECIMAL(12,2);
		V_VALOR_AUMENTO DECIMAL(12,2);
		V_PROJ_ANT INTEGER := 0;

	BEGIN
		OPEN CUR_FUNC;
		LOOP
			FETCH CUR_FUNC INTO V_FUNC, V_PROJ;
			EXIT WHEN NOT FOUND;

			IF V_PROJ_ANT <> V_PROJ THEN
			   V_PROJ_ANT := V_PROJ;

		   		SELECT AVG(SALARIO)	INTO V_MEDIA
		   		FROM FUNCIONARIOS INNER JOIN FUNCIONARIOS_PROJETOS
		   			ON (FUNCIONARIOS.I_FUNCIONARIO = 
		   				FUNCIONARIOS_PROJETOS.I_FUNCIONARIO)
	   			WHERE FUNCIONARIOS_PROJETOS.I_PROJETO = V_PROJ;
			END IF;

			SELECT I_CIDADE, SALARIO INTO V_CIDADE_FUNC, V_SALARIO
				FROM FUNCIONARIOS
				WHERE FUNCIONARIOS.I_FUNCIONARIO = V_FUNC; 

			SELECT I_CIDADE INTO V_CIDADE_PROJ 
				FROM FUNCIONARIOS_PROJETOS
			WHERE PROJETOS.I_PROJETO = V_PROJ;

			IF V_CIDADE_FUNC = V_CIDADE_PROJ THEN 
				V_VALOR_AUMENTO := (V_MEDIA * 0.10);
			ELSE
				IF V_SALARIO > V_MEDIA THEN
					V_VALOR_AUMENTO := (V_SALARIO - V_MEDIA);
				ELSEIF V_SALARIO < V_MEDIA THEN
					V_VALOR_AUMENTO:= (V_MEDIA - V_SALARIO);
				ELSE
					V_VALOR_AUMENTO := 0.00;
				END IF;
			END IF;
			UPDATE FUNCIONARIOS
			SET SALARIO = (SALARIO + V_VALOR_AUMENTO)
			WHERE I_FUNCIONARIO = V_FUNC;
		END LOOP;
		CLOSE CUR_FUNC;
		COMMIT;
	END $$;		
END;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

CRIAR UM BLOCO DE PROGRAMAÇÃO ESTRUTURADA PARA APRESENTAR O CONSOLE DO BROWSER NO BANCO DE DADOS: 
O NOME DOS CLIENTES, O CODIGO DA COMPRA E O VALOR FINAL DAS COMPRAS QUE ESTÃO ABAIXO DO VALOR MÉDIO.

 DO $$
 DECLARE 
 	CUR_VENDAS CURSOR FOR
	 	SELECT I_VENDA, VENDAS.I_CLIENTE, NOME, VALOR_FINAL
	 	FROM VENDAS,I_CLIENTE
	 	WHERE VENDAS.I_CLIENTE = CLIENTES.I_CLIENTE
	 	ORDER BY VENDAS.I_CLIENTE, I_VENDA;

	 	V_MEDIA DECIMAL(12,2) := 0;
	 	V_VENDA INTEGER := 0;
	 	V_CLIENTE INTEGER := 0;
	 	V_VALOR DECIMAL (12,2) := 0;
	 	V_NOME = VARCHAR := '';

	BEGIN
		SELECT AVG(VALOR_FINAL) INTO V_MEDIA
		FROM VENDAS;
		RAISE NOTICE 'MÉDIA %', V_MEDIA;
		OPEN CUR_VENDAS;
		LOOP
			FETCH CUR_VENDAS INTO V_VENDA, V_CLIENTE, V_NOME, V_VALOR;
			EXIT WHEN NOT FOUND;
			IF V_VALOR < V_MEDIA THEN
				RAISE NOTICE 'CLIENTE? % - % VENDA: % - VALOR: %', V_CLIENTE, V_NOME, V_VENDA, V_VALOR;
			END IF;
		END LOOP;
	END	
END $$;	

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

CRIAR UM BLOCO DE PROGRAMAÇÃO ESTRUTURADA PARA AUMENTAR O PREÇO DE CADA PRODUTO EM 5%, SENDO QUE AS VENDAS
REALIZADAS NO MÊS DE SETEMBRO TAMBÉM DEVERÃO SOFRER ESTE REAJUSTE, O QUE IMPLICA NA MODIFICAÇÃO DOS CAMPOS 
DE VALORES NAS TABELAS DE ITENS E VENDAS.

DO $$
DECLARE
	CUR_VENDA CURSOR FOR 
		SELECT I_VENDA
		FROM VENDAS
		WHERE EXTRACT(MONTH FROM DATA_VENDA) = 9;
	CODVENDA INTEGER := 0;
	V_PERCENT DECIMAL (4,2) := 5.00;
BEGIN 
	UPDATE PRODUTOS
	SET VALOR = VALOR + ((V_PERCENT/100) + 1);
	OPEN CUR_VENDA;
	LOOP
		FETCH CUR_VENDA INTO CODVENDA;
		EXIT WHERE NOT FOUND;
		UPDATE VENDAS
		SET VALOR_VENDA = VALOR_VENDA * ((V_PERCENT/100) + 1),
		DESCONTO =(VALOR_VENDA * ((V_PERCENT/100) +1) - VALOR_FINAL
		WHERE I_VENDA = CODVENDA;
	END LOOP;
	CLOSE CUR_VENDA;
	COMMIT;
END $$;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
PROCEDURES. NÃO CAI NA PROVA
BEGIN
	DO $$
	DECLARE 
		V_PRODUTO INTEGER;
		V_VALOR NUMERIC(12,2);
	BEGIN 
		SELECT MAX(I_PRODUTO) + 1 INTO V_PRODUTO
		FROM PRODUTOS;

		SELECT VALOR INTO V_VALOR
		FROM PRODUTOS
		WHERE I_PRODUTO = 1;

		INSERT INTO PRODUTOS
		VALUES(V_PRODUTO, 'NOME DO NOVO PRODUTO', V_VALOR);

		COMMIT;
	END $$;

	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	CREATE OR REPLACE PROCEDURE
		P_TEST PROC(P_ARG1 IN OUT NUMERIC, P_ARG2 IN OUT NUMERIC, P_RESULT IN OUT NUMERIC)
	LANGUAGE PLPGSQL
	AS $$
	BEGIN
		P_RESULT := P_ARG1 + P_ARG2;
	END $$;
	---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	DO $$
	DECLARE
		S NUMERIC := 0;
		ARG1 NUMERIC := 4;
		ARG2 NUMERIC := 2;
	BEGIN 
		RAISE NOTICE 'ARG1: % - ARG2: % - S:%', ARG1, ARG2, S;
		CALL P_TEST_PROC (ARG1, ARG2,S);
		RAISE NOTICE 'ARG1: % - ARG2: % - S: %', ARG1, ARG2, S;
	END $$;

	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
END