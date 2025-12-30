package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Order;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
@PostMapping
public ResponseEntity<Order> createOrder(@RequestBody Order order){
    Order o1=orderService.createOrder(order);
    return new ResponseEntity<>(o1,HttpStatus.CREATED);
}
@GetMapping
public ResponseEntity<List<Order>> getAllOrders(){
    return new ResponseEntity<>(orderService.readAllOrder(),HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<Order> getById(@PathVariable Long id){
    return new ResponseEntity<>(orderService.findOrderById(id),HttpStatus.OK);
}
@PutMapping("/{id}")
public ResponseEntity<Order> updateOrder(@PathVariable Long id,@RequestBody Order ipOrder){
    return new ResponseEntity<>(orderService.updateOrder(id,ipOrder),HttpStatus.OK);
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteById(@PathVariable Long id){
    orderService.deleteOrder(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}
}
