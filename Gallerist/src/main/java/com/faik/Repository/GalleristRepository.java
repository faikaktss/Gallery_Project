package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Model.Gallerist;

@Repository
public interface GalleristRepository extends JpaRepository<Gallerist, Long>{
	
}
