package com.jpaul.response;

import com.jpaul.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {
    private List<Category> category;
}
