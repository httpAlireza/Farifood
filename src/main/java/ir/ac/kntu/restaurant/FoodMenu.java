package ir.ac.kntu.restaurant;

import java.util.ArrayList;
import ir.ac.kntu.comment.Comment;
import ir.ac.kntu.food.Food;

public class FoodMenu {
    private ArrayList<Food> foods = new ArrayList<>();

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void addFood(String foodName, int price, int cookTime, Restaurant restaurant) {
        foodName = foodName.toLowerCase().trim();
        Food food = new Food(foodName, price, cookTime, restaurant);
        foods.add(food);
    }

    public void removeFood(Food food) {
        if (foods.contains(food)) {
            foods.remove(food);
        }
    }

    public void changeFoodPrice(String foodName, int newPrice) {
        foodName = foodName.toLowerCase().trim();
        if (foods.contains(new Food(foodName))) {
            for (Food food : foods) {
                if (food.equals(new Food(foodName))) {
                    food.setPrice(newPrice);
                    break;
                }
            }
        }
    }

    public boolean contains(String foodName) {
        foodName = foodName.toLowerCase().trim();
        return foods.contains(new Food(foodName));
    }

    public void printMenu() {
        for (int i = 0; i < foods.size(); i++) {
            System.out.print((i + 1) + "-" + foods.get(i));
        }
    }
}
