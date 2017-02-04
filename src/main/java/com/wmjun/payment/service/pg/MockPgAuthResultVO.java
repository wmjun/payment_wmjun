package com.wmjun.payment.service.pg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Setter
@Getter
public class MockPgAuthResultVO {

    private boolean success;

    private String code;

    private String message;

    public static MockPgAuthResultVO newSuccessResult(){
        MockPgAuthResultVO resultVO = new MockPgAuthResultVO();
        resultVO.setSuccess(true);
        resultVO.setCode("0000");
        resultVO.setMessage("정상 처리");
        return resultVO;

    }
}
