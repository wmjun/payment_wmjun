package com.wmjun.payment.service.pg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Getter
@Setter
public class MockPgApprovalResultVO {

    private boolean success;

    private String code;

    private String message;

    public static MockPgApprovalResultVO newSuccessResult(){
        MockPgApprovalResultVO resultVO = new MockPgApprovalResultVO();
        resultVO.setSuccess(true);
        resultVO.setCode("0000");
        resultVO.setMessage("정상 처리");
        return resultVO;

    }


}
