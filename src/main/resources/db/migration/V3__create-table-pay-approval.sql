CREATE TABLE `pay_approval_requests` (
  `payApprovalRequestId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'key',
  `payAuthRequestId` bigint(20) NOT NULL COMMENT 'auth request id',
  `customerId` bigint(20) NOT NULL COMMENT '고객 번호',
  `orderId` bigint(20) NOT NULL COMMENT '주문 번호',
  `amount` bigint(20) NOT NULL COMMENT '금액',
  `createdAt` datetime NOT NULL COMMENT '생성일시',
  `modifiedAt` datetime NOT NULL COMMENT '변경일시',
  PRIMARY KEY (`payApprovalRequestId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pay_approval_responses` (
  `payApprovalResponseId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'key',
  `payAuthRequestId` bigint(20) NOT NULL COMMENT 'aut req id',
  `payApprovalRequestId` bigint(20) NOT NULL COMMENT 'approval req id',
  `success` tinyint(1) NOT NULL COMMENT '성공여부',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '코드',
  `message` varchar(200) DEFAULT '' COMMENT '메시지',
  `createdAt` datetime NOT NULL COMMENT '생성일시',
  `modifiedAt` datetime NOT NULL COMMENT '수정일시',
  PRIMARY KEY (`payApprovalResponseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
