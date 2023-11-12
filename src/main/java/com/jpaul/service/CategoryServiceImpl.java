package com.jpaul.service;

import com.jpaul.dao.ICategoryDao;
import com.jpaul.model.Category;
import com.jpaul.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryDao iCategoryDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {
        CategoryResponseRest categoryResponseRest = new CategoryResponseRest();

        try{
            List<Category> categoryList = (List<Category>) iCategoryDao.findAll();
            categoryResponseRest.getCategoryResponse().setCategory(categoryList);
            categoryResponseRest.setMetadata("Response ok","00","Response Successful");
        }
        catch (Exception e){
            categoryResponseRest.setMetadata("Response nok", "-1", "Error UnSuccessful");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.OK);
    }
}
