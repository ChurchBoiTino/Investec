import main.za.co.anycompany.datalayer.CustomerRepository;
import main.za.co.anycompany.model.Customer;
import main.za.co.anycompany.service.CustomerService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    CustomerService customerService = new CustomerService();
    Customer customer = new Customer();
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        new Main().mainMenu();
    }

    public void mainMenu() throws SQLException {
        String selection = "";

        System.out.println("Hello \n" + "Please select an option from the menu: \n" + "1. Place an order. \n" + "2. Retrieve a customer. \n" + "3. Load all customers. \n" + "0. Exit \n");
        System.out.print("Selection: ");

        selection = input.nextLine();
        String choice = "";

        switch (selection){
            case "1":
                System.out.println("Are you an existing customer?: \n" + "1. Yes. \n" + "2. No \n");
                System.out.print("Selection: ");
                choice = input.nextLine();
                if(choice.equalsIgnoreCase("1"))
                    customerService.retrieveCustomer();
                if (choice.equalsIgnoreCase("2"))
                    customerService.createCustomer();
                break;
            case "2":
                customerService.retrieveCustomer();
                break;
            case "3":
                CustomerRepository.loadCustomerOrders(customer.getCustomerId());
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection. Try again");
                mainMenu();
        }
    }
}