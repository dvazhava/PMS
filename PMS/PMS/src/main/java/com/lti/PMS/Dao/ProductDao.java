package com.lti.PMS.Dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.lti.PMS.model.Product;


@Repository
@Transactional
public interface ProductDao extends  JpaRepository<Product, Integer> {
    
	@Query(value= " select c from Product c where c.category=?1")
	Optional<Product> findbyCategory(String category);
    
	@Query(value= " select c from Product c where c.name=?1")
	Optional<Product> findByName(String name);
    
	

}
