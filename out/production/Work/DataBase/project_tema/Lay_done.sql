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

-- Dumping structure for table project_tema.Lay_done
DROP TABLE IF EXISTS `Lay_done`;
CREATE TABLE IF NOT EXISTS `Lay_done` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `patern0` int(11) DEFAULT NULL,
  `patern1` int(11) DEFAULT NULL,
  `patern2` int(11) DEFAULT NULL,
  `patern3` int(11) DEFAULT NULL,
  `patern4` int(11) DEFAULT NULL,
  `Task` int(10) DEFAULT NULL,
  `Type` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Lay_done_Task` (`Task`),
  CONSTRAINT `FK_Lay_done_Task` FOREIGN KEY (`Task`) REFERENCES `task` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- Dumping data for table project_tema.Lay_done: ~40 rows (approximately)
/*!40000 ALTER TABLE `Lay_done` DISABLE KEYS */;
INSERT INTO `Lay_done` (`ID`, `patern0`, `patern1`, `patern2`, `patern3`, `patern4`, `Task`, `Type`) VALUES
	(93, 8, 0, 0, 0, 0, 7, 0),
	(94, 2, 3, 5, 0, 0, 7, 1),
	(95, 2, 4, 5, 0, 0, 7, 1),
	(96, 11, 0, 0, 0, 0, 7, 2),
	(97, 8, 0, 0, 0, 0, 8, 0),
	(98, 9, 0, 0, 0, 0, 8, 0),
	(99, 10, 0, 0, 0, 0, 8, 0),
	(100, 2, 4, 5, 0, 0, 8, 1),
	(101, 2, 4, 7, 0, 0, 8, 1),
	(102, 11, 0, 0, 0, 0, 8, 2),
	(103, 8, 0, 0, 0, 0, 9, 0),
	(104, 9, 0, 0, 0, 0, 9, 0),
	(105, 10, 0, 0, 0, 0, 9, 0),
	(106, 2, 3, 5, 0, 0, 9, 1),
	(107, 11, 0, 0, 0, 0, 9, 2),
	(108, 12, 0, 0, 0, 0, 9, 2),
	(109, 13, 0, 0, 0, 0, 9, 2),
	(110, 8, 0, 0, 0, 0, 10, 0),
	(111, 9, 0, 0, 0, 0, 10, 0),
	(112, 10, 0, 0, 0, 0, 10, 0),
	(113, 2, 3, 5, 0, 0, 10, 1),
	(114, 11, 0, 0, 0, 0, 10, 2),
	(115, 8, 0, 0, 0, 0, 11, 0),
	(116, 2, 3, 5, 0, 0, 11, 1),
	(117, 2, 3, 7, 0, 0, 11, 1),
	(118, 11, 0, 0, 0, 0, 11, 2),
	(119, 12, 0, 0, 0, 0, 11, 2),
	(120, 13, 0, 0, 0, 0, 11, 2),
	(121, 18, 0, 0, 0, 0, 12, 0),
	(122, 19, 0, 0, 0, 0, 12, 0),
	(123, 20, 0, 0, 0, 0, 12, 0),
	(124, 14, 15, 21, 0, 0, 12, 1),
	(125, 14, 16, 21, 0, 0, 12, 1),
	(126, 22, 0, 0, 0, 0, 12, 2),
	(127, 8, 0, 0, 0, 0, 13, 0),
	(128, 2, 3, 5, 0, 0, 13, 1),
	(129, 2, 4, 5, 0, 0, 13, 1),
	(130, 11, 0, 0, 0, 0, 13, 2),
	(131, 12, 0, 0, 0, 0, 13, 2),
	(132, 13, 0, 0, 0, 0, 13, 2);
/*!40000 ALTER TABLE `Lay_done` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
