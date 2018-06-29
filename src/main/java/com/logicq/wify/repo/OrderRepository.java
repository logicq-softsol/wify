package com.logicq.wify.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.wify.model.OrderDetails;

@Transactional
public interface OrderRepository extends JpaRepository<OrderDetails, String> {

	public List<OrderDetails> findTop20ByOrderByOrderTimeDesc();

	public List<OrderDetails> findTop20ByOrderByOrderStatus(String orderStatus);
	
	List<OrderDetails> findByTableName(Integer tableName);
	
	   @Query("select o from OrderDetails o where o.orderStatus != :orderStatus")
	public List<OrderDetails> findByOrderStatusNot(@Param("orderStatus") String orderStatus);
}
