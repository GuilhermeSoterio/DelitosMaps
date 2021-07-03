package com.spring.delitosmaps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.delitosmaps.entities.Occurrence;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long>{

}
