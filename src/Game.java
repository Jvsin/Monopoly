import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private final Player[] players = new Player[4];
    private Player currentPlayer;
    private final Board board;
    private JPanel gameInfoPanel = new JPanel();
    private JLabel textInfoGame = new JLabel();
    private JLabel textInfoPlayer = new JLabel();
    private JPanel playerInfoPanel = new JPanel();
    private Field cardView = null;
    private final JLabel dicePlaceholder = new JLabel();
    private Dice dice = new Dice();
    private static int PLAYER_NUMBER;
    public int WINDOW_WIDTH = 1500;
    public int WINDOW_HEIGHT = 930;
    private int START_BONUS = 400; // TODO: Ekonomia -> premia za przejscie przez start
    private int HOUSE_PRICE = 500; // TODO: Ekonomia -> koszt dobudowania domu

    public Game() {
        board = new Board();
        if (PLAYER_NUMBER >= 1) {
            players[0] = new Player(PlayersColors.BLUE);
            board.setPawn(players[0], 0);
        }
        if (PLAYER_NUMBER >= 2) {
            players[0] = new Player(PlayersColors.RED);
            board.setPawn(players[0], 0);
        }
        if (PLAYER_NUMBER >= 3) {
            players[0] = new Player(PlayersColors.GREEN);
            board.setPawn(players[0], 0);
        }
        if (PLAYER_NUMBER == 4) {
            players[0] = new Player(PlayersColors.YELLOW);
            board.setPawn(players[0], 0);
        }
        currentPlayer = players[0];
        setCardView();
        setWindowParameters();
    }

    public static void startMenu() {
        Object[] options = {"2 graczy", "3 graczy", "4 graczy"};
        int check = JOptionPane.showOptionDialog(null, "Wybierz ilość graczy: ", "Monopoly",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (check == 0)
            PLAYER_NUMBER = 2;
        else if (check == 1)
            PLAYER_NUMBER = 3;
        else
            PLAYER_NUMBER = 4;
    }

    public void round() {
        for (Player player : players) {
            //TODO: Rozgrywka -> kolejnosc rund dla graczy
        }
    }

    private void setCardView() {
        cardView = board.getField(currentPlayer.getPosition());
        repaint();
    }

    public void setDiceView(int diceResult) {
        dice.setIcon(Dice.diceViews[diceResult - 1]);
    }

    private void buyField(Player player, Field field) {
        field.setOwner(player);
        player.buyField(field);
    }

    private void setWindowParameters() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("MONOPOLY - WORLD CUP EDITION");

        cardView.setPreferredSize(new Dimension(317, 457));
        cardView.setHorizontalAlignment(JLabel.CENTER);

        dice.setForeground(Color.white);
        dice.setPreferredSize(new Dimension(90, 90));
        dice.setBounds(50, 0, 90, 90);

        dicePlaceholder.setPreferredSize(new Dimension(200, 200));
        dicePlaceholder.setHorizontalAlignment(JLabel.CENTER);
        dicePlaceholder.add(dice);
        setDiceView(1);

        textInfoGame.setPreferredSize(new Dimension(200, 50));
        textInfoGame.setBackground(new Color(255, 255, 255));
        textInfoGame.setForeground(new Color(241, 3, 3));
        textInfoGame.setHorizontalAlignment(JLabel.CENTER);
        textInfoGame.setFont(new Font("Arial", Font.BOLD, 30));
        textInfoGame.setText("POLE:");

        gameInfoPanel.setPreferredSize(new Dimension(300, 900));
        gameInfoPanel.setBackground(Color.YELLOW);
        gameInfoPanel.setBounds(0, 0, 300, 900);
        gameInfoPanel.add(textInfoGame, BorderLayout.CENTER);
        gameInfoPanel.add(cardView);
        gameInfoPanel.add(dicePlaceholder, BorderLayout.SOUTH);

        textInfoPlayer.setPreferredSize(new Dimension(200, 200));
        textInfoPlayer.setBackground(new Color(255, 255, 255));
        textInfoPlayer.setForeground(new Color(241, 3, 3));
        textInfoPlayer.setHorizontalAlignment(JLabel.CENTER);
        textInfoPlayer.setFont(new Font("Arial", Font.BOLD, 40));
        textInfoPlayer.setText("Twoje karty:");

        playerInfoPanel.setPreferredSize(new Dimension(300, 900));
        playerInfoPanel.setBounds(1200, 0, 300, 900);
        gameInfoPanel.setBackground(Color.YELLOW);
        playerInfoPanel.add(textInfoPlayer, BorderLayout.CENTER);

        this.add(gameInfoPanel, BorderLayout.WEST);
        this.add(board, BorderLayout.CENTER);
        this.add(playerInfoPanel, BorderLayout.EAST);
        this.repaint();
    }
}
