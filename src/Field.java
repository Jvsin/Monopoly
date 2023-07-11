import javax.swing.*;
import java.awt.*;

public class Field extends JLabel {
    private final int MAX_ACCOMMODATION_LEVEL = 3;
    private Image fieldCard = null;
    private final double[] ACCOMMODATION_PRICES = {0.1, 0.2, 0.3, 0.4}; //TODO: Ekonomia -> ceny spania
    private final String Name;
    private int buyPrice = 0;
    private int accommodationLevel = 0;
    private final FieldType fieldType;
    private Countries country = null;
    private Player owner = null;

    Field(String newName, int price, FieldType type, Countries newCountry, Image image) {
        Name = newName;
        buyPrice = price;
        country = newCountry;
        fieldType = type;
        fieldCard = image;
    }
    Field(String newName, FieldType type, Image image) {
        Name = newName;
        fieldType = type;
        fieldCard = image;
    }
    public void setOwner(Player player) {
        if (fieldType == FieldType.NORMAL || fieldType == FieldType.BALL)
            owner = player;
    }
    public Player getOwner() {
        return owner;
    }
    public int getBuyPrice() {
        return buyPrice;
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

    public Image getFieldCard () {
        return fieldCard;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fieldCard, 0, 0, this);
    }
}
