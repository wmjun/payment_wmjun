package com.wmjun.payment.service.payauth;

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
public class PayAuthResponseVO {
    private boolean success;

    private String code;

    private String message;

}
