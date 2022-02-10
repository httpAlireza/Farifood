package ir.ac.kntu.restaurant;

import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Objects;

import ir.ac.kntu.comment.Comment;
import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.food.Food;

public class Restaurant {
    private String name;

    private String address;

    private PriceType priceType;

    private double score = 5;

    private WorkingHours workingHours = new WorkingHours();

    private FoodMenu menu = new FoodMenu();

    private ArrayList<Comment> comments = new ArrayList<>();

    private ArrayList<Delivery> deliveries = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String name, String address, PriceType priceType, WorkingHours workingHours) {
        this.name = name;
        this.address = address;
        this.priceType = priceType;
        this.workingHours = workingHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    public double getScore() {
        return score;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public void addAComment(Comment comment) {
        if (comments.size() == 0) {
            score = comment.getScore();
        } else {
            score = ((score * comments.size()) + comment.getScore()) / (comments.size() + 1);
        }
        comments.add(comment);
    }

    public void addADelivery(Delivery delivery) {
        deliveries.add(delivery);
    }

    public void removeADelivery(Delivery delivery) {
        deliveries.remove(delivery);
    }

    public void addAFoodToMenu(String foodName, int price, int cookTime) {
        menu.addFood(foodName, price, cookTime, this);
    }

    public void removeFoodFromMenu(Food food) {
        menu.removeFood(food);
    }

    public boolean menuContains(String foodName) {
        return menu.contains(foodName);
    }

    public void printMenu() {
        menu.printMenu();
    }

    public ArrayList<Food> getFoods() {
        return menu.getFoods();
    }

    public void setFoods(ArrayList<Food> foods) {
        menu.setFoods(foods);
    }

    public boolean isOpen() {
        if (workingHours.getStartTime().compareTo(LocalTime.now()) < 0
                && workingHours.getCloseTime().compareTo(LocalTime.now()) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Restaurant restaurant = (Restaurant) object;
        return Objects.equals(getName(), restaurant.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
