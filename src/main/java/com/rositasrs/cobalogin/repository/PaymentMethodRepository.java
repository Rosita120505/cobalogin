package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

    Optional<PaymentMethod> findBypaymentId(Integer paymentId);
}
