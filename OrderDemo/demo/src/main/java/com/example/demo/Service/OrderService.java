package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Order;
import com.example.demo.Repository.Orderrepo;

@Service
public class OrderService {
    private final Orderrepo orderrepo;

    public OrderService(Orderrepo orderrepo) {
        this.orderrepo = orderrepo;
    }
    public Order createOrder(Order order){
        return orderrepo.save(order);
    }
    public List<Order> readAllOrder(){
        return orderrepo.findAll();

    }
    public Order findOrderById(Long id){
        return orderrepo.findById(id).orElse(null);
    }
    public Order updateOrder(Long id, Order updateOrder){
        return orderrepo.findById(id)
        .map(e->{
            e.setAmount(updateOrder.getAmount());
            e.setCustomerName(updateOrder.getCustomerName());
            e.setStatus(updateOrder.getStatus());
            return orderrepo.save(e);
        }).orElse(null);
    }
    public void deleteOrder(Long id){
        orderrepo.deleteById(id);
    }
    
}
