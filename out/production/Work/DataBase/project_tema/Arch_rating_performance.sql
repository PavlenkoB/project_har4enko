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

-- Dumping structure for table project_tema.Arch_rating_performance
DROP TABLE IF EXISTS `Arch_rating_performance`;
CREATE TABLE IF NOT EXISTS `Arch_rating_performance` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Arch_1` int(10) DEFAULT '0',
  `Arch_2` int(10) DEFAULT '0',
  `performance` double DEFAULT NULL,
  `Task` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- Dumping data for table project_tema.Arch_rating_performance: ~41 rows (approximately)
/*!40000 ALTER TABLE `Arch_rating_performance` DISABLE KEYS */;
INSERT INTO `Arch_rating_performance` (`ID`, `Arch_1`, `Arch_2`, `performance`, `Task`) VALUES
	(1, 287, 288, 1, 11),
	(2, 287, 289, 0.111111111, 11),
	(3, 269, 270, 2, 8),
	(4, 269, 271, 3, 8),
	(5, 269, 272, 7, 8),
	(6, 269, 273, 0.142857142, 8),
	(7, 269, 274, 2, 8),
	(8, 270, 271, 3, 8),
	(9, 270, 272, 2, 8),
	(10, 267, 268, 2, 7),
	(11, 267, 268, 2, 7),
	(12, 269, 270, 2, 8),
	(13, 269, 270, 3, 8),
	(14, 269, 270, 3, 8),
	(15, 269, 270, 3, 8),
	(16, 267, 268, 1, 7),
	(17, 269, 270, 2, 8),
	(18, 269, 271, 5, 8),
	(19, 269, 272, 7, 8),
	(20, 269, 273, 0, 8),
	(21, 269, 274, 5, 8),
	(22, 267, 268, 3, 7),
	(23, 269, 270, 1, 8),
	(24, 267, 268, 4, 7),
	(25, 299, 300, 6, 13),
	(26, 299, 301, 3, 13),
	(27, 299, 302, 8, 13),
	(28, 299, 303, 6, 13),
	(29, 299, 304, 5, 13),
	(30, 300, 301, 7, 13),
	(31, 300, 302, 4, 13),
	(32, 300, 303, 1, 13),
	(33, 300, 304, 3, 13),
	(34, 301, 302, 5, 13),
	(35, 301, 303, 8, 13),
	(36, 301, 304, 9, 13),
	(37, 302, 303, 2, 13),
	(38, 302, 304, 5, 13),
	(39, 303, 304, 7, 13),
	(40, 269, 270, 5, 8),
	(41, 269, 271, 8, 8);
/*!40000 ALTER TABLE `Arch_rating_performance` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
