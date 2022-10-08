CREATE DATABASE  IF NOT EXISTS `mireaDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mireaDB`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 194.87.239.99    Database: mireaDB
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

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
-- Table structure for table `add_service`
--

DROP TABLE IF EXISTS `add_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `add_service` (
  `add_service_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `cost` double NOT NULL,
  `description` varchar(500) NOT NULL,
  `internet_size` double NOT NULL,
  `minutes_size` int NOT NULL,
  `sms_size` int NOT NULL,
  PRIMARY KEY (`add_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_service`
--

LOCK TABLES `add_service` WRITE;
/*!40000 ALTER TABLE `add_service` DISABLE KEYS */;
INSERT INTO `add_service` VALUES (1,'Интернет-Mini',595,'Интернет для компьютера по всей России',7,0,0),(2,'Интернет-Maxi',945,'Интернет для компьютера по всей России',15,0,0),(3,'Интернет-VIP',1415,'Интернет для компьютера по всей России',30,0,0),(4,'Пакет 100 SMS',145,'',0,0,100),(5,'Пакет 300 SMS',250,'',0,0,300),(6,'Пакет 100 минут',145,'',0,100,0),(7,'Пакет 300 минут',350,'',0,300,0),(8,'Продли интернет 40 ГБ',500,'',40,0,0),(9,'+50 SMS',30,'',0,0,50),(10,'Продли звонки 200 минут',100,'',0,200,0);
/*!40000 ALTER TABLE `add_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Пополнение счёта'),(2,'Подключение доп. услуги'),(3,'Смена тарифа'),(4,'Отключение доп. услуги'),(5,'Списание со счёта');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `phone_number` varchar(25) NOT NULL,
  `account_state` binary(1) NOT NULL,
  `tariff_id` int NOT NULL,
  PRIMARY KEY (`client_id`),
  KEY `tariff_id` (`tariff_id`),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`tariff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,150,'+79123456789',_binary '1',4),(2,250,'+79241560739',_binary '1',2),(3,300,'+79530405146',_binary '1',2),(4,500,'+79552920133',_binary '1',6),(5,182,'+79266482049',_binary '1',2),(6,753,'+79694369522',_binary '1',1),(7,568,'+79107395688',_binary '1',8),(8,198,'+79447118103',_binary '1',3),(9,665,'+79277617636',_binary '1',4),(10,548,'+79277771985',_binary '1',7);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_add_service`
--

DROP TABLE IF EXISTS `client_add_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_add_service` (
  `client_add_service_id` int NOT NULL AUTO_INCREMENT,
  `add_service` int NOT NULL,
  `client_id` int NOT NULL,
  `finish_date` datetime DEFAULT NULL,
  PRIMARY KEY (`client_add_service_id`),
  KEY `client_id` (`client_id`),
  KEY `add_service` (`add_service`),
  CONSTRAINT `client_add_service_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `client_add_service_ibfk_2` FOREIGN KEY (`add_service`) REFERENCES `add_service` (`add_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_add_service`
--

LOCK TABLES `client_add_service` WRITE;
/*!40000 ALTER TABLE `client_add_service` DISABLE KEYS */;
INSERT INTO `client_add_service` VALUES (1,4,5,'2020-08-24 15:29:00');
/*!40000 ALTER TABLE `client_add_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(128) NOT NULL,
  `login` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Смирнов Дмитрий Семенович','smirnov@admin.ru','ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270'),(2,'Воронцов Юрий Алексеевич','voroncov@admin.ru','77aae185203edc6357676db95caa25d0f398d402c1723e6a7b42cfe8d2967f2e'),(3,'Печин Никита Витальевич','pechin@admin.ru','d3c4642826afa599b04d09579d0623f2557f49f61589948250b920ff6e489a2a');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_storage`
--

DROP TABLE IF EXISTS `file_storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file_storage` (
  `file_storage_id` int NOT NULL AUTO_INCREMENT,
  `report_id` int NOT NULL,
  `client_id` int NOT NULL,
  PRIMARY KEY (`file_storage_id`),
  KEY `report_id` (`report_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `file_storage_ibfk_1` FOREIGN KEY (`report_id`) REFERENCES `report` (`report_id`),
  CONSTRAINT `file_storage_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_storage`
--

LOCK TABLES `file_storage` WRITE;
/*!40000 ALTER TABLE `file_storage` DISABLE KEYS */;
INSERT INTO `file_storage` VALUES (1,1,4),(2,2,1),(3,4,2),(4,3,5);
/*!40000 ALTER TABLE `file_storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_info`
--

DROP TABLE IF EXISTS `personal_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_info` (
  `client_id` int NOT NULL,
  `full_name` varchar(128) NOT NULL,
  `passport_data` varchar(128) NOT NULL,
  `login` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`client_id`),
  CONSTRAINT `personal_info_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_info`
--

LOCK TABLES `personal_info` WRITE;
/*!40000 ALTER TABLE `personal_info` DISABLE KEYS */;
INSERT INTO `personal_info` VALUES (1,'Петров Василий Анатольевич','0000 123456','petrov@mail.ru','11e4acb858f56e032a6ecf04221ba87b12121ae9672126defe0d2e53875a0950'),(2,'Панкратова Анна Максимовна','0000 123558','panam@mail.ru','fa1f9420941a9ebd0d40cedd61d4f2b3448464d9ab8711fa7ea76c26768b84ce'),(3,'Степанов Даниил Даниилович','0000 328967','stepanov@mail.ru','daaad6e5604e8e17bd9f108d91e26afe6281dac8fda0091040a7a6d7bd9b43b5'),(4,'Смирнов Савва Матвеевич','0000 931785','smirnovsm@mail.ru','33c6baccb0e0c567c9c84fe03638379f98d5843bbd2871ebdcc1853ff82bf1f1'),(5,'Яковлев Даниил Фёдорович','0000 987654','yakovlv@mail.ru','9f08d336aeb49e30ba542e1b5742eabc456f25bc1a838fa50fe9fc02c43c42a4'),(6,'Парфенов Григорий Васильевич','0000 264893','parfenov@mail.ru','8b147274ae9775ce8369cfe1ac59aab1a723457784696f444f92765c0bcff9f1'),(7,'Козлова Таисия Максимовна','0000 964872','kozlovatm@mail.ru','5979b227a4cecb37bcb0078292735651037fb86e47e7c22bc4dee73040cd9a46'),(8,'Степанова Евгения Ярославовна','0000 924672','Stepanovae@mail.ru','5100fa20749f33205ab7287ec336f50314273f54d9ff3a89e303bd101331d952'),(9,'Большаков Артемий Владимирович','0000 753987','bolshakov@mail.ru','fc85d3f2a8563a36ae4dd0fbaaff5d72570d8b90c4744ab07cc145442a1cc932'),(10,'Измайлов Кирилл Алексеевич','0000 931207','izmaylov@mail.ru','e922990bc80579c4edbb1077499c2bc17092347d1a3d2854eb50a7284fa1790d');
/*!40000 ALTER TABLE `personal_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `report_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL,
  `finish_date` datetime DEFAULT NULL,
  `result` binary(1) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`report_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `report_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (1,1,'2022-08-10 18:37:00',_binary '1','Пополнение на 500 рублей'),(2,1,'2021-07-02 08:10:00',_binary '1','Пополнение на 150 рублей'),(3,2,'2022-05-08 10:37:00',_binary '1','Подключение доп. услуги 100 SMS'),(4,3,'2022-09-13 15:42:00',_binary '1','Смена тарифа на ULTRA');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariff`
--

DROP TABLE IF EXISTS `tariff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tariff` (
  `tariff_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `cost` double NOT NULL,
  `description` varchar(500) NOT NULL,
  `internet_size` double NOT NULL,
  `minutes_size` int NOT NULL,
  `sms_size` int NOT NULL,
  PRIMARY KEY (`tariff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariff`
--

LOCK TABLES `tariff` WRITE;
/*!40000 ALTER TABLE `tariff` DISABLE KEYS */;
INSERT INTO `tariff` VALUES (1,'Smart',590,'Базовый пакет интернета и минут',5,250,250),(2,'ULTRA',2900,'Много минут и интернета',60,5000,1000),(3,'Тарифище',790,'Звонки на все сети России',30,700,700),(4,'Супер',0,'Для выгодных звонков домашнего региона',0,0,0),(5,'Минимум',550,'Оставайтесь всегда на связи',6,400,0),(6,'Звонки',650,'Оставайтесь всегда на связи',6,800,0),(7,'Интернет',650,'Оставайтесь всегда на связи',20,400,0),(8,'МегаТариф',750,'Оставайтесь всегда на связи',30,800,300),(9,'Максимум',900,'Оставайтесь всегда на связи',50,1200,300),(10,'VIP',1200,'Оставайтесь всегда на связи',50,1700,300);
/*!40000 ALTER TABLE `tariff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mireaDB'
--

--
-- Dumping routines for database 'mireaDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-08 19:03:22
