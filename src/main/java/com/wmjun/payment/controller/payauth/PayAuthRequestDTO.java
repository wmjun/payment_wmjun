package com.wmjun.payment.controller.payauth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Setter
@Getter
public class PayAuthRequestDTO {

    private Long customerId;

    private Long orderId;

    private Long amount;
}
