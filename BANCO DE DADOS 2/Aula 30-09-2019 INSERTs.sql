INSERT INTO FUNCIONARIOS 
VALUES(1,'JOÃO','DA SILVA','1', '1', 1000,'M', NULL, NULL, NULL, NULL );
INSERT INTO FUNCIONARIOS 
VALUES(2,'MARIA','VIEIRA','1', '1', 1255,'F', NULL, NULL, NULL, NULL );
INSERT INTO FUNCIONARIOS 
VALUES(3,'PEDRO','PEREIRA','1', '1', 1652,'M', NULL, NULL, NULL, NULL );
INSERT INTO FUNCIONARIOS 
VALUES(4,'CLAUDIA','FERREIRA','1','1',1244,'F', NULL, NULL, NULL, NULL );

INSERT INTO PROJETOS 
VALUES(1, 'PONTE DE LAGUNA', 'PONTES', NULL,NULL );
INSERT INTO PROJETOS 
VALUES(2, 'PONTE DO RIO CRICIÚMA', 'PONTES', NULL,NULL );
INSERT INTO PROJETOS 
VALUES(3, 'PAVIMENTAÇÃO', 'ASFALTO', NULL,NULL );


INSERT INTO funcionarios_projetos VALUES(1, 1, 20);
INSERT INTO funcionarios_projetos VALUES(1, 2, 10);
INSERT INTO funcionarios_projetos VALUES(1, 3, 10);
INSERT INTO funcionarios_projetos VALUES(2, 1, 35);
INSERT INTO funcionarios_projetos VALUES(2, 2, 5);
INSERT INTO funcionarios_projetos VALUES(3, 1, 10);
INSERT INTO funcionarios_projetos VALUES(3, 3, 15);
INSERT INTO funcionarios_projetos VALUES(4, 2, 30);
INSERT INTO funcionarios_projetos VALUES(4, 3, 2);