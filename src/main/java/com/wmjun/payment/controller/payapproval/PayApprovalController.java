package com.wmjun.payment.controller.payapproval;

import com.wmjun.payment.exception.pg.PgSystemException;
import com.wmjun.payment.service.payapproval.PayApprovalResponseVO;
import com.wmjun.payment.service.payapproval.PayApprovalService;
import com.wmjun.payment.service.pg.PgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@RestController
@RequestMapping("api/pay-approval")
public class PayApprovalController {

    @Autowired
    private PayApprovalService payApprovalService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PayApprovalResponseDTO approval(@RequestBody PayApprovalRequestDTO requestDTO) {
        try {
            PayApprovalResponseVO responseVO = payApprovalService.approval(requestDTO);
            return new PayApprovalResponseDTO(responseVO.isSuccess(), responseVO.getCode(), responseVO.getMessage());
        } catch (PgSystemException e) {
            return new PayApprovalResponseDTO(false, PgService.PG_SYSTEM_ERROR_CODE, PgService.PG_SYSTEM_ERROR_MSG);
        }
    }
}
