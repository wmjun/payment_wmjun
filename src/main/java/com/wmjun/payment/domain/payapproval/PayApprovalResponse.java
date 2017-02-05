package com.wmjun.payment.domain.payapproval;

import com.wmjun.payment.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by wmjun on 2017. 2. 5..
 */
@Entity
@Getter
@Setter
@Table(name = "pay_approval_responses")
public class PayApprovalResponse extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payApprovalResponseId;

    private Long payAuthRequestId;

    private Long payApprovalRequestId;

    private boolean success;

    private String code;

    private String message;
}
