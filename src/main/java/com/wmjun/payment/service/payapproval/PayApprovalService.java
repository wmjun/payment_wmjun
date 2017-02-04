package com.wmjun.payment.service.payapproval;

import com.wmjun.payment.controller.payapproval.PayApprovalRequestDTO;
import com.wmjun.payment.exception.pg.PgSystemException;

/**
 * Created by wmjun on 2017. 2. 4..
 */
public interface PayApprovalService {
    PayApprovalResponseVO approval(PayApprovalRequestDTO requestDTO) throws PgSystemException;
}
