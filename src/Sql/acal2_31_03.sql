-- MySQL dump 10.13  Distrib 5.5.30, for Win64 (x86)
--
-- Host: localhost    Database: acal2
-- ------------------------------------------------------
-- Server version	5.5.30

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
  KEY `FK9AEAD6E1EB06E4EA` (`taxasId`),
  KEY `FK271F6B9AA011B865` (`taxasId`),
  KEY `FK271F6B9AC9B06B76` (`taxasId`),
  CONSTRAINT `FK271F6B9AA011B865` FOREIGN KEY (`taxasId`) REFERENCES `taxa` (`id`),
  CONSTRAINT `FK271F6B9AC9B06B76` FOREIGN KEY (`taxasId`) REFERENCES `taxa` (`id`),
  CONSTRAINT `FK9AEAD6E1EB06E4EA` FOREIGN KEY (`taxasId`) REFERENCES `taxa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriasocio`
--

LOCK TABLES `categoriasocio` WRITE;
/*!40000 ALTER TABLE `categoriasocio` DISABLE KEYS */;
INSERT INTO `categoriasocio` VALUES (5,'Categoria de Socio Fundador','Socio Fundador',1),(6,'Categoria de Socio temporario','socio temporario',3),(7,'socio','categoria',1),(8,'categoria Socio','',1),(9,'bizarro','',1);
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
  KEY `FKAED8F221893CFF1` (`idMotivoDespesa`),
  KEY `FKAED8F221B686FB5B` (`idFuncionario`),
  KEY `FKAED8F22151783C38` (`idMotivoDespesa`),
  KEY `FKAED8F221E196A484` (`idFuncionario`),
  KEY `FKAED8F221495AD467` (`idMotivoDespesa`),
  KEY `FKAED8F221A28C8C53` (`idFuncionario`),
  CONSTRAINT `FKAED8F221495AD467` FOREIGN KEY (`idMotivoDespesa`) REFERENCES `motivodespesa` (`id`),
  CONSTRAINT `FKAED8F22151783C38` FOREIGN KEY (`idMotivoDespesa`) REFERENCES `motivodespesa` (`id`),
  CONSTRAINT `FKAED8F221A28C8C53` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FKAED8F221E196A484` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `id_funcionario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `id_motivo_depesa` FOREIGN KEY (`idMotivoDespesa`) REFERENCES `motivodespesa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheque`
--

