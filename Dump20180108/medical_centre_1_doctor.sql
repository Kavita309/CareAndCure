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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `d_id` decimal(10,0) NOT NULL,
  `d_type` varchar(20) NOT NULL,
  `d_day` varchar(20) NOT NULL,
  `d_time` time NOT NULL,
  `speciality` varchar(20) NOT NULL,
  `degree` varchar(20) NOT NULL,
  PRIMARY KEY (`d_id`),
  CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`d_id`) REFERENCES `employee` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (102,'VISITING','MON,TUES,WED','11:00:00','ENT','MBBS'),(104,'PERMANENT','MON,THURS,SAT','16:00:00','LUNG','MD'),(105,'PERMANENT','TUES,WED,THURS','16:00:00','LUNG','PHD'),(106,'VISITING','MON,TUES,WED','08:00:00','DERMATOLOGIST','MCM'),(108,'TRAINEE','MON,WED,THURS','08:00:00','ALLERGIST','MBBS'),(110,'TRAINEE','MON,TUES,WED','09:00:00','CARDIOLOGIST','DCM'),(112,'VISITING','MON,TUES,FRI','01:00:00','PSYCHIATRIST','MD'),(114,'PERMANENT','MON,TUES,SAT','01:00:00','GYNECOLOGIST','PHD'),(115,'VISITING','WED,THURS,FRI','03:00:00','NEUROLOGIST','PHD'),(116,'PERMANENT','MON,TUES,FRI','04:00:00','ENT','MCM'),(117,'TRAINEE','MON,WED,SAT','08:00:00','ONCOLOGIST','MD'),(120,'PERMANENT','TUES,FRI,SAT','08:00:00','ENT','MBBS'),(123,'VISITING','MON,TUES,WED','16:00:00','LUNG','MBBS'),(125,'VISITING','MON,TUES,THURS','16:00:00','ALLERGIST','MCM'),(128,'TRAINEE','MON,TUES,SAT','17:00:00','ALLERGIST','PHD'),(129,'VISITING','MON,FRI,SAT','17:00:00','DERMATOLOGIST','MBBS');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
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
