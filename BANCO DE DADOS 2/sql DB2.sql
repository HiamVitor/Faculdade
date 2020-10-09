CRIAR EXPRESSÃO DE ÁLGEBRA E RESPECTIVO SQL PARA:

- CONSULTAR O NOME DOS PILOTOS, E SIGLA DO PAIS DE CADA PILOTO;
- FILTRANDO APENAS OS PILOTOS CUJA SIGLA DO PAIS SEJA CORRESPONDENTE A INGLATERRA;

1º PARTE
ALGEBRA:
(PI) nome, sigla (pilotos) ;
SLQ:
SELECT nome,sigla from pilotos;

2º PARTE
ALGEBRA:
(SIGMA) sigla = 'ENG' (pilotos);
SLQ:
SELECT * FROM pilotos WHERE silga = 'ENG';

3º PARTE
ALGEBRA:
(PI) nome, sigla ((SIGMA) sigla = 'ENG' (pilotos))
SQL:
SELECT R.nome, R.sigla FROM (SELECT * FROM pilotos WHERE pilotos.sigla = 'ENG')R;


SELECT nome, sigla FROM pilotos WHERE sigla = 'ENG';

(SIGMA) sigla = "ENG" ((PI) nome, sigla(pilotos));

SELECT * FROM (SELECT nome, sigla FROM pilotos) R WHERE sigla = 'ENG';

CRIAR EXPRESSÃO DE ÁLGEBRA E RESPECTIVO SQL PARA:

- CONSULTAR O NOME DOS PILOTOS, E O CÓDIGO DA EQUIPE;
- FILTRANDO APENAS OS PILOTOS CUJA SIGLA DO PAIS SEJA CORRESPONDENTE A INGLATERRA;

(PI) nome, i_equipe (R <- ((SIGMA) sigla = 'ENG'(pilotos)))
SELECT R.nome, R.i_equipe FROM (SELECT * FROM pilotos WHERE sigla = 'ENG') R;

(SIGMA) sigla = 'ENG' ((PI) nome, i_equipe (pilotos))
SELECT * FROM (SELECT nome, i_equipe from pilotos) R WHERE sigla = 	'ENG'
