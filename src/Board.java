import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private final Image mainBoard = new ImageIcon("./assets/planszafinal.png").getImage();
    public final static int BEGIN_COORDINATE = 0;
    private final ArrayList<Field> fields = new ArrayList<>();
    private final ArrayList<Coordinate> fieldsCoordinates = new ArrayList<>();

    Board() {
        setParameters();
        generateCoordinatesList();
        generateFieldsList();
    }

    private void generateFieldsList() {
        //TODO: Ekonomia -> ceny nieruchomości
        fields.add(new Field("Start", FieldType.START, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Port Elizabeth", 150, FieldType.NORMAL, Countries.SOUTH_AFRICA, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Tax", FieldType.TAX, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Johannesburg", 200, FieldType.NORMAL, Countries.SOUTH_AFRICA, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Chance", FieldType.CHANCE, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Telstar Mexico 1970", 500, FieldType.BALL, Countries.BALLS, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Chicago", 200, FieldType.NORMAL, Countries.USA, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Chance", FieldType.CHANCE, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Washinghton", 250, FieldType.NORMAL, Countries.USA, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Pasadena", 200, FieldType.NORMAL, Countries.USA, new ImageIcon("./assets/Cards/firstCard.png").getImage()));

        fields.add(new Field("Jail", FieldType.JAIL, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Toulouse", 300, FieldType.NORMAL, Countries.FRANCE, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Chance", FieldType.CHANCE, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Marsyllie", 300, FieldType.NORMAL, Countries.FRANCE, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Paris", 350, FieldType.NORMAL, Countries.FRANCE, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Tango Espania 1982", 500, FieldType.BALL, Countries.BALLS, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Berlin", 450, FieldType.NORMAL, Countries.GERMANY, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Chance", FieldType.CHANCE, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Dortmund", 400, FieldType.NORMAL, Countries.GERMANY, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Munich", 400, FieldType.NORMAL, Countries.GERMANY, new ImageIcon("./assets/Cards/firstCard.png").getImage()));

        fields.add(new Field("Parking", FieldType.PARKING, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Buenos Aires", 550, FieldType.NORMAL, Countries.ARGENTINA, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Chance", FieldType.CHANCE, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Rosario", 500, FieldType.NORMAL, Countries.ARGENTINA, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Chance", FieldType.CHANCE, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Brazuca Brazil 2014", 500, FieldType.BALL, Countries.BALLS, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Napoli", 600, FieldType.NORMAL, Countries.ITALY, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Milan", 600, FieldType.NORMAL, Countries.ITALY, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Chance", FieldType.CHANCE, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Roma", 650, FieldType.NORMAL, Countries.ITALY, new ImageIcon("./assets/Cards/firstCard.png").getImage()));

        fields.add(new Field("Go to jail", FieldType.GO_TO_JAIL, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Brasilia", 700, FieldType.NORMAL, Countries.BRAZIL, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Sao Paulo", 700, FieldType.NORMAL, Countries.BRAZIL, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Chance", FieldType.CHANCE, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("Rio de Janeiro", 750, FieldType.NORMAL, Countries.BRAZIL, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Jabulani RPA 2010", 500, FieldType.BALL, Countries.BALLS, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Birmingham", 800, FieldType.NORMAL, Countries.ENGLAND, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Manchester", 800, FieldType.NORMAL, Countries.ENGLAND, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
        fields.add(new Field("Tax", FieldType.TAX, new ImageIcon("./assets/Cards/secondCard.png").getImage()));
        fields.add(new Field("London", 850, FieldType.NORMAL, Countries.ENGLAND, new ImageIcon("./assets/Cards/firstCard.png").getImage()));
    }

    private void generateCoordinatesList() {
        int beginX = 810;
        int beginY = 810;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        beginX = beginX - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        for (int i = 0; i < 8; i++) {
            beginX = beginX - 71;
            fieldsCoordinates.add(new Coordinate(beginX, beginY));
        }
        beginX = beginX - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        beginY = beginY - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        for (int i = 0; i < 8; i++) {
            beginY = beginY - 71;
            fieldsCoordinates.add(new Coordinate(beginX, beginY));
        }
        beginY = beginY - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        beginX = beginX + 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        for (int i = 0; i < 8; i++) {
            beginX = beginX + 71;
            fieldsCoordinates.add(new Coordinate(beginX, beginY));
        }
        beginX = beginX + 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        beginY = beginY + 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        for (int i = 0; i < 8; i++) {
            beginY = beginY + 71;
            fieldsCoordinates.add(new Coordinate(beginX, beginY));
        }
    }

    public Field getField(int fieldIndex) {
        return fields.get(fieldIndex);
    }

    private void setParameters() {
        this.setOpaque(true);
        this.setBounds(300, 0, 880, 880);
        this.setLayout(null);
    }

    public void setPawn(Player pawn, int index) {
        double scaleX = mainBoard.getWidth(null) / (double) getWidth();
        double scaleY = mainBoard.getHeight(null) / (double) getHeight();
        Coordinate coordinate = fieldsCoordinates.get(index);
        pawn.setBounds((int) (coordinate.getX() * scaleX), (int) (coordinate.getY() * scaleY), Player.PAWN_WIDTH, Player.PAWN_HEIGHT);
        this.add(pawn);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(mainBoard, 0, 0, null);
    }

}
