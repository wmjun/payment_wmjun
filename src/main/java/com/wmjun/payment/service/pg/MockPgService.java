package com.wmjun.payment.service.pg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Service
@Slf4j
public class MockPgService implements PgService {

    @Override
    public MockPgAuthResultVO requestAuth() {
        log.info("Pay Auth Request - [Pg Mock Server]");
        return MockPgAuthResultVO.newSuccessResult();
    }

    @Override
    public MockPgApprovalResultVO requestApproval() {
        log.info("Pay Approval Request - [Pg Mock Server]");
        return MockPgApprovalResultVO.newSuccessResult();
    }
}
