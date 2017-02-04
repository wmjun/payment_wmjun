CREATE TABLE `pay_auth_requests` (
  `payAuthRequestId` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'key',
  `customerId`       BIGINT(20) UNSIGNED NOT NULL
  COMMENT '고객 id',
  `orderId`          BIGINT(20) UNSIGNED NOT NULL
  COMMENT '주문 id',
  `pgId`             BIGINT(20)          NOT NULL
  COMMENT 'PG id',
  `amount`           BIGINT(20)          NOT NULL
  COMMENT ' 결제요청금액',
  `createdAt`        DATETIME(6)         NOT NULL
  COMMENT '생성일시',
  `modifiedAt`       DATETIME(6)         NOT NULL
  COMMENT '수정일시',
  PRIMARY KEY (`payAuthRequestId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;