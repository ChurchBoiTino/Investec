package main.za.co.anycompany.service;

import main.za.co.anycompany.datalayer.CustomerRepository;
import main.za.co.anycompany.datalayer.OrderRepository;
import main.za.co.anycompany.model.Customer;
import main.za.co.anycompany.model.Order;

import java.sql.SQLException;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    public boolean placeOrder(Order order, int customerID) throws SQLException {
        Customer customer = CustomerRepository.load(customerID);

        if(order.getAmount() == 0){
            return false;
        }

        if(customer.getCountry() == "UK"){
            order.setVAT(0.2d);
        }
        else {
            order.setVAT(0);
        }

        orderRepository.save(order);

        return true;
    }
}