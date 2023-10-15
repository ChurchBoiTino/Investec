package main.za.co.anycompany.service;

import main.za.co.anycompany.datalayer.CustomerRepository;
import main.za.co.anycompany.model.Customer;
import main.za.co.anycompany.model.Order;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerService {
    private String name;
    private String country;
    private String dOB;
    private Customer customer = new Customer();
    Scanner userInput = new Scanner(System.in);
    Order order = new Order();

    public void createCustomer() throws SQLException {
        System.out.print("Enter your name: ");
        name = userInput.nextLine();
        customer.setName(name);

        System.out.print("Enter your country: ");
        country = userInput.nextLine();
        customer.setCountry(country);

        System.out.print("Enter your date of birth: ");
        dOB = userInput.nextLine();
        customer.setCountry(dOB);

        userInput.close();

        CustomerRepository.load(customer.getCustomerId());
    }

    public void retrieveCustomer() throws SQLException {
        CustomerRepository.load(customer.getCustomerId());
    }


}
