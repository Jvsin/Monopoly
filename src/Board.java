import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private final Image mainBoard = new ImageIcon("./assets/planszafinal.jpg").getImage();
    public final static int BEGIN_COORDINATE = 0;
    private final ArrayList<Field> fields = new ArrayList<>();
    private final ArrayList<Coordinate> fieldsCoordinates = new ArrayList<>();
    private final ArrayList<Chance> chances = new ArrayList<>();
    private int beginX = 810;
    private int beginY = 810;

    Board() {
        setParameters();
        generateCoordinatesList();
        generateFieldsList();
        generateChanceField();
    }

    private void generateChanceField() {
        chances.add(new Chance(100, 0, "Dostajesz 100 na bilet"));
        chances.add(new Chance(200, 0, "Dostajesz 200 na bilet"));
        chances.add(new Chance(250, 0, "Wygrywasz kupon za 250"));
        chances.add(new Chance(350, 0, "Masz 350 i baw się dobrze na meczu"));
        chances.add(new Chance(500, 0, "Dostajesz 500 na nową piłkę"));

        chances.add(new Chance(-100, 0, "Musisz zapłacić 100 mandatu za picie piwa przed stadionem"));
        chances.add(new Chance(-200, 0, "Zdecydowałeś się kupić lepszy bilet na mecz i musisz dopłacić 200"));
        chances.add(new Chance(-250, 0, "Właśnie wychodzisz z meczu gdzie twoja drużyna przegrała mecz za 250"));
        chances.add(new Chance(-250, 0, "Na stadionie wybuchły zamieszki i policja zabrała cię do aresztu. Dostałeś 350 mandatu"));
        chances.add(new Chance(-500, 0, "Bardzo się spieszyłeś na mecz i dostałeś 500 kary za złe parkowanie"));

        chances.add(new Chance(150, 0, "Szedłeś na mecz i znalazłeś 150 na ulicy"));
        chances.add(new Chance(300, 0, "Twoja reprezentacja wygrała dla ciebie kupon o wartości 300"));
        chances.add(new Chance(450, 0, "Właśnie zakręciłeś kołem fortuny przed stadionem i wygrałeś 450"));
        chances.add(new Chance(400, 0, "Masz 400 i baw się dobrze na meczu"));
        chances.add(new Chance(600, 0, "Po meczu dostałeś autograf który ktoś od ciebie kupił za 600"));

        chances.add(new Chance(0, 0.1, "Musisz zapłacić 10% podatku"));
        chances.add(new Chance(0, 0.15, "Musisz zapłacić 15% podatku"));
        chances.add(new Chance(0, 0.2, "Musisz zapłacić 20% podatku"));
        chances.add(new Chance(0, 0.25, "Musisz zapłacić 25% podatku"));
        chances.add(new Chance(0, 0.3, "Musisz zapłacić 30% podatku"));
    }

    public Chance getRandomChance() {
        int min = 1;
        int max = chances.size();
        int chanceResult = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return chances.get(chanceResult - 1);
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
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        generateCoordinatesRow(-71, 0);
        beginX = beginX - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        generateCoordinatesRow(0, -71);
        beginY = beginY - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        generateCoordinatesRow(71, 0);
        beginX = beginX + 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        generateCoordinatesRow(0, 71);
    }

    private void generateCoordinatesRow(int differenceX, int differenceY) {
        if (differenceX != 0) {
            if (differenceX > 0)
                beginX += 100;
            else
                beginX -= 100;
        }
        if (differenceY != 0) {
            if (differenceY > 0)
                beginY += 100;
            else
                beginY -= 100;
        }
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        for (int i = 0; i < 8; i++) {
            if (differenceX != 0)
                beginX += differenceX;
            else
                beginY += differenceY;
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
