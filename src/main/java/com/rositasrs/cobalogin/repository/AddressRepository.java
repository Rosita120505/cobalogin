package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.Address;
import com.rositasrs.cobalogin.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<Address> findByAddressId (Integer addressId);

}
