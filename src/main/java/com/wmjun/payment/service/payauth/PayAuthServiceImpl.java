package com.wmjun.payment.service.payauth;

import com.wmjun.payment.controller.payauth.PayAuthRequestDTO;
import com.wmjun.payment.domain.payauth.PayAuthRequest;
import com.wmjun.payment.domain.payauth.PayAuthRequestRepository;
import com.wmjun.payment.domain.payauth.PayAuthResponse;
import com.wmjun.payment.domain.payauth.PayAuthResponseRepository;
import com.wmjun.payment.exception.pg.PgSystemException;
import com.wmjun.payment.service.pg.MockPgAuthResultVO;
import com.wmjun.payment.service.pg.PgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wmjun on 2017. 1. 31..
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class PayAuthServiceImpl implements PayAuthService {

    @Autowired
    private PayAuthRequestRepository payAuthRequestRepository;

    @Autowired
    private PayAuthResponseRepository payAuthResponseRepository;

    @Autowired
    private PgService pgService;


    @Override
    public List<PayAuthRequest> getAll() {
        return payAuthRequestRepository.findAll();
    }

    @Override
    public PayAuthRequest get(Long id) {
        return payAuthRequestRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public PayAuthResponseVO requestPayAuth(PayAuthRequestDTO requestDTO) throws PgSystemException {
        //TODO PayAuthRequest 데이타 저장 시점은 언제가 좋은가 ? (PG로 인증 요청이 성공 했을 때 저장 / 인증 요청 시도만 해도 저장)

        PayAuthRequest payAuthRequest = savePayAuthRequest(requestDTO);
        MockPgAuthResultVO pgAuthResult = pgService.requestAuth();
        PayAuthResponse payAuthResponse = savePayAuthResponse(pgAuthResult, payAuthRequest.getPayAuthRequestId());

        // TODO: 2017. 2. 4. : MockPG에서는 PG 결과 값을 그대로 전달 받았지만, PG사가 여러개일 시 매핑을 통해 PayAuthResponse에 다르게 저장.
        return new PayAuthResponseVO(payAuthResponse.isSuccess(), payAuthResponse.getCode(), payAuthResponse.getMessage());


    }

    @Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
    private PayAuthRequest savePayAuthRequest(PayAuthRequestDTO requestDTO) {
        PayAuthRequest payAuthRequest = new PayAuthRequest();
        payAuthRequest.setAmount(requestDTO.getAmount());
        payAuthRequest.setCustomerId(requestDTO.getCustomerId());
        payAuthRequest.setOrderId(requestDTO.getOrderId());
        payAuthRequest.setPgId(1L); //TODO : pg 분배 관리자에 의해 자동으로 설정 되어야 함

        return payAuthRequestRepository.save(payAuthRequest);
    }

    private PayAuthResponse savePayAuthResponse(MockPgAuthResultVO pgAuthResultVO, Long payAuthRequestId) {
        PayAuthResponse payAuthResponse = new PayAuthResponse();
        payAuthResponse.setSuccess(pgAuthResultVO.isSuccess());
        payAuthResponse.setCode(pgAuthResultVO.getCode());
        payAuthResponse.setMessage(pgAuthResultVO.getMessage());
        payAuthResponse.setPayAuthRequestId(payAuthRequestId);

        return payAuthResponseRepository.save(payAuthResponse);
    }
}
