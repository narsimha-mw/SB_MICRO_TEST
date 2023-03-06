package com.ics.performances.repository;

import com.ics.performances.model.ActiveOutlets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveOutletsRepository extends JpaRepository<ActiveOutlets, Integer> {
}
