CREATE TABLE `pay_auth_responses` (
  `payAuthResponseId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `success` tinyint(4) NOT NULL COMMENT '성공여부',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '결과코드',
  `message` varchar(200) DEFAULT '' COMMENT '메시지',
  `createdAt` datetime NOT NULL COMMENT '생성일시',
  `modifiedAt` datetime NOT NULL COMMENT '수정일시',
  PRIMARY KEY (`payAuthResponseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;