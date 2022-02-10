package ir.ac.kntu.main;

import ir.ac.kntu.admin.Admin;

public class HandleMenu {
    public boolean facilitiesMenu() {
        System.out.println("\n--------------------------------------------");
        System.out.println("***Facilities menu***\n");
        System.out.println("1-Restaurant menu");
        System.out.println("2-Delivery menu");
        System.out.println("3-Order menu");
        System.out.println("4-Customer menu");
        System.out.println("5-Setting");
        System.out.println("0-Exit");
        System.out.print("->");
        int option = ScannerWrapper.getInstance().nextInt();
        return facilitiesMenuHandler(option);
    }

    private boolean facilitiesMenuHandler(int option) {
        switch (option) {
            case 1:
                System.out.println("\n--------------------------------------------");
                System.out.println("***Restaurant menu***\n");
                HandleRestaurantMenu handleRestaurantMenu = new HandleRestaurantMenu();
                return handleRestaurantMenu.restaurantMenu();
            case 2:
                System.out.println("\n--------------------------------------------");
                System.out.println("***Delivery menu***\n");
                HandleDeliveryMenu handleDeliveryMenu = new HandleDeliveryMenu();
                return handleDeliveryMenu.deliveryMenu();
            case 3:
                System.out.println("\n--------------------------------------------");
                System.out.println("***Order menu***\n");
                HandleOrderMenu handleOrderMenu = new HandleOrderMenu();
                return handleOrderMenu.orderMenu();
            case 4:
                System.out.println("\n--------------------------------------------");
                System.out.println("***Customer menu***\n");
                HandleCustomerMenu handleCustomerMenu = new HandleCustomerMenu();
                return handleCustomerMenu.customerMenu();
            case 5:
                System.out.println("\n--------------------------------------------");
                System.out.println("***Setting***\n");
                HandleSetting setting = new HandleSetting();
                return setting.settingMenu();
            case 0:
                return false;
            default:
                System.out.println("***Invalid input***\n");
                return true;
        }
    }
}
