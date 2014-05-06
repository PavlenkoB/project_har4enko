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

-- Dumping structure for table project_tema.Task
DROP TABLE IF EXISTS `Task`;
CREATE TABLE IF NOT EXISTS `Task` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Usetype` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Dumping data for table project_tema.Task: ~7 rows (approximately)
/*!40000 ALTER TABLE `Task` DISABLE KEYS */;
INSERT INTO `Task` (`ID`, `Name`, `Usetype`) VALUES
	(7, 'Test_task_1', 4),
	(8, 'Test_task_2', 4),
	(9, 'Test_task_3', 4),
	(10, 'tyu', 4),
	(11, 'yty', 4),
	(12, '78', 5),
	(13, 'Наша решаемая задача', 4);
/*!40000 ALTER TABLE `Task` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
