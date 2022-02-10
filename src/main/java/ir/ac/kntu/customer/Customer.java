package ir.ac.kntu.customer;

import ir.ac.kntu.order.Order;

import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private String userName;

    private String phoneNumber;

    private String address;

    private ArrayList<Order> orderHistory = new ArrayList<>();

    public Customer(String userName, String phoneNumber, String address) {
        this.userName = userName;
        if (phoneNumber.matches("^09[0-9]{9}$")) {
            this.phoneNumber = phoneNumber;
        }
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^09[0-9]{9}$")) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addAOrder(Order order) {
        orderHistory.add(order);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Customer customer = (Customer) object;
        return Objects.equals(getUserName(), customer.getUserName()) &&
                Objects.equals(getPhoneNumber(), customer.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return getUserName() + " - phoneNumber: " + getPhoneNumber();
    }
}
