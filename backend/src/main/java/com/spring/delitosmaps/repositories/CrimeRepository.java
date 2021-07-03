package com.spring.delitosmaps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.delitosmaps.entities.Crime;

@Repository
public interface CrimeRepository extends JpaRepository<Crime, Long>{

}
