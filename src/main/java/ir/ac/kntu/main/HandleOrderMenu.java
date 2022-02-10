package ir.ac.kntu.main;

import ir.ac.kntu.comment.Comment;
import ir.ac.kntu.customer.Customer;
import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.food.Food;
import ir.ac.kntu.order.Order;
import ir.ac.kntu.order.OrderStatus;
import ir.ac.kntu.restaurant.PriceType;
import ir.ac.kntu.restaurant.Restaurant;
import java.time.LocalTime;
import java.util.ArrayList;

public class HandleOrderMenu {
    private Sort sort = new Sort();

    public boolean orderMenu() {
        System.out.println("1-Confirm a new order");
        System.out.println("2-Show all comments of a food in all restaurants");
        System.out.println("3-Show 5 best restaurant for a food");
        System.out.println("4-Show orders based on their status");
        System.out.println("5-Change an order status");
        System.out.println("0-Back");
        int option = chooseInRange(0, 5);
        return orderMenuHandler(option);
    }

    private boolean orderMenuHandler(int option) {
        switch (option) {
            case 1:
                confirmANewOrder();
                break;
            case 2:
                showAllCommentsOfAFood();
                break;
            case 3:
                show5BestRestaurantForAFood();
                break;
            case 4:
                showOrdersBasedOnTheirStatus();
                break;
            case 5:
                changeAnOrderStatus();
                break;
            case 0:
                return true;
            default:
                break;
        }
        System.out.println("\n--------------------------------------------");
        System.out.println("***Order menu***\n");
        return orderMenu();
    }

    private void confirmANewOrder() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Confirm a new order***\n");
        System.out.println("***Select the customer***");
        Customer customer = chooseCustomer();
        if(customer == null) {
            return;
        }
        System.out.println("***Select the restaurant***");

