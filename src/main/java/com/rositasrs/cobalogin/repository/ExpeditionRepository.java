package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.Expedition;
import com.rositasrs.cobalogin.model.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpeditionRepository extends JpaRepository<Expedition, Integer> {
    Optional<Expedition> findByDeliveryCode (Integer deliveryCode);
}
