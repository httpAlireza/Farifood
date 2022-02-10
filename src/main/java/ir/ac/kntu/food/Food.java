package ir.ac.kntu.food;

import ir.ac.kntu.comment.Comment;
import ir.ac.kntu.restaurant.Restaurant;
import java.util.ArrayList;
import java.util.Objects;

public class Food {
    private String name;

    private int price;

    private int cookTime;

    private Restaurant restaurant;

    private double score = 5.0;

    private ArrayList<Comment> commentHistory = new ArrayList<>();

    public Food() {
    }

    public Food(String name) {
        name = name.toLowerCase().trim();
        this.name = name;
    }

    public Food(String name, int price, int cookTime, Restaurant restaurant) {
        name = name.toLowerCase().trim();
        this.name = name;
        this.price = price;
        this.cookTime = cookTime;
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.toLowerCase().trim();
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double getScore() {
        return score;
    }

    public ArrayList<Comment> getCommentHistory() {
        return commentHistory;
    }

    public void addAComment(Comment comment) {
        if (commentHistory.size() == 0) {
            score = comment.getScore();
        } else {
            score = ((score * commentHistory.size()) + comment.getScore()) / (commentHistory.size() + 1);
        }
        commentHistory.add(comment);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Food food = (Food) object;
        return Objects.equals(getName(), food.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name + " :    price:" + price + "    --> score:" + (Double.toString(score) + "0").substring(0, 4) +
                " , " + commentHistory.size() + " vote(s)\n";
    }
}
