-- MySQL dump 10.9
--
-- Host: localhost    Database: fidelizacion
-- ------------------------------------------------------
-- Server version	4.1.22-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `ID` int(11) NOT NULL auto_increment,
  `CODIGOBARRASGENERADO` varchar(40) default NULL,
  `NOMBRE` varchar(100) default NULL,
  `1apellido` varchar(100) default NULL,
  `2apellido` varchar(100) default NULL,
  `CODIGOPOSTAL` varchar(5) default NULL,
  `FECHA_ALTA` date default NULL,
  `email` varchar(80) default NULL,
  `TELEFONO` varchar(50) default NULL,
  `CANTIDAD_DESAYUNOS` int(11) default NULL,
  `CANTIDAD_MENUS` int(11) default NULL,
  `CANTIDAD_IMPORTES` int(11) default NULL,
  `PUNTOS_ACTUALES_DESAYUNOS` int(11) default NULL,
  `PUNTOS_ACTUALES_MENUS` int(11) default NULL,
  `PUNTOS_ACTUALES_IMPORTES` int(11) default NULL,
  `PUNTOS_RCONSUMIDOS_DESAYUNOS` int(11) default NULL,
  `PUNTOS_RCONSUMIDOS_MENUS` int(11) default NULL,
  `PUNTOS_RCONSUMIDOS_IMPORTES` int(11) default NULL,
  `REGALOS_ACUMULADOSDESAYUNOS` varchar(100) default NULL,
  `REGALOS_ACUMULADOSMENUS` varchar(100) default NULL,
  `REGALOS_ACUMULADOSIMPORTES` varchar(100) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'1111111111111','Juan Carlos','Perez','Almendro','28983','2015-02-10','jcper8@hotmail.com','912634614',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'2222222222222','Rafael','Perez','Almendro','28983','2015-02-10','Rafael@hotmail.com','916640776',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'3333333333333','Jose Luis','Garcia','Prueba','28983','2015-02-10','Garcia@hotmail.com','913333333',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'4444444444444','Dirk','Junior','prueba1','28983','2015-02-10','prueba1@hotmail.com','914444444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'5555555555555','Emilio','GarciaPrueba','Prueba3','28983','2015-02-10','prueba3@hotmail.com','915555555',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'6666666666666','Luis','SanzPrueba4','Prueba4','28983','2015-02-10','Prueba4@hotmail.com','916666666',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuracion`
--

