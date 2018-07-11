-- MySQL dump 10.13  Distrib 5.7.16, for osx10.12 (x86_64)
--
-- Host: localhost    Database: lostandfound
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `UsersAdmin`
--

DROP TABLE IF EXISTS `UsersAdmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UsersAdmin` (
  `websiteId` int(11) NOT NULL AUTO_INCREMENT,
  `websiteLogo` varchar(50) DEFAULT NULL,
  `websiteName` varchar(40) DEFAULT NULL,
  `websiteDescription` text,
  `websiteRange` varchar(20) DEFAULT NULL,
  `websiteAdmin` varchar(20) DEFAULT NULL,
  `websiteContact` int(11) DEFAULT NULL,
  `websiteAddress` text,
  `websiteCreateTime` datetime DEFAULT NULL,
  `websiteAdminUsername` varchar(30) DEFAULT NULL,
  `websiteAdminPassword` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`websiteId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UsersAdmin`
--

LOCK TABLES `UsersAdmin` WRITE;
/*!40000 ALTER TABLE `UsersAdmin` DISABLE KEYS */;
INSERT INTO `UsersAdmin` VALUES (1,NULL,'长沙民政','最好的',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `UsersAdmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT,
  `articleName` varchar(10) DEFAULT NULL,
  `articleDescription` text,
  `articleClassify` varchar(10) DEFAULT NULL,
  `articleLocal` varchar(30) DEFAULT NULL,
  `articleContact` varchar(13) DEFAULT NULL,
  `articleAddress` varchar(30) DEFAULT NULL,
  `articleFlag` int(1) DEFAULT '0',
  `articleWebsite` int(20) DEFAULT '0',
  `articleTime` datetime DEFAULT NULL,
  `articleImage` varchar(40) DEFAULT '/img/article/defualt.png',
  PRIMARY KEY (`articleId`),
  KEY `articlewebsite_fk_websiteid` (`articleWebsite`),
  CONSTRAINT `articlewebsite_fk_websiteid` FOREIGN KEY (`articleWebsite`) REFERENCES `UsersAdmin` (`websiteId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='所有物品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (4,'伞','一把红色的折叠伞',NULL,'12栋504','9738322','3区2栋604',0,1,'2018-07-11 01:37:10','/img/article/kk.png'),(5,'包','真皮的钱包，里面还有一些钱。证件上显示是彭伟的',NULL,'校门那个地方','1822973842','德新苑',0,1,NULL,'/img/article/kk.png'),(6,'校园卡','软开1633彭伟','NULL','3区超市','1822973842','德新苑',0,1,'2012-02-03 00:00:00','/img/article/kk.png'),(7,NULL,'好的',NULL,'3栋508','18229738322','北方古',0,1,NULL,'/img/article/defualt.png'),(8,NULL,'haode1ba',NULL,'3栋508','18229738322','北方古',0,1,NULL,'/img/article/defualt.png');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-11 10:37:38
