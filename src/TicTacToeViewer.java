import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    private Square[][] board;
    private Image[] images;
    private final int GRID_DIM = 3;
    private TicTacToe t;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final int START = 75;


    public TicTacToeViewer(TicTacToe t) {
        this.t = t;
        this.board = t.getBoard();

        images = new Image[2];
        images[0] = new ImageIcon("Resources/O.png").getImage();
        images[1] = new ImageIcon("Resources/X.png").getImage();


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

    }


    public Image[] getImages() {
        return images;
    }

    public void paint(Graphics g) {
        int x = 150;
        int y = 150;
        g.setFont(new Font("Verdana", Font.ITALIC, 18));
        g.setColor(Color.RED);
        for (int i = 0; i < 3; i ++) {
            g.drawString(String.valueOf(i), x, START);
            x += 100;
        }


        for (int i = 0; i < 3; i ++) {
            g.drawString(String.valueOf(i), START, y);
            y += 100;
        }
        board = t.getBoard();
        for (int i  = 0; i < GRID_DIM; i ++) {
            for (int j = 0; j < GRID_DIM; j ++) {
                board[i][j].draw(g, this);
            }
        }

        g.setFont(new Font("Verdana", Font.BOLD, 36));
        g.setColor(Color.BLACK);
        if (t.checkTie()) {
            g.drawString("It's a Tie!", WINDOW_WIDTH/2, WINDOW_HEIGHT-50);
        }
        else if (t.getGameOver()) {
            String winner = t.getWinner();
            g.drawString(winner + " wins!", WINDOW_WIDTH/2, WINDOW_HEIGHT-50);
        }


    }
}
