package ir.ac.kntu.main;

import ir.ac.kntu.customer.Customer;
import ir.ac.kntu.order.Order;

public class HandleCustomerMenu {
    public boolean customerMenu() {
        System.out.println("1-Add a new customer");
        System.out.println("2-Show a customer information");
        System.out.println("3-Show orders of a customer");
        System.out.println("4-Show comments of a customer");
        System.out.println("5-Change a customer information");
        System.out.println("6-Remove a customer");
        System.out.println("0-Back");
        int option = chooseInRange(0, 6);
        return customerMenuHandler(option);
    }

    private boolean customerMenuHandler(int option) {
        switch (option) {
            case 1:
                addANewCustomer();
                break;
            case 2:
                showACustomerInformation();
                break;
            case 3:
                showOrdersOfACustomer();
                break;
            case 4:
                showCommentsOfACustomer();
                break;
            case 5:
                changeACustomerInformation();
                break;
            case 6:
                removeACustomer();
                break;
            case 0:
                return true;
            default:
                break;
        }
        System.out.println("\n--------------------------------------------");
        System.out.println("***Customer menu***\n");
        return customerMenu();
    }

    private void addANewCustomer() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Add a new customer***\n");
        System.out.print("Enter the username: ");
        String userName = ScannerWrapper.getInstance().nextLine().trim();
        System.out.print("Phone number: ");
        String phoneNumber = ScannerWrapper.getInstance().nextLine().trim();
        while (!phoneNumber.matches("^09[0-9]{9}$")) {
            System.out.println("Format of input is wrong.(Right format: 09XXXXXXXXX)");
            System.out.print("Try again: ");
            phoneNumber = ScannerWrapper.getInstance().nextLine().trim();
        }
        System.out.print("Address: ");
        String address = ScannerWrapper.getInstance().nextLine();
        Customer customer = new Customer(userName, phoneNumber, address);
        DataBase.addACustomer(customer);
        System.out.println("***New customer added successfully***\n");
    }

    private void showACustomerInformation() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Show a customer information***\n");
        Customer customer = chooseCustomer();
        if (customer == null) {
            return;
        }
        System.out.println("\n--------------------------------------------");
        System.out.println("***Information of: " + customer.getUserName() + "***\n");
        System.out.println("User name: " + customer.getUserName());
        System.out.println("Phone number: " + customer.getPhoneNumber());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Number of orders: " + customer.getOrderHistory().size());
    }

    private void showOrdersOfACustomer() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Showing orders of a customer***\n");
        Customer customer = chooseCustomer();
        if (customer == null) {
            return;
        }
        System.out.println("\n--------------------------------------------");
        System.out.println("***Showing orders of " + customer.getUserName() + "***\n");
        if (customer.getOrderHistory().size() == 0) {
            System.out.println("***This list is empty***\n");
        } else {
            for (Order order : customer.getOrderHistory()) {
                System.out.println(order + "\n----");
            }
        }
    }

    private void showCommentsOfACustomer() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Showing comments of a customer***\n");
        Customer customer = chooseCustomer();
        if (customer == null) {
            return;
        }
        System.out.println("\n--------------------------------------------");
        System.out.println("***Showing comments of " + customer.getUserName() + "***\n");
        if (customer.getOrderHistory().size() == 0) {
            System.out.println("***This list is empty***\n");
        } else {
            for (Order order : customer.getOrderHistory()) {
                System.out.println("Restaurant: " + order.getRestaurant().getName());
                System.out.println(order.getRestaurantComment());
                System.out.println("Food: " + order.getFood().getName());
                System.out.println(order.getFoodComment());
                System.out.println("Delivery: " + order.getDelivery().getId());
                System.out.println(order.getDeliveryComment());
                System.out.println("\n------------------");
            }
        }
    }

    private void changeACustomerInformation() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Change a customer information***\n");
        Customer customer = chooseCustomer();
        if (customer == null) {
            return;
        }
        System.out.println("\n--------------------------------------------");
        System.out.println("***Change " + customer.getUserName() + " information***\n");
        System.out.println("1-Change user name");
        System.out.println("2-Change phone number");
        System.out.println("3-Change address");
        System.out.println("0-Back");
        int option = chooseInRange(0, 3);
        switch (option) {
            case 1:
                changeCustomerUserName(customer);
                break;
            case 2:
                changeCustomerPhoneNumber(customer);
                break;
            case 3:
                changeCustomerAddress(customer);
                break;
            default:
                return;
        }
    }

    private void changeCustomerUserName(Customer customer) {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Change " + customer.getUserName() + " user name***\n");
        System.out.print("Enter new user name: ");
        String newUserName = ScannerWrapper.getInstance().nextLine().trim();
        customer.setUserName(newUserName);
        System.out.println("***User name changed successfully***\n");
    }

    private void changeCustomerPhoneNumber(Customer customer) {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Change " + customer.getUserName() + " phone number***\n");
        System.out.print("Enter new phone number: ");
        String newPhoneNumber = ScannerWrapper.getInstance().nextLine().trim();
        while (!newPhoneNumber.matches("^09[0-9]{9}$")) {
            System.out.println("Format of input is wrong.(Right format: 09XXXXXXXXX)");
            System.out.print("Try again: ");
            newPhoneNumber = ScannerWrapper.getInstance().nextLine().trim();
        }
        customer.setPhoneNumber(newPhoneNumber);
        System.out.println("***Phone number changed successfully***\n");
    }

    private void changeCustomerAddress(Customer customer) {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Change " + customer.getUserName() + " address***\n");
        System.out.print("Enter new address: ");
        String newAddress = ScannerWrapper.getInstance().nextLine().trim();
        customer.setAddress(newAddress);
        System.out.println("***Address changed successfully***\n");
    }

    private void removeACustomer() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Remove a customer***\n");
        Customer customer = chooseCustomer();
        if (customer == null) {
            return;
        }
        String customerUserName = customer.getUserName();
        if (makeSure(customerUserName)) {
            DataBase.removeACustomer(customer);
            System.out.println("***" + customer.getUserName() + " successfully removed***");
        }
    }

    private int chooseInRange(int from, int to) {
        System.out.print("->");
        int option = ScannerWrapper.getInstance().nextInt();
        while (!(from <= option && option <= to)) {
            System.out.println("***Invalid input***\n");
            System.out.print("->");
            option = ScannerWrapper.getInstance().nextInt();
        }
        return option;
    }

    private Customer chooseCustomer() {
        if (DataBase.getCustomers().size() == 0) {
            System.out.println("***This list is empty***\n");
            return null;
        }
        for (int i=0; i< DataBase.getCustomers().size(); i++) {
            System.out.println((i+1) + "-" + DataBase.getCustomers().get(i));
        }
        System.out.println("0-Back");
        int option = chooseInRange(0, DataBase.getDeliveries().size()) - 1;
        if (option + 1 == 0) {
            return null;
        }
        return DataBase.getCustomers().get(option);
    }

    private boolean makeSure(String name) {
        System.out.println("Are you sure you want to remove " + name + " from this list?");
        System.out.println("1-Yes");
        System.out.println("2-No");
        int option = chooseInRange(1, 2);
        if (option == 1) {
            return true;
        }
        return false;
    }
}
