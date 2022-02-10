package ir.ac.kntu.main;

import ir.ac.kntu.admin.Admin;

public class Main {
    public static void main(String[] args) {
        System.out.println("---*** WELCOME TO FARIFOOD SERVICE ***---\n");
        DataBase.addInstancesToRestaurants();
        DataBase.addInstancesToDeliveries();
        DataBase.addInstancesToCustomers();
        Admin admin = new Admin("Admin", "1234");
        while (true) {
            System.out.print("Username: ");
            String userName = ScannerWrapper.getInstance().nextLine();
            System.out.print("Password: ");
            String password = ScannerWrapper.getInstance().nextLine();
            if (admin.logIn(userName, password)) {
                System.out.println("***You loged in successfully***\n");
                break;
            } else {
                System.out.println("***Username or password is wrong***\n");
            }
        }
        HandleSetting setting = new HandleSetting();
        setting.settingMenu();
        HandleMenu handleMenu = new HandleMenu();
        while (handleMenu.facilitiesMenu()) {
            continue;
        }
        System.out.println("\nThanks for using our service.");
    }
}
