package gradle.crud_products.services;

import gradle.crud_products.dto.CategoryDto;
import gradle.crud_products.entities.Category;
import gradle.crud_products.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService {

    final
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto getById(Long id){
        Category category = categoryRepository.findById(id).get();
        CategoryDto dto = entityToDto(category);

        return dto;
    }

    public CategoryDto entityToDto(Category category){
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());

        return dto;

    }

    public List<CategoryDto> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        CategoryDto categoryDto;
        List<CategoryDto> dtos = new ArrayList<>();
        for(Category category: categories){
            categoryDto = entityToDto(category);
            dtos.add(categoryDto);
        }return dtos;
     }

     public Category addNewCategory(Category category){
        return categoryRepository.save(category);
     }

     public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
     }
}
