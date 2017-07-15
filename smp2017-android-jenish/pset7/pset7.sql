


DROP TABLE IF EXISTS `portfolio`;


CREATE TABLE `portfolio` (
  `id` int(10) NOT NULL,
  `symbol` varchar(255) NOT NULL,
  `shares` int(11) NOT NULL,
  PRIMARY KEY (`id`,`symbol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;






LOCK TABLES `portfolio` WRITE;

INSERT INTO `portfolio` VALUES (20,'AAPL',1);

UNLOCK TABLES;



DROP TABLE IF EXISTS `transactions`;


CREATE TABLE `transactions` (
  `id` int(10) NOT NULL,
  `transaction` varchar(255) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `symbol` varchar(255) NOT NULL,
  `shares` int(11) NOT NULL,
  `price` decimal(65,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;






LOCK TABLES `transactions` WRITE;

INSERT INTO `transactions` VALUES (20,'BUY','2013-02-13 01:23:20','AAPL',1,463.6700),(20,'BUY','2013-02-13 01:25:36','VOD',1000,26.8900),(20,'SELL','2013-02-13 01:25:58','AAPL',3,463.7401),(20,'SELL','2013-02-13 01:41:23','A',27,44.9580),(20,'BUY','2013-02-13 01:42:42','AAPL',1,470.2750);

UNLOCK TABLES;





DROP TABLE IF EXISTS `users`;


CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `cash` decimal(65,4) unsigned NOT NULL DEFAULT '0.0000',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;






LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES (1,'caesar','$1$50$GHABNWBNE/o4VL7QjmQ6x0',10000.0000),(2,'cs50','$1$50$ceNa7BV5AoVQqilACNLuC1',10000.0000),(3,'jharvard','$1$50$RX3wnAMNrGIbgzbRYrxM1/',10000.0000),(4,'malan','$1$HA$azTGIMVlmPi9W9Y12cYSj/',10000.0000),(5,'nate','$1$50$sUyTaTbiSKVPZCpjJckan0',10000.0000),(6,'rbowden','$1$50$lJS9HiGK6sphej8c4bnbX.',10000.0000),(7,'skroob','$1$50$euBi4ugiJmbpIbvTTfmfI.',10000.0000),(8,'tmacwilliam','$1$50$91ya4AroFPepdLpiX.bdP1',10000.0000),(9,'zamyla','$1$50$Suq.MOtQj51maavfKvFsW1',10000.0000),(20,'james','$1$P0t6nrmQ$54v.S5Vu4kPt/gCH7s1ff/',159818.8413);

UNLOCK TABLES;


