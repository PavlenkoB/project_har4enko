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

-- Dumping structure for table project_tema.Arch_rating_dependability
DROP TABLE IF EXISTS `Arch_rating_dependability`;
CREATE TABLE IF NOT EXISTS `Arch_rating_dependability` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Arch_1` int(10) DEFAULT '0',
  `Arch_2` int(10) DEFAULT '0',
  `dependability` double DEFAULT NULL,
  `Task` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- Dumping data for table project_tema.Arch_rating_dependability: ~9 rows (approximately)
/*!40000 ALTER TABLE `Arch_rating_dependability` DISABLE KEYS */;
INSERT INTO `Arch_rating_dependability` (`ID`, `Arch_1`, `Arch_2`, `dependability`, `Task`) VALUES
	(1, 267, 268, 0.2, 7),
	(2, 293, 294, 3, 12),
	(3, 293, 295, 2, 12),
	(4, 293, 296, 3, 12),
	(5, 293, 297, 5, 12),
	(6, 293, 298, 2, 12),
	(7, 269, 269, 1, 8),
	(8, 269, 270, 2, 8),
	(9, 269, 271, 3, 8);
/*!40000 ALTER TABLE `Arch_rating_dependability` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
