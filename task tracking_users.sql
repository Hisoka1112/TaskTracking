DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `ProjectId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `project_idx` (`ProjectId`),
  CONSTRAINT `project` FOREIGN KEY (`ProjectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
