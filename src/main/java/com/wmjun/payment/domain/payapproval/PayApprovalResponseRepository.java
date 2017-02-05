package com.wmjun.payment.domain.payapproval;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wmjun on 2017. 2. 5..
 */
@Repository
public interface PayApprovalResponseRepository extends JpaRepository<PayApprovalResponse, Long> {
}
