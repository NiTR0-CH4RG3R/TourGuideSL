-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: tourguide
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `tourguide`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `tourguide` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `tourguide`;

--
-- Table structure for table `accomodations`
--

DROP TABLE IF EXISTS `accomodations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accomodations` (
  `a_id` int NOT NULL AUTO_INCREMENT,
  `a_client_id` int NOT NULL,
  `a_check_in` datetime NOT NULL,
  `a_check_out` datetime NOT NULL,
  PRIMARY KEY (`a_id`),
  KEY `a_client_id` (`a_client_id`),
  CONSTRAINT `accomodations_ibfk_1` FOREIGN KEY (`a_client_id`) REFERENCES `clients` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accomodations`
--

LOCK TABLES `accomodations` WRITE;
/*!40000 ALTER TABLE `accomodations` DISABLE KEYS */;
INSERT INTO `accomodations` VALUES (5,6,'2023-05-29 12:00:00','2023-05-30 12:00:00'),(6,6,'2023-05-29 12:00:00','2023-05-30 12:00:00'),(7,6,'2023-05-29 12:00:00','2023-05-30 12:00:00');
/*!40000 ALTER TABLE `accomodations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ciNOT NULL,
  `c_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ciNOT NULL,
  `c_country` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ciDEFAULT NULL,
  `c_contact` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ciNOT NULL,
  `c_age` int NOT NULL,
  `c_gender` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ciNOT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_email` (`c_email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (6,'Buddhima Zoysa','buddhimakaveeshwara@gmail.com','Sri Lanka','0759758857',25,'MALE');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drivers` (
  `d_id` int NOT NULL AUTO_INCREMENT,
  `d_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `d_driving_license` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `d_national_id` varchar(12) COLLATE utf8mb4_general_ci NOT NULL,
  `d_contact` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivers`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` VALUES (1,'Malindu Zoysa','LOL1','1234567890V','0759758857');
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `l_id` int NOT NULL AUTO_INCREMENT,
  `l_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `l_address` varchar(250) COLLATE utf8mb4_general_ci NOT NULL,
  `l_description` text COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'MY HOME','LOL! My home address','It\'s my home you fucking idiot');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travels`
--

DROP TABLE IF EXISTS `travels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travels` (
  `t_id` int NOT NULL AUTO_INCREMENT,
  `t_c_id` int NOT NULL,
  `t_l_id` int NOT NULL,
  `t_v_id` int NOT NULL,
  `t_d_id` int NOT NULL,
  `t_passenger_count` int NOT NULL,
  `t_departure_time` datetime NOT NULL,
  PRIMARY KEY (`t_id`),
  KEY `t_c_id` (`t_c_id`),
  KEY `t_l_id` (`t_l_id`),
  KEY `t_v_id` (`t_v_id`),
  KEY `t_d_id` (`t_d_id`),
  CONSTRAINT `travels_ibfk_1` FOREIGN KEY (`t_c_id`) REFERENCES `clients` (`c_id`),
  CONSTRAINT `travels_ibfk_2` FOREIGN KEY (`t_l_id`) REFERENCES `locations` (`l_id`),
  CONSTRAINT `travels_ibfk_3` FOREIGN KEY (`t_v_id`) REFERENCES `vehicles` (`v_id`),
  CONSTRAINT `travels_ibfk_4` FOREIGN KEY (`t_d_id`) REFERENCES `drivers` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travels`
--

LOCK TABLES `travels` WRITE;
/*!40000 ALTER TABLE `travels` DISABLE KEYS */;
INSERT INTO `travels` VALUES (1,6,1,1,1,3,'2023-05-08 12:00:00'),(3,6,1,1,1,3,'2023-05-08 12:00:00'),(4,6,1,1,1,3,'2023-05-08 12:00:00');
/*!40000 ALTER TABLE `travels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `u_username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ciNOT NULL,
  `u_password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ciNOT NULL,
  PRIMARY KEY (`u_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles` (
  `v_id` int NOT NULL AUTO_INCREMENT,
  `v_type` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `v_license_plate` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `v_passenger_count` int NOT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (1,'CAR','LOL-1234',5);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26  1:08:54
