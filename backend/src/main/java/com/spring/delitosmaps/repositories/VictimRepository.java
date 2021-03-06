package com.spring.delitosmaps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.delitosmaps.entities.Victim;

@Repository
public interface VictimRepository extends JpaRepository<Victim, Long>{

}
