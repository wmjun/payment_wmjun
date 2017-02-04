package com.wmjun.payment.service.pg;

import com.wmjun.payment.exception.pg.PgSystemException;
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

        return MockPgAuthResultVO.newSuccessResult();
    }

    @Override
    public MockPgApprovalResultVO requestApproval() {
        return MockPgApprovalResultVO.newSuccessResult();
    }
}
