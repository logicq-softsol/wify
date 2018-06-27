package com.logicq.wify.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.wify.model.FacilityRequest;

@Transactional
public interface FacilityRequestRepository extends JpaRepository<FacilityRequest, Long> {

	
	List<FacilityRequest> findByStatus(String status);
}