LOCK TABLES `cheque` WRITE;
/*!40000 ALTER TABLE `cheque` DISABLE KEYS */;
INSERT INTO `cheque` VALUES (9,'2101-01-01 00:00:00','2101-01-01 00:00:00',1,'1',1450.00,1,3),(10,'2101-01-01 00:00:00','2101-01-01 00:00:00',1,'1',23.00,2,3);
/*!40000 ALTER TABLE `cheque` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER ChequeLogInsert after insert ON cheque
FOR EACH ROW BEGIN INSERT INTO 
chequeslog (
idOriginal,
dataPagamento,
dataVencimento,
dataAlteracao,
numero,
observacoes,
valor,
idFuncionarioAlteracao,
tipo
)VALUES(
new.id,
new.dataPagamento,
new.dataVencimento,
now(),
new.numero,
new.observacoes,
new.valor,
1,
'insert'

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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER ChequeLogDelete after delete ON cheque
FOR EACH ROW BEGIN INSERT INTO 
chequeslog(
idOriginal,
dataPagamento,
dataVencimento,
dataAlteracao,
numero,
observacoes,
valor,
idFuncionarioAlteracao,
tipo
)VALUES(
old.id,
old.dataPagamento,
old.dataVencimento,
now(),
old.numero,
old.observacoes,
old.valor,
1,
'delete'

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
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chequeslog`
--

LOCK TABLES `chequeslog` WRITE;
/*!40000 ALTER TABLE `chequeslog` DISABLE KEYS */;
INSERT INTO `chequeslog` VALUES (3,9,'2101-01-01 00:00:00','2101-01-01 00:00:00','2013-03-29 21:15:07',1,'1',1450.00,1,'insert'),(4,10,'2101-01-01 00:00:00','2101-01-01 00:00:00','2013-03-29 21:15:07',1,'1',23.00,1,'insert');
/*!40000 ALTER TABLE `chequeslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataPag` datetime DEFAULT NULL,
  `dataVence` datetime NOT NULL,
  `observacoes` text,
  `taxaSocio` int(11) DEFAULT NULL,
  `taxaRelogio` decimal(10,2) DEFAULT NULL,
  `idNumeroSocio` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5A7376FC2A54024` (`idNumeroSocio`),
  KEY `FK5A7376F56F0C6CC` (`idNumeroSocio`),
  KEY `FK5A7376F612875DB` (`idNumeroSocio`),
  KEY `taxaSocio` (`taxaSocio`),
  CONSTRAINT `conta_ibfk_1` FOREIGN KEY (`taxaSocio`) REFERENCES `taxa` (`id`),
  CONSTRAINT `FK5A7376F56F0C6CC` FOREIGN KEY (`idNumeroSocio`) REFERENCES `socio` (`id`),
  CONSTRAINT `FK5A7376F612875DB` FOREIGN KEY (`idNumeroSocio`) REFERENCES `socio` (`id`),
  CONSTRAINT `FK5A7376FC2A54024` FOREIGN KEY (`idNumeroSocio`) REFERENCES `socio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (1,'2101-01-01 00:00:00','2101-01-01 00:00:00','asda',1,50.00,1),(2,'2101-01-01 00:00:00','2101-01-01 00:00:00','da',1,NULL,2),(3,'2101-01-01 00:00:00','2101-01-01 00:00:00','2101-01-01 00:00:00',NULL,50.00,2),(4,'2101-01-01 00:00:00','2101-01-01 00:00:00','asds',1,NULL,2),(5,'2101-01-01 00:00:00','2101-01-01 00:00:00','2112',NULL,23.00,1),(6,NULL,'2101-01-01 00:00:00','123',NULL,12.00,1),(7,NULL,'2101-01-01 00:00:00','conta vencida',NULL,1.00,1),(9,NULL,'2101-01-01 00:00:00','asda',NULL,500.00,1),(10,NULL,'2101-01-01 00:00:00','123',NULL,50.00,2);
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER contaLogInsert  after insert ON conta
FOR EACH ROW BEGIN  INSERT INTO
contasLog 
(
idOriginal,
dataPag,
dataVence,
observacoes,
taxaSocio,
taxaRelogio,
idNumeroSocio,
horaAlteracao,
tipo
) values(
new.id,
new.dataPag,
new.dataVence,
new.observacoes,
new.taxaSocio,
new.taxaRelogio,
new.idNumeroSocio,
now(),
'Insert'
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER contaLogDelete  after delete ON conta
FOR EACH ROW BEGIN  INSERT INTO
contasLog 
(
idOriginal,
dataPag,
dataVence,
observacoes,
taxaSocio,
taxaRelogio,
idNumeroSocio,
horaAlteracao,
tipo
) values(
old.id,
old.dataPag,
old.dataVence,
old.observacoes,
old.taxaSocio,
old.taxaRelogio,
old.idNumeroSocio,
now(),
'Delete'
);

  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary table structure for view `contas_socio_taxa`
--

DROP TABLE IF EXISTS `contas_socio_taxa`;
/*!50001 DROP VIEW IF EXISTS `contas_socio_taxa`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `contas_socio_taxa` (
  `id` tinyint NOT NULL,
  `dataPag` tinyint NOT NULL,
  `dataVence` tinyint NOT NULL,
  `taxaRelogio` tinyint NOT NULL,
  `valor` tinyint NOT NULL,
  `codigo_socio` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `sobrenome` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  `horaAlteracao` datetime DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contaslog`
--

LOCK TABLES `contaslog` WRITE;
/*!40000 ALTER TABLE `contaslog` DISABLE KEYS */;
INSERT INTO `contaslog` VALUES (1,8,'2101-01-01 00:00:00','2101-01-01 00:00:00','teste de log',2,40.00,1,'2013-03-30 14:20:34','Insert'),(2,8,'2101-01-01 00:00:00','2101-01-01 00:00:00','teste de log',2,40.00,1,'2013-03-30 14:21:31','Delete'),(3,9,NULL,'2101-01-01 00:00:00','asda',NULL,500.00,1,'2013-03-30 14:35:05','Insert'),(4,10,NULL,'2101-01-01 00:00:00','123',NULL,50.00,2,'2013-03-30 14:36:12','Insert');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (1,'ddasa','adsa','dsadasd');
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
  `descricao` text,
  `nome` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Rua da pista','Fernando Daltro','Avenida'),(2,'rua que fica a acal','Do morro','Avenida'),(3,'rua da praca','Qunitinho alves','Praca');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `observacao` text,
  `valor` decimal(10,2) NOT NULL,
  `idCedente` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `idMotivoEntrada` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA12266579628C684` (`idMotivoEntrada`),
  KEY `FKA12266574303C16E` (`idCedente`),
  KEY `FKA1226657B686FB5B` (`idFuncionario`),
  KEY `FKA1226657DA19CCBC` (`idMotivoEntrada`),
  KEY `FKA1226657FDA06717` (`idCedente`),
  KEY `FKA1226657E196A484` (`idFuncionario`),
  KEY `FKA1226657D1FC64EB` (`idMotivoEntrada`),
  KEY `FKA12266577D81626` (`idCedente`),
  KEY `FKA1226657A28C8C53` (`idFuncionario`),
  CONSTRAINT `FKA12266574303C16E` FOREIGN KEY (`idCedente`) REFERENCES `socio` (`id`),
  CONSTRAINT `FKA12266577D81626` FOREIGN KEY (`idCedente`) REFERENCES `socio` (`id`),
  CONSTRAINT `FKA12266579628C684` FOREIGN KEY (`idMotivoEntrada`) REFERENCES `motivoentrada` (`id`),
  CONSTRAINT `FKA1226657A28C8C53` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FKA1226657B686FB5B` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FKA1226657D1FC64EB` FOREIGN KEY (`idMotivoEntrada`) REFERENCES `motivoentrada` (`id`),
  CONSTRAINT `FKA1226657DA19CCBC` FOREIGN KEY (`idMotivoEntrada`) REFERENCES `motivoentrada` (`id`),
  CONSTRAINT `FKA1226657E196A484` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FKA1226657FDA06717` FOREIGN KEY (`idCedente`) REFERENCES `socio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,'2012-01-01','obs',15.00,1,1,1),(2,'2012-01-01',NULL,15.00,2,2,2),(3,'2012-01-01',NULL,40.00,2,2,2);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER EntradaLogInsert after insert ON entrada
FOR EACH ROW BEGIN  INSERT INTO
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
observacao

) values(
new.id,
new.data,
now(),
new.valor,
new.idCedente,
new.idFuncionario,
new.idMotivoEntrada,
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER EntradaLogDelete after delete ON entrada
FOR EACH ROW BEGIN  INSERT INTO
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
observacao

) values(
old.id,
old.data,
now(),
old.valor,
old.idCedente,
old.idFuncionario,
old.idMotivoEntrada,
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
  `idFuncionarioAlteracao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradaslog`
--

LOCK TABLES `entradaslog` WRITE;
/*!40000 ALTER TABLE `entradaslog` DISABLE KEYS */;
INSERT INTO `entradaslog` VALUES (1,1,'2012-01-01','2013-03-29 21:11:59',15.00,1,1,1,'insert','obs',NULL),(2,2,'2012-01-01','2013-03-29 21:12:13',15.00,2,2,2,'insert',NULL,NULL),(3,3,'2013-01-01','2013-03-30 10:01:42',15.00,2,2,2,'insert',NULL,NULL),(4,3,'2013-01-01','2013-03-30 10:02:28',15.00,2,2,2,'delete',NULL,NULL),(5,3,'2012-01-01','2013-03-31 18:57:52',40.00,2,2,2,'insert',NULL,NULL);
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
  `salario` float NOT NULL,
  `idPessoa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50401DDBA2F76C89` (`idPessoa`),
  KEY `FK50401DDBE2CAEDC0` (`idPessoa`),
  KEY `FK50401DDB1F892091` (`idPessoa`),
  CONSTRAINT `FK50401DDB1F892091` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FK50401DDBA2F76C89` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FK50401DDBE2CAEDC0` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Programador Java','2013-01-01 00:00:00',23,NULL,1300,1),(2,'Analista Java','2013-01-01 00:00:00',123,NULL,1300,2);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivodespesa`
