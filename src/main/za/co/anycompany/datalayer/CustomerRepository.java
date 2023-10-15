package main.za.co.anycompany.datalayer;

import main.za.co.anycompany.model.Customer;
import main.za.co.anycompany.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerRepository {
    public static Customer load(int customerId) throws SQLException {
        Statement statement = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE customerId = ?")) {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE CUSTOMER (customerId int auto_increment primary key not null, NAME, COUNTRY, DATE_OF_BIRTH");
            preparedStatement.setInt(1, customerId);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setName(resultSet.getString("NAME"));
                    customer.setCountry(resultSet.getString("COUNTRY"));
                    customer.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"));
                    customer.setCustomerId(resultSet.getInt("customerId"));
                    return customer;
                }

            } catch (SQLException e) {
                e.getMessage();
            }
        }

        return null;
    }
    public static List<Order> loadCustomerOrders(int customerId){
        List<Order> orders = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ORDERS WHERE customer_id = ?");){
            preparedStatement.setInt(1, customerId);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                Order order = new Order();
                while (resultSet.next()){
                    order.setOrderId(resultSet.getInt("orderId"));
                    order.setAmount(resultSet.getDouble("amount"));
                    order.setVAT(resultSet.getDouble("vat"));
                    orders.add(order);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }
}
