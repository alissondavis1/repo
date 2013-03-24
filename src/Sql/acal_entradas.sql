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
-- Table structure for table `entradas`
--

DROP TABLE IF EXISTS `entradas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entradas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` float NOT NULL,
  `data` date NOT NULL,
  `id_motivo` int(11) NOT NULL,
  `id_cedente` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `observacao` text,
  PRIMARY KEY (`id`),
  KEY `Id_motivo` (`id_motivo`),
  KEY `Id_cedente` (`id_cedente`),
  KEY `Id_funcionario` (`id_funcionario`),
  CONSTRAINT `entradas_ibfk_12` FOREIGN KEY (`id_motivo`) REFERENCES `motivoentradas` (`Id`) ON UPDATE CASCADE,
  CONSTRAINT `entradas_ibfk_13` FOREIGN KEY (`id_cedente`) REFERENCES `socio` (`Id`) ON UPDATE CASCADE,
  CONSTRAINT `entradas_ibfk_14` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`Id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradas`
--

LOCK TABLES `entradas` WRITE;
/*!40000 ALTER TABLE `entradas` DISABLE KEYS */;
INSERT INTO `entradas` VALUES (1,300,'2013-03-19',1,4,1,''),(2,10,'2013-03-05',3,4,1,''),(3,25,'2013-03-01',5,4,1,''),(4,35,'2013-03-03',1,4,1,''),(5,40,'2013-03-03',2,4,1,'1');
/*!40000 ALTER TABLE `entradas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-23 19:08:57
