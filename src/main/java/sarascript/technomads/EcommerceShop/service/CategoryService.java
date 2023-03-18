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

    public void createCategory(Category category){
        categoryRepository.save(category);
    }
    public List<Category> listCategory(){
        return categoryRepository.findAll();
    }
}
