package com.jpaul.controller;

import com.jpaul.response.CategoryResponseRest;
import com.jpaul.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CategoryRestController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        ResponseEntity<CategoryResponseRest> categoryResponseRestResponseEntity = iCategoryService.search();
        return categoryResponseRestResponseEntity;
    }
}
