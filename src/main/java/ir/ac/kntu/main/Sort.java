package ir.ac.kntu.main;

import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.food.Food;
import ir.ac.kntu.restaurant.Restaurant;

import java.util.ArrayList;

public class Sort {
    public void sorting(SortMode sortMode) {
        switch (sortMode) {
            case ASCENDING_BASED_ON_SCORE:
                restaurantsAscendingSortBasedOnScore();
                deliveriesAscendingSortBasedOnScore();
                foodsAscendingSortBasedOnScore();
                break;
            case ASCENDING_BASED_ON_COMMENTS:
                restaurantsAscendingSortBasedOnCommentNumber();
                deliveriesAscendingSortBasedOnCommentsNumber();
                foodsAscendingSortBasedOnCommentsNumber();
                break;
            case DESCENDING_BASED_ON_SCORE:
                restaurantsDescendingSortBasedOnScore();
                deliveriesDescendingSortBasedOnScore();
                foodsDescendingSortBasedOnScore();
                break;
            case DESCENDING_BASED_ON_COMMENTS:
                restaurantsDescendingSortBasedOnCommentNumber();
                deliveriesDescendingSortBasedOnCommentsNumber();
                foodsDescendingSortBasedOnCommentsNumber();
                break;
            default:
                break;
        }
    }

    private void restaurantsAscendingSortBasedOnScore() {
        ArrayList<Restaurant> sorted = new ArrayList<>();
        Restaurant maxScore = DataBase.getRestaurants().get(0);
        int numberOfRestaurants = DataBase.getRestaurants().size();
        for (int i = 0; i < numberOfRestaurants; i++) {
            for (Restaurant restaurant : DataBase.getRestaurants()) {
                if (restaurant.getScore() > maxScore.getScore()) {
                    maxScore = restaurant;
                }
            }
            DataBase.getRestaurants().remove(maxScore);
            sorted.add(maxScore);
        }
        DataBase.setRestaurants(sorted);
    }

    private void restaurantsAscendingSortBasedOnCommentNumber() {
        ArrayList<Restaurant> sorted = new ArrayList<>();
        Restaurant maxComment = DataBase.getRestaurants().get(0);
        int numberOfRestaurants = DataBase.getRestaurants().size();
        for (int i = 0; i < numberOfRestaurants; i++) {
            for (Restaurant restaurant : DataBase.getRestaurants()) {
                if (restaurant.getComments().size() > maxComment.getComments().size()) {
                    maxComment = restaurant;
                }
            }
            DataBase.getRestaurants().remove(maxComment);
            sorted.add(maxComment);
        }
        DataBase.setRestaurants(sorted);
    }

    private void restaurantsDescendingSortBasedOnScore() {
        ArrayList<Restaurant> sorted = new ArrayList<>();
        Restaurant minScore = DataBase.getRestaurants().get(0);
        int numberOfRestaurants = DataBase.getRestaurants().size();
        for (int i = 0; i < numberOfRestaurants; i++) {
            for (Restaurant restaurant : DataBase.getRestaurants()) {
                if (restaurant.getScore() < minScore.getScore()) {
                    minScore = restaurant;
                }
            }
            DataBase.getRestaurants().remove(minScore);
            sorted.add(minScore);
        }
        DataBase.setRestaurants(sorted);
    }

    private void restaurantsDescendingSortBasedOnCommentNumber() {
        ArrayList<Restaurant> sorted = new ArrayList<>();
        Restaurant minComment = DataBase.getRestaurants().get(0);
        int numberOfRestaurants = DataBase.getRestaurants().size();
        for (int i = 0; i < numberOfRestaurants; i++) {
            for (Restaurant restaurant : DataBase.getRestaurants()) {
                if (restaurant.getComments().size() < minComment.getComments().size()) {
                    minComment = restaurant;
                }
            }
            DataBase.getRestaurants().remove(minComment);
            sorted.add(minComment);
        }
        DataBase.setRestaurants(sorted);
    }

    private void deliveriesAscendingSortBasedOnScore() {
        ArrayList<Delivery> sorted = new ArrayList<>();
        Delivery maxScore = DataBase.getDeliveries().get(0);
        int numberOfDeliveries = DataBase.getDeliveries().size();
        for (int i = 0; i < numberOfDeliveries; i++) {
            for (Delivery delivery : DataBase.getDeliveries()) {
                if (delivery.getScore() > maxScore.getScore()) {
                    maxScore = delivery;
                }
            }
            DataBase.getDeliveries().remove(maxScore);
            sorted.add(maxScore);
        }
        DataBase.setDeliveries(sorted);
    }

