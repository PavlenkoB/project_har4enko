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

-- Dumping structure for table project_tema.Arch_rating_security
DROP TABLE IF EXISTS `Arch_rating_security`;
CREATE TABLE IF NOT EXISTS `Arch_rating_security` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Arch_1` int(10) DEFAULT '0',
  `Arch_2` int(10) DEFAULT '0',
  `security` double DEFAULT NULL,
  `Task` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- Dumping data for table project_tema.Arch_rating_security: ~0 rows (approximately)
/*!40000 ALTER TABLE `Arch_rating_security` DISABLE KEYS */;
/*!40000 ALTER TABLE `Arch_rating_security` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