--

LOCK TABLES `motivodespesa` WRITE;
/*!40000 ALTER TABLE `motivodespesa` DISABLE KEYS */;
INSERT INTO `motivodespesa` VALUES (2,'Conta de Energia','Para Pagar Energia',NULL),(3,'Alguel do predio','cs',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivoentrada`
--

LOCK TABLES `motivoentrada` WRITE;
/*!40000 ALTER TABLE `motivoentrada` DISABLE KEYS */;
INSERT INTO `motivoentrada` VALUES (1,'Recebimento de contas','c',NULL),(2,'Caminhao de agua','1',NULL);
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
  `apelido` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `categoriaSocio` int(11) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `dataNasc` datetime DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `nomeMae` varchar(255) DEFAULT NULL,
  `nomePai` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `numeroMatricula` int(11) DEFAULT NULL,
  `observacoes` text,
  `rgEmissao` date DEFAULT NULL,
  `rgExpedidor` varchar(255) DEFAULT NULL,
  `rgNumero` int(11) DEFAULT NULL,
  `sexo` enum('Masculino','Feminino') DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `idEndereco` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC4E40FA758EBBA0D` (`idEndereco`),
  KEY `FKC4E40FA7F1E3C984` (`idEndereco`),
  KEY `FKC4E40FA7F7E08C15` (`idEndereco`),
  CONSTRAINT `FKC4E40FA758EBBA0D` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`),
  CONSTRAINT `FKC4E40FA7F1E3C984` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`),
  CONSTRAINT `FKC4E40FA7F7E08C15` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Alex','lages',5,NULL,NULL,'12345678912',NULL,NULL,'Alexandre','Queiroz',NULL,NULL,NULL,123,NULL,NULL,NULL,NULL,'Masculino','',NULL,NULL,1),(2,'Davis','Camacari',NULL,NULL,NULL,'98765432121',NULL,NULL,'Alisson','davis',NULL,NULL,NULL,3432,NULL,NULL,NULL,NULL,'Masculino','',NULL,NULL,2);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `relatorio_contas`
