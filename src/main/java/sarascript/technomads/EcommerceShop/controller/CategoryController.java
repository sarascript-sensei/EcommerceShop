package sarascript.technomads.EcommerceShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sarascript.technomads.EcommerceShop.model.Category;
import sarascript.technomads.EcommerceShop.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "success";
    }
    @GetMapping("/list")
    public List listCategories(){
        return categoryService.listCategory();
    }
}
