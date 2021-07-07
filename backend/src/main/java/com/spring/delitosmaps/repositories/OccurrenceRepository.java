package com.spring.delitosmaps.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.delitosmaps.entities.Occurrence;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long>{

	@Query("SELECT obj FROM Occurrence obj WHERE "
			+ "(coalesce(:min, null) IS NULL OR obj.moment >= :min) AND "
			+ "(coalesce(:max, null) IS NULL OR obj.moment <= :max)")
	Page<Occurrence> findByMoments(Instant min, Instant max, Pageable pageable);
}
