package com.jpaul.dao;

import com.jpaul.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category, Long> {


}
