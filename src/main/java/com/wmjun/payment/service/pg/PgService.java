package com.wmjun.payment.service.pg;

import com.wmjun.payment.exception.pg.PgSystemException;

/**
 * Created by wmjun on 2017. 2. 4..
 */
public interface PgService {

    String PG_SYSTEM_ERROR_CODE = "-001";

    String PG_SYSTEM_ERROR_MSG = "PG사 통신이 원활하지 않습니다. 잠시 후 다시 시도해 주세요.";

    MockPgAuthResultVO requestAuth() throws PgSystemException;

    MockPgApprovalResultVO requestApproval() throws PgSystemException;
}
