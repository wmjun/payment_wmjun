package com.wmjun.payment.service.payauth;

import com.wmjun.payment.controller.payauth.PayAuthRequestDTO;
import com.wmjun.payment.domain.payauth.PayAuthRequest;
import com.wmjun.payment.exception.pg.PgSystemException;

import java.util.List;

/**
 * Created by wmjun on 2017. 1. 31..
 */
public interface PayAuthService {
    List<PayAuthRequest> getAll();

    PayAuthRequest get(Long id);

    PayAuthResponseVO requestPayAuth(PayAuthRequestDTO requestDTO) throws PgSystemException;

}
