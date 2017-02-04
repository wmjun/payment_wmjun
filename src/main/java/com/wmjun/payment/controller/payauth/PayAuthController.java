package com.wmjun.payment.controller.payauth;

import com.wmjun.payment.domain.payauth.PayAuthRequest;
import com.wmjun.payment.exception.pg.PgSystemException;
import com.wmjun.payment.service.payauth.PayAuthService;
import com.wmjun.payment.service.payauth.PayAuthResponseVO;
import com.wmjun.payment.service.pg.PgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wmjun on 2017. 1. 31..
 */
@RestController
@RequestMapping("api/pay-auth-requests")
public class PayAuthController {


    @Autowired
    private PayAuthService payAuthService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PayAuthRequest> getPayAuthRequests() {
        return payAuthService.getAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PayAuthRequest getPayAuthRequest(@PathVariable Long id) {
        return payAuthService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PayAuthResponseDTO requestAuth(@RequestBody PayAuthRequestDTO payAuthRequestDTO) {
        try {
            final PayAuthResponseVO result = payAuthService.requestPayAuth(payAuthRequestDTO);
            return new PayAuthResponseDTO(result.isSuccess(), result.getCode(), result.getMessage());
        } catch (PgSystemException e) {
            return new PayAuthResponseDTO(false, PgService.PG_SYSTEM_ERROR_CODE, PgService.PG_SYSTEM_ERROR_MSG);
        }
    }
}
