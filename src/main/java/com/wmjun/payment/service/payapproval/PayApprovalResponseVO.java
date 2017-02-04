package com.wmjun.payment.service.payapproval;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayApprovalResponseVO {
    private boolean success;

    private String code;

    private String message;

}
