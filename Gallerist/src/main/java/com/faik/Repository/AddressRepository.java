package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
