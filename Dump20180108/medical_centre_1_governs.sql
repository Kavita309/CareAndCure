CREATE DATABASE  IF NOT EXISTS `medical_centre_1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `medical_centre_1`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: medical_centre_1
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `governs`
--

DROP TABLE IF EXISTS `governs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `governs` (
  `n_id` decimal(10,0) NOT NULL,
  `r_id` decimal(10,0) NOT NULL,
  `start_date` date NOT NULL,
  PRIMARY KEY (`n_id`,`r_id`),
  UNIQUE KEY `n_id` (`n_id`,`r_id`),
  KEY `r_id` (`r_id`),
  CONSTRAINT `governs_ibfk_1` FOREIGN KEY (`n_id`) REFERENCES `nurse` (`n_id`),
  CONSTRAINT `governs_ibfk_2` FOREIGN KEY (`r_id`) REFERENCES `room` (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `governs`
--

LOCK TABLES `governs` WRITE;
/*!40000 ALTER TABLE `governs` DISABLE KEYS */;
INSERT INTO `governs` VALUES (101,302,'2015-02-03'),(103,301,'2015-02-03'),(109,303,'2015-02-03'),(109,305,'2015-02-03'),(113,303,'2015-02-03'),(113,304,'2015-02-03'),(121,306,'2015-02-03'),(121,307,'2015-02-03'),(122,301,'2015-02-03'),(122,308,'2015-02-03'),(127,307,'2015-02-03');
/*!40000 ALTER TABLE `governs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-08 17:21:53
