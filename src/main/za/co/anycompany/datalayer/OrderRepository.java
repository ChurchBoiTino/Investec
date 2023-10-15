package main.za.co.anycompany.datalayer;


import main.za.co.anycompany.model.Order;

import java.sql.*;

public class OrderRepository {
    public void save(Order order) throws SQLException {
        Statement statement = null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ORDER(oderId, amount, vat) VALUES(?,?,?)");){
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE ORDER (oderId int primary key not null, amount number(10,2), vat number (3,1)), customerId");
            preparedStatement.setInt(1, order.getOrderId());
            preparedStatement.setDouble(2, order.getAmount());
            preparedStatement.setDouble(3, order.getVAT());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
