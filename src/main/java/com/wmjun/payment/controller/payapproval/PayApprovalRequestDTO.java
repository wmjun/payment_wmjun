package com.wmjun.payment.controller.payapproval;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Getter
@Setter
public class PayApprovalRequestDTO {

    private Long payAuthRequestId;

    private Long customerId;

    private Long orderId;

    private Long amount;

}
