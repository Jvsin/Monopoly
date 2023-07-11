import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private Player currentPlayer;
    private final Board board;
    private JPanel gameInfoPanel = new JPanel();
    private JLabel textInfoGame = new JLabel();
    private JLabel textInfoPlayer = new JLabel();
    private JPanel playerInfoPanel = new JPanel();

    public int WINDOW_WIDTH = 1500;
    public int WINDOW_HEIGHT = 930;
    public Game(){
        board = new Board();
        setWindowParameters();
        Player player = new Player(PlayersColors.BLUE);
        board.setPawn(player,0);
    }

    private void setWindowParameters(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("MONOPOLY - WORLD CUP EDITION");

        textInfoGame.setPreferredSize(new Dimension(200, 200));
        textInfoGame.setBackground(new Color(255, 255, 255));
        textInfoGame.setForeground(new Color(241, 3, 3));
        textInfoGame.setHorizontalAlignment(JLabel.CENTER);
        textInfoGame.setFont(new Font("Arial", Font.BOLD, 40));
        textInfoGame.setText("TEST");

        gameInfoPanel.setPreferredSize(new Dimension(300,900));
        gameInfoPanel.setBounds(0,0,300,900);
        gameInfoPanel.add(textInfoGame,BorderLayout.CENTER);

        textInfoPlayer.setPreferredSize(new Dimension(200, 200));
        textInfoPlayer.setBackground(new Color(255, 255, 255));
        textInfoPlayer.setForeground(new Color(241, 3, 3));
        textInfoPlayer.setHorizontalAlignment(JLabel.CENTER);
        textInfoPlayer.setFont(new Font("Arial", Font.BOLD, 40));
        textInfoPlayer.setText("Twoje karty:");

        playerInfoPanel.setPreferredSize(new Dimension(300,900));
        playerInfoPanel.setBounds(1200,0,300,900);
        playerInfoPanel.setBackground(new Color(255, 255, 255));
        playerInfoPanel.add(textInfoPlayer,BorderLayout.CENTER);

        this.add(gameInfoPanel, BorderLayout.WEST);
        this.add(board, BorderLayout.CENTER);
        this.add(playerInfoPanel, BorderLayout.EAST);
        this.repaint();
    }
}
