CREATE DATABASE  IF NOT EXISTS `heroku_dd9ca97e9e588ce` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `heroku_dd9ca97e9e588ce`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: eu-cdbr-west-01.cleardb.com    Database: heroku_dd9ca97e9e588ce
-- ------------------------------------------------------
-- Server version	5.6.50-log

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
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) NOT NULL,
  `project_description` varchar(1000) NOT NULL,
  `project_hours` int(11) DEFAULT NULL,
  `project_price` int(11) DEFAULT NULL,
  `subproject_price` int(11) DEFAULT NULL,
  `subproject_total_hours` int(11) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  UNIQUE KEY `project_id_UNIQUE` (`project_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `subproject_price` (`subproject_price`),
  KEY `subproject_total_hours` (`subproject_total_hours`),
  CONSTRAINT `subproject_price` FOREIGN KEY (`subproject_price`) REFERENCES `subprojects` (`subproject_price`),
  CONSTRAINT `subproject_total_hours` FOREIGN KEY (`subproject_total_hours`) REFERENCES `subprojects` (`subproject_total_hours`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12635 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (5,5,'test','online test',NULL,NULL,NULL,NULL),(5,15,'test22','online test lørdag2',NULL,NULL,NULL,NULL),(100,100,'prjNameTest','prjDescTest',0,0,NULL,NULL),(5,105,'test','test2',NULL,NULL,NULL,NULL),(5,135,'test 30','test d. 30/11 kl 14',NULL,NULL,NULL,NULL),(5,145,'testssss','test kl 14:01',NULL,NULL,NULL,NULL),(5,155,'','erkerjklerjlre erjerlk',NULL,NULL,NULL,NULL),(165,165,'Highhoures','bøh',NULL,NULL,NULL,NULL),(5,175,'test','test d 2/12 kl 15',NULL,NULL,NULL,NULL),(1,195,'jenstest2','create-project2',NULL,NULL,NULL,NULL),(1,205,'jenstest3','create-project3',NULL,NULL,NULL,NULL),(1,215,'jenstest4','create-project',NULL,NULL,NULL,NULL),(1,225,'jenstest HTTP','Http',NULL,NULL,NULL,NULL),(1,235,'jenstest HTTP2','jenstest HTTP2',NULL,NULL,NULL,NULL),(5,245,'test','6/12',NULL,NULL,NULL,NULL),(5,275,'ikke-5 test','vil gerne se om vi kan få et projektid der ikke går op i 5',NULL,NULL,NULL,NULL),(5,285,'ikke-5 test2','vil gerne se om vi kan få et projektid der ikke går op i 5 test 2',NULL,NULL,NULL,NULL),(5,295,'required field','der er navn i name feltet',NULL,NULL,NULL,NULL),(855,305,'kk','kk',NULL,NULL,NULL,NULL),(165,315,'k','ø',NULL,NULL,NULL,NULL),(165,325,'ddghfhf','ddhdhdh',NULL,NULL,NULL,NULL),(1,12355,'ds','sd',NULL,NULL,NULL,NULL),(1,12365,'dflml','ædfl',NULL,NULL,NULL,NULL),(1,12375,'dfkk','kdfk',NULL,NULL,NULL,NULL),(1,12385,'kk','kkkk',NULL,NULL,NULL,NULL),(155,12395,'bgddfgb','fdbgdfbg',NULL,NULL,NULL,NULL),(155,12405,'fdbgfdbg','fdbgdfgbdf',NULL,NULL,NULL,NULL),(5,12415,'billigt projekt','til 500 kr. test af prisen',NULL,NULL,NULL,NULL),(145,12435,'1','1',NULL,NULL,NULL,NULL),(145,12445,'2','2',NULL,NULL,NULL,NULL),(145,12455,'sub2','sub1',NULL,NULL,NULL,NULL),(145,12465,'3','3',NULL,NULL,NULL,NULL),(5,12475,'test','test af om den første create metode skal bruges',NULL,NULL,NULL,NULL),(1,12485,'kork','fd',NULL,NULL,NULL,NULL),(1805,12495,'test','hejsa',NULL,NULL,NULL,NULL),(1805,12505,'Jakobs','Øvelse',NULL,NULL,NULL,NULL),(3385,12515,'Spongo','Jeg skal bede om nogle heste og en hjort til en stald',NULL,NULL,NULL,NULL),(3395,12525,'vask tøj','der skal vaskes tøj...',NULL,NULL,NULL,NULL),(3395,12535,'sdtfs','sfdf',NULL,NULL,NULL,NULL),(3395,12545,'asd','asd',NULL,NULL,NULL,NULL),(3395,12555,'dgf','dfg',NULL,NULL,NULL,NULL),(1,12565,'g','df',NULL,NULL,NULL,NULL),(4905,12575,'fine wine','you can get damn good wine ',NULL,NULL,NULL,NULL),(4905,12585,'fine øl','øl',NULL,NULL,NULL,NULL),(1805,12595,'Rigtig Prjekt','Øvelse 123',NULL,NULL,NULL,NULL),(1,12605,'jens 11','jens',NULL,NULL,NULL,NULL),(1,12615,'gg','gg',NULL,NULL,NULL,NULL),(1,12625,'Hej','Hej',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subprojects`
--

DROP TABLE IF EXISTS `subprojects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subprojects` (
  `subproject_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `subproject_name` varchar(100) NOT NULL,
  `subproject_description` varchar(1000) DEFAULT NULL,
  `subproject_seniordeveloper_hours` int(11) DEFAULT NULL,
  `subproject_developer_hours` int(11) DEFAULT NULL,
  `subproject_graphic_hours` int(11) DEFAULT NULL,
  `subproject_price` int(11) DEFAULT NULL,
  `subproject_total_hours` int(11) DEFAULT NULL,
  PRIMARY KEY (`subproject_id`),
  KEY `project_id_idx` (`project_id`),
  KEY `subproject_price_idx` (`subproject_price`),
  KEY `subproject_total_hours` (`subproject_total_hours`),
  KEY `subproject_price` (`subproject_price`),
  CONSTRAINT `project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1475 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subprojects`
--

LOCK TABLES `subprojects` WRITE;
/*!40000 ALTER TABLE `subprojects` DISABLE KEYS */;
INSERT INTO `subprojects` VALUES (1,100,'jens','jens',55,5,5,100,0),(45,165,'geg','geg',0,0,0,NULL,NULL),(55,165,'wrg','wg',0,0,0,NULL,NULL),(65,165,'ebe','ebb',0,0,0,NULL,NULL),(75,165,'rttttt','tttttt',0,0,0,NULL,NULL),(95,165,'alex','hej',20,30,40,NULL,NULL),(105,165,'dgh','hdh',2,1,1,NULL,NULL),(115,165,'rth','hr',1,0,1,NULL,NULL),(125,165,'fbdb','dbbd',1,0,1,NULL,NULL),(145,165,'sf','sf',1,0,1,NULL,NULL),(155,165,'alex2½','egeg',2,0,2,NULL,NULL),(165,165,'alex3½','svsv',1,0,1,NULL,NULL),(175,165,'rtjtrj','hrhr',2,0,0,NULL,NULL),(195,165,'dnbn','dndn',0,0,1,NULL,NULL),(205,245,'subtest','6/12',2,2,2,NULL,NULL),(225,165,'ole','hest',5,5,5,NULL,NULL),(235,165,'fgggggg','ggggggg',1,1,1,NULL,NULL),(245,165,'tttttttttttttttttt','tttttttttttttttttt',0,1,1,1250,2),(255,165,'hhhhhhhhhhhhh','hhhhhhhhhhhhhhhh',10,10,10,27500,30),(265,305,'kk','kk',52,52,52,NULL,NULL),(275,5,'test','d. 7/12 kl 00:14 --> 00:49',2,2,2,5500,0),(285,5,'edit test','7/12 kl 00:45 EDIT kl 00:51',4,2,2,5500,0),(295,5,'aaaaaaaaaaaaaa','OwO -->09:56',4,2,2,5500,0),(305,165,'jens&alex','alex&jens',1,1,1,2750,0),(315,165,'jens&alex','a',0,0,0,0,0),(325,165,'j','',0,0,0,0,0),(335,165,'jens&alex','s',0,0,0,0,0),(345,165,'jens&alex','alex&jens',1,1,1,2750,3),(355,165,'w','w',1,0,0,1500,1),(365,165,'hhhhhh','hhhhhh',1,1,1,2750,3),(375,165,'ww','ww',1,1,1,2750,3),(385,165,'w','w',0,0,1,500,0),(395,165,'BEGGE metor','BEGGE metor',1,1,0,2250,3),(405,165,'gg','gg',1,1,1,2750,3),(415,165,'dd','dd',1,1,0,2250,3),(425,165,'ff','ff',1,1,0,2250,3),(435,165,'qq','qq',1,1,0,2250,3),(445,165,'hh','hh',1,1,0,2250,2),(455,165,'++','++',1,1,0,2250,2),(465,165,'==','==',1,1,0,2250,2),(475,165,'jens','jens',1,1,0,2250,0),(485,165,'alex','alex',1,1,0,2250,2),(495,165,'aa','aa',1,1,0,2250,2),(505,165,'ll','ll',1,0,1,2000,2),(515,165,'jkj','jkj',0,1,0,750,1),(525,165,'jkk','jkk',1,1,0,2250,2),(535,165,'ds','ds',0,1,1,1250,2),(545,165,'kk','llklklkl',1,1,1,2750,3),(555,165,'ds','sd',0,0,2,1000,2),(565,165,'jjjjjjjjjjjjjjjjjjjjjjjjjjj','jjjjjjjjjjjjjjjjjjjjjjjjjjjj',1,1,1,2750,3),(575,105,'asd','asd',2,2,2,5500,6),(645,12385,'alex','alex',1,1,1,2750,3),(745,165,'alex','alex',1,1,1,2750,3),(915,5,'test','d 9/12 kl 13',2,2,2,5500,6),(935,5,'test','d 9/12 kl 14:30',2,2,2,5500,6),(945,5,'test3','d 9/12 kl 14:39',2,2,2,5500,6),(965,235,'jens','jens',1,1,1,2750,3),(1035,12415,'billig test sub','billig',0,0,1,500,1),(1045,12435,'sub1','sub1',0,0,1,500,1),(1055,12445,'sub2','sub2',0,0,1,500,1),(1065,12435,'sub2','sub2 i pro1',0,0,1,500,1),(1075,12465,'3','3',0,0,1,500,1),(1085,5,'billig','billig',0,0,1,500,1),(1095,5,'erer','',0,0,0,0,0),(1165,12485,'fldkl','mfld',5,5,5,13750,15),(1175,12485,'dfknndfk','kfdkn',55,55,8,127750,118),(1185,12365,'lmgl','mg',8,8,8,22000,24),(1195,12495,'hejsa','des',5,7,5,15250,17),(1205,12495,'grfg','obpbi',3,5,4,10250,12),(1215,12515,'Stald','med hest',10,10,10,27500,30),(1225,12525,'noget','...',2,4,3,7500,9),(1245,12575,'ØL','you can also get damn good ØL',2,2,2,5500,6),(1265,195,'rg','fd',5,5,5,13750,15),(1275,12595,'Test','123',10,5,11,24250,26),(1285,195,'jjjjjj','jjjjjjjjjjjjjjjjj',1,2,1,3500,8),(1295,195,'df','fddf',1,1,1,2750,3),(1315,12605,'jens 11','jens 11',1,5,2,6250,8),(1325,12605,'jens 12','jens',1,2,1,0,0),(1335,12605,'jens 13','jens',4,4,4,11000,12),(1355,195,'kkkkkkkkkkkkkkkkkk','kkkkkkkkkkkkkkkk',10,10,10,27500,30),(1375,12615,'gg1','gg1',1,1,1,2750,3),(1385,205,'hg','fg',1,1,1,2750,3),(1395,205,'jgj','gdg',1,1,1,2750,3),(1405,12625,'hejsub','hejsub',10,10,10,27500,30),(1415,195,'qqq','qqq',12,12,12,33000,36),(1425,195,'ÆÆ','ÆÆ',8,8,8,22000,24);
/*!40000 ALTER TABLE `subprojects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `user_email_UNIQUE` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=7035 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'jens@jens.dk','1234','JensBIG'),(5,'silkemailtest','silke','silke'),(100,'Test@test.dk','test1234','userNameTest'),(105,'test','test','test'),(125,'silketest','x','silketest'),(145,'x','x','x'),(155,'spongo@gmail.com','spongo','spongo'),(165,'alex1005','1005','alex'),(175,'testUser02-12-2021 kl:15:20','1234','testUser02-12-2021 kl:15:20'),(185,'@testUser04-12-2021 kl:20:38','1234','testUser04-12-2021 kl:20:38'),(195,'@testUserNyCreteUser04-12-2021 kl:21:21','1234','testUserNyCreteUser04-12-2021 kl:21:21'),(205,'dsd','56','sd'),(215,'jene','122','jens'),(325,'kjkk','4544','hjhjh'),(855,'kk','kk','kk'),(1805,'jakob@gmail.com','12345','jakobm'),(3375,'asdasd@gmail.com','123123123','olololol'),(3385,'oliver_bp99@hotmail.com','123123','asdas'),(3395,'hoolfelt@gmail.com','Lamaviho21','paragon'),(4905,'janechkryger@gmail.com','Janech123','Jackthesnack'),(7005,'EmailAlreadyExisting@AlphaSolutions.dk','1234','Yes Test'),(7015,'validateUser@AlphaSolutions.dk','1234','Yes Test');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-13  9:52:03
