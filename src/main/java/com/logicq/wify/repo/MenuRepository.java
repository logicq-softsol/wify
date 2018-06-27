package com.logicq.wify.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.wify.model.Menu;

@Transactional
public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findByAvlType(String avltype);

	List<Menu> findByType(String type);
}
