package com.require4testing.repository;

import com.require4testing.model.Testfall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestfallRepository extends JpaRepository<Testfall, Long> {
}
