package gradle.crud_products.controllers;

import gradle.crud_products.dto.CategoryDto;
import gradle.crud_products.entities.Category;
import gradle.crud_products.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    final
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    CategoryDto getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @GetMapping("/all")
    List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/save")
    Category saveNewCategory(@RequestBody Category category){
        return categoryService.addNewCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
