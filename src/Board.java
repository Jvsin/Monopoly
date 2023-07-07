import java.util.ArrayList;
public class Board {
    private final ArrayList<Field> fields = new ArrayList<>();
    Board() {
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
    public Field getField (int fieldIndex) {
        return fields.get(fieldIndex);
    }
}
