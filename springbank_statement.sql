CREATE DATABASE  IF NOT EXISTS `springbank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `springbank`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: springbank
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `statement`
--

DROP TABLE IF EXISTS `statement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountNo` varchar(255) DEFAULT NULL,
  `dipoBalance` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `totalbalance` int(11) NOT NULL,
  `transectionDate` date DEFAULT NULL,
  `withdrowBalance` int(11) NOT NULL,
  `crAccountNo` varchar(255) DEFAULT NULL,
  `transferAmount` int(11) NOT NULL,
  `crAccount` int(11) NOT NULL,
  `drAccount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statement`
--

LOCK TABLES `statement` WRITE;
/*!40000 ALTER TABLE `statement` DISABLE KEYS */;
INSERT INTO `statement` VALUES (17,'123456',20000,'md nuruzzaman',40000,'2019-11-10',0,'-',0,0,'-'),(18,'123456',0,'md nuruzzaman',10000,'2019-11-10',30000,'-',0,0,'-'),(19,'4515985',10000,'mm jitu',760000,'2019-11-10',0,'-',0,0,'-'),(20,'4515985',0,'mm jitu',700000,'2019-11-10',60000,'-',0,0,'-'),(21,'123456',0,'md nuruzzaman',5000,'2019-11-10',0,'4515985',5000,0,'-'),(22,'4515985',0,'mm jitu',705000,'2019-11-10',0,'-',0,5000,'123456'),(23,'123456',10000,'md nuruzzaman',15000,'2019-11-10',0,'-',0,0,'-'),(24,'123456',0,'md nuruzzaman',12000,'2019-11-10',3000,'-',0,0,'-'),(25,'123456',0,'md nuruzzaman',10000,'2019-11-10',0,'4515985',2000,0,'-'),(26,'4515985',0,'mm jitu',707000,'2019-11-10',0,'-',0,2000,'123456'),(40,'4045554',0,'alim',140000,'2019-11-11',0,'-',0,0,'-'),(41,'6094188',50000,'rabbi',100000,'2019-11-11',0,'-',0,0,'-'),(42,'6094188',0,'rabbi',30000,'2019-11-11',70000,'-',0,0,'-'),(43,'1176687',50000,'munna',800000,'2019-11-11',0,'-',0,0,'-'),(44,'1176687',0,'munna',700000,'2019-11-11',100000,'-',0,0,'-'),(45,'1176687',0,'munna',670000,'2019-11-11',0,'6094188',30000,0,'-'),(46,'6094188',0,'rabbi',60000,'2019-11-11',0,'-',0,30000,'1176687');
/*!40000 ALTER TABLE `statement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-11 21:58:05
