package com.wmjun.payment.domain.payauth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wmjun on 2017. 1. 31..
 */
@Repository
public interface PayAuthRequestRepository extends JpaRepository<PayAuthRequest, Long> {

}
