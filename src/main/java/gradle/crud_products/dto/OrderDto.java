package gradle.crud_products.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private LocalDate shipDate;
    private LocalDate createdAt;
    private String status;
    private Boolean complete;
    private List<ProductDto> product;
}
