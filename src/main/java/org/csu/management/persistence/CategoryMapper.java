package org.csu.management.persistence;

import org.csu.management.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    Category getCategory(String categoryId);
    List<Category> getCategoryList();
    void addCategory(Category category);//这是新增一个category
    void updateCategory(Category category);//这是修改一个category
    void deleteCategory(Category category);//这是删除一个category

}
