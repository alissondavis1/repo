-- MySQL dump 10.13  Distrib 5.5.28, for Win64 (x86)
--
-- Host: localhost    Database: acal
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoriasocio`
--

DROP TABLE IF EXISTS `categoriasocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoriasocio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` text,
  `nome` varchar(255) NOT NULL,
  `taxasId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK271F6B9AA011B865` (`taxasId`),
  CONSTRAINT `taxaid` FOREIGN KEY (`taxasId`) REFERENCES `taxa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriasocio`
--

LOCK TABLES `categoriasocio` WRITE;
/*!40000 ALTER TABLE `categoriasocio` DISABLE KEYS */;
INSERT INTO `categoriasocio` VALUES (13,'','Categoria 20',37);
/*!40000 ALTER TABLE `categoriasocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheque`
--

DROP TABLE IF EXISTS `cheque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataPagamento` datetime DEFAULT NULL,
  `dataVencimento` datetime NOT NULL,
  `numero` int(11) NOT NULL,
  `observacoes` text,
  `valor` decimal(10,2) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `idMotivoDespesa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_UNIQUE` (`numero`),
  KEY `FKAED8F22151783C38` (`idMotivoDespesa`),
  KEY `FKAED8F221E196A484` (`idFuncionario`),
  CONSTRAINT `id_funcionario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `id_motivo_depesa` FOREIGN KEY (`idMotivoDespesa`) REFERENCES `motivodespesa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheque`
--

