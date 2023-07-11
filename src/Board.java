import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
public class Board extends JPanel{
    private final Image mainBoard = new ImageIcon("./assets/planszafinal.png").getImage();
    public final static int BEGIN_COORDINATE = 0;
    private final ArrayList<Field> fields = new ArrayList<>();
    private final ArrayList<Coordinate> fieldsCoordinates = new ArrayList<>();
    Board() {
        setParameters();
        generateCoordinatesList();
        //TODO: Ekonomia -> ceny nieruchomości
        fields.add(new Field("Start", 0, FieldType.START));
        fields.add(new Field("Buenos Aires", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Rosario", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Tango Espania 1982",0,FieldType.BALL));
        fields.add(new Field("Waszyngton", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Dallas", 100, FieldType.NORMAL));
        fields.add(new Field("Pasadena", 100, FieldType.NORMAL));

        fields.add(new Field("Jail", 0, FieldType.JAIL));
        fields.add(new Field("Port Elizabeth", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Johannesburg", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Telstar Mexico 1970",0,FieldType.BALL));
        fields.add(new Field("Lyon", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Marsylia", 100, FieldType.NORMAL));
        fields.add(new Field("Paryż", 100, FieldType.NORMAL));

        fields.add(new Field("Parking", 0, FieldType.PARKING));
        fields.add(new Field("Berlin", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Dortmund", 100, FieldType.NORMAL));
        fields.add(new Field("Monachium", 100, FieldType.NORMAL));
        fields.add(new Field("Brazuca Brazil 2014",0,FieldType.BALL));
        fields.add(new Field("Neapol", 100, FieldType.NORMAL));
        fields.add(new Field("Mediolan", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Rzym", 100, FieldType.NORMAL));

        fields.add(new Field("Go to jail",0, FieldType.GO_TO_JAIL));
        fields.add(new Field("Birmingham", 100, FieldType.NORMAL));
        fields.add(new Field("Manchester", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Londyn", 100, FieldType.NORMAL));
        fields.add(new Field("Jabulani RPA 2010",0,FieldType.BALL));
        fields.add(new Field("Brasilia", 100, FieldType.NORMAL));
        fields.add(new Field("Chance", 0, FieldType.CHANCE));
        fields.add(new Field("Sao Paulo", 100, FieldType.NORMAL));
        fields.add(new Field("Rio de Janeiro", 100, FieldType.NORMAL));
    }
    private void generateCoordinatesList() {
        int beginX = 810;
        int beginY = 810;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        beginX = beginX - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        for (int i = 0 ; i < 8 ;i++) {
            beginX = beginX - 71;
            fieldsCoordinates.add(new Coordinate(beginX, beginY));
        }
        beginX = beginX - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        beginY = beginY - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        for ( int i = 0 ; i < 8 ; i++ ) {
            beginY = beginY - 71;
            fieldsCoordinates.add(new Coordinate(beginX, beginY));
        }
        beginY = beginY - 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        beginX = beginX + 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        for (int i = 0 ; i < 8 ;i++) {
            beginX = beginX + 71;
            fieldsCoordinates.add(new Coordinate(beginX, beginY));
        }
        beginX = beginX + 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        beginY = beginY + 100;
        fieldsCoordinates.add(new Coordinate(beginX, beginY));
        for ( int i = 0 ; i < 8 ; i++ ) {
            beginY = beginY + 71;
            fieldsCoordinates.add(new Coordinate(beginX, beginY));
        }
    }
    public Field getField (int fieldIndex) {
        return fields.get(fieldIndex);
    }

    private void setParameters (){
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
