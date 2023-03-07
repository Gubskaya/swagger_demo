package gradle.crud_products.controllers;

import gradle.crud_products.dto.ProductDto;
import gradle.crud_products.entities.Product;
import gradle.crud_products.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    final
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    ProductDto getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @GetMapping("/all")
    List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
