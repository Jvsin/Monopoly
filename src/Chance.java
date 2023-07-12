public class Chance {
    private final int money;
    private final double tax;
    private final String contents;

    Chance(int moneyAmount, double taxes, String name) {
        money = moneyAmount;
        tax = taxes;
        contents = name;
    }

    public String getContents() {
        return contents;
    }

    public int getMoney() {
        return money;
    }

    public double getTax() {
        return tax;
    }

    public double getRandomTax() {
        int min = 1;
        int max = 10;
        double randResult = Math.floor(Math.random() * (max - min + 1) + min);
        return randResult * 0.05;
    }

}
