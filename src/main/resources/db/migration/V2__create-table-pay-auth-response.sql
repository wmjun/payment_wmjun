CREATE TABLE `pay_auth_responses` (
  `payAuthResponseId` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'pk',
  `success`           TINYINT(4)          NOT NULL
  COMMENT '성공여부',
  `code`              VARCHAR(50)         NOT NULL DEFAULT ''
  COMMENT '결과코드',
  `message`           VARCHAR(200)                 DEFAULT ''
  COMMENT '메시지',
  `createdAt`         DATETIME            NOT NULL
  COMMENT '생성일시',
  `modifiedAt`        DATETIME            NOT NULL
  COMMENT '수정일시',
  PRIMARY KEY (`payAuthResponseId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;