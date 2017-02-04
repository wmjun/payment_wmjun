package com.wmjun.payment.service.pg;

import com.wmjun.payment.exception.pg.PgSystemException;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@FunctionalInterface
public interface MockPgAction<T> {
    T action() throws PgSystemException;
}
