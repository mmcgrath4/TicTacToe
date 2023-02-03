import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    private Square[][] board;
    private Image[] images;
    private final int GRID_DIM = 3;

    public TicTacToeViewer(Square[][] board) {
        this.board = board;

        images = new Image[2];
        images[0] = new ImageIcon("Resources/O.png").getImage();
        images[1] = new ImageIcon("Resources/X.png").getImage();

    }

    public Image[] getImages() {
        return images;
    }

    public void paint(Graphics g) {
        for (int i  = 0; i < GRID_DIM; i ++) {
            for (int j = 0; j < GRID_DIM; j ++) {
                board[i][j].draw(g, this);
            }
        }
    }
}