LOCK TABLES `cheque` WRITE;
/*!40000 ALTER TABLE `cheque` DISABLE KEYS */;
/*!40000 ALTER TABLE `cheque` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ChequeLogDelete` AFTER DELETE ON `cheque` FOR EACH ROW BEGIN INSERT INTO 
chequeslog(
idOriginal,
dataPagamento,
dataVencimento,
dataAlteracao,
numero,
observacoes,
valor,
idFuncionarioAlteracao,
tipo,
usuariobanco

)VALUES(
old.id,
old.dataPagamento,
old.dataVencimento,
now(),
old.numero,
old.observacoes,
old.valor,
1,
'delete',
user()
);





  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `chequeslog`
--

DROP TABLE IF EXISTS `chequeslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chequeslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idOriginal` int(11) DEFAULT NULL,
  `dataPagamento` datetime DEFAULT NULL,
  `dataVencimento` datetime DEFAULT NULL,
  `dataAlteracao` datetime DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `observacoes` text,
  `valor` decimal(10,2) DEFAULT NULL,
  `idFuncionarioAlteracao` int(11) DEFAULT NULL,
  `idMotivoDepesa` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `usuariobanco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chequeslog`
--

LOCK TABLES `chequeslog` WRITE;
/*!40000 ALTER TABLE `chequeslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `chequeslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `dataPag` datetime DEFAULT NULL,
  `dataVence` datetime NOT NULL,
  `observacoes` text,
  `idEnderecoPessoa` int(11) NOT NULL,
  `dataGerada` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5A7376F56F0C6CC` (`idEnderecoPessoa`),
  CONSTRAINT `FK_EnderecoPessoa` FOREIGN KEY (`idEnderecoPessoa`) REFERENCES `enderecopessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (216,'2013-06-18 00:00:00','2013-01-23 00:00:00','',22,'2013-06-18 11:35:55');
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contaslog`
--

DROP TABLE IF EXISTS `contaslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contaslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idOriginal` int(11) DEFAULT NULL,
  `dataPag` datetime DEFAULT NULL,
  `dataVence` datetime DEFAULT NULL,
  `observacoes` text,
  `taxaSocio` int(11) DEFAULT NULL,
  `taxaRelogio` decimal(10,2) DEFAULT NULL,
  `idNumeroSocio` int(11) DEFAULT NULL,
  `horaRegristro` datetime DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `usuarioAlteracao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contaslog`
--

LOCK TABLES `contaslog` WRITE;
/*!40000 ALTER TABLE `contaslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `contaslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `corpo` text,
  `descricao` text NOT NULL,
  `nome` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` enum('AEROPORTO','APARTAMENTO','AVENIDA','BECO','BLOCO','CAMINHO','ESCADINHA','ESTAÃ‡ÃƒO','ESTRADA','FAZENDA','LADEIRA','LARGO',' PRAÃ‡A','PARQUE','QUADRA','QUILÃ”METRO','QUINTA','RODOVIA','RUA','TRAVESSA') NOT NULL,
  `nome` varchar(255) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (15,'AVENIDA','João Angélica','');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enderecopessoa`
--

DROP TABLE IF EXISTS `enderecopessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enderecopessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPessoa` int(11) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `Numero` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Numero_UNIQUE` (`Numero`),
  KEY `idPessoaEndereco_idx` (`idPessoa`),
  KEY `idEnderecoPessoa_idx` (`idEndereco`),
  CONSTRAINT `idEnderecoPessoa` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idPessoaEndereco` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecopessoa`
--

LOCK TABLES `enderecopessoa` WRITE;
/*!40000 ALTER TABLE `enderecopessoa` DISABLE KEYS */;
INSERT INTO `enderecopessoa` VALUES (22,12,15,34);
/*!40000 ALTER TABLE `enderecopessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `observacao` text,
  `valor` decimal(10,2) NOT NULL,
  `idCedente` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `idMotivoEntrada` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_MotivoEntrada` (`idMotivoEntrada`),
  KEY `FK_IdCedente` (`idCedente`),
  KEY `FK_IdFuncionario` (`idFuncionario`),
  CONSTRAINT `FK_EntradaFuncionario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_EntradaMotivoEntrada` FOREIGN KEY (`idMotivoEntrada`) REFERENCES `motivoentrada` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_EntradaSocio` FOREIGN KEY (`idCedente`) REFERENCES `socio` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `EntradaLogInsert` AFTER INSERT ON `entrada` FOR EACH ROW BEGIN  INSERT INTO
entradasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
idCedente,
idFuncionario,
idMotivoEntrada,
tipo,
observacao,
usuarioAlteracao

) values(
new.id,
new.data,
now(),
new.valor,
new.idCedente,
new.idFuncionario,
new.idMotivoEntrada,
'insert',
new.observacao,
user()
);

  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `EntradaLogDelete` AFTER DELETE ON `entrada` FOR EACH ROW BEGIN  INSERT INTO
entradasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
idCedente,
idFuncionario,
idMotivoEntrada,
tipo,
observacao,
usuarioAlteracao

) values(
old.id,
old.data,
now(),
old.valor,
old.idCedente,
old.idFuncionario,
old.idMotivoEntrada,
'delete',
old.observacao,
user()
);

  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `entradaslog`
--

DROP TABLE IF EXISTS `entradaslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entradaslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idOriginal` int(11) DEFAULT NULL,
  `dataOriginal` date DEFAULT NULL,
  `dataAlteracao` datetime DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `idCedente` int(11) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  `idMotivoEntrada` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `observacao` text,
  `usuarioAlteracao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradaslog`
--

LOCK TABLES `entradaslog` WRITE;
/*!40000 ALTER TABLE `entradaslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `entradaslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(255) NOT NULL,
  `dataContratacao` datetime NOT NULL,
  `matricula` int(11) NOT NULL,
  `observacao` text,
  `salario` decimal(10,2) NOT NULL,
  `idPessoa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idPessoa_UNIQUE` (`idPessoa`),
  KEY `PK_Funcionario` (`idPessoa`),
  CONSTRAINT `FK_FuncionarioPessoa` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hidrometro`
--

DROP TABLE IF EXISTS `hidrometro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hidrometro` (
  `idhidrometro` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idconta` int(11) unsigned NOT NULL,
  `Consumo` double DEFAULT NULL,
  PRIMARY KEY (`idhidrometro`),
  UNIQUE KEY `idconta_UNIQUE` (`idconta`),
  KEY `fk_idconta_idx` (`idhidrometro`),
  CONSTRAINT `fk_conta_id_hidrometro` FOREIGN KEY (`idconta`) REFERENCES `conta` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hidrometro`
--

LOCK TABLES `hidrometro` WRITE;
/*!40000 ALTER TABLE `hidrometro` DISABLE KEYS */;
/*!40000 ALTER TABLE `hidrometro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivodespesa`
--

DROP TABLE IF EXISTS `motivodespesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motivodespesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text NOT NULL,
  `observacao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivodespesa`
--

LOCK TABLES `motivodespesa` WRITE;
/*!40000 ALTER TABLE `motivodespesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `motivodespesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivoentrada`
--

DROP TABLE IF EXISTS `motivoentrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motivoentrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` text,
  `observacao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivoentrada`
--

LOCK TABLES `motivoentrada` WRITE;
/*!40000 ALTER TABLE `motivoentrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `motivoentrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `numeroEndereco` varchar(11) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `apelido` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `dataNasc` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nomeMae` varchar(255) DEFAULT NULL,
  `nomePai` varchar(255) DEFAULT NULL,
  `numeroMatricula` int(11) DEFAULT NULL,
  `observacoes` text,
  `rgEmissao` date DEFAULT NULL,
  `rgExpedidor` varchar(255) DEFAULT NULL,
  `rgNumero` varchar(20) DEFAULT NULL,
  `sexo` enum('Masculino','Feminino') DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `uf` enum('AC','AL','AP','AM','BA','CE','DF','ES','GO','MA','MT','MS','MG','PA','PB','PR','PE','PI','RJ','RN','RS','RO','RR','SC','SP','SE','TO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  UNIQUE KEY `numeroMatricula_UNIQUE` (`numeroMatricula`),
  KEY `FK_PessoaEndereco` (`idEndereco`),
  CONSTRAINT `FK_PessoaEndereco` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (12,'Alisson','Davis',15,'34','','','','','','545.744.646-49',NULL,'','','',NULL,NULL,NULL,'','','Masculino','','BA');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `rc_categoriasocio`
--

DROP TABLE IF EXISTS `rc_categoriasocio`;
/*!50001 DROP VIEW IF EXISTS `rc_categoriasocio`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_categoriasocio` (
  `id` tinyint NOT NULL,
  `descricao` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `valor` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rc_cheque`
--

DROP TABLE IF EXISTS `rc_cheque`;
/*!50001 DROP VIEW IF EXISTS `rc_cheque`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_cheque` (
  `codigo` tinyint NOT NULL,
  `numero` tinyint NOT NULL,
  `dataPagamento` tinyint NOT NULL,
  `dataVencimento` tinyint NOT NULL,
  `valor` tinyint NOT NULL,
  `funcionario` tinyint NOT NULL,
  `nome` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rc_entradas`
--

DROP TABLE IF EXISTS `rc_entradas`;
/*!50001 DROP VIEW IF EXISTS `rc_entradas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_entradas` (
  `id` tinyint NOT NULL,
  `data` tinyint NOT NULL,
  `valor` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `socio` tinyint NOT NULL,
  `funcionario` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rc_funcionario`
--

DROP TABLE IF EXISTS `rc_funcionario`;
/*!50001 DROP VIEW IF EXISTS `rc_funcionario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_funcionario` (
  `id` tinyint NOT NULL,
  `concat(p.nome," ",p.sobrenome)` tinyint NOT NULL,
  `cpf` tinyint NOT NULL,
  `cargo` tinyint NOT NULL,
  `dataContratacao` tinyint NOT NULL,
  `matricula` tinyint NOT NULL,
  `observacao` tinyint NOT NULL,
  `salario` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rc_saidas`
--

DROP TABLE IF EXISTS `rc_saidas`;
/*!50001 DROP VIEW IF EXISTS `rc_saidas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_saidas` (
  `id` tinyint NOT NULL,
  `data` tinyint NOT NULL,
  `observacao` tinyint NOT NULL,
  `valor` tinyint NOT NULL,
  `favorecido` tinyint NOT NULL,
  `funcionario` tinyint NOT NULL,
  `motivo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rc_socio`
--

DROP TABLE IF EXISTS `rc_socio`;
/*!50001 DROP VIEW IF EXISTS `rc_socio`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_socio` (
  `regristo` tinyint NOT NULL,
  `numeroSocio` tinyint NOT NULL,
  `dataMatricula` tinyint NOT NULL,
  `dataAprovacao` tinyint NOT NULL,
  `observacao` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `categoria` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `saida`
--

DROP TABLE IF EXISTS `saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `observacao` text,
  `valor` decimal(10,2) NOT NULL,
  `favorecido` varchar(255) NOT NULL,
  `idfuncionario` int(11) NOT NULL,
  `idmotivosaida` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6823D9860A64FB` (`idmotivosaida`),
  KEY `FK6823D98E196A484` (`idfuncionario`),
  CONSTRAINT `FK6823D98B686FB5B` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK6823D98F5B1A7DB` FOREIGN KEY (`idmotivosaida`) REFERENCES `motivodespesa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saida`
--

LOCK TABLES `saida` WRITE;
/*!40000 ALTER TABLE `saida` DISABLE KEYS */;
/*!40000 ALTER TABLE `saida` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `SaidaLogInsert` AFTER INSERT ON `saida` FOR EACH ROW BEGIN  INSERT INTO
saidasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
favorecido,
idFuncionario,
usuarioAlteracao,
idMotivosaida,
tipo,
observacao


) values(
new.id,
new.data,
now(),
new.valor,
new.favorecido,
new.idfuncionario,
user(),
new.idmotivosaida,
'insert',
new.observacao

);

  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `SaidaLogDelete` AFTER DELETE ON `saida` FOR EACH ROW BEGIN  INSERT INTO
saidasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
favorecido,
idFuncionario,
usuarioAlteracao,
idMotivosaida,
tipo,
observacao


) values(
old.id,
old.data,
now(),
old.valor,
old.favorecido,
old.idfuncionario,
user(),
old.idmotivosaida,
'delete',
old.observacao

);

  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `saidaslog`
--

DROP TABLE IF EXISTS `saidaslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saidaslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idoriginal` int(11) DEFAULT NULL,
  `dataoriginal` date DEFAULT NULL,
  `dataalteracao` datetime DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `favorecido` varchar(255) DEFAULT NULL,
  `idfuncionario` int(11) DEFAULT NULL,
  `idFuncionarioAltercao` int(11) DEFAULT NULL,
  `usuarioAlteracao` varchar(45) DEFAULT NULL,
  `idmotivosaida` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `observacao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saidaslog`
--

LOCK TABLES `saidaslog` WRITE;
/*!40000 ALTER TABLE `saidaslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `saidaslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataVence` date DEFAULT NULL,
  `dataAprovacao` datetime DEFAULT NULL,
  `dataMatricula` datetime NOT NULL,
  `numeroSocio` int(11) NOT NULL,
  `observacao` text,
  `idCategoriaSocio` int(11) NOT NULL,
  `idPessoa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idPessoa_UNIQUE` (`idPessoa`),
  UNIQUE KEY `numeroSocio_UNIQUE` (`numeroSocio`),
  KEY `FK68884EDA2F76C89` (`idPessoa`),
  KEY `FK68884ED9B4A2386` (`idCategoriaSocio`),
  CONSTRAINT `FK68884EDA557E577` FOREIGN KEY (`idCategoriaSocio`) REFERENCES `categoriasocio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK68884EDE2CAEDC0` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (11,'2014-04-05','2013-06-18 11:29:17','2013-06-18 00:00:00',1,NULL,13,12);
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxa`
--

DROP TABLE IF EXISTS `taxa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `observacao` text,
  `valor` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxa`
--

LOCK TABLES `taxa` WRITE;
/*!40000 ALTER TABLE `taxa` DISABLE KEYS */;
INSERT INTO `taxa` VALUES (37,'Taxa Sócio','',NULL,20.00);
/*!40000 ALTER TABLE `taxa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxasconta`
--

DROP TABLE IF EXISTS `taxasconta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxasconta` (
  `idtaxasConta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `contaid` int(10) unsigned NOT NULL,
  `taxaid` int(11) NOT NULL,
  PRIMARY KEY (`idtaxasConta`),
  KEY `fk_conta_idx` (`contaid`),
  KEY `fk_taxa_idx` (`taxaid`),
  CONSTRAINT `fk_conta` FOREIGN KEY (`contaid`) REFERENCES `conta` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_taxa` FOREIGN KEY (`taxaid`) REFERENCES `taxa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxasconta`
--

LOCK TABLES `taxasconta` WRITE;
/*!40000 ALTER TABLE `taxasconta` DISABLE KEYS */;
INSERT INTO `taxasconta` VALUES (46,216,37);
/*!40000 ALTER TABLE `taxasconta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `rc_categoriasocio`
--

/*!50001 DROP TABLE IF EXISTS `rc_categoriasocio`*/;
/*!50001 DROP VIEW IF EXISTS `rc_categoriasocio`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_categoriasocio` AS select `cs`.`id` AS `id`,`cs`.`descricao` AS `descricao`,`cs`.`nome` AS `nome`,`t`.`valor` AS `valor` from (`categoriasocio` `cs` join `taxa` `t` on((`t`.`id` = `cs`.`taxasId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rc_cheque`
--

/*!50001 DROP TABLE IF EXISTS `rc_cheque`*/;
/*!50001 DROP VIEW IF EXISTS `rc_cheque`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_cheque` AS select `c`.`id` AS `codigo`,`c`.`numero` AS `numero`,`c`.`dataPagamento` AS `dataPagamento`,`c`.`dataVencimento` AS `dataVencimento`,`c`.`valor` AS `valor`,`p`.`nome` AS `funcionario`,`md`.`nome` AS `nome` from (((`cheque` `c` join `funcionario` `f` on((`c`.`idFuncionario` = `f`.`id`))) join `pessoa` `p` on((`f`.`idPessoa` = `p`.`id`))) join `motivodespesa` `md` on((`c`.`idMotivoDespesa` = `md`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rc_entradas`
--

/*!50001 DROP TABLE IF EXISTS `rc_entradas`*/;
/*!50001 DROP VIEW IF EXISTS `rc_entradas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_entradas` AS select `e`.`id` AS `id`,`e`.`data` AS `data`,`e`.`valor` AS `valor`,`m`.`nome` AS `nome`,concat(`ps`.`nome`,_latin1' ',`ps`.`sobrenome`) AS `socio`,concat(`pf`.`nome`,_latin1' ',`pf`.`sobrenome`) AS `funcionario` from (((((`entrada` `e` join `socio` `s` on((`s`.`id` = `e`.`idCedente`))) join `funcionario` `f` on((`f`.`id` = `e`.`idFuncionario`))) join `pessoa` `pf` on((`pf`.`id` = `f`.`idPessoa`))) join `pessoa` `ps` on((`ps`.`id` = `s`.`idPessoa`))) join `motivoentrada` `m` on((`m`.`id` = `e`.`idMotivoEntrada`))) order by `e`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rc_funcionario`
--

/*!50001 DROP TABLE IF EXISTS `rc_funcionario`*/;
/*!50001 DROP VIEW IF EXISTS `rc_funcionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_funcionario` AS select `f`.`id` AS `id`,concat(`p`.`nome`,_latin1' ',`p`.`sobrenome`) AS `concat(p.nome," ",p.sobrenome)`,`p`.`cpf` AS `cpf`,`f`.`cargo` AS `cargo`,`f`.`dataContratacao` AS `dataContratacao`,`f`.`matricula` AS `matricula`,`f`.`observacao` AS `observacao`,`f`.`salario` AS `salario` from (`funcionario` `f` join `pessoa` `p` on((`p`.`id` = `f`.`idPessoa`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rc_saidas`
--

/*!50001 DROP TABLE IF EXISTS `rc_saidas`*/;
/*!50001 DROP VIEW IF EXISTS `rc_saidas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_saidas` AS select `s`.`id` AS `id`,`s`.`data` AS `data`,`s`.`observacao` AS `observacao`,`s`.`valor` AS `valor`,`s`.`favorecido` AS `favorecido`,concat(`p`.`nome`,_latin1' ',`p`.`sobrenome`) AS `funcionario`,`m`.`nome` AS `motivo` from (((`saida` `s` join `funcionario` `f` on((`f`.`id` = `s`.`idfuncionario`))) join `pessoa` `p` on((`p`.`id` = `f`.`idPessoa`))) join `motivodespesa` `m` on((`m`.`id` = `s`.`idmotivosaida`))) order by `s`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rc_socio`
--

/*!50001 DROP TABLE IF EXISTS `rc_socio`*/;
/*!50001 DROP VIEW IF EXISTS `rc_socio`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_socio` AS select `s`.`id` AS `regristo`,`s`.`numeroSocio` AS `numeroSocio`,`s`.`dataMatricula` AS `dataMatricula`,`s`.`dataAprovacao` AS `dataAprovacao`,`s`.`observacao` AS `observacao`,concat(`p`.`nome`,_latin1' ',`p`.`sobrenome`) AS `nome`,`cat`.`nome` AS `categoria` from ((`socio` `s` join `pessoa` `p` on((`p`.`id` = `s`.`idPessoa`))) join `categoriasocio` `cat` on((`cat`.`id` = `s`.`idCategoriaSocio`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-18 13:37:42
