import javax.swing.*;
import java.awt.*;

public class Player extends JLabel {
    private final int MAP_DISTANCE = 40;
    private final ImageIcon icon;
    private int moneyInWallet;
    private int positionOnMap;
    public final static int PAWN_WIDTH = 30;
    public final static int PAWN_HEIGHT = 30;
    private final PlayersColors playerColor;
    private PlayerStatus playerStatus;
    Player(PlayersColors color) {
        //TODO: Ekonomia -> pieniądze startowe
        moneyInWallet = 100;
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
    public void blockPlayer() {
        playerStatus = PlayerStatus.IN_JAIL;
    }
    public void unlockPlayer() {
        playerStatus = PlayerStatus.IN_JAIL;
    }
    public void losePlayer() {
        playerStatus = PlayerStatus.LOST;
    }
    public void playerMove(int distance) {
        positionOnMap += distance;
        if ( positionOnMap >= MAP_DISTANCE )
            positionOnMap -= positionOnMap;
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
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(icon.getImage(), Board.BEGIN_COORDINATE, Board.BEGIN_COORDINATE, getWidth(), getHeight(), null);
    }
}
