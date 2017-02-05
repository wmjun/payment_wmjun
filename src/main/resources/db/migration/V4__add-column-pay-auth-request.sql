ALTER TABLE `pay_auth_responses` ADD `payAuthRequestId` BIGINT(20)  NOT NULL  COMMENT 'auth req id'  AFTER `payAuthResponseId`;
