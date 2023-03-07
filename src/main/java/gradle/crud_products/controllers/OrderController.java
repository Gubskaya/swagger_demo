package gradle.crud_products.controllers;

import gradle.crud_products.dto.OrderDto;
import gradle.crud_products.entities.Order;
import gradle.crud_products.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    final
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    OrderDto getById(@PathVariable Long id){
        return orderService.getById(id);
    }

   /* @GetMapping("/all")
    List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }*/

 /*   @PostMapping("/save")
    Order saveNewOrder(@RequestBody Order order){
        return orderService.saveNewOrder(order);
    }*/

    @DeleteMapping("/delete/{id}")
    void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
