package ir.ac.kntu.main;

public class HandleSetting {
    private Sort sort = new Sort();

    public boolean settingMenu() {
        System.out.println("How to display lists?");
        System.out.println("1-Ascending based on score");
        System.out.println("2-Descending based on score");
        System.out.println("3-Ascending based on comments number");
        System.out.println("4-Descending based on comments number");
        int option = chooseInRange(1, 4);
        settingMenuHandler(option);
        return true;
    }

    public void settingMenuHandler(int option) {
        switch (option) {
            case 1:
                DataBase.setSortMode(SortMode.ASCENDING_BASED_ON_SCORE);
                break;
            case 2:
                DataBase.setSortMode(SortMode.DESCENDING_BASED_ON_SCORE);
                break;
            case 3:
                DataBase.setSortMode(SortMode.ASCENDING_BASED_ON_COMMENTS);
                break;
            case 4:
                DataBase.setSortMode(SortMode.DESCENDING_BASED_ON_COMMENTS);
                break;
            default:
                break;
        }
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
}
