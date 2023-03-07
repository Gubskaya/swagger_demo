package gradle.crud_products.services;

import gradle.crud_products.dto.OrderDto;
import gradle.crud_products.entities.Order;
import gradle.crud_products.repositories.OrderRepository;
import org.springframework.stereotype.Service;
@Service
public class OrderService {

    final
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public OrderDto getById(Long id){
        Order order = (Order) orderRepository.findById(id).get();
        OrderDto dto = entityToDto(order);
        return dto;
    }

    public OrderDto entityToDto(Order order){
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setShipDate(order.getShipDate());
        dto.setStatus(order.getStatus());
        return dto;
    }

    /*public List<OrderDto> getAllOrders(){
        List<Order> orders = orderRepository.findAll();

        List<OrderDto> dtos = new ArrayList<>();
        OrderDto dto;
        for(Order order: orders){
            dto = entityToDto(order);
            dtos.add(dto);
        }return dtos;
    }*/

  /*  public Order saveNewOrder(Order order){
        return orderRepository.save(order);
    }
*/
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
