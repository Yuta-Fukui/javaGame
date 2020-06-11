-- create sqls
CREATE TABLE `Question` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `questionStatement` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `answer1` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `answer2` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `answer3` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `answer4` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `questionStatement` (`questionStatement`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `Correct_Answer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `questionId` bigint NOT NULL,
  `correctAnswer` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `explanation` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `questionId` (`questionId`),
  CONSTRAINT `Correct_Answer_ibfk_1` FOREIGN KEY (`questionId`) REFERENCES `Question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;