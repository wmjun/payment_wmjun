package com.wmjun.payment.domain.payapproval;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Repository
public interface PayApprovalRequestRepository extends JpaRepository<PayApprovalRequest, Long> {
}
