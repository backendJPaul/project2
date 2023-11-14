package com.jpaul.dao;

import com.jpaul.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends JpaRepository<Category, Long> {


}