        Restaurant restaurant = filterRestaurantsList();
        if (restaurant == null) {
            return;
        }
        System.out.println("***Select the food***");
        restaurant.printMenu();
        int option = chooseInRange(1, restaurant.getFoods().size()) - 1;
        if (option + 1 == 0) {
            return;
        }
        Food food = restaurant.getFoods().get(option);
        System.out.println("Delivery address:");
        String address ="";
        System.out.println("1-Select this customer address");
        System.out.println("2-Input another address");
        System.out.println("0-Back");
        option = chooseInRange(0, 2);
        if (option == 0) {
            return;
        }else if (option == 1) {
            address = customer.getAddress();
        }else if (option == 2) {
            System.out.println("Input the address: ");
            address = ScannerWrapper.getInstance().nextLine();
        }
        Order order = new Order(customer, food, restaurant, address);
        customer.addAOrder(order);
        DataBase.addAProcessingOrder(order);
        System.out.println("***Order confirmed successfully***\n");
    }

    private void showAllCommentsOfAFood() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Show all comments of a food***\n");
        System.out.print("Enter food name: ");
        String foodName = ScannerWrapper.getInstance().nextLine().trim();
        boolean check = false;
        for (Restaurant restaurant : DataBase.getRestaurants()) {
            for (Food food : restaurant.getFoods()) {
                if (food.getName().equals(foodName)) {
                    for (Comment comment : food.getCommentHistory()) {
                        System.out.println(restaurant + " restaurant:\n" + comment + "\n-------------");
                        check = true;
                    }
                }
            }
        }
        if(!check) {
            System.out.println("***This food doesn't have any comments or doesn't exist in restaurants menus***\n");
        }
    }

    private void show5BestRestaurantForAFood() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Show 5 best restaurants for a food***\n");
        System.out.print("Enter food name: ");
        String foodName = ScannerWrapper.getInstance().nextLine().trim();
        ArrayList<Food> foods = new ArrayList<>();
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        for (Restaurant restaurant : DataBase.getRestaurants()) {
            for (Food food : restaurant.getFoods()) {
                if (food.getName().equals(foodName)) {
                    foods.add(food);
                    restaurants.add(restaurant);
                    break;
                }
            }
        }
        ArrayList<Restaurant> bestRestaurants = new ArrayList<>();
        ArrayList<Double> scores = new ArrayList<>();
        Food maxScore = foods.get(0);
        int numberOfFoods = foods.size();
        for (int i = 0; i < numberOfFoods; i++) {
            for (Food food : foods) {
                if (food.getScore() > maxScore.getScore()) {
                    maxScore = food;
                    break;
                }
            }
            Restaurant restaurant = restaurants.get(foods.indexOf(maxScore));
            bestRestaurants.add(restaurant);
            scores.add(maxScore.getScore());
            foods.remove(maxScore);
            restaurants.remove(restaurant);
        }
        int restaurantsNumber = bestRestaurants.size();
        if (restaurantsNumber > 5) {
            restaurantsNumber = 5;
        }
        for (int i=0; i<restaurantsNumber; i++) {
            System.out.println((i+1) + "-" + bestRestaurants.get(i) + ";  score of this food: " + scores.get(i));
        }
        if (restaurantsNumber < 5) {
            System.out.println("***only " + restaurantsNumber + " restaurant(s) have this food***\n");
        }
    }

    private void showOrdersBasedOnTheirStatus() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Show orders based on their status***\n");
        System.out.println("1-Processing orders");
        System.out.println("2-Delivering orders");
        System.out.println("3-Delivered Orders");
        System.out.println("0-Back");
        int option = chooseInRange(0, 3);
        switch (option) {
            case 1:
                showProcessingOrders();
                break;
            case 2:
                showDeliveringOrders();
                break;
            case 3:
                showDeliveredOrders();
                break;
            default:
                return;
        }
    }

    private void showProcessingOrders() {
        if (DataBase.getProcessingOrders().size() == 0) {
            System.out.println("***This list is empty***\n");
            return;
        }
        for (int i = 0; i < DataBase.getProcessingOrders().size(); i++) {
            System.out.println((i + 1) + "-" + DataBase.getProcessingOrders().get(i));
        }
    }

    private void showDeliveringOrders() {
        if (DataBase.getDeliveringOrders().size() == 0) {
            System.out.println("***This list is empty***\n");
            return;
        }
        for (int i=0; i<DataBase.getDeliveringOrders().size(); i++) {
            System.out.println((i+1) + "-" + DataBase.getDeliveringOrders().get(i));
        }
    }

    private void showDeliveredOrders() {
        if (DataBase.getDeliveredOrders().size() == 0) {
            System.out.println("***This list is empty***\n");
            return;
        }
        for (int i=0; i<DataBase.getDeliveredOrders().size(); i++) {
            System.out.println((i+1) + "-" + DataBase.getDeliveredOrders().get(i));
        }
    }

    private void changeAnOrderStatus() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Change an order status***\n");
        System.out.println("1-Change status of processing orders to delivering");
        System.out.println("2-Change status of Delivering orders to delivered");
        System.out.println("0-Back");
        int option = chooseInRange(0, 2);
        switch (option) {
            case 1:
                changeProcessingToDelivering();
                break;
            case 2:
                changeDeliveringToDelivered();
                break;
            default:
                return;
        }
    }

    private void changeProcessingToDelivering() {
        if (DataBase.getProcessingOrders().size() == 0) {
            System.out.println("***There is no order in processing status***\n");
            return;
        }
        for (int i=0; i<DataBase.getProcessingOrders().size(); i++) {
            System.out.println((i+1) + "-" + DataBase.getProcessingOrders().get(i));
        }
        System.out.println("0-Back");
        int option = chooseInRange(0, DataBase.getProcessingOrders().size()) - 1;
        if (option + 1 == 0) {
            return;
        }
        Order order = DataBase.getProcessingOrders().get(option);
        boolean isDeliveryAvailable = false;
        for (Delivery delivery: order.getRestaurant().getDeliveries()) {
            if (delivery.isAvailableNow()) {
                order.setDelivery(delivery);
                delivery.setDelivering(true);
                isDeliveryAvailable = true;
                break;
            }
        }
        if (!isDeliveryAvailable) {
            System.out.println("***There is no available delivery for this order***\n");
            return;
        }
        order.setOrderStatus(OrderStatus.DELIVERING);
        DataBase.removeAProcessingOrder(order);
        DataBase.addADeliveringOrder(order);
    }

    private void changeDeliveringToDelivered() {
        if (DataBase.getDeliveringOrders().size() == 0) {
            System.out.println("***There is no order in delivering status***\n");
            return;
        }
        for (int i=0; i<DataBase.getDeliveringOrders().size(); i++) {
            System.out.println((i+1) + "-" + DataBase.getDeliveringOrders().get(i));
        }
        System.out.println("0-Back");
        int option = chooseInRange(0, DataBase.getDeliveringOrders().size()) - 1;
        if (option + 1 == 0) {
            return;
        }
        Order order = DataBase.getDeliveringOrders().get(option);
        order.setDeliveryTime(LocalTime.now());
        order.setOrderStatus(OrderStatus.DELIVERED);
        order.getDelivery().setDelivering(false);
        order.getDelivery().addAnOrder(order);
        DataBase.removeADeliveringOrder(order);
        DataBase.addADeliveredOrder(order);
        getComment(order);
    }

    private void getComment(Order order) {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Leaving a comment for this order***\n");
        System.out.println("Food: ");
        System.out.print("Score(from 1 to 5): ");
        int score = chooseInRange(1, 5);
        System.out.print("Comment: ");
        String comment = ScannerWrapper.getInstance().nextLine();
        Comment foodComment = new Comment(score, comment, order.getCustomer());
        order.setFoodComment(foodComment);
        System.out.println("----------\n");
        System.out.println("Restaurant: ");
        System.out.print("Score(from 1 to 5): ");
        score = chooseInRange(1, 5);
        System.out.print("Comment: ");
        comment = ScannerWrapper.getInstance().nextLine();
        Comment restaurantComment = new Comment(score, comment, order.getCustomer());
        order.setRestaurantComment(restaurantComment);
        System.out.println("----------\n");
        System.out.println("Delivery: ");
        System.out.print("Score(from 1 to 5): ");
        score = chooseInRange(1, 5);
        System.out.print("Comment: ");
        comment = ScannerWrapper.getInstance().nextLine();
        Comment deliveryComment = new Comment(score, comment, order.getCustomer());
        order.setDeliveryComment(deliveryComment);
        sort.sorting(DataBase.getSortMode());
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

    private Restaurant filterRestaurantsList() {
        System.out.println("Do filter restaurants list based on price type?");
        System.out.println("1-Yes");
        System.out.println("2-No");
        int option = chooseInRange(1, 2);
        if (option == 2) {
            return chooseAnOpenRestaurant(DataBase.getRestaurants());
        }
        System.out.println("choose price type");
        System.out.println("1-Luxury");
        System.out.println("2-Intermediate");
        System.out.println("3-Economic");
        ArrayList<Restaurant> filteredRestaurants = new ArrayList<>();
        option = chooseInRange(1, 3);
        switch (option) {
            case 1:
                System.out.println("\n***Luxury restaurants***\n");
                for (Restaurant restaurant : DataBase.getRestaurants()) {
                    if (restaurant.getPriceType() == PriceType.LUXURY) {
                        filteredRestaurants.add(restaurant);
                    }
                }
                break;
            case 2:
                System.out.println("\n***Intermediate restaurants***\n");
                for (Restaurant restaurant : DataBase.getRestaurants()) {
                    if (restaurant.getPriceType() == PriceType.INTERMEDIATE) {
                        filteredRestaurants.add(restaurant);
                    }
                }
                break;
            case 3:
                System.out.println("\n***Economic restaurants***\n");
                for (Restaurant restaurant : DataBase.getRestaurants()) {
                    if (restaurant.getPriceType() == PriceType.ECONOMIC) {
                        filteredRestaurants.add(restaurant);
                    }
                }
                break;
            default:
                break;
        }
        return chooseAnOpenRestaurant(filteredRestaurants);
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

    private Restaurant chooseAnOpenRestaurant(ArrayList<Restaurant> restaurants) {
        ArrayList<Restaurant> openRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.isOpen()) {
                openRestaurants.add(restaurant);
            }
        }
        if (openRestaurants.size() == 0) {
            System.out.println("***This list is empty***\n");
            return null;
        }
        for (int i=0; i< openRestaurants.size(); i++) {
            System.out.println((i+1) + "-" + openRestaurants.get(i) + "    Score: " + openRestaurants.get(i).getScore() +
                    "    Comments number: " + openRestaurants.get(i).getComments().size());
        }
        System.out.println("0-Back");
        int option = chooseInRange(0, openRestaurants.size()) - 1;
        if (option + 1 == 0) {
            return null;
        }
        return openRestaurants.get(option);
    }
}
