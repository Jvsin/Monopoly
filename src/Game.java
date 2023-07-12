import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Game extends JFrame {
    private final Player[] players;
    private Player currentPlayer;
    private final Board board;
    private final JPanel gameInfoPanel = new JPanel();
    private final JLabel textInfoGame = new JLabel();
    private final JLabel textInfoPlayer = new JLabel();
    private final JPanel playerInfoPanel = new JPanel();
    private Field cardView = null;
    private final JLabel dicePlaceholder = new JLabel();
    private final JLabel dicePlaceholderSecond = new JLabel();
    private Dice firstDice = new Dice();
    private Dice secondDice = new Dice();
    private int diceResult;

    private static int PLAYER_NUMBER;
    public int WINDOW_WIDTH = 1500;
    public int WINDOW_HEIGHT = 930;
    private final int START_BONUS = 400; // TODO: Ekonomia -> premia za przejscie przez start
    private final int HOUSE_PRICE = 500; // TODO: Ekonomia -> koszt dobudowania domu

    public Game() {
        board = new Board();
        players = new Player[PLAYER_NUMBER];
        if (PLAYER_NUMBER >= 1) {
            players[0] = new Player(PlayersColors.BLUE);
            board.setPawn(players[0], 0);
        }
        if (PLAYER_NUMBER >= 2) {
            players[1] = new Player(PlayersColors.RED);
            board.setPawn(players[1], 0);
        }
        if (PLAYER_NUMBER >= 3) {
            players[2] = new Player(PlayersColors.GREEN);
            board.setPawn(players[2], 0);
        }
        if (PLAYER_NUMBER == 4) {
            players[3] = new Player(PlayersColors.YELLOW);
            board.setPawn(players[3], 0);
        }
        currentPlayer = players[0];
        setDefaultCard();
        setWindowParameters();

        currentPlayer.tempFunAddCity(board.getField(1));
        currentPlayer.tempFunAddCity(board.getField(3));
        currentPlayer.tempFunAddCity(board.getField(11));
    }

    public static void startMenu() {
        Object[] options = {"2 graczy", "3 graczy", "4 graczy"};
        int check = JOptionPane.showOptionDialog(null, "Wybierz ilość graczy: ", "Monopoly",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        System.out.println(check);
        if (check == 0)
            PLAYER_NUMBER = 2;
        else if (check == 1)
            PLAYER_NUMBER = 3;
        else
            PLAYER_NUMBER = 4;
    }

    public void round() {
        for (Player player : players) {
            currentPlayer = player;
            setInformation();
            setDiceListeners();
            System.out.println("wynik kostki:" + diceResult);
            currentPlayer.playerMove(diceResult);
            board.setPawn(currentPlayer,currentPlayer.getPosition());
            setCardView();
            System.out.println("pozycja gracza: " + currentPlayer.getPlayerColor() + " " + currentPlayer.getPosition());
            diceResult = 0;
            repaintBoard();
            //TODO: Rozgrywka -> kolejnosc rund dla graczy
            //TODO: Kostka -> dodać listenery na 2 kostki na raz
        }
    }

    public void repaintBoard(){
        setCardView();
        board.repaint();
        gameInfoPanel.repaint();
        playerInfoPanel.repaint();
        setPlayerCards(currentPlayer);
    }
    private void setDiceListeners() {
        final CountDownLatch latch = new CountDownLatch(1);
        firstDice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                firstDice = (Dice) e.getSource();
                diceResult = firstDice.diceThrow() + secondDice.diceThrow();

                latch.countDown(); // Zwalnianie CountDownLatch po kliknięciu
            }
        });
        secondDice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                secondDice = (Dice) e.getSource();
                diceResult = firstDice.diceThrow() + secondDice.diceThrow();

                latch.countDown(); // Zwalnianie CountDownLatch po kliknięciu
            }
        });
        try {
            latch.await(); // Oczekiwanie na kliknięcie
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        firstDice.removeMouseListener(firstDice.getMouseListeners()[0]);
        secondDice.removeMouseListener(secondDice.getMouseListeners()[0]);
    }
    private void setInformation () {
        textInfoGame.setText("Ruch: " + currentPlayer.getPlayerColor());
    }
    private void setCardView() {
        Field tempField = board.getField(currentPlayer.getPosition());
        Image image = tempField.getFieldCard();
        cardView.setFieldCard(image);
        cardView.repaint();
    }
    private void setDefaultCard () {
        Image image = new ImageIcon("./assets/Cards/defaultCard.png").getImage();
        cardView = board.getField(0);
        cardView.setFieldCard(image);
        cardView.repaint();
    }

    private void setPlayerCards(Player currPlayer){
        ArrayList<Field> fieldToDisplay = new ArrayList<>();
        for(Field owns : currPlayer.getOwnedFields()){
            Field tempField = owns;
            tempField.setFieldCard(owns.getMiniFieldCard());
            tempField.setPreferredSize(new Dimension(100, 30));
            tempField.setBounds(0, 0, 100, 30);
            fieldToDisplay.add(tempField);
        }
        for(Field field : fieldToDisplay){
            playerInfoPanel.add(field);
        }
        playerInfoPanel.repaint();
    }

    public void setDiceView(int diceResult, Dice dicePlaceholder) {
        dicePlaceholder.setIcon(Dice.diceViews[diceResult - 1]);
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

        firstDice.setForeground(Color.white);
        firstDice.setPreferredSize(new Dimension(90, 90));
        firstDice.setBounds(50, 0, 90, 90);

        secondDice.setForeground(Color.white);
        secondDice.setPreferredSize(new Dimension(90, 90));
        secondDice.setBounds(50, 0, 90, 90);

        dicePlaceholder.setPreferredSize(new Dimension(200, 100));
        dicePlaceholder.setHorizontalAlignment(JLabel.LEFT);
        dicePlaceholder.add(firstDice);
        setDiceView(1, firstDice);

        dicePlaceholderSecond.setPreferredSize(new Dimension(200, 100));
        dicePlaceholderSecond.setHorizontalAlignment(JLabel.RIGHT);
        dicePlaceholderSecond.add(secondDice);
        setDiceView(4, secondDice);

        textInfoGame.setPreferredSize(new Dimension(200, 50));
        textInfoGame.setBackground(new Color(255, 255, 255));
        textInfoGame.setForeground(new Color(241, 3, 3));
        textInfoGame.setHorizontalAlignment(JLabel.CENTER);
        textInfoGame.setFont(new Font("Arial", Font.BOLD, 10));
        textInfoGame.setText("Ruch gracza: " + currentPlayer.getPlayerColor());

        gameInfoPanel.setPreferredSize(new Dimension(300, 900));
        gameInfoPanel.setBackground(Color.YELLOW);
        gameInfoPanel.setBounds(0, 0, 300, 900);
        gameInfoPanel.add(textInfoGame, BorderLayout.CENTER);
        gameInfoPanel.add(cardView);
        gameInfoPanel.add(dicePlaceholder);
        gameInfoPanel.add(dicePlaceholderSecond);

        textInfoPlayer.setPreferredSize(new Dimension(200, 200));
        textInfoPlayer.setBackground(new Color(255, 255, 255));
        textInfoPlayer.setForeground(new Color(241, 3, 3));
        textInfoPlayer.setHorizontalAlignment(JLabel.CENTER);
        textInfoPlayer.setFont(new Font("Arial", Font.BOLD, 20));
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
