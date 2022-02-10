package ir.ac.kntu.order;

import ir.ac.kntu.comment.Comment;
import ir.ac.kntu.customer.Customer;
import ir.ac.kntu.food.Food;
import ir.ac.kntu.restaurant.Restaurant;
import ir.ac.kntu.delivery.Delivery;

import java.time.LocalTime;

public class Order {
    private Customer customer;

    private Food food;

    private Restaurant restaurant;

    private Delivery delivery;

    private String destination;

    private OrderStatus orderStatus = OrderStatus.PROCESSING;

    private LocalTime deliveryTime;

    private Comment restaurantComment;

    private Comment foodComment;

    private Comment deliveryComment;

    public Order(Customer customer, Food food, Restaurant restaurant, String destination) {
        this.customer = customer;
        this.food = food;
        this.restaurant = restaurant;
        this.destination = destination;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Food getFood() {
        return food;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Comment getRestaurantComment() {
        return restaurantComment;
    }

    public void setRestaurantComment(Comment restaurantComment) {
        this.restaurantComment = restaurantComment;
    }

    public Comment getFoodComment() {
        return foodComment;
    }

    public void setFoodComment(Comment foodComment) {
        this.foodComment = foodComment;
    }

    public Comment getDeliveryComment() {
        return deliveryComment;
    }

    public void setDeliveryComment(Comment deliveryComment) {
        this.deliveryComment = deliveryComment;
    }

    @Override
    public String toString() {
        if (orderStatus == OrderStatus.DELIVERED) {
            return "Customer" + customer.getUserName() + "\nFood : " + food.getName() + "\nPrice : " +
                    food.getPrice() + "\nRestaurant : " + restaurant + "\nOrder status: " + orderStatus +
                    "\nDelivered at : " + deliveryTime;
        }
        return "Customer" + customer.getUserName() + "\nFood : " + food.getName() + "\nPrice : " +
                food.getPrice() + "\nRestaurant : " + restaurant + "\nOrder status: " + orderStatus;
    }
}
