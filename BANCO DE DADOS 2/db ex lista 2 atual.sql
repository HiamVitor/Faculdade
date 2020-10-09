-------------------EX 1 LISTA 2 ----------------------

(PI) i_funcionario ( 
	(SIGMA) I_PROJETO = 1 and HORAS_SEMANA > 10 (funcionario_PROJETOS))



SELECT i_funcionario
	from (SELECT * 
			from funcionario_PROJETOS
				where I_PROJETO = 1 and
				 	   HORAS_SEMANA > 10);





SELECT i_funcionario
	from funcionario_PROJETOS	
		where I_PROJETO = 1 and HORAS_SEMANA > 10;	

-------------------EX 2 LISTA 2 ----------------------		
(PI) nome (funcionarios)

select nome
	from funcionarios;

-------------------EX 3 LISTA 2 ----------------------		
(PI) nome (
(SIGMA) i_func_supervisor = 1) (funcionarios))


SELECT nome
	from funcionarios
		where i_func_supervisor = 1;

-------------------EX 4 LISTA 2 ----------------------	
(PI) funcionario.nome, projeto.nome
(funcionario |X| funcionario.i_funcionario = funcionario_PROJETOS.i_funcionario)
funcionario_PROJETOS
|X| funcionario_PROJETOS.I_PROJETO = projeto.I_PROJETO projetos

SELECT nome_func, nome_proj 
	FROM (SELECT funcionarios.nome AS nome_func,
				 projetos.nome AS nome_proj
				 FROM funcionarios INNER JOIN funcionario_PROJETOS 
				 ON (funcionarios.i_funcionario = funcionario_PROJETOS.i_funcionario)
				  INNER JOIN projetos 
				 ON (funcionario_PROJETOS.I_PROJETO = projetos.I_PROJETO));
;
-------------------EX 5 LISTA 2 ----------------------	
(PI) nome (
	(funcionarios) |X| funcionarios.i_funcionario = funcionario_PROJETOS.i_funcionario
	((SIGMA) funcionario_PROJETOS.I_PROJETO = 1 (funcionario_PROJETOS))



SELECT sub.nome
	from (SELECT * 
			from funcionarios INNER JOIN funcionario_PROJETOS 
			on (funcionarios.i_funcionario = funcionario_PROJETOS.i_funcionario)
			where funcionario_PROJETOS.I_PROJETO = 1) sub;


-------------------EX 6 LISTA 2 ----------------------	
(PI) funcionarios
except
(PI) (i_funcionario) |X| (i_funcionario.I_dependentes)

SELECT sobrenome
	FROM I_dependentes 
except
SELECT 
	FROM I_dependentes INNER JOIN on(funcionarios.i_funcionario = dependentes.I_dependentes)

-------------------EX 7 LISTA 2 ----------------------	
SELECT funcionarios.nome,
		C2.nome,
		logradouros.nome
	FROM cidades c1 INNER JOIN departamentos
		ON (c1.i_cidade = departamentos.i_cidade) 
		INNER JOIN funcionarios
		ON (departamentos.i_departamentps = 
			funcionarios.i_departamentps)
		INNER JOIN cidades C2 = 
		ON (funcionarios.i_logradouros = logradouros.i_logradouros)
		INNER JOIN funcionario_PROJETOS = 
		ON (funcionarios.i_funcionario = funcionario_PROJETOS.i_funcionario)
		INNER JOIN projetos
		ON (funcionario_PROJETOS.I_PROJETO = projetos.I_PROJETO)
		INNER JOIN C3
		ON (projetos.i_cidade = C3.i_cidade)
	WHERE c1.nome <> 'SÃO PAULO' and C3 <> 'SÃO PAULO'

-------------------EX 8 LISTA 2 ----------------------	
MEU

SELECT projetos.nome
	   funcionario_PROJETOS.HORAS_SEMANA
	   SUM 
	   FROM funcionario_PROJETOS INNER JOIN projetos
	   ON (projetos.I_PROJETO = funcionario_PROJETOS.I_PROJETO)
FORMA 1

SELECT NOME,SUM(HORAS_SEMANA)
	FROM funcionario_PROJETOS INNER JOIN projetos
	ON (funcionario_PROJETOS.I_PROJETO = projetos.I_PROJETO)
GROUP BY NOME.
FORMA 2

SELECT NOME,SUM(HORAS_SEMANA)
	FROM funcionario_PROJETOS, projetos
	WHERE funcionario_PROJETOS.I_PROJETO = projetos.I_PROJETO
	GROUP BY NOME;
-------------------EX 9 LISTA 2 ----------------------	
SELECT NOME,AVG(SALARIO)
	FROM i_funcionario INNER JOIN i_departamentps
	ON (i_funcionario.i_departamentps = departamentos.i_departamentps)
	GROUP BY NOME.







