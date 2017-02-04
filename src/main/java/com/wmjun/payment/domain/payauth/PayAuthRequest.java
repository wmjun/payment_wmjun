package com.wmjun.payment.domain.payauth;

import com.wmjun.payment.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by wmjun on 2017. 1. 31..
 */

@Getter
@Setter
@Entity
@Table(name = "pay_auth_requests")
public class PayAuthRequest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payAuthRequestId;

    private Long customerId;

    private Long orderId;

    private Long pgId;

    private Long amount;

}
