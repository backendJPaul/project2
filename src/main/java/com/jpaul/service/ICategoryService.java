package com.jpaul.service;

import com.jpaul.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    public ResponseEntity<CategoryResponseRest> search();
}
