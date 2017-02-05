CREATE TABLE `pay_auth_requests` (
  `payAuthRequestId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'key',
  `customerId` bigint(20) unsigned NOT NULL COMMENT '고객 id',
  `orderId` bigint(20) unsigned NOT NULL COMMENT '주문 id',
  `pgId` bigint(20) NOT NULL COMMENT 'PG id',
  `amount` bigint(20) NOT NULL COMMENT ' 결제요청금액',
  `createdAt` datetime(6) NOT NULL COMMENT '생성일시',
  `modifiedAt` datetime(6) NOT NULL COMMENT '수정일시',
  PRIMARY KEY (`payAuthRequestId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;