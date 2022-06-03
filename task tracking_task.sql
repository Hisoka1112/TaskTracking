

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `TaskUserId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `User_idx` (`TaskUserId`),
  CONSTRAINT `User` FOREIGN KEY (`TaskUserId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
