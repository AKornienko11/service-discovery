package com.example.servicediscovery.repository;

import com.example.servicediscovery.dto.IntegrationInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IntegrationRepository extends JpaRepository<IntegrationInfoEntity, Long> {
}
