package com.logicq.wify.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.wify.model.Language;

@Transactional
public interface LanguageRepository extends JpaRepository<Language, Long> {


}
