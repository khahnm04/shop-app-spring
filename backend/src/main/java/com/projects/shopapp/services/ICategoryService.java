package com.projects.shopapp.services;

import com.projects.shopapp.dtos.CategoryDTO;
import com.projects.shopapp.models.Category;
import java.util.*;

public interface ICategoryService {

    Category createCategory(CategoryDTO category);

    Category getCategoryById(long id);

    List<Category> getAllCategories();

    Category updateCategory(long categoryId, CategoryDTO category);

    void deleteCategory(long id);

}
