CREATE TABLE CIDADES(
I_CIDADE INTEGER NOT NULL,
NOME VARCHAR2(100),
CONSTRAINT PK_CIDADES PRIMARY KEY(I_CIDADE));

CREATE TABLE LOGRADOUROS(
I_LOGRADOURO INTEGER NOT NULL,
NOME VARCHAR2(100),
TIPO VARCHAR(15) NOT NULL,
CONSTRAINT PK_LOGRADOUROS PRIMARY KEY(I_LOGRADOURO));

CREATE TABLE PROJETOS(
I_PROJETO INTEGER NOT NULL,
NOME VARCHAR2(100) NOT NULL,
DESCRICAO VARCHAR(500),
I_LOGRADOURO INTEGER NOT NULL,
I_CIDADE INTEGER NOT NULL,
CONSTRAINT PK_PROJETOS PRIMARY KEY(I_PROJETO),
CONSTRAINT FK_PROJETOS_LOGRADOUROS FOREIGN KEY(I_LOGRADOURO) REFERENCES LOGRADOUROS(I_LOGRADOURO),
CONSTRAINT FK_PROJETOS_CIDADES FOREIGN KEY(I_CIDADE) REFERENCES CIDADES(I_CIDADE));

CREATE TABLE DEPARTAMENTOS(
I_DEPARTAMENTO INTEGER NOT NULL,
NOME VARCHAR2(100) NOT NULL,
I_FUNC_GERENTE INTEGER,
I_LOGRADOURO INTEGER NOT NULL,
I_CIDADE INTEGER NOT NULL,
CONSTRAINT PK_DEPARTAMENTOS PRIMARY KEY(I_DEPARTAMENTO),
CONSTRAINT FK_DEPARTAMENTOS_LOGRADOUROS FOREIGN KEY(I_LOGRADOURO) REFERENCES LOGRADOUROS(I_LOGRADOURO),
CONSTRAINT FK_DEPARTAMENTOS_CIDADES FOREIGN KEY(I_CIDADE) REFERENCES CIDADES(I_CIDADE));

CREATE TABLE FUNCIONARIOS(
I_FUNCIONARIO INTEGER NOT NULL,
NOME VARCHAR2(20) NOT NULL,
SOBRENOME VARCHAR2(80) NOT NULL,
CPF CHAR(11) NOT NULL,
RG CHAR(9) NOT NULL,
SALARIO NUMERIC(12,2) NOT NULL,
SEXO CHAR(1) NOT NULL,
I_DEPARTAMENTO INTEGER NOT NULL,
I_FUNC_SUPERVISOR INTEGER NOT NULL,
I_LOGRADOURO INTEGER NOT NULL,
I_CIDADE INTEGER NOT NULL,
CONSTRAINT PK_FUNCIONARIOS PRIMARY KEY(I_FUNCIONARIO),
CONSTRAINT FK_FUNCIONARIOS_DEPARTAMENTOS FOREIGN KEY(I_DEPARTAMENTO) REFERENCES DEPARTAMENTOS(I_DEPARTAMENTO),
CONSTRAINT FK_FUNCIONARIOS_FUNCIONARIOS FOREIGN KEY(I_FUNC_SUPERVISOR) REFERENCES FUNCIONARIOS(I_FUNCIONARIO),
CONSTRAINT FK_FUNCIONARIOS_LOGRADOUROS FOREIGN KEY(I_LOGRADOURO) REFERENCES LOGRADOUROS(I_LOGRADOURO),
CONSTRAINT FK_FUNCIONARIOS_CIDADES FOREIGN KEY(I_CIDADE) REFERENCES CIDADES(I_CIDADE) );

ALTER TABLE DEPARTAMENTOS 
ADD CONSTRAINT FK_DEPARTAMENTOS_FUNCIONARIOS FOREIGN KEY(I_FUNC_GERENTE) REFERENCES FUNCIONARIOS(I_FUNCIONARIO);

CREATE TABLE FUNCIONARIOS_PROJETOS(
I_FUNCIONARIO INTEGER NOT NULL,
I_PROJETO INTEGER NOT NULL,
HORAS_SEMANA INTEGER NOT NULL,
CONSTRAINT PK_FUNCIONARIOS_PROJETOS PRIMARY KEY(I_FUNCIONARIO, I_PROJETO),
CONSTRAINT FK_FUNC_PROJ_FUNC FOREIGN KEY(I_FUNCIONARIO) REFERENCES FUNCIONARIOS(I_FUNCIONARIO),
CONSTRAINT FK_FUNC_PROJ_PROJ FOREIGN KEY(I_PROJETO) REFERENCES PROJETOS(I_PROJETO));

CREATE TABLE DEPENDENTES(
I_DEPENDENTE INTEGER NOT NULL,
I_FUNCIONARIO INTEGER NOT NULL,
NOME VARCHAR2(20) NOT NULL,
SOBRENOME VARCHAR2(80) NOT NULL,
CONSTRAINT PK_DEPENDENTES PRIMARY KEY(I_DEPENDENTE),
CONSTRAINT FK_DEPENDENTES_FUNCIONARIOS FOREIGN KEY(I_FUNCIONARIO) REFERENCES FUNCIONARIOS(I_FUNCIONARIO));