DROP TABLE IF EXISTS `configuracion`;
CREATE TABLE `configuracion` (
  `CONTRASEÑA` text,
  `LICENCIA` int(11) default NULL,
  `FECHA` date default NULL,
  `DIASDEMO` int(11) default NULL,
  `ESTABLECIMIENTO` text,
  `NIF` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `configuracion`
--

LOCK TABLES `configuracion` WRITE;
/*!40000 ALTER TABLE `configuracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `configuracion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuracionlector`
--

DROP TABLE IF EXISTS `configuracionlector`;
CREATE TABLE `configuracionlector` (
  `COM` text,
  `LONGITUD` int(11) default NULL,
  `INTERVALO` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `configuracionlector`
--

LOCK TABLES `configuracionlector` WRITE;
/*!40000 ALTER TABLE `configuracionlector` DISABLE KEYS */;
INSERT INTO `configuracionlector` VALUES ('8',13,500);
/*!40000 ALTER TABLE `configuracionlector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntoscomida`
--

DROP TABLE IF EXISTS `puntoscomida`;
CREATE TABLE `puntoscomida` (
  `id` int(11) default NULL,
  `FECHA_ALTA` date default NULL,
  `PUNTOS_ACTUALES` int(11) default NULL,
  `REGALOS_ACUMULADOS` varchar(100) default NULL,
  `REGALOS_CONSUMIDOS` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `puntoscomida`
--

LOCK TABLES `puntoscomida` WRITE;
/*!40000 ALTER TABLE `puntoscomida` DISABLE KEYS */;
INSERT INTO `puntoscomida` VALUES (1,'2015-02-10',53,'1 menu',0),(2,'2015-02-10',0,'0',0),(3,'2015-02-10',0,'0',0),(4,'2015-02-10',0,'0',0),(5,'2015-02-10',0,'0',0),(6,'2015-02-10',0,'0',0);
/*!40000 ALTER TABLE `puntoscomida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntosdesayunos`
--

DROP TABLE IF EXISTS `puntosdesayunos`;
CREATE TABLE `puntosdesayunos` (
  `id` int(11) default NULL,
  `FECHA_ALTA` date default NULL,
  `PUNTOS_ACTUALES` int(11) default NULL,
  `REGALOS_ACUMULADOS` varchar(100) default NULL,
  `REGALOS_CONSUMIDOS` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `puntosdesayunos`
--

LOCK TABLES `puntosdesayunos` WRITE;
/*!40000 ALTER TABLE `puntosdesayunos` DISABLE KEYS */;
INSERT INTO `puntosdesayunos` VALUES (1,'2015-02-10',29,'1 desayuno',0),(2,'2015-02-10',0,'0',0),(3,'2015-02-10',0,'0',0),(4,'2015-02-10',0,'0',0),(5,'2015-02-10',0,'0',0),(6,'2015-02-10',0,'0',0);
/*!40000 ALTER TABLE `puntosdesayunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntosfidelizacion`
--

DROP TABLE IF EXISTS `puntosfidelizacion`;
CREATE TABLE `puntosfidelizacion` (
  `INCREMENTODESAYUNOS` int(11) default NULL,
  `PREMIOSDESAYUNOS` varchar(100) default NULL,
  `INCREMENTOMENU` int(11) default NULL,
  `PREMIOSMENU` varchar(100) default NULL,
  `INCREMENTOIMPORTE` int(11) default NULL,
  `PREMIOSIMPORTE` varchar(100) default NULL,
  `PUNTOSDESAYUNO` int(11) default NULL,
  `PUNTOSMENU` int(11) default NULL,
  `PUNTOSIMPORTE` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `puntosfidelizacion`
--

LOCK TABLES `puntosfidelizacion` WRITE;
/*!40000 ALTER TABLE `puntosfidelizacion` DISABLE KEYS */;
INSERT INTO `puntosfidelizacion` VALUES (10,'1 desayuno',10,'1 menu',10,'5% descuento',1,1,1);
/*!40000 ALTER TABLE `puntosfidelizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntosimporte`
--

DROP TABLE IF EXISTS `puntosimporte`;
CREATE TABLE `puntosimporte` (
  `id` int(11) default NULL,
  `FECHA_ALTA` date default NULL,
  `PUNTOS_ACTUALES` int(11) default NULL,
  `REGALOS_ACUMULADOS` varchar(100) default NULL,
  `REGALOS_CONSUMIDOS` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `puntosimporte`
--

LOCK TABLES `puntosimporte` WRITE;
/*!40000 ALTER TABLE `puntosimporte` DISABLE KEYS */;
INSERT INTO `puntosimporte` VALUES (1,'2015-02-10',0,'0',0),(2,'2015-02-10',0,'0',0),(3,'2015-02-10',0,'0',0),(4,'2015-02-10',0,'0',0),(5,'2015-02-10',0,'0',0),(6,'2015-02-10',0,'0',0);
/*!40000 ALTER TABLE `puntosimporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrodiario`
--

DROP TABLE IF EXISTS `registrodiario`;
CREATE TABLE `registrodiario` (
  `FECHA_OPERACION` date default NULL,
  `CODIGO` varchar(100) default NULL,
  `ID` int(11) default NULL,
  `TABLA_PUNTOS` varchar(100) default NULL,
  `TIPO_OPERACION` varchar(100) default NULL,
  `CANTIDAD` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registrodiario`
--

LOCK TABLES `registrodiario` WRITE;
/*!40000 ALTER TABLE `registrodiario` DISABLE KEYS */;
INSERT INTO `registrodiario` VALUES ('2015-02-19','912634614',1,'MENU','Obtenidos','6'),('2015-02-19','912634614',1,'DESAYUNO','Obtenidos','5'),('2015-02-19','1111111111111',1,'MENU','Obtenidos','6'),('2015-02-20','1111111111111',1,'MENU','Obtenidos','6'),('2015-02-20','1111111111111',1,'DESAYUNO','Obtenidos','6'),('2015-02-20','1111111111111',1,'MENU','Obtenidos','3'),('2015-02-20','1111111111111',1,'MENU','Obtenidos','5'),('2015-02-20','1111111111111',1,'MENU','Obtenidos','6'),('2015-02-20','1111111111111',1,'DESAYUNO','Obtenidos','1'),('2015-02-20','1111111111111',1,'MENU','Obtenidos','6'),('2015-02-20','1111111111111',1,'MENU','Obtenidos','5'),('2015-02-20','1111111111111',1,'DESAYUNO','Obtenidos','6'),('2015-02-20','1111111111111',1,'MENU','Obtenidos','6'),('2015-02-20','1111111111111',1,'DESAYUNO','Obtenidos','5'),('2015-02-20','1111111111111',1,'DESAYUNO','Obtenidos','6'),('2015-02-20','1111111111111',1,'MENU','Obtenidos','1'),('2015-02-20','1111111111111',1,'MENU','Obtenidos','3');
/*!40000 ALTER TABLE `registrodiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablaconsumodiario`
--

DROP TABLE IF EXISTS `tablaconsumodiario`;
CREATE TABLE `tablaconsumodiario` (
  `ID` int(11) default NULL,
  `FECHA_DIARIA` date default NULL,
  `CONSUMIDOSDESAYUNOS` int(11) default NULL,
  `PREMIOSDESAYUNOS` varchar(100) default NULL,
  `CONSUMIDOSMENUS` int(11) default NULL,
  `PREMIOSMENUS` varchar(100) default NULL,
  `CONSUMIDOSIMPORTES` int(11) default NULL,
  `PREMIOSIMPORTES` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tablaconsumodiario`
--

LOCK TABLES `tablaconsumodiario` WRITE;
/*!40000 ALTER TABLE `tablaconsumodiario` DISABLE KEYS */;
INSERT INTO `tablaconsumodiario` VALUES (1,'2015-02-10',0,'0',0,'0',0,'0'),(2,'2015-02-10',0,'0',0,'0',0,'0'),(3,'2015-02-10',0,'0',0,'0',0,'0'),(4,'2015-02-10',0,'0',0,'0',0,'0'),(5,'2015-02-10',0,'0',0,'0',0,'0'),(6,'2015-02-10',0,'0',0,'0',0,'0');
/*!40000 ALTER TABLE `tablaconsumodiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabladiaria`
--

DROP TABLE IF EXISTS `tabladiaria`;
CREATE TABLE `tabladiaria` (
  `ID` int(11) default NULL,
  `FECHA_DIARIA` date default NULL,
  `DESAYUNOS` int(11) default NULL,
  `MENUS` int(11) default NULL,
  `IMPORTES` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabladiaria`
--

LOCK TABLES `tabladiaria` WRITE;
/*!40000 ALTER TABLE `tabladiaria` DISABLE KEYS */;
INSERT INTO `tabladiaria` VALUES (1,'2015-02-10',0,0,0),(2,'2015-02-10',0,0,0),(3,'2015-02-10',0,0,0),(4,'2015-02-10',0,0,0),(5,'2015-02-10',0,0,0),(6,'2015-02-10',0,0,0),(1,'2015-02-19',NULL,6,NULL),(1,'2015-02-19',5,NULL,NULL),(1,'2015-02-19',NULL,6,NULL),(1,'2015-02-20',NULL,6,NULL),(1,'2015-02-20',6,NULL,NULL),(1,'2015-02-20',NULL,3,NULL),(1,'2015-02-20',NULL,5,NULL),(1,'2015-02-20',NULL,6,NULL),(1,'2015-02-20',1,NULL,NULL),(1,'2015-02-20',NULL,6,NULL),(1,'2015-02-20',NULL,5,NULL),(1,'2015-02-20',6,NULL,NULL),(1,'2015-02-20',NULL,6,NULL),(1,'2015-02-20',5,NULL,NULL),(1,'2015-02-20',6,NULL,NULL),(1,'2015-02-20',NULL,1,NULL),(1,'2015-02-20',NULL,3,NULL);
/*!40000 ALTER TABLE `tabladiaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablaregalospendientes`
--

DROP TABLE IF EXISTS `tablaregalospendientes`;
CREATE TABLE `tablaregalospendientes` (
  `ID` int(11) default NULL,
  `FECHA_DIARIA` date default NULL,
  `PREMIOSDESAYUNOS` varchar(100) default NULL,
  `PREMIOSMENUS` varchar(100) default NULL,
  `PREMIOSIMPORTES` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tablaregalospendientes`
--

LOCK TABLES `tablaregalospendientes` WRITE;
/*!40000 ALTER TABLE `tablaregalospendientes` DISABLE KEYS */;
INSERT INTO `tablaregalospendientes` VALUES (1,'2015-02-10','2','5','0'),(2,'2015-02-10','0','0','0'),(3,'2015-02-10','0','0','0'),(4,'2015-02-10','0','0','0'),(5,'2015-02-10','0','0','0'),(6,'2015-02-10','0','0','0');
/*!40000 ALTER TABLE `tablaregalospendientes` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

