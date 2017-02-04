package com.wmjun.payment.service.payapproval;

import com.wmjun.payment.controller.payapproval.PayApprovalRequestDTO;
import com.wmjun.payment.exception.pg.PgSystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Slf4j
@Service
public class PayApprovalServiceImpl implements PayApprovalService {

    @Override
    public PayApprovalResponseVO approval(PayApprovalRequestDTO requestDTO) throws PgSystemException {
        //request 데이타 검증.
        //request 데이타 저장.
        //pg 통신.
        //response 데이타 저장.
        return null;
    }
}
