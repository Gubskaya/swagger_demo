package gradle.crud_products.services;


import gradle.crud_products.dto.ProductDto;
import gradle.crud_products.entities.Product;
import gradle.crud_products.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    final
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDto getById(Long id){
        Product product = productRepository.findById(id).get();
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());

        return productDto;
    }
    public List<ProductDto> getAllProducts(){
       List<Product> products = productRepository.findAll();
       ProductDto dto;
       List<ProductDto> dtos = new ArrayList<>();
       for(Product product: products){
           dto = entityToDto(product);
           dtos.add(dto);
       }return dtos;
    }
    public ProductDto entityToDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        return dto;
    }

    public Product saveProduct(Product product){
       Product product1 = productRepository.save(product);
       return product1;
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
