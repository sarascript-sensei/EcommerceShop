package sarascript.technomads.EcommerceShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarascript.technomads.EcommerceShop.model.Category;
import sarascript.technomads.EcommerceShop.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }

    public void updateCategory(int categoryId, Category newCategory) {
        Category category = categoryRepository.getById(categoryId);
        category.setName(newCategory.getName());
        category.setDescription(newCategory.getDescription());
        category.setImageUrl(newCategory.getImageUrl());
        categoryRepository.save(category);
    }

    public boolean findById(int categoryId) {
        return categoryRepository.findById(categoryId).isPresent();
    }
    public void deleteCategory(int categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
