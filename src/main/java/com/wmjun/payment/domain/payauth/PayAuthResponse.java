package com.wmjun.payment.domain.payauth;

import com.wmjun.payment.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Getter
@Setter
@Entity
@Table(name = "pay_auth_responses")
public class PayAuthResponse extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payAuthResponseId;

    private Long payAuthRequestId;

    private boolean success;

    private String code;

    private String message;

}
