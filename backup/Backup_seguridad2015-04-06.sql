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
INSERT INTO `clientes` VALUES (1,'1111111111111','JuanPrueba','Prueba1Apellido1','Prueba1Apellido2','28983','2015-02-12','Prueba1@hotmail.com','911111111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'2222222222222','LuisPrueba2','Prueba2Apellido1','Prueba2Apellido2','28983','2015-02-12','Prueba2@hotmail.com','912222222',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'3333333333333','LuisPrueba3','Prueba3Apellido1','Prueba3Apellido2','28983','2015-02-12','Prueba3@hotmail.com','913333333',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'4444444444444','AlbertoPrueba4','Prueba4Apellido1','Prueba4Apellido2','28983','2015-02-12','Prueba4@hotmail.com','914444444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'5555555555555','JosePrueba5','Prueba5Apellido1','Prueba5Apellido2','28985','2015-02-12','Prueba5@hotmail.com','915555555',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'6666666666666','SusanaPrueba6','Prueba6Apellido1','Prueba6Apellido2','28985','2015-02-12','Prueba6@hotmail.com','916666666',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'8888888888888','juan carlos','Perez','Almendro','28983','2015-04-01','jcper8@hotmail.com','912634614',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'7777777777777','prueba7','apellido7','apellido27','28983','2015-04-01','jcper8','916640776',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
INSERT INTO `configuracion` VALUES ('1234',0,'2015-02-12',0,'prueba','1111111111');
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
INSERT INTO `puntoscomida` VALUES (1,'2015-02-12',11,'2 menus',0),(2,'2015-02-12',11,'2 menus',0),(3,'2015-02-12',0,'0',0),(4,'2015-02-12',0,'0',0),(5,'2015-02-12',0,'0',0),(6,'2015-02-12',0,'0',0),(7,'2015-04-01',0,'0',0),(8,'2015-04-01',0,'0',0);
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
INSERT INTO `puntosdesayunos` VALUES (1,'2015-02-12',0,'0',1),(2,'2015-02-12',3,'0',0),(3,'2015-02-12',0,'0',0),(4,'2015-02-12',0,'0',0),(5,'2015-02-12',0,'0',0),(6,'2015-02-12',0,'0',0),(7,'2015-04-01',0,'0',0),(8,'2015-04-01',0,'0',0);
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
INSERT INTO `puntosfidelizacion` VALUES (10,'1 desayuno',10,'2 menus',10,'5% descuento',1,1,1);
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
INSERT INTO `puntosimporte` VALUES (1,'2015-02-12',97777,'5% descuento',0),(2,'2015-02-12',0,'0',0),(3,'2015-02-12',0,'0',0),(4,'2015-02-12',0,'0',0),(5,'2015-02-12',0,'0',0),(6,'2015-02-12',0,'0',0),(7,'2015-04-01',0,'0',0),(8,'2015-04-01',0,'0',0);
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
INSERT INTO `registrodiario` VALUES ('2015-02-12','911111111',1,'MENU','Obtenidos','6'),('2015-02-12','911111111',1,'MENU','Obtenidos','3'),('2015-02-12','911111111',1,'MENU','Obtenidos','2'),('2015-02-12','911111111',1,'DESAYUNO','Obtenidos','6'),('2015-02-12','911111111',1,'DESAYUNO','Obtenidos','5'),('2015-02-12','911111111',1,'Desayuno','Consumidos','11'),('2015-03-08','2222222222222',2,'MENU','Obtenidos','6'),('2015-03-08','2222222222222',2,'DESAYUNO','Obtenidos','3'),('2015-03-27','1111111111111',1,'IMPORTES','Obtenidos','97777'),('2015-04-01','2222222222222',2,'MENU','Obtenidos','5');
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
INSERT INTO `tablaconsumodiario` VALUES (1,'2015-02-12',0,'0',0,'0',0,'0'),(2,'2015-02-12',0,'0',0,'0',0,'0'),(3,'2015-02-12',0,'0',0,'0',0,'0'),(4,'2015-02-12',0,'0',0,'0',0,'0'),(5,'2015-02-12',0,'0',0,'0',0,'0'),(6,'2015-02-12',0,'0',0,'0',0,'0'),(1,'2015-02-12',11,'1 desayuno',NULL,NULL,NULL,NULL),(7,'2015-04-01',0,'0',0,'0',0,'0'),(8,'2015-04-01',0,'0',0,'0',0,'0');
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
INSERT INTO `tabladiaria` VALUES (1,'2015-02-12',0,0,0),(2,'2015-02-12',0,0,0),(3,'2015-02-12',0,0,0),(4,'2015-02-12',0,0,0),(5,'2015-02-12',0,0,0),(6,'2015-02-12',0,0,0),(1,'2015-02-12',NULL,6,NULL),(1,'2015-02-12',NULL,3,NULL),(1,'2015-02-12',NULL,2,NULL),(1,'2015-02-12',6,NULL,NULL),(1,'2015-02-12',5,NULL,NULL),(2,'2015-03-08',NULL,6,NULL),(2,'2015-03-08',3,NULL,NULL),(1,'2015-03-27',NULL,NULL,97777),(2,'2015-04-01',NULL,5,NULL),(7,'2015-04-01',0,0,0),(8,'2015-04-01',0,0,0);
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
INSERT INTO `tablaregalospendientes` VALUES (1,'2015-02-12','0','1','9777'),(2,'2015-02-12','0','1','0'),(3,'2015-02-12','0','0','0'),(4,'2015-02-12','0','0','0'),(5,'2015-02-12','0','0','0'),(6,'2015-02-12','0','0','0'),(7,'2015-04-01','0','0','0'),(8,'2015-04-01','0','0','0');
/*!40000 ALTER TABLE `tablaregalospendientes` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

