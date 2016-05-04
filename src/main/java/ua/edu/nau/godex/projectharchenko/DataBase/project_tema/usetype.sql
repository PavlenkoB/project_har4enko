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

-- Dumping structure for table project_tema.usetype
DROP TABLE IF EXISTS `usetype`;
CREATE TABLE IF NOT EXISTS `usetype` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Character` text NOT NULL,
  `Grath` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table project_tema.usetype: ~3 rows (approximately)
/*!40000 ALTER TABLE `usetype` DISABLE KEYS */;
INSERT INTO `usetype` (`ID`, `Name`, `Character`, `Grath`) VALUES
	(4, 'Веб Приложение', 'Приложения этого типа, как правило, поддерживают сценарии с постоянным подключением и различные браузеры, выполняющиеся в разнообразнейших операционных системах и на разных платформах.', 'Grath/Usetypes/Web_open.jpg'),
	(5, 'Клиентское приложение', 'Приложения этого типа обычно разрабатываются как самодостаточные приложения с графическим пользовательским интерфейсом, который обеспечивает отображение данных с помощью набора', 'Grath/Usetypes/Client_open.jpg'),
	(6, 'Приложение сервисов', 'Сервис – это открытый интерфейс, обеспечивающий доступ к единице функциональности. Сервисы являются гибкими по своей природе и могут использоваться в разнообразнейших сценариях и комбинациях.', 'Grath/Usetypes/Servis_open.jpg');
/*!40000 ALTER TABLE `usetype` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