    private void deliveriesAscendingSortBasedOnCommentsNumber() {
        ArrayList<Delivery> sorted = new ArrayList<>();
        Delivery maxComment = DataBase.getDeliveries().get(0);
        int numberOfDeliveries = DataBase.getDeliveries().size();
        for (int i = 0; i < numberOfDeliveries; i++) {
            for (Delivery delivery : DataBase.getDeliveries()) {
                if (delivery.getCommentHistory().size() > maxComment.getCommentHistory().size()) {
                    maxComment = delivery;
                }
            }
            DataBase.getDeliveries().remove(maxComment);
            sorted.add(maxComment);
        }
        DataBase.setDeliveries(sorted);
    }

    private void deliveriesDescendingSortBasedOnScore() {
        ArrayList<Delivery> sorted = new ArrayList<>();
        Delivery minScore = DataBase.getDeliveries().get(0);
        int numberOfDeliveries = DataBase.getDeliveries().size();
        for (int i = 0; i < numberOfDeliveries; i++) {
            for (Delivery delivery : DataBase.getDeliveries()) {
                if (delivery.getScore() < minScore.getScore()) {
                    minScore = delivery;
                }
            }
            DataBase.getDeliveries().remove(minScore);
            sorted.add(minScore);
        }
        DataBase.setDeliveries(sorted);
    }

    private void deliveriesDescendingSortBasedOnCommentsNumber() {
        ArrayList<Delivery> sorted = new ArrayList<>();
        Delivery minComment = DataBase.getDeliveries().get(0);
        int numberOfDeliveries = DataBase.getDeliveries().size();
        for (int i = 0; i < numberOfDeliveries; i++) {
            for (Delivery delivery : DataBase.getDeliveries()) {
                if (delivery.getCommentHistory().size() < minComment.getCommentHistory().size()) {
                    minComment = delivery;
                }
            }
            DataBase.getDeliveries().remove(minComment);
            sorted.add(minComment);
        }
        DataBase.setDeliveries(sorted);
    }

    private void foodsAscendingSortBasedOnScore() {
        ArrayList<Food> sorted = new ArrayList<>();
        for (Restaurant restaurant : DataBase.getRestaurants()) {
            Food maxScore = restaurant.getFoods().get(0);
            int numberOfFoods = restaurant.getFoods().size();
            for (int i = 0; i < numberOfFoods; i++) {
                for (Food food : restaurant.getFoods()) {
                    if (food.getScore() > maxScore.getScore()) {
                        maxScore = food;
                    }
                }
                restaurant.getFoods().remove(maxScore);
                sorted.add(maxScore);
            }
            restaurant.setFoods(sorted);
        }
    }

    private void foodsAscendingSortBasedOnCommentsNumber() {
        ArrayList<Food> sorted = new ArrayList<>();
        for (Restaurant restaurant : DataBase.getRestaurants()) {
            Food maxComment = restaurant.getFoods().get(0);
            int numberOfFoods = restaurant.getFoods().size();
            for (int i = 0; i < numberOfFoods; i++) {
                for (Food food : restaurant.getFoods()) {
                    if (food.getCommentHistory().size() > maxComment.getCommentHistory().size()) {
                        maxComment = food;
                    }
                }
                restaurant.getFoods().remove(maxComment);
                sorted.add(maxComment);
            }
            restaurant.setFoods(sorted);
        }
    }

    private void foodsDescendingSortBasedOnScore() {
        ArrayList<Food> sorted = new ArrayList<>();
        for (Restaurant restaurant : DataBase.getRestaurants()) {
            Food minScore = restaurant.getFoods().get(0);
            int numberOfFoods = restaurant.getFoods().size();
            for (int i = 0; i < numberOfFoods; i++) {
                for (Food food : restaurant.getFoods()) {
                    if (food.getScore() < minScore.getScore()) {
                        minScore = food;
                    }
                }
                restaurant.getFoods().remove(minScore);
                sorted.add(minScore);
            }
            restaurant.setFoods(sorted);
        }
    }

    private void foodsDescendingSortBasedOnCommentsNumber() {
        ArrayList<Food> sorted = new ArrayList<>();
        for (Restaurant restaurant : DataBase.getRestaurants()) {
            Food minComment = restaurant.getFoods().get(0);
            int numberOfFoods = restaurant.getFoods().size();
            for (int i = 0; i < numberOfFoods; i++) {
                for (Food food : restaurant.getFoods()) {
                    if (food.getCommentHistory().size() < minComment.getCommentHistory().size()) {
                        minComment = food;
                    }
                }
                restaurant.getFoods().remove(minComment);
                sorted.add(minComment);
            }
            restaurant.setFoods(sorted);
        }
    }
}
