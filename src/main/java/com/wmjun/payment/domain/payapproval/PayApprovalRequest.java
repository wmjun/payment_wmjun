package com.wmjun.payment.domain.payapproval;

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
@Table(name = "pay_approval_requests")
public class PayApprovalRequest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payApprovalRequestId;

    private Long payAuthRequestId;

    private Long customerId;

    private Long orderId;

    private Long amount;

}
