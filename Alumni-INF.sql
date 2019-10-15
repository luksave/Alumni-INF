-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: dbAlumniINF
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `Activities`
--

DROP TABLE IF EXISTS `Activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Activities` (
  `idOpportunity` int(11) NOT NULL,
  `description` varchar(300) NOT NULL,
  PRIMARY KEY (`idOpportunity`),
  CONSTRAINT `fk_Activities_1` FOREIGN KEY (`idOpportunity`) REFERENCES `jobOpportunity` (`idJobOpportunity`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Activities`
--

LOCK TABLES `Activities` WRITE;
/*!40000 ALTER TABLE `Activities` DISABLE KEYS */;
/*!40000 ALTER TABLE `Activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Alumnus`
--

DROP TABLE IF EXISTS `Alumnus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumnus` (
  `idUser` int(11) NOT NULL,
  `birthDate` date NOT NULL,
  `CPF` int(11) NOT NULL,
  `activeAcc` tinyint(1) NOT NULL,
  `registration` int(11) NOT NULL,
  PRIMARY KEY (`idUser`,`registration`),
  CONSTRAINT `idUser` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alumnus`
--

LOCK TABLES `Alumnus` WRITE;
/*!40000 ALTER TABLE `Alumnus` DISABLE KEYS */;
/*!40000 ALTER TABLE `Alumnus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Coordinator`
--

DROP TABLE IF EXISTS `Coordinator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Coordinator` (
  `idCoordinator` int(11) NOT NULL,
  `beginningDate` date NOT NULL,
  `endingDate` date NOT NULL,
  `nameCoordinator` varchar(150) NOT NULL,
  `level` varchar(45) NOT NULL,
  PRIMARY KEY (`idCoordinator`),
  CONSTRAINT `fk_Coordinator_1` FOREIGN KEY (`idCoordinator`) REFERENCES `Professor` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Coordinator`
--

LOCK TABLES `Coordinator` WRITE;
/*!40000 ALTER TABLE `Coordinator` DISABLE KEYS */;
/*!40000 ALTER TABLE `Coordinator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Course` (
  `idCourse` int(11) NOT NULL,
  `nameCourse` varchar(45) NOT NULL,
  `actualCoordinator` varchar(150) NOT NULL,
  PRIMARY KEY (`idCourse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CurricularComponent`
--

DROP TABLE IF EXISTS `CurricularComponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CurricularComponent` (
  `idCourse` int(11) NOT NULL,
  `nameComponent` varchar(45) NOT NULL,
  PRIMARY KEY (`idCourse`),
  CONSTRAINT `fk_CurricularComponent_1` FOREIGN KEY (`idCourse`) REFERENCES `concludeCourse` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CurricularComponent`
--

LOCK TABLES `CurricularComponent` WRITE;
/*!40000 ALTER TABLE `CurricularComponent` DISABLE KEYS */;
/*!40000 ALTER TABLE `CurricularComponent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `External`
--

DROP TABLE IF EXISTS `External`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `External` (
  `idUser` int(11) NOT NULL,
  `CPF` int(11) NOT NULL,
  `CNPJ` int(11) NOT NULL,
  `razaoSocial` varchar(45) NOT NULL,
  `nameRepresentedCo` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`),
  CONSTRAINT `fk_External_1` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `External`
--

LOCK TABLES `External` WRITE;
/*!40000 ALTER TABLE `External` DISABLE KEYS */;
/*!40000 ALTER TABLE `External` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Formation`
--

DROP TABLE IF EXISTS `Formation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Formation` (
  `idOpportunity` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`idOpportunity`),
  CONSTRAINT `fk_Formation_1` FOREIGN KEY (`idOpportunity`) REFERENCES `jobOpportunity` (`idJobOpportunity`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Formation`
--

LOCK TABLES `Formation` WRITE;
/*!40000 ALTER TABLE `Formation` DISABLE KEYS */;
/*!40000 ALTER TABLE `Formation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Professor`
--

DROP TABLE IF EXISTS `Professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Professor` (
  `idUser` int(11) NOT NULL,
  `coordinates` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  CONSTRAINT `fk_Professor_1` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Professor`
--

LOCK TABLES `Professor` WRITE;
/*!40000 ALTER TABLE `Professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `Professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Skills`
--

DROP TABLE IF EXISTS `Skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Skills` (
  `idOpportunity` int(11) NOT NULL,
  `description` varchar(300) NOT NULL,
  PRIMARY KEY (`idOpportunity`),
  CONSTRAINT `fk_Skills_1` FOREIGN KEY (`idOpportunity`) REFERENCES `jobOpportunity` (`idJobOpportunity`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Skills`
--

LOCK TABLES `Skills` WRITE;
/*!40000 ALTER TABLE `Skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `Skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(150) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `userPassword` varchar(45) NOT NULL,
  `userType` varchar(45) NOT NULL,
  `tellphone` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concludeCourse`
--

DROP TABLE IF EXISTS `concludeCourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concludeCourse` (
  `idCourse` int(11) NOT NULL,
  `courseName` varchar(45) NOT NULL,
  `conclusionYear` date NOT NULL,
  `level` varchar(45) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idCourse`,`idUser`),
  KEY `fk_concludeCourse_1_idx` (`idUser`),
  CONSTRAINT `fk_concludeCourse_1` FOREIGN KEY (`idUser`) REFERENCES `Alumnus` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concludeCourse`
--

LOCK TABLES `concludeCourse` WRITE;
/*!40000 ALTER TABLE `concludeCourse` DISABLE KEYS */;
/*!40000 ALTER TABLE `concludeCourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobOpportunity`
--

DROP TABLE IF EXISTS `jobOpportunity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobOpportunity` (
  `idJobOpportunity` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `actingCity` varchar(100) NOT NULL,
  `minSalary` double DEFAULT NULL,
  `maxSalary` double DEFAULT NULL,
  `offererID` int(11) NOT NULL,
  PRIMARY KEY (`idJobOpportunity`),
  KEY `fk_jobOpportunity_1_idx` (`offererID`),
  CONSTRAINT `fk_jobOpportunity_1` FOREIGN KEY (`offererID`) REFERENCES `External` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobOpportunity`
--

LOCK TABLES `jobOpportunity` WRITE;
/*!40000 ALTER TABLE `jobOpportunity` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobOpportunity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-15 11:32:49
