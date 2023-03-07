package gradle.crud_products.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate shipDate;
    private LocalDate createdAt;
    private String status;
    private Boolean complete;
    @OneToMany
    private List<Product> product;


}