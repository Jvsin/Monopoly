import java.util.ArrayList;

public enum Countries {
    SOUTH_AFRICA,
    USA,
    FRANCE,
    GERMANY,
    ARGENTINA,
    ITALY,
    BRAZIL,
    ENGLAND,
    BALLS;

    public ArrayList<String> getCities(Countries country) {
        ArrayList<String> list = new ArrayList<>();
        switch (country) {
            case USA -> {
                list.add("Chicago");
                list.add("Washinghton");
                list.add("Pasadena");
            }
            case SOUTH_AFRICA -> {
                list.add("Port Elizabeth");
                list.add("Johannesburg");
            }
            case FRANCE -> {
                list.add("Toulouse");
                list.add("Marsyllie");
                list.add("Paris");
            }
            case GERMANY -> {
                list.add("Berlin");
                list.add("Dortmund");
                list.add("Munich");
            }
            case ARGENTINA -> {
                list.add("Rosario");
                list.add("Buenos Aires");
            }
            case ITALY -> {
                list.add("Napoli");
                list.add("Milan");
                list.add("Roma");
            }
            case ENGLAND -> {
                list.add("Birmingham");
                list.add("Manchester");
                list.add("London");
            }
            case BRAZIL -> {
                list.add("Brasilia");
                list.add("Sao Paulo");
                list.add("Rio de Janeiro");
            }
            case BALLS -> {
                list.add("Telstar Mexico 1970");
                list.add("Tango Espania 1982");
                list.add("Brazuca Brazil 2014");
                list.add("Jabulani RPA 2010");
            }
        }
        return list;
    }
}
