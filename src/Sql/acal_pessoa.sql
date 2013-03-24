CREATE DATABASE  IF NOT EXISTS `acal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `acal`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
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
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `Sobrenome` varchar(100) NOT NULL,
  `Apelido` varchar(40) DEFAULT NULL,
  `Id_Endereco` int(11) NOT NULL,
  `Numero` int(11) DEFAULT NULL,
  `Bairro` varchar(100) DEFAULT NULL,
  `Cidade` varchar(50) DEFAULT NULL,
  `Uf` varchar(10) DEFAULT NULL,
  `Cep` varchar(50) DEFAULT NULL,
  `Telefone` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Data_nasc` datetime DEFAULT NULL,
  `Sexo` enum('masculino','feminino') DEFAULT NULL,
  `Cpf` int(11) DEFAULT NULL,
  `Rg_numero` int(11) DEFAULT NULL,
  `Rg_expedidor` varchar(10) DEFAULT NULL,
  `Rg_emissao` date DEFAULT NULL,
  `Nome_mae` varchar(100) DEFAULT NULL,
  `Nome_pai` varchar(100) DEFAULT NULL,
  `Numero_matricula` int(11) DEFAULT NULL,
  `Status` tinyint(1) NOT NULL DEFAULT '0',
  `Categoria_socio` int(11) DEFAULT NULL,
  `Observacoes` text,
  PRIMARY KEY (`Id`),
  KEY `Id_Endereco` (`Id_Endereco`),
  CONSTRAINT `pessoa_ibfk_1` FOREIGN KEY (`Id_Endereco`) REFERENCES `enderecos` (`Id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Alexandre','Queiroz','alexandre',1,1,'centro','lages','ba','4125000','','Alexandre.jacobina@hotmail.com','1985-03-19 00:00:00','masculino',0,0,'','0000-00-00','','',0,0,0,'');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-23 19:09:03
