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

-- Dumping structure for table project_tema.Arch_done
DROP TABLE IF EXISTS `Arch_done`;
CREATE TABLE IF NOT EXISTS `Arch_done` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Task` int(11) DEFAULT NULL,
  `Layer0` int(11) DEFAULT NULL,
  `Layer1` int(11) DEFAULT NULL,
  `Layer2` int(11) DEFAULT NULL,
  `Layer3` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Arch_done_Task` (`Task`),
  KEY `FK_Arch_done_Lay_done` (`Layer0`),
  KEY `FK_Arch_done_Lay_done_2` (`Layer1`),
  KEY `FK_Arch_done_Lay_done_3` (`Layer2`),
  KEY `FK_Arch_done_Lay_done_4` (`Layer3`),
  CONSTRAINT `FK_Arch_done_Task` FOREIGN KEY (`Task`) REFERENCES `task` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=305 DEFAULT CHARSET=utf8;

-- Dumping data for table project_tema.Arch_done: ~38 rows (approximately)
/*!40000 ALTER TABLE `Arch_done` DISABLE KEYS */;
INSERT INTO `Arch_done` (`ID`, `Task`, `Layer0`, `Layer1`, `Layer2`, `Layer3`) VALUES
	(267, 7, 93, 94, 96, 0),
	(268, 7, 93, 95, 96, 0),
	(269, 8, 97, 100, 102, 0),
	(270, 8, 97, 101, 102, 0),
	(271, 8, 98, 100, 102, 0),
	(272, 8, 98, 101, 102, 0),
	(273, 8, 99, 100, 102, 0),
	(274, 8, 99, 101, 102, 0),
	(275, 9, 103, 106, 107, 0),
	(276, 9, 103, 106, 108, 0),
	(277, 9, 103, 106, 109, 0),
	(278, 9, 104, 106, 107, 0),
	(279, 9, 104, 106, 108, 0),
	(280, 9, 104, 106, 109, 0),
	(281, 9, 105, 106, 107, 0),
	(282, 9, 105, 106, 108, 0),
	(283, 9, 105, 106, 109, 0),
	(284, 10, 110, 113, 114, 0),
	(285, 10, 111, 113, 114, 0),
	(286, 10, 112, 113, 114, 0),
	(287, 11, 115, 116, 118, 0),
	(288, 11, 115, 116, 119, 0),
	(289, 11, 115, 116, 120, 0),
	(290, 11, 115, 117, 118, 0),
	(291, 11, 115, 117, 119, 0),
	(292, 11, 115, 117, 120, 0),
	(293, 12, 121, 124, 126, 0),
	(294, 12, 121, 125, 126, 0),
	(295, 12, 122, 124, 126, 0),
	(296, 12, 122, 125, 126, 0),
	(297, 12, 123, 124, 126, 0),
	(298, 12, 123, 125, 126, 0),
	(299, 13, 127, 128, 130, 0),
	(300, 13, 127, 128, 131, 0),
	(301, 13, 127, 128, 132, 0),
	(302, 13, 127, 129, 130, 0),
	(303, 13, 127, 129, 131, 0),
	(304, 13, 127, 129, 132, 0);
/*!40000 ALTER TABLE `Arch_done` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
