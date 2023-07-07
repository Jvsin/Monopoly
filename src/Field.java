public class Field {
    String Name;
    int buyPrice;
    int accommodationLevel;
    FieldType fieldType;
    Field(String newName, int price, FieldType type) {
        Name = newName;
        buyPrice = price;
        accommodationLevel = 0;
        fieldType = type;
    }
}
