-- MySQL dump 10.13  Distrib 5.5.30, for Win64 (x86)
--
-- Host: localhost    Database: acal
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
  `taxasId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK271F6B9AA011B865` (`taxasId`),
  CONSTRAINT `taxaid` FOREIGN KEY (`taxasId`) REFERENCES `taxa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriasocio`
--

LOCK TABLES `categoriasocio` WRITE;
/*!40000 ALTER TABLE `categoriasocio` DISABLE KEYS */;
INSERT INTO `categoriasocio` VALUES (5,'Categoria de Socio Fundador','Socio Fundador',19),(6,'Categoria de Socio temporario','socio temporario',19),(7,'socio','categoria',19),(8,'categoria Socio','',19),(9,'bizarro','',19),(10,'teste','qw',19),(12,'descricao de teste','nome de teste',19);
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
INSERT INTO `cheque` VALUES (6,'2013-03-30 00:00:00','2013-03-30 00:00:00',123,'sdss',120.00,1,8),(7,'2013-03-30 00:00:00','2013-03-30 00:00:00',124,NULL,130.00,2,9),(8,'2013-03-30 00:00:00','2013-03-30 00:00:00',125,NULL,13.00,3,10),(9,'2013-04-06 19:15:40','2013-04-06 19:15:40',1,NULL,1.00,1,7),(12,'2013-04-06 19:15:40','2013-04-06 19:15:40',2,'334',356.00,1,8);
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
INSERT INTO `chequeslog` VALUES (1,6,'2013-03-30 00:00:00','2013-03-30 00:00:00','2013-04-01 02:50:14',123,'sdss',120.00,1,NULL,'insert',NULL),(2,7,'2013-03-30 00:00:00','2013-03-30 00:00:00','2013-04-01 02:50:35',124,NULL,130.00,1,NULL,'insert',NULL),(3,8,'2013-03-30 00:00:00','2013-03-30 00:00:00','2013-04-01 02:50:35',125,NULL,13.00,1,NULL,'insert',NULL),(4,9,'2013-04-06 19:15:40','2013-04-06 19:15:40','2013-04-06 19:15:40',1,NULL,1.00,1,NULL,'insert',NULL),(5,10,'2013-04-06 19:15:40','2013-05-06 19:15:40','2013-04-07 11:40:35',2,'1232',500.00,1,NULL,'insert','root@localhost'),(6,10,'2013-04-06 19:15:40','2013-05-06 19:15:40','2013-04-07 11:41:08',2,'1232',500.00,1,NULL,'delete','root@localhost');
/*!40000 ALTER TABLE `chequeslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumo`
--

DROP TABLE IF EXISTS `consumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumo` (
  `idconsumo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idsocio` int(11) NOT NULL,
  `mes` date NOT NULL,
  `consumo` double NOT NULL,
  PRIMARY KEY (`idconsumo`),
  KEY `socio_idx` (`idsocio`),
  CONSTRAINT `socio` FOREIGN KEY (`idsocio`) REFERENCES `socio` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumo`
--

LOCK TABLES `consumo` WRITE;
/*!40000 ALTER TABLE `consumo` DISABLE KEYS */;
INSERT INTO `consumo` VALUES (1,4,'2012-01-01',5000),(2,4,'2012-02-01',4000),(3,4,'2012-03-01',15704),(4,4,'2012-04-01',27000),(5,4,'2012-05-01',0),(6,4,'2012-06-01',0),(12,5,'2012-01-01',4245),(13,5,'2012-02-01',4554),(14,5,'2012-03-01',4555),(15,5,'2012-04-01',4799),(16,5,'2012-05-01',6661),(17,5,'2012-06-01',563);
/*!40000 ALTER TABLE `consumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `dataPag` datetime DEFAULT NULL,
  `dataVence` datetime NOT NULL,
  `observacoes` text,
  `taxaSocio` int(11) NOT NULL,
  `taxaHidrometro` decimal(10,2) DEFAULT '0.00',
  `idNumeroSocio` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5A7376F56F0C6CC` (`idNumeroSocio`),
  KEY `fk_taxaSocio` (`taxaSocio`),
  CONSTRAINT `fk_Socio` FOREIGN KEY (`idNumeroSocio`) REFERENCES `socio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (00000000001,'2013-03-30 00:00:00','2013-03-30 00:00:00',NULL,19,NULL,5),(00000000002,'2013-03-30 00:00:00','2013-03-30 00:00:00',NULL,20,NULL,5),(00000000004,'2013-03-30 00:00:00','2013-03-30 00:00:00',NULL,19,NULL,4),(00000000007,NULL,'2013-03-12 00:00:00',NULL,20,NULL,4),(00000000008,NULL,'2013-03-23 00:00:00',NULL,21,NULL,4),(00000000014,NULL,'2013-02-10 00:00:00',NULL,20,NULL,4),(00000000015,NULL,'2013-01-20 00:00:00',NULL,20,NULL,4),(00000000016,NULL,'2013-03-10 00:00:00',NULL,21,NULL,4),(00000000020,'2013-03-10 00:00:00','2013-03-10 00:00:00',NULL,20,NULL,4),(00000000021,'2013-03-10 00:00:00','2013-03-10 00:00:00',NULL,20,NULL,4),(00000000022,'2013-03-10 00:00:00','2013-03-10 00:00:00',NULL,20,NULL,4);
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
INSERT INTO `contaslog` VALUES (1,1,'2013-03-30 00:00:00','2013-03-30 00:00:00',NULL,4,NULL,5,'2013-04-01 02:52:16','Insert',NULL),(2,2,'2013-03-30 00:00:00','2013-03-30 00:00:00',NULL,5,400.00,5,'2013-04-01 02:52:16','Insert',NULL),(3,4,'2013-03-30 00:00:00','2013-03-30 00:00:00',NULL,4,200.00,4,'2013-04-01 02:53:04','Insert',NULL),(5,7,NULL,'2013-03-30 00:00:00',NULL,5,200.00,4,'2013-04-01 21:06:19','Insert',NULL),(6,8,NULL,'2013-03-30 00:00:00',NULL,5,NULL,4,'2013-04-01 21:06:19','Insert',NULL),(12,14,NULL,'2013-02-10 00:00:00',NULL,5,NULL,4,'2013-04-01 21:08:11','Insert',NULL),(13,15,NULL,'2013-01-20 00:00:00',NULL,5,NULL,4,'2013-04-01 21:08:11','Insert',NULL),(14,16,NULL,'2013-03-10 00:00:00',NULL,5,NULL,4,'2013-04-01 21:08:11','Insert',NULL),(15,17,NULL,'2013-03-10 00:00:00',NULL,1,200.00,4,'2013-04-06 07:27:31','Insert',NULL),(16,17,NULL,'2013-03-10 00:00:00',NULL,1,200.00,4,'2013-04-06 07:31:11','Delete',NULL),(17,20,'2013-03-10 00:00:00','2013-03-10 00:00:00',NULL,20,222.00,4,'2013-04-06 07:33:36','Insert',NULL),(19,22,'2013-03-10 00:00:00','2013-03-10 00:00:00',NULL,20,200.00,4,'2013-04-07 12:11:42','insert','root@localhost'),(20,22,'2013-03-10 00:00:00','2013-03-10 00:00:00',NULL,20,200.00,4,'2013-04-07 12:12:33','delete','root@localhost'),(21,22,'2013-03-10 00:00:00','2013-03-10 00:00:00',NULL,20,0.00,4,'2013-04-08 20:37:06','insert','root@localhost');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (4,'AVENIDA','Fernando Daltro','Rua da posta'),(5,'BECO','Roberio','BECO'),(6,'ESTRADA','Saco',NULL),(7,'RUA','do Morro',NULL),(8,'LADEIRA','feliz',NULL),(9,'RUA','odina','teste swing grafico!'),(10,'AEROPORTO','teste','teste');
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (6,'2013-04-08 00:00:00',NULL,15.00,5,3,2),(9,'2013-12-30 00:00:00',NULL,23.00,4,3,1),(10,'2013-03-01 00:00:00',NULL,50.00,4,3,1),(11,'2013-03-01 00:00:00',NULL,25.00,4,3,1),(12,'2013-03-01 00:00:00',NULL,7.00,4,3,1),(13,'2013-03-01 00:00:00',NULL,500.00,4,1,1),(14,'2013-03-01 00:00:00',NULL,250.00,4,1,1),(15,'2013-03-01 00:00:00',NULL,50.00,4,2,1),(16,'2013-03-01 00:00:00',NULL,50.00,4,2,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradaslog`
--

LOCK TABLES `entradaslog` WRITE;
/*!40000 ALTER TABLE `entradaslog` DISABLE KEYS */;
INSERT INTO `entradaslog` VALUES (1,6,'2012-10-10','2013-04-01 02:55:53',15.00,5,3,2,'insert',NULL,NULL),(2,9,'2012-10-10','2013-04-01 02:56:26',23.00,4,3,1,'insert',NULL,NULL),(3,10,'2013-03-01','2013-04-01 13:16:50',50.00,4,3,1,'insert',NULL,NULL),(4,11,'2013-03-01','2013-04-01 13:17:04',25.00,4,3,1,'insert',NULL,NULL),(5,12,'2013-03-01','2013-04-07 00:36:46',50.00,4,3,1,'insert',NULL,NULL),(6,12,'2013-03-01','2013-04-07 00:37:00',50.00,4,3,1,'delete',NULL,NULL),(7,12,'2013-03-01','2013-04-07 08:53:44',13.00,4,3,1,'insert',NULL,NULL),(8,13,'2013-03-01','2013-04-07 09:40:43',500.00,4,1,1,'insert',NULL,NULL),(9,14,'2013-03-01','2013-04-07 09:40:43',250.00,4,1,1,'insert',NULL,NULL),(10,15,'2013-03-01','2013-04-07 09:41:13',50.00,4,2,1,'insert',NULL,NULL),(11,16,'2013-03-01','2013-04-07 09:41:13',50.00,4,2,1,'insert',NULL,NULL),(12,19,'2013-03-01','2013-04-07 12:19:56',450.00,4,2,1,'insert',NULL,'root@localhost'),(13,20,'2013-03-01','2013-04-07 12:21:07',34.65,4,1,1,'insert',NULL,'root@localhost'),(14,20,'2013-03-01','2013-04-07 12:22:54',34.65,4,1,1,'delete',NULL,'root@localhost'),(15,19,'2013-03-01','2013-04-07 12:22:54',450.00,4,2,1,'delete',NULL,'root@localhost');
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
  KEY `PK_Funcionario` (`idPessoa`),
  CONSTRAINT `FK_FuncionarioPessoa` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Programador','2013-03-30 00:00:00',123,NULL,1500.00,4),(2,'Programador','2013-03-30 00:00:00',124,NULL,1500.00,5),(3,'Encanador','2013-03-30 00:00:00',125,NULL,900.00,6);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hidrometro`
