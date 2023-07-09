import javax.swing.*;

public class Game extends JFrame {

    private final Board board;
    public Game(){
        board = new Board();
        setBoardParameters();
    }

    private void setBoardParameters(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 1000);
        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("MONOPOLY - WORLD CUP EDITION");
        this.add(board);
        this.repaint();
    }
}
