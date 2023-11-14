package com.jpaul.service;

import com.jpaul.dao.ICategoryDao;
import com.jpaul.model.Category;
import com.jpaul.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            categoryResponseRest.setMetadata("Response ok","00","Response Successful search");
        }
        catch (Exception e){
            categoryResponseRest.setMetadata("Response nok", "-1", "Error UnSuccessful search");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {

        CategoryResponseRest categoryResponseRest = new CategoryResponseRest();
        List<Category> categoryList = new ArrayList<>();
        try{
            Optional<Category> optionalCategory = iCategoryDao.findById(id);
            if(optionalCategory.isPresent()){
                categoryList.add(optionalCategory.get());
                categoryResponseRest.getCategoryResponse().setCategory(categoryList);
                categoryResponseRest.setMetadata("Response ok","00","Response Successful findById");
            }
            else {
                categoryResponseRest.setMetadata("Response nok", "-1", "Error UnSuccessful findById");
                return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            categoryResponseRest.setMetadata("Response nok", "-1", "Error UnSuccessful findById");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CategoryResponseRest>(categoryResponseRest, HttpStatus.OK);
    }
}