--

DROP TABLE IF EXISTS `hidrometro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hidrometro` (
  `idhidrometro` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idSocio` int(11) NOT NULL,
  `total` decimal(10,2) unsigned DEFAULT NULL,
  `mesAnteriror` double unsigned DEFAULT NULL,
  `mesAtual` double unsigned DEFAULT NULL,
  PRIMARY KEY (`idhidrometro`),
  KEY `idsocio_idx` (`idSocio`),
  CONSTRAINT `idsocio` FOREIGN KEY (`idSocio`) REFERENCES `socio` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hidrometro`
--

LOCK TABLES `hidrometro` WRITE;
/*!40000 ALTER TABLE `hidrometro` DISABLE KEYS */;
INSERT INTO `hidrometro` VALUES (2,4,40.00,5000,100),(3,5,30.00,3000,200);
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
INSERT INTO `motivodespesa` VALUES (7,'Enegia','a',NULL),(8,'peca de carro','b',NULL),(9,'mecanico','c',NULL),(10,'faxina','d',NULL),(11,'compra de lampada','e',NULL),(12,'camara de ar','f',NULL),(13,'gasolina','g',NULL),(14,'MotivoDespesa nome','motivo Despesas descricao','motivo Despesas observacao');
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
INSERT INTO `motivoentrada` VALUES (1,'recebimento de agua','1',NULL),(2,'devolucao do iptu','2',NULL),(3,'camiao de agua','3',NULL);
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
  `categoriaSocio` int(11) NOT NULL,
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
  KEY `FK_PessoaEndereco` (`idEndereco`),
  CONSTRAINT `FK_PessoaEndereco` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (4,'Alexandre','Querioz',1,4,'618','','Alexandreq','lages','44700-000','jacobina','09987885562','1998-01-01 00:00:00','alexandre.jacobina@hotmail.com','Eliege maria','GEraldo alves',123,'Otimo cliente','1999-10-10','ssp-ba','','Masculino','36742310','BA'),(5,'Alisson','Davis',2,5,'123','','alex','licury','41240-012','ourolandia','09987885561','1978-01-01 00:00:00','alisson@teste.com','zenelda','jose',124,'teste de cadastro','1999-10-10','ssp-mg',NULL,'Masculino','36742310','BA'),(6,'Fernando','Lorrand',3,6,'321','','nando','contorno','41240-012','vazea nova','09987885564','1978-01-01 00:00:00','fenando@hotmail.com','teste','teste',125,'teste','1999-10-10','ssp-mg',NULL,'Masculino','34323411','BA');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `rc_cheque`
--

DROP TABLE IF EXISTS `rc_cheque`;
/*!50001 DROP VIEW IF EXISTS `rc_cheque`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_cheque` (
  `id` tinyint NOT NULL,
  `dataPagamento` tinyint NOT NULL,
  `dataVencimento` tinyint NOT NULL,
  `numero` tinyint NOT NULL,
  `valor` tinyint NOT NULL,
  `concat(p.nome,"",p.sobrenome)` tinyint NOT NULL,
  `motivo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rc_consumo`
--

DROP TABLE IF EXISTS `rc_consumo`;
/*!50001 DROP VIEW IF EXISTS `rc_consumo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_consumo` (
  `idconsumo` tinyint NOT NULL,
  `mes` tinyint NOT NULL,
  `consumo` tinyint NOT NULL,
  `numeroSocio` tinyint NOT NULL,
  `nome` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rc_consumocompleto`
--

DROP TABLE IF EXISTS `rc_consumocompleto`;
/*!50001 DROP VIEW IF EXISTS `rc_consumocompleto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_consumocompleto` (
  `idconsumo` tinyint NOT NULL,
  `mes` tinyint NOT NULL,
  `socio` tinyint NOT NULL,
  `categoria` tinyint NOT NULL,
  `valor` tinyint NOT NULL,
  `consumo` tinyint NOT NULL,
  `ltdExcesso` tinyint NOT NULL,
  `valorExecesso` tinyint NOT NULL
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
INSERT INTO `saida` VALUES (1,'2000-10-08 00:00:00','teste de observacao',154.00,'Alexandre',1,7),(2,'2000-10-09 00:00:00','teste de observacao 2',100.00,'coelba',2,8),(3,'2000-11-09 00:00:00',NULL,130.00,'embasa',3,9),(4,'2000-12-09 00:00:00',NULL,10.00,'macacao',1,10),(5,'2013-01-01 00:00:00',NULL,145.00,'feramentas',2,11),(6,'2013-02-01 00:00:00',NULL,12.00,'grafica',3,12),(7,'2013-03-01 00:00:00',NULL,12.00,'anti-virus',1,13),(8,'2013-04-01 00:00:00',NULL,55.00,'computadores',2,14),(9,'2013-05-01 00:00:00',NULL,555.00,'escova de cabelo',3,7),(10,'2013-06-01 00:00:00',NULL,10.02,'dentista',3,8),(11,'2013-07-01 00:00:00',NULL,1799.10,'eleicao',1,7),(12,'2013-08-01 00:00:00',NULL,1800.01,'teste',2,8),(13,'2013-09-01 00:00:00',NULL,130.03,'teste',3,9);
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER SaidaLogInsert after insert ON saida
FOR EACH ROW BEGIN  INSERT INTO
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
INSERT INTO `saidaslog` VALUES (2,9,'2013-03-04','2013-04-07 13:54:21',130.00,'alexandre',1,NULL,'root@localhost',7,'insert','teste de saida'),(3,10,'2013-03-04','2013-04-07 13:54:21',250.00,'Alexandre',1,NULL,'root@localhost',7,'insert','teste saida 2'),(4,9,'2013-03-04','2013-04-07 13:56:56',130.00,'alexandre',1,NULL,'root@localhost',7,'delete','teste de saida'),(5,1,'2000-10-08','2013-04-08 15:00:45',154.00,'Alexandre',1,NULL,'root@localhost',7,'insert','teste de observacao'),(6,2,'2000-10-09','2013-04-08 15:04:17',100.00,'coelba',2,NULL,'root@localhost',8,'insert','teste de observacao 2'),(7,3,'2000-11-09','2013-04-08 15:04:17',130.00,'embasa',3,NULL,'root@localhost',9,'insert',NULL),(8,4,'2000-12-09','2013-04-08 15:04:17',10.00,'macacao',1,NULL,'root@localhost',10,'insert',NULL),(9,5,'2013-01-01','2013-04-08 15:04:17',145.00,'feramentas',2,NULL,'root@localhost',11,'insert',NULL),(10,6,'2013-02-01','2013-04-08 15:04:17',12.00,'grafica',3,NULL,'root@localhost',12,'insert',NULL),(11,7,'2013-03-01','2013-04-08 15:04:17',12.00,'anti-virus',1,NULL,'root@localhost',13,'insert',NULL),(12,8,'2013-04-01','2013-04-08 15:04:17',55.00,'computadores',2,NULL,'root@localhost',14,'insert',NULL),(13,9,'2013-05-01','2013-04-08 15:04:17',555.00,'escova de cabelo',3,NULL,'root@localhost',7,'insert',NULL),(14,10,'2013-06-01','2013-04-08 15:04:17',10.02,'dentista',3,NULL,'root@localhost',8,'insert',NULL),(15,11,'2013-07-01','2013-04-08 15:04:17',1799.10,'eleicao',1,NULL,'root@localhost',7,'insert',NULL),(16,12,'2013-08-01','2013-04-08 15:04:17',1800.01,'teste',2,NULL,'root@localhost',8,'insert',NULL),(17,13,'2013-09-01','2013-04-08 15:04:17',130.03,'teste',3,NULL,'root@localhost',9,'insert',NULL);
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
  KEY `FK68884EDA2F76C89` (`idPessoa`),
  KEY `FK68884ED9B4A2386` (`idCategoriaSocio`),
  CONSTRAINT `FK68884EDA557E577` FOREIGN KEY (`idCategoriaSocio`) REFERENCES `categoriasocio` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK68884EDE2CAEDC0` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (4,'2012-01-01','2012-01-01 00:00:00','2012-01-01 00:00:00',1,NULL,5,4),(5,'2012-01-01','2012-01-01 00:00:00','2012-01-01 00:00:00',2,NULL,5,5);
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxa`
--

LOCK TABLES `taxa` WRITE;
/*!40000 ALTER TABLE `taxa` DISABLE KEYS */;
INSERT INTO `taxa` VALUES (19,'Ligacao de agua','a',NULL,20.00),(20,'Religacao de agua','b',NULL,30.00),(21,'Socio Fundador','c',NULL,15.00),(22,'Socio Temporario','d',NULL,18.00),(23,'Socio Efetivo','3',NULL,15.00),(24,'aSSociao','asda',NULL,4.00),(25,'hidrometro (15 mil ou menos)','taxa ate mil litros',NULL,32.50),(26,'execo de agua (5 litros)',NULL,NULL,0.01);
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxasconta`
--

LOCK TABLES `taxasconta` WRITE;
/*!40000 ALTER TABLE `taxasconta` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxasconta` ENABLE KEYS */;
UNLOCK TABLES;

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
/*!50001 VIEW `rc_cheque` AS select `c`.`id` AS `id`,`c`.`dataPagamento` AS `dataPagamento`,`c`.`dataVencimento` AS `dataVencimento`,`c`.`numero` AS `numero`,`c`.`valor` AS `valor`,concat(`p`.`nome`,'',`p`.`sobrenome`) AS `concat(p.nome,"",p.sobrenome)`,`m`.`nome` AS `motivo` from (((`cheque` `c` join `funcionario` `f` on((`f`.`id` = `c`.`idFuncionario`))) join `pessoa` `p` on((`p`.`id` = `f`.`idPessoa`))) join `motivodespesa` `m` on((`m`.`id` = `c`.`idMotivoDespesa`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rc_consumo`
--

/*!50001 DROP TABLE IF EXISTS `rc_consumo`*/;
/*!50001 DROP VIEW IF EXISTS `rc_consumo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_consumo` AS select `c`.`idconsumo` AS `idconsumo`,`c`.`mes` AS `mes`,`c`.`consumo` AS `consumo`,`c`.`idsocio` AS `numeroSocio`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `nome` from ((`consumo` `c` join `socio` `s` on((`s`.`id` = `c`.`idsocio`))) join `pessoa` `p` on((`p`.`id` = `s`.`idPessoa`))) order by `c`.`mes`,`c`.`idsocio` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rc_consumocompleto`
--

/*!50001 DROP TABLE IF EXISTS `rc_consumocompleto`*/;
/*!50001 DROP VIEW IF EXISTS `rc_consumocompleto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_consumocompleto` AS select `c`.`idconsumo` AS `idconsumo`,`c`.`mes` AS `mes`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `socio`,`cs`.`nome` AS `categoria`,`t`.`valor` AS `valor`,`c`.`consumo` AS `consumo`,if(((`c`.`consumo` - 15000) > 0),(`c`.`consumo` - 15000),0) AS `ltdExcesso`,if(((`c`.`consumo` - 15000) > 0),((`c`.`consumo` - 15000) * 0.002),0) AS `valorExecesso` from ((((`consumo` `c` join `socio` `s` on((`s`.`id` = `c`.`idsocio`))) join `pessoa` `p` on((`p`.`id` = `s`.`idPessoa`))) join `categoriasocio` `cs` on((`cs`.`id` = `s`.`idCategoriaSocio`))) join `taxa` `t` on((`t`.`id` = `cs`.`taxasId`))) order by `c`.`mes`,concat(`p`.`nome`,`p`.`sobrenome`) */;
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
/*!50001 VIEW `rc_entradas` AS select `e`.`id` AS `id`,`e`.`data` AS `data`,`e`.`valor` AS `valor`,`m`.`nome` AS `nome`,concat(`ps`.`nome`,' ',`ps`.`sobrenome`) AS `socio`,concat(`pf`.`nome`,' ',`pf`.`sobrenome`) AS `funcionario` from (((((`entrada` `e` join `socio` `s` on((`s`.`id` = `e`.`idCedente`))) join `funcionario` `f` on((`f`.`id` = `e`.`idFuncionario`))) join `pessoa` `pf` on((`pf`.`id` = `f`.`idPessoa`))) join `pessoa` `ps` on((`ps`.`id` = `s`.`idPessoa`))) join `motivoentrada` `m` on((`m`.`id` = `e`.`idMotivoEntrada`))) order by `e`.`id` */;
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
/*!50001 VIEW `rc_funcionario` AS select `f`.`id` AS `id`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `concat(p.nome," ",p.sobrenome)`,`p`.`cpf` AS `cpf`,`f`.`cargo` AS `cargo`,`f`.`dataContratacao` AS `dataContratacao`,`f`.`matricula` AS `matricula`,`f`.`observacao` AS `observacao`,`f`.`salario` AS `salario` from (`funcionario` `f` join `pessoa` `p` on((`p`.`id` = `f`.`idPessoa`))) */;
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
/*!50001 VIEW `rc_saidas` AS select `s`.`id` AS `id`,`s`.`data` AS `data`,`s`.`observacao` AS `observacao`,`s`.`valor` AS `valor`,`s`.`favorecido` AS `favorecido`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `funcionario`,`m`.`nome` AS `motivo` from (((`saida` `s` join `funcionario` `f` on((`f`.`id` = `s`.`idfuncionario`))) join `pessoa` `p` on((`p`.`id` = `f`.`idPessoa`))) join `motivodespesa` `m` on((`m`.`id` = `s`.`idmotivosaida`))) order by `s`.`id` */;
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
/*!50001 VIEW `rc_socio` AS select `s`.`id` AS `regristo`,`s`.`numeroSocio` AS `numeroSocio`,`s`.`dataMatricula` AS `dataMatricula`,`s`.`dataAprovacao` AS `dataAprovacao`,`s`.`observacao` AS `observacao`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `nome`,`cat`.`nome` AS `categoria` from ((`socio` `s` join `pessoa` `p` on((`p`.`id` = `s`.`idPessoa`))) join `categoriasocio` `cat` on((`cat`.`id` = `s`.`idCategoriaSocio`))) */;
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

-- Dump completed on 2013-04-25 18:12:56
