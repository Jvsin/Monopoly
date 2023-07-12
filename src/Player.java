import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends JLabel {
    private final int MAP_DISTANCE = 40;
    private final ImageIcon icon;
    private int moneyInWallet;
    private int positionOnMap;
    public final static int PAWN_WIDTH = 30;
    public final static int PAWN_HEIGHT = 30;
    private final PlayersColors playerColor;
    private PlayerStatus playerStatus;
    private final ArrayList<Field> ownedFields = new ArrayList<>();

    Player(PlayersColors color) {
        moneyInWallet = 2000; //TODO: Ekonomia -> pieniądze startowe
        positionOnMap = 0;
        playerColor = color;
        playerStatus = PlayerStatus.IN_GAME;
        switch (color) {
            case YELLOW -> this.icon = new ImageIcon("./assets/Pawns/PawnYellow.png");
            case GREEN -> this.icon = new ImageIcon("./assets/Pawns/PawnGreen.png");
            case BLUE -> this.icon = new ImageIcon("./assets/Pawns/PawnBlue.png");
            case RED -> this.icon = new ImageIcon("./assets/Pawns/PawnRed.png");
            default -> this.icon = null;
        }
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void buyField(Field field) {
        decreaseMoney(field.getBuyPrice());
        ownedFields.add(field);
    }

    public void blockPlayer() {
        playerStatus = PlayerStatus.IN_JAIL;
    }

    public void unlockPlayer() {
        playerStatus = PlayerStatus.IN_GAME;
    }

    public void losePlayer() {
        playerStatus = PlayerStatus.LOST;
    }

    public void playerMove(int distance) {
        positionOnMap += distance;
        if (positionOnMap >= MAP_DISTANCE)
            positionOnMap -= MAP_DISTANCE;
    }

    public int getPosition() {
        return positionOnMap;
    }

    public void increaseMoney(int amount) {
        moneyInWallet += amount;
    }

    public void decreaseMoney(int amount) {
        moneyInWallet -= amount;
    }

    public int getMoneyInWallet() {
        return moneyInWallet;
    }

    public PlayersColors getPlayerColor() {
        return playerColor;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon.getImage(), Board.BEGIN_COORDINATE, Board.BEGIN_COORDINATE, getWidth(), getHeight(), null);
    }
}
