package com.wmjun.payment.service.payapproval;

import com.wmjun.payment.controller.payapproval.PayApprovalRequestDTO;
import com.wmjun.payment.domain.payapproval.PayApprovalRequest;
import com.wmjun.payment.domain.payapproval.PayApprovalRequestRepository;
import com.wmjun.payment.domain.payapproval.PayApprovalResponse;
import com.wmjun.payment.domain.payapproval.PayApprovalResponseRepository;
import com.wmjun.payment.domain.payauth.PayAuthRequest;
import com.wmjun.payment.domain.payauth.PayAuthRequestRepository;
import com.wmjun.payment.domain.payauth.PayAuthResponse;
import com.wmjun.payment.domain.payauth.PayAuthResponseRepository;
import com.wmjun.payment.exception.pg.PgSystemException;
import com.wmjun.payment.service.pg.MockPgApprovalResultVO;
import com.wmjun.payment.service.pg.PgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class PayApprovalServiceImpl implements PayApprovalService {

    private static final String VALIDATE_ERROR_MSG = "유효하지 않은 인증 정보입니다.";

    @Autowired
    private PayAuthRequestRepository payAuthRequestRepository;

    @Autowired
    private PayAuthResponseRepository payAuthResponseRepository;

    @Autowired
    private PayApprovalRequestRepository payApprovalRequestRepository;

    @Autowired
    private PayApprovalResponseRepository payApprovalResponseRepository;


    @Autowired
    private PgService pgService;

    @Override
    @Transactional(readOnly = false)
    public PayApprovalResponseVO approval(PayApprovalRequestDTO requestDTO) throws PgSystemException {
        //request 데이타 검증.
        validateRequest(requestDTO);
        //request 데이타 저장.
        PayApprovalRequest payApprovalRequest = saveApprovalRequest(requestDTO);
        //pg 통신.
        MockPgApprovalResultVO pgApprovalResultVO = pgService.requestApproval();
        //response 데이타 저장.
        PayApprovalResponse payApprovalResponse = saveApprovalResponse(payApprovalRequest, pgApprovalResultVO);

        return new PayApprovalResponseVO(payApprovalResponse.isSuccess(), payApprovalResponse.getCode(), payApprovalResponse.getMessage());
    }


    private void validateRequest(PayApprovalRequestDTO requestDTO) {
        PayAuthRequest payAuthRequest = payAuthRequestRepository.findOne(requestDTO.getPayAuthRequestId());
        Assert.notNull(payAuthRequest, VALIDATE_ERROR_MSG);
        PayAuthResponse payAuthResponse = payAuthResponseRepository.findByPayAuthRequestId(payAuthRequest.getPayAuthRequestId());
        Assert.isTrue((payAuthResponse != null) && payAuthResponse.isSuccess(), VALIDATE_ERROR_MSG);
        Assert.isTrue(payAuthRequest.getAmount().equals(requestDTO.getAmount()), VALIDATE_ERROR_MSG);
        Assert.isTrue(payAuthRequest.getCustomerId().equals(requestDTO.getCustomerId()), VALIDATE_ERROR_MSG);
        Assert.isTrue(payAuthRequest.getOrderId().equals(requestDTO.getOrderId()), VALIDATE_ERROR_MSG);
    }

    @Transactional(readOnly = false)
    private PayApprovalRequest saveApprovalRequest(PayApprovalRequestDTO requestDTO) {
        PayApprovalRequest payApprovalRequest = new PayApprovalRequest();
        payApprovalRequest.setCustomerId(requestDTO.getCustomerId());
        payApprovalRequest.setAmount(requestDTO.getAmount());
        payApprovalRequest.setPayAuthRequestId(requestDTO.getPayAuthRequestId());
        payApprovalRequest.setOrderId(requestDTO.getOrderId());

        return payApprovalRequestRepository.save(payApprovalRequest);
    }

    @Transactional(readOnly = false)
    private PayApprovalResponse saveApprovalResponse(PayApprovalRequest payApprovalRequest, MockPgApprovalResultVO pgApprovalResultVO) {
        PayApprovalResponse payApprovalResponse = new PayApprovalResponse();
        payApprovalResponse.setPayAuthRequestId(payApprovalRequest.getPayAuthRequestId());
        payApprovalResponse.setPayApprovalRequestId(payApprovalRequest.getPayApprovalRequestId());
        payApprovalResponse.setSuccess(pgApprovalResultVO.isSuccess());
        payApprovalResponse.setCode(pgApprovalResultVO.getCode());
        payApprovalResponse.setMessage(pgApprovalResultVO.getMessage());

        payApprovalResponseRepository.save(payApprovalResponse);
        return payApprovalResponse;
    }
}
