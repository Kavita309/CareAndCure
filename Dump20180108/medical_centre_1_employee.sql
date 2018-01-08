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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `e_id` decimal(10,0) NOT NULL,
  `e_name` varchar(20) NOT NULL,
  `e_sex` varchar(10) NOT NULL,
  `e_DOB` date NOT NULL,
  `e_salary` decimal(7,2) NOT NULL,
  `e_experience` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (101,'SHAILESH MISHRA','MALE','1987-02-02',67000.00,'5 YEARS'),(102,'MEENA KUMARI','FEMALE','1982-02-04',69000.00,'3 YEARS'),(103,'PRIYA YADAV','FEMALE','1983-05-06',40000.00,'1 YEAR'),(104,'ISHAN AHLAWAT','MALE','1985-12-11',77000.00,'10 YEARS'),(105,'SHAILENDRA SHAH','MALE','1990-07-10',30000.00,'2 YEARS'),(106,'LAKSHITA DUGGAL','FEMALE','1987-07-07',56000.00,'2.5 YEARS'),(107,'RAMESH KUMAR SHAH','MALE','1987-02-05',64000.00,'5.6 YEARS'),(108,'SHAILESH MISHRA','MALE','1986-02-01',64000.00,'5.2 YEARS'),(109,'RIYA JAIN','FEMALE','1985-01-01',67000.00,'3 YEARS'),(110,'PARAMVEER SINGH','MALE','1991-11-11',68000.00,'7 YEARS'),(111,'REETA KHURANA','FEMALE','1992-02-12',63000.00,'8 YEARS'),(112,'HEERA AGGARWAL','MALE','1989-10-02',66000.00,'7.8 YEARS'),(113,'REEMA SETHI','FEMALE','1988-10-09',73000.00,'6 YEARS'),(114,'JAY GUPTA','MALE','1990-03-02',78000.00,'5.6 YEARS'),(115,'PRAKRITI BANSAL','FEMALE','1987-04-07',71000.00,'4 YEARS'),(116,'ANJALI AGARWAL','FEMALE','1989-12-08',45000.00,'9 YEARS'),(117,'ANUPAM SEN','MALE','1982-09-12',76000.00,'8.3 YEARS'),(118,'R.K MISHRA','MALE','1983-02-03',56000.00,'4 YEARS'),(119,'KRITI KHARBANDA','FEMALE','1983-10-02',88000.00,'1.3 YEARS'),(120,'RIYA AHLUWALIA','FEMALE','1985-12-02',67000.00,'4.3 YEARS'),(121,'SHRUTI BATRA','FEMALE','1987-02-06',40000.00,'5.2 YEARS'),(122,'REKHA VERMA','FEMALE','1986-08-07',90000.00,'5 YEARS'),(123,'AMIT TRIVEDI','MALE','1984-09-09',67000.00,'1 YEAR'),(124,'DEEPSHIKHAR KHATRI','MALE','1987-11-11',34000.00,'0.5 YEARS'),(125,'PIYUSH WADHWA','MALE','1988-06-05',65000.00,'0.3 YEARS'),(126,'SHREYA MITTAL','FEMALE','1989-02-11',68000.00,'7 YEARS'),(127,'AKANKSHA JAIN','FEMALE','1989-12-12',67000.00,'2 YEARS'),(128,'RIYA JAIN','FEMALE','1990-02-10',62000.00,'1 YEAR'),(129,'V.P GUPTA','MALE','1991-03-02',44000.00,'7 YEARS'),(130,'PRIYANSHU BATRA','MALE','1986-05-05',77000.00,'5 YEARS');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger emp_sal_check before insert on employee
for each row
 begin
 if new.e_salary<30000 then
signal sqlstate '45001' set message_text="MINIMUM SALARY IS 30000! MISTAKE!";
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-08 17:21:53