--

DROP TABLE IF EXISTS `relatorio_contas`;
/*!50001 DROP VIEW IF EXISTS `relatorio_contas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `relatorio_contas` (
  `id` tinyint NOT NULL,
  `dataPag` tinyint NOT NULL,
  `dataVence` tinyint NOT NULL,
  `Taxa_Valor` tinyint NOT NULL,
  `Relogio` tinyint NOT NULL,
  `codigo_socio` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `sobrenome` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `relatorio_contas_abertas`
--

DROP TABLE IF EXISTS `relatorio_contas_abertas`;
/*!50001 DROP VIEW IF EXISTS `relatorio_contas_abertas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `relatorio_contas_abertas` (
  `Numero_Conta` tinyint NOT NULL,
  `Vencimento` tinyint NOT NULL,
  `TaxaSocio` tinyint NOT NULL,
  `taxaRelogio` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `cpf` tinyint NOT NULL,
  `categoria` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `relatorio_entradas`
--

DROP TABLE IF EXISTS `relatorio_entradas`;
/*!50001 DROP VIEW IF EXISTS `relatorio_entradas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `relatorio_entradas` (
  `numero` tinyint NOT NULL,
  `data` tinyint NOT NULL,
  `valor` tinyint NOT NULL,
  `motivo` tinyint NOT NULL,
  `cod_F` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `cpf` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `relatorio_socio_ativos`
--

DROP TABLE IF EXISTS `relatorio_socio_ativos`;
/*!50001 DROP VIEW IF EXISTS `relatorio_socio_ativos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `relatorio_socio_ativos` (
  `numeroSocio` tinyint NOT NULL,
  `apelido` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `cpf` tinyint NOT NULL,
  `dataMatricula` tinyint NOT NULL,
  `dataAprovacao` tinyint NOT NULL,
  `Categoria` tinyint NOT NULL
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
  KEY `FK6823D98F5B1A7DB` (`idmotivosaida`),
  KEY `FK6823D98B686FB5B` (`idfuncionario`),
  KEY `FK6823D9860A64FB` (`idmotivosaida`),
  KEY `FK6823D98E196A484` (`idfuncionario`),
  KEY `FK6823D98FDECFD2A` (`idmotivosaida`),
  KEY `FK6823D98A28C8C53` (`idfuncionario`),
  CONSTRAINT `FK6823D9860A64FB` FOREIGN KEY (`idmotivosaida`) REFERENCES `motivodespesa` (`id`),
  CONSTRAINT `FK6823D98A28C8C53` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FK6823D98B686FB5B` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FK6823D98E196A484` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FK6823D98F5B1A7DB` FOREIGN KEY (`idmotivosaida`) REFERENCES `motivodespesa` (`id`),
  CONSTRAINT `FK6823D98FDECFD2A` FOREIGN KEY (`idmotivosaida`) REFERENCES `motivodespesa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saida`
--

LOCK TABLES `saida` WRITE;
/*!40000 ALTER TABLE `saida` DISABLE KEYS */;
INSERT INTO `saida` VALUES (4,'2010-01-01 00:00:00','obs',1400.00,'Oficina',1,2),(5,'2010-01-01 00:00:00','das',123.00,'Bomba Da agua',2,3);
/*!40000 ALTER TABLE `saida` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER SaidaLogInsert  after insert ON saida
FOR EACH ROW BEGIN  INSERT INTO
saidasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
favorecido,
idFuncionario,

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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER SaidaLogDelete  after delete ON saida
FOR EACH ROW BEGIN  INSERT INTO
saidasLog 
(
idOriginal,
dataOriginal,
dataAlteracao,
valor,
favorecido,
idFuncionario,

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
-- Temporary table structure for view `saida_funcionario`
--

DROP TABLE IF EXISTS `saida_funcionario`;
/*!50001 DROP VIEW IF EXISTS `saida_funcionario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `saida_funcionario` (
  `id` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `sobrenome` tinyint NOT NULL,
  `salario` tinyint NOT NULL,
  `data` tinyint NOT NULL,
  `favorecido` tinyint NOT NULL,
  `valor` tinyint NOT NULL,
  `despesa` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  `idmotivosaida` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `observacao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saidaslog`
--

LOCK TABLES `saidaslog` WRITE;
/*!40000 ALTER TABLE `saidaslog` DISABLE KEYS */;
INSERT INTO `saidaslog` VALUES (1,4,'2010-01-01','2013-03-29 21:11:01',1400.00,'Oficina',1,NULL,2,'insert','obs'),(2,5,'2010-01-01','2013-03-29 21:11:20',123.00,'Bomba Da agua',2,NULL,3,'insert','das');
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
  UNIQUE KEY `Id_pessoa` (`idPessoa`),
  KEY `FK68884EDA2F76C89` (`idPessoa`),
  KEY `FK68884EDD8D64A80` (`idCategoriaSocio`),
  KEY `FK68884ED9B4A2386` (`idCategoriaSocio`),
  KEY `FK68884EDE2CAEDC0` (`idPessoa`),
  KEY `FK68884EDA557E577` (`idCategoriaSocio`),
  KEY `FK68884ED1F892091` (`idPessoa`),
  CONSTRAINT `FK68884ED1F892091` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FK68884ED9B4A2386` FOREIGN KEY (`idCategoriaSocio`) REFERENCES `categoriasocio` (`id`),
  CONSTRAINT `FK68884EDA2F76C89` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FK68884EDA557E577` FOREIGN KEY (`idCategoriaSocio`) REFERENCES `categoriasocio` (`id`),
  CONSTRAINT `FK68884EDD8D64A80` FOREIGN KEY (`idCategoriaSocio`) REFERENCES `categoriasocio` (`id`),
  CONSTRAINT `FK68884EDE2CAEDC0` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (1,'2001-12-12','2001-12-12 00:00:00','2001-12-12 00:00:00',1,NULL,5,1),(2,'2001-12-12','2001-12-12 00:00:00','2001-12-12 00:00:00',2,NULL,5,2);
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `soma_contas_abertas_por_pessoa`
--

