package ch.schmid.samuel.gymEquip.Service.CategoryService;

import ch.schmid.samuel.gymEquip.Model.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();

    public Category getCategoryById(Long id);

    public Category updateCategory(Long id, Category category);

    public void deleteCategory(Long id);

    public Category createCategory(Category category);

}
