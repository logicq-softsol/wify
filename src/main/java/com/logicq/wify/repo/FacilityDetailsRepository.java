package com.logicq.wify.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.wify.model.FacilityDetails;

@Transactional
public interface FacilityDetailsRepository extends JpaRepository<FacilityDetails, Long> {


}
