package sarascript.technomads.EcommerceShop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sarascript.technomads.EcommerceShop.common.ApiResponse;
import sarascript.technomads.EcommerceShop.model.Category;
import sarascript.technomads.EcommerceShop.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return  new ResponseEntity<>(new ApiResponse(true, "successfully created category!"), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public List listCategories(){
        return categoryService.listCategory();
    }
    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category){
        if(!categoryService.findById(categoryId)){
            return new ResponseEntity<>(new ApiResponse(false,"category doesn't exist"), HttpStatus.NOT_FOUND);
        }
        categoryService.updateCategory(categoryId, category);
        return new ResponseEntity<>(new ApiResponse(true, "successfully updated"), HttpStatus.OK);
    }
    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") int categoryId) {
        if (!categoryService.findById(categoryId)) {
            return new ResponseEntity<>(new ApiResponse(false, "category doesn't exist"), HttpStatus.NOT_FOUND);
        }
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse(true, "category successfully deleted"), HttpStatus.OK);
    }
}
