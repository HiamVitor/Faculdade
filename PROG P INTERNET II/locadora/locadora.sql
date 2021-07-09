-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 03/05/2021 às 18:39
-- Versão do servidor: 10.1.36-MariaDB
-- Versão do PHP: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `locadora`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `telefone` char(10) DEFAULT NULL,
  `celular` char(11) DEFAULT NULL,
  `cpf` char(11) NOT NULL,
  `foto` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `endereco`, `telefone`, `celular`, `cpf`, `foto`) VALUES
(1, 'Cristiano', 'Rua teste', '4832145874', '48965325741', '25165874214', NULL),
(2, 'Flavia', 'Rua exemplo', '4896524587', '48356587452', '26587568754', NULL),
(3, 'Alvaro', 'Rua body', '4885658745', '48985654871', '22354877414', NULL),
(4, 'Cladia', 'Rua header', '4835468752', '4896587524', '2265986352', NULL),
(5, 'Clovis', 'Rua title', '4836215478', '48956325874', '24215785365', NULL),
(6, 'Carlos', 'Rua teste', '3241341234', '42341234123', '23412341234', 'esucri.png');

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente_bonus`
--

CREATE TABLE `cliente_bonus` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `data_validade_ini` date NOT NULL,
  `data_validade_fim` date NOT NULL,
  `locacao_gratis` int(11) DEFAULT NULL,
  `desconto` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `cliente_bonus`
--

INSERT INTO `cliente_bonus` (`id`, `id_cliente`, `data_validade_ini`, `data_validade_fim`, `locacao_gratis`, `desconto`) VALUES
(1, 1, '2021-03-22', '2021-04-30', 5, NULL),
(2, 2, '2021-03-26', '2021-04-19', NULL, '10.00'),
(3, 4, '2021-04-14', '2021-05-26', 2, NULL),
(4, 5, '2021-04-21', '2021-04-30', NULL, '15.00'),
(5, 8, '2021-03-29', '2021-04-29', 5, '0.00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente_dependente`
--

CREATE TABLE `cliente_dependente` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `cpf` char(11) NOT NULL,
  `foto` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `cliente_dependente`
--

INSERT INTO `cliente_dependente` (`id`, `id_cliente`, `nome`, `cpf`, `foto`) VALUES
(1, 1, 'Ana', '32652548752', NULL),
(2, 1, 'Carla', '23589754875', NULL),
(3, 3, 'Anderson', '12345785427', NULL),
(4, 3, 'Carlos', '26875897854', NULL),
(5, 4, 'Silvio', '35698157248', 'esucri.png'),
(7, 8, 'Arildo', '34565468464', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `distribuidor`
--

CREATE TABLE `distribuidor` (
  `id` int(11) NOT NULL,
  `razao_social` varchar(150) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `telefone` char(10) NOT NULL,
  `nome_contato` varchar(150) DEFAULT NULL,
  `cnpj` char(14) NOT NULL,
  `foto` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `distribuidor`
--

INSERT INTO `distribuidor` (`id`, `razao_social`, `endereco`, `telefone`, `nome_contato`, `cnpj`, `foto`) VALUES
(1, 'Disney', 'Rua disney', '4836521548', 'Alberto', '32652154785215', NULL),
(2, 'MGM', 'Rua mgm', '4836521548', 'Cladio', '65245875214578', NULL),
(3, 'Pixar', 'Rua pixar', '4852157568', 'Juliane', '36548521547896', NULL),
(4, 'Globo', 'Rua globo', '4861357852', 'Cintia', '65821547895258', NULL),
(5, 'Fox', 'Rua fox', '4837541258', 'Fabricio', '56875215478521', NULL),
(7, 'Marvel', 'Rua marvel', '4893235635', 'Tony', '63549684987987', 'esucri.png');

-- --------------------------------------------------------

--
-- Estrutura para tabela `locacao`
--

CREATE TABLE `locacao` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_midia` int(11) NOT NULL,
  `data_coleta` datetime NOT NULL,
  `data_prevista` date NOT NULL,
  `data_entrega` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `locacao`
--

INSERT INTO `locacao` (`id`, `id_cliente`, `id_midia`, `data_coleta`, `data_prevista`, `data_entrega`) VALUES
(1, 1, 2, '2021-03-16 11:00:00', '2021-03-17', '2021-03-17 11:14:00'),
(2, 2, 4, '2021-03-18 17:00:00', '2021-03-19', '2021-03-19 15:18:00'),
(3, 4, 3, '2021-03-20 14:00:00', '2021-03-22', '2021-03-22 15:38:00'),
(4, 4, 1, '2021-03-22 17:09:00', '2021-03-24', '2021-04-26 15:50:00'),
(5, 1, 4, '2021-04-26 21:30:00', '2021-04-28', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `midia`
--

CREATE TABLE `midia` (
  `id` int(11) NOT NULL,
  `id_distribuidor` int(11) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `duracao` time NOT NULL,
  `valor_compra` decimal(5,2) NOT NULL,
  `valor_locacao` decimal(4,2) NOT NULL,
  `tipo_midia` varchar(7) NOT NULL,
  `classificacao` char(1) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `sinopse` text NOT NULL,
  `foto` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `midia`
--

INSERT INTO `midia` (`id`, `id_distribuidor`, `titulo`, `duracao`, `valor_compra`, `valor_locacao`, `tipo_midia`, `classificacao`, `quantidade`, `sinopse`, `foto`) VALUES
(1, 1, 'Matrix', '02:05:00', '100.00', '7.00', 'DVD', 'C', 3, 'Filme Matrix', NULL),
(2, 2, 'Seu Sou a Lenda', '01:47:00', '97.00', '4.00', 'DVD', 'B', 2, 'Filme Eu Sou a Lenda', NULL),
(3, 4, 'Senhor dos Anéis', '02:20:00', '85.00', '11.00', 'Blu-Ray', 'B', 1, 'Filme Senhor dos Anéis', NULL),
(4, 5, 'Avatar', '02:12:00', '75.00', '3.00', 'VHS', 'D', 2, 'Filme Avatar', 'esucri.png');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `status` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `login`, `senha`, `status`) VALUES
(1, 'Cristiano', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'A');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cpf_UNIQUE` (`cpf`);

--
-- Índices de tabela `cliente_bonus`
--
ALTER TABLE `cliente_bonus`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `cliente_dependente`
--
ALTER TABLE `cliente_dependente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cpf_UNIQUE` (`cpf`);

--
-- Índices de tabela `distribuidor`
--
ALTER TABLE `distribuidor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cnpj_UNIQUE` (`cnpj`);

--
-- Índices de tabela `locacao`
--
ALTER TABLE `locacao`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `midia`
--
ALTER TABLE `midia`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `cliente_bonus`
--
ALTER TABLE `cliente_bonus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `cliente_dependente`
--
ALTER TABLE `cliente_dependente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `distribuidor`
--
ALTER TABLE `distribuidor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `locacao`
--
ALTER TABLE `locacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `midia`
--
ALTER TABLE `midia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
