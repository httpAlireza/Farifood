package ir.ac.kntu.restaurant;

public enum PriceType {
    ECONOMIC, INTERMEDIATE, LUXURY;

    @Override
    public String toString() {
        switch (this) {
            case LUXURY:
                return "Luxury";
            case INTERMEDIATE:
                return "Intermediate";
            case ECONOMIC:
                return "Economic";
            default:
                return "";
        }
    }
}
