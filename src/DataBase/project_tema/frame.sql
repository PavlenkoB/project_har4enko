-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.65-community-log - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2014-04-24 20:29:03
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping structure for table project_tema.frame
DROP TABLE IF EXISTS `frame`;
CREATE TABLE IF NOT EXISTS `frame` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `UseType` int(10) NOT NULL,
  `Character` text NOT NULL,
  `layer_num` int(11) NOT NULL,
  `grath` text,
  PRIMARY KEY (`ID`),
  KEY `Use Type` (`UseType`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table project_tema.frame: ~6 rows (approximately)
/*!40000 ALTER TABLE `frame` DISABLE KEYS */;
INSERT INTO `frame` (`ID`, `Name`, `UseType`, `Character`, `layer_num`, `grath`) VALUES
	(3, 'Cквозной фунуционал', 4, '', 3, 'Grath/Frames/Web_open.jpg'),
	(4, 'Раздельная функциональность', 4, '', 3, 'Grath/Frames/Web_open.jpg'),
	(5, 'Cквозной фунуционал', 5, '', 4, NULL),
	(6, 'Cквозной фунуционал', 6, '', 3, NULL),
	(7, 'Раздельная функциональность', 5, '', 4, NULL),
	(8, 'Раздельная функциональность', 6, '', 3, NULL);
/*!40000 ALTER TABLE `frame` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
