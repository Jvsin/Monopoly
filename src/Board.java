import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
public class Board extends JPanel{
    private final Image mainBoard = new ImageIcon("./assets/planszafinal.png").getImage();
    private final ArrayList<Field> fields = new ArrayList<>();
    Board() {
        setParameters();
        //TODO: Ekonomia -> ceny nieruchomości
        fields.add(new Field("Start", FieldType.START));
        fields.add(new Field("Port Elizabeth", 100, FieldType.NORMAL, Countries.SOUTH_AFRICA));
        fields.add(new Field("Tax", FieldType.TAX));
        fields.add(new Field("Johannesburg", 100, FieldType.NORMAL,Countries.SOUTH_AFRICA));
        fields.add(new Field("Chance", FieldType.CHANCE));
        fields.add(new Field("Telstar Mexico 1970",50,FieldType.BALL, Countries.BALLS));
        fields.add(new Field("Chicago", 100, FieldType.NORMAL,Countries.USA));
        fields.add(new Field("Chance", FieldType.CHANCE));
        fields.add(new Field("Washinghton", 100, FieldType.NORMAL,Countries.USA));
        fields.add(new Field("Pasadena", 100, FieldType.NORMAL, Countries.USA));

        fields.add(new Field("Jail", FieldType.JAIL));
        fields.add(new Field("Toulouse", 100, FieldType.NORMAL, Countries.FRANCE));
        fields.add(new Field("Chance", FieldType.CHANCE));
        fields.add(new Field("Marsyllie", 100, FieldType.NORMAL,Countries.FRANCE));
        fields.add(new Field("Paris", 100, FieldType.NORMAL,Countries.FRANCE));
        fields.add(new Field("Tango Espania 1982",50,FieldType.BALL,Countries.BALLS));
        fields.add(new Field("Berlin", 100, FieldType.NORMAL,Countries.GERMANY));
        fields.add(new Field("Chance", FieldType.CHANCE));
        fields.add(new Field("Dortmund", 100, FieldType.NORMAL,Countries.GERMANY));
        fields.add(new Field("Munich", 100, FieldType.NORMAL,Countries.GERMANY));

        fields.add(new Field("Parking",FieldType.PARKING));
        fields.add(new Field("Buenos Aires", 100, FieldType.NORMAL,Countries.ARGENTINA));
        fields.add(new Field("Chance", FieldType.CHANCE));
        fields.add(new Field("Rosario", 100, FieldType.NORMAL,Countries.ARGENTINA));
        fields.add(new Field("Chance", FieldType.CHANCE));
        fields.add(new Field("Brazuca Brazil 2014",0,FieldType.BALL, Countries.BALLS));
        fields.add(new Field("Napoli", 100, FieldType.NORMAL,Countries.ITALY));
        fields.add(new Field("Milan", 100, FieldType.NORMAL,Countries.ITALY));
        fields.add(new Field("Chance", FieldType.CHANCE));
        fields.add(new Field("Roma", 100, FieldType.NORMAL,Countries.ITALY));

        fields.add(new Field("Go to jail", FieldType.GO_TO_JAIL));
        fields.add(new Field("Brasilia", 100, FieldType.NORMAL,Countries.BRAZIL));
        fields.add(new Field("Sao Paulo", 100, FieldType.NORMAL,Countries.BRAZIL));
        fields.add(new Field("Chance", FieldType.CHANCE));
        fields.add(new Field("Rio de Janeiro", 100, FieldType.NORMAL,Countries.BRAZIL));
        fields.add(new Field("Jabulani RPA 2010",0,FieldType.BALL,Countries.BALLS));
        fields.add(new Field("Birmingham", 100, FieldType.NORMAL,Countries.ENGLAND));
        fields.add(new Field("Manchester", 100, FieldType.NORMAL,Countries.ENGLAND));
        fields.add(new Field("Tax", FieldType.TAX));
        fields.add(new Field("London", 100, FieldType.NORMAL,Countries.ENGLAND));
    }
    public Field getField (int fieldIndex) {
        return fields.get(fieldIndex);
    }

    private void setParameters (){
        this.setOpaque(true);
        this.setBounds(300, 0, 880, 880);
        this.setLayout(null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(mainBoard, 0, 0, null);
    }

}