DROP TABLE IF EXISTS `soma_contas_abertas_por_pessoa`;
/*!50001 DROP VIEW IF EXISTS `soma_contas_abertas_por_pessoa`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `soma_contas_abertas_por_pessoa` (
  `id` tinyint NOT NULL,
  `dataPag` tinyint NOT NULL,
  `dataVence` tinyint NOT NULL,
  `total_contas` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `sobrenome` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `soma_contas_pagas_por_pessoa`
--

DROP TABLE IF EXISTS `soma_contas_pagas_por_pessoa`;
/*!50001 DROP VIEW IF EXISTS `soma_contas_pagas_por_pessoa`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `soma_contas_pagas_por_pessoa` (
  `id` tinyint NOT NULL,
  `dataPag` tinyint NOT NULL,
  `dataVence` tinyint NOT NULL,
  `soma_relogio` tinyint NOT NULL,
  `soma_contas_por_taxas` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `sobrenome` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `taxa`
--

DROP TABLE IF EXISTS `taxa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `observacao` text,
  `valor` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxa`
--

LOCK TABLES `taxa` WRITE;
/*!40000 ALTER TABLE `taxa` DISABLE KEYS */;
INSERT INTO `taxa` VALUES (1,'Taxa de Socio Efetivo','Taxa Socio efetivo','taxa aprovada pela comicao no tdia ',20.00),(2,'Taxa De Socio Fundador','Taxa Socio fundador','taxa em uso pelo an1os 2012',15.00),(3,'','null','da',20.00),(8,'taxa','teste','teste1',12.00);
/*!40000 ALTER TABLE `taxa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `contas_socio_taxa`
--

/*!50001 DROP TABLE IF EXISTS `contas_socio_taxa`*/;
/*!50001 DROP VIEW IF EXISTS `contas_socio_taxa`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `contas_socio_taxa` AS select `c`.`id` AS `id`,`c`.`dataPag` AS `dataPag`,`c`.`dataVence` AS `dataVence`,`c`.`taxaRelogio` AS `taxaRelogio`,`t`.`valor` AS `valor`,`s`.`id` AS `codigo_socio`,`p`.`nome` AS `nome`,`p`.`sobrenome` AS `sobrenome` from (((`conta` `c` join `taxa` `t` on((`c`.`taxaSocio` = `t`.`id`))) join `socio` `s` on((`s`.`id` = `c`.`idNumeroSocio`))) join `pessoa` `p` on((`p`.`id` = `s`.`idPessoa`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `relatorio_contas`
--

/*!50001 DROP TABLE IF EXISTS `relatorio_contas`*/;
/*!50001 DROP VIEW IF EXISTS `relatorio_contas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `relatorio_contas` AS select `c`.`id` AS `id`,`c`.`dataPag` AS `dataPag`,`c`.`dataVence` AS `dataVence`,`t`.`valor` AS `Taxa_Valor`,`c`.`taxaRelogio` AS `Relogio`,`s`.`id` AS `codigo_socio`,`p`.`nome` AS `nome`,`p`.`sobrenome` AS `sobrenome` from (((`conta` `c` left join `taxa` `t` on((`c`.`taxaSocio` = `t`.`id`))) join `socio` `s` on((`s`.`id` = `c`.`idNumeroSocio`))) join `pessoa` `p` on((`s`.`idPessoa` = `p`.`id`))) order by `c`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `relatorio_contas_abertas`
--

/*!50001 DROP TABLE IF EXISTS `relatorio_contas_abertas`*/;
/*!50001 DROP VIEW IF EXISTS `relatorio_contas_abertas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `relatorio_contas_abertas` AS select `c`.`id` AS `Numero_Conta`,`c`.`dataVence` AS `Vencimento`,`c`.`taxaSocio` AS `TaxaSocio`,`c`.`taxaRelogio` AS `taxaRelogio`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `nome`,`p`.`cpf` AS `cpf`,`cs`.`nome` AS `categoria` from (((`conta` `c` join `socio` `s` on((`s`.`id` = `c`.`idNumeroSocio`))) join `pessoa` `p` on((`p`.`id` = `s`.`idPessoa`))) join `categoriasocio` `cs` on((`cs`.`id` = `s`.`idCategoriaSocio`))) where isnull(`c`.`dataPag`) order by `c`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `relatorio_entradas`
--

/*!50001 DROP TABLE IF EXISTS `relatorio_entradas`*/;
/*!50001 DROP VIEW IF EXISTS `relatorio_entradas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `relatorio_entradas` AS select `e`.`id` AS `numero`,`e`.`data` AS `data`,`e`.`valor` AS `valor`,`me`.`nome` AS `motivo`,`f`.`id` AS `cod_F`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `nome`,`p`.`cpf` AS `cpf` from (((`entrada` `e` join `motivoentrada` `me` on((`me`.`id` = `e`.`idMotivoEntrada`))) join `funcionario` `f` on((`e`.`idFuncionario` = `f`.`id`))) join `pessoa` `p` on((`f`.`idPessoa` = `p`.`id`))) order by `p`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `relatorio_socio_ativos`
--

/*!50001 DROP TABLE IF EXISTS `relatorio_socio_ativos`*/;
/*!50001 DROP VIEW IF EXISTS `relatorio_socio_ativos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `relatorio_socio_ativos` AS select `s`.`numeroSocio` AS `numeroSocio`,`p`.`apelido` AS `apelido`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `nome`,`p`.`cpf` AS `cpf`,`s`.`dataMatricula` AS `dataMatricula`,`s`.`dataAprovacao` AS `dataAprovacao`,`cs`.`nome` AS `Categoria` from ((`pessoa` `p` join `socio` `s` on((`p`.`id` = `s`.`idPessoa`))) join `categoriasocio` `cs` on((`cs`.`id` = `s`.`idCategoriaSocio`))) where (`p`.`status` = 1) order by `p`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `saida_funcionario`
--

/*!50001 DROP TABLE IF EXISTS `saida_funcionario`*/;
/*!50001 DROP VIEW IF EXISTS `saida_funcionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `saida_funcionario` AS select `p`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`sobrenome` AS `sobrenome`,`f`.`salario` AS `salario`,`s`.`data` AS `data`,`s`.`favorecido` AS `favorecido`,`s`.`valor` AS `valor`,`m`.`nome` AS `despesa` from (((`funcionario` `f` join `pessoa` `p` on((`f`.`idPessoa` = `p`.`id`))) join `saida` `s` on((`s`.`idfuncionario` = `f`.`id`))) join `motivodespesa` `m` on((`m`.`id` = `s`.`idmotivosaida`))) order by `p`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `soma_contas_abertas_por_pessoa`
--

/*!50001 DROP TABLE IF EXISTS `soma_contas_abertas_por_pessoa`*/;
/*!50001 DROP VIEW IF EXISTS `soma_contas_abertas_por_pessoa`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `soma_contas_abertas_por_pessoa` AS select `c`.`id` AS `id`,`c`.`dataPag` AS `dataPag`,`c`.`dataVence` AS `dataVence`,sum(`c`.`taxaRelogio`) AS `total_contas`,`p`.`nome` AS `nome`,`p`.`sobrenome` AS `sobrenome` from ((`conta` `c` join `socio` `s` on((`c`.`idNumeroSocio` = `s`.`id`))) join `pessoa` `p` on((`p`.`id` = `s`.`idPessoa`))) where isnull(`c`.`dataPag`) group by `p`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `soma_contas_pagas_por_pessoa`
--

/*!50001 DROP TABLE IF EXISTS `soma_contas_pagas_por_pessoa`*/;
/*!50001 DROP VIEW IF EXISTS `soma_contas_pagas_por_pessoa`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `soma_contas_pagas_por_pessoa` AS select `c`.`id` AS `id`,`c`.`dataPag` AS `dataPag`,`c`.`dataVence` AS `dataVence`,sum(`c`.`taxaRelogio`) AS `soma_relogio`,sum(`t`.`valor`) AS `soma_contas_por_taxas`,`p`.`nome` AS `nome`,`p`.`sobrenome` AS `sobrenome` from (((`conta` `c` join `socio` `s` on((`s`.`id` = `c`.`idNumeroSocio`))) join `pessoa` `p` on((`s`.`idPessoa` = `p`.`id`))) left join `taxa` `t` on((`t`.`id` = `c`.`taxaSocio`))) where (`c`.`dataPag` is not null) group by `p`.`id` order by `p`.`nome` */;
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

-- Dump completed on 2013-03-31 22:45:10
