package com.wmjun.payment.domain.payauth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Repository
public interface PayAuthResponseRepository extends JpaRepository<PayAuthResponse, Long> {

    PayAuthResponse findByPayAuthRequestId(Long payAuthRequestId);
}
