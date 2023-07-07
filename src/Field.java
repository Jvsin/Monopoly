public class Field {
    private final int MAX_ACCOMMODATION_LEVEL = 3;

    //TODO: Ekonomia -> ceny spania
    private final double[] ACCOMMODATION_PRICES = {0.1, 0.2,0.3, 0.4};
    private String Name;
    private int buyPrice;
    private int accommodationLevel;
    private FieldType fieldType;

    Field(String newName, int price, FieldType type) {
        Name = newName;
        buyPrice = price;
        accommodationLevel = 0;
        fieldType = type;
    }

    public void increaseAccommodationLevel() {
        if ( accommodationLevel < MAX_ACCOMMODATION_LEVEL && fieldType == FieldType.NORMAL ) {
            accommodationLevel++;
        }
    }

    public double getSleepPrice() {
        if ( fieldType == FieldType.NORMAL ) {
            return buyPrice*ACCOMMODATION_PRICES[accommodationLevel];
        }
        return 0;
    }
}
