package com.wmjun.payment.controller.payauth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayAuthResponseDTO {

    private boolean success;

    private String code;

    private String message;
}
