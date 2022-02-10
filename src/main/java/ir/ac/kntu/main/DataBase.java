package ir.ac.kntu.main;

import ir.ac.kntu.customer.Customer;
import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.delivery.SalaryType;
import ir.ac.kntu.delivery.Vehicle;
import ir.ac.kntu.order.Order;
import ir.ac.kntu.restaurant.PriceType;
import ir.ac.kntu.restaurant.Restaurant;
import ir.ac.kntu.restaurant.WorkingHours;
import java.time.LocalTime;
import java.util.ArrayList;

public class DataBase {
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();

    private static ArrayList<Delivery> deliveries = new ArrayList<>();

    private static ArrayList<Customer> customers = new ArrayList<>();

    private static ArrayList<Order> processingOrders = new ArrayList<>();

    private static ArrayList<Order> deliveringOrders = new ArrayList<>();

    private static ArrayList<Order> deliveredOrders = new ArrayList<>();

    private static SortMode sortMode;

    public static SortMode getSortMode() {
        return sortMode;
    }

    public static void setSortMode(SortMode sortMode) {
        DataBase.sortMode = sortMode;
    }

    public static void addARestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public static void removeARestaurant(Restaurant restaurant) {
        restaurants.remove(restaurant);
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static void setRestaurants(ArrayList<Restaurant> restaurants) {
        DataBase.restaurants = restaurants;
    }

    public static void addADelivery(Delivery delivery) {
        deliveries.add(delivery);
    }

    public static void removeADelivery(Delivery delivery) {
        deliveries.remove(delivery);
    }

    public static ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public static void setDeliveries(ArrayList<Delivery> deliveries) {
        DataBase.deliveries = deliveries;
    }

    public static void addACustomer(Customer customer) {
        customers.add(customer);
    }

    public static void removeACustomer(Customer customer) {
        customers.remove(customer);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void addAProcessingOrder(Order order) {
        processingOrders.add(order);
    }

    public static void removeAProcessingOrder(Order order) {
        processingOrders.remove(order);
    }

    public static ArrayList<Order> getProcessingOrders() {
        return processingOrders;
    }

    public static void addADeliveringOrder(Order order) {
        deliveringOrders.add(order);
    }

    public static void removeADeliveringOrder(Order order) {
        deliveringOrders.remove(order);
    }

    public static ArrayList<Order> getDeliveringOrders() {
        return processingOrders;
    }

    public static void addADeliveredOrder(Order order) {
        processingOrders.add(order);
    }

    public static ArrayList<Order> getDeliveredOrders() {
        return processingOrders;
    }

    public static void addInstancesToRestaurants() {
        Restaurant shandizJordan = new Restaurant("Shandiz Jordan", "Tehran , Jordan , District 3", PriceType.LUXURY,
                new WorkingHours(LocalTime.of(8, 0), LocalTime.of(23, 0)));
        shandizJordan.addAFoodToMenu("cholo kabab", 90000, 25);
        shandizJordan.addAFoodToMenu("pasta", 70000, 20);
        shandizJordan.addAFoodToMenu("ghorme sabzi", 70000, 25);
        Restaurant alborz = new Restaurant("Alborz", "Tehran , District 7", PriceType.INTERMEDIATE,
                new WorkingHours(LocalTime.of(9, 0), LocalTime.of(23, 0)));
        alborz.addAFoodToMenu("cholo kabab", 70000, 20);
        alborz.addAFoodToMenu("pasta", 45000, 25);
        alborz.addAFoodToMenu("ghorme sabzi", 45000, 25);
        Restaurant belamonica = new Restaurant("Belamonica", "Tehran , Vozara Street", PriceType.ECONOMIC,
                new WorkingHours(LocalTime.of(9, 0), LocalTime.of(22, 0)));
        belamonica.addAFoodToMenu("cholo kabab", 50000, 30);
        belamonica.addAFoodToMenu("pasta", 40000, 25);
        belamonica.addAFoodToMenu("ghorme sabzi", 40000, 30);
        addARestaurant(shandizJordan);
        addARestaurant(alborz);
        addARestaurant(belamonica);
    }

    public static void addInstancesToDeliveries() {
        Delivery delivery1 = new Delivery(Vehicle.MOTORCYCLE, SalaryType.PER_EACH_DELIVERY, 15000);
        Delivery delivery2 = new Delivery(Vehicle.MOTORCYCLE, SalaryType.HOURLY, 30000);
        Delivery delivery3 = new Delivery(Vehicle.CAR, SalaryType.PER_EACH_DELIVERY, 20000);
        Delivery delivery4 = new Delivery(Vehicle.BICYCLE, SalaryType.PER_EACH_DELIVERY, 10000);
        addADelivery(delivery1);
        addADelivery(delivery2);
        addADelivery(delivery3);
        addADelivery(delivery4);
    }

    public static void addInstancesToCustomers() {
        Customer customer1 = new Customer("Alireza", "09377652436", "Tehran , Saadat Abad");
        Customer customer2 = new Customer("Mmd", "09030001234", "Tehran , Shahrak Gharb");
        Customer customer3 = new Customer("Rez", "09952241124", "Tehran , Lavasan");
        addACustomer(customer1);
        addACustomer(customer2);
        addACustomer(customer3);
    }
}
