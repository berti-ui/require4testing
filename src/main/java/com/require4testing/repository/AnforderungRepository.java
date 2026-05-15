package com.require4testing.repository;

import com.require4testing.model.Anforderung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnforderungRepository extends JpaRepository<Anforderung, Long> {
}