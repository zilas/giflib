package com.teamtreehouse.giflib.data;

import com.teamtreehouse.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "human"),
            new Category(2, "machine"),
            new Category(3, "nature")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    //finds by element number in queue
    public Category findCategoryById(int id) {
        return ALL_CATEGORIES.get(id);
    }
    //finds by real parameter id
    public Category findByUserId(int id) {
        for (Category category : ALL_CATEGORIES){
            if (category.getId() == id){
                return category;
            }
        }
        return null;
    }

}