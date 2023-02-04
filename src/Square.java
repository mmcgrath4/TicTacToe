import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private final int SQUARE_DIM = 100;
    private final int FIRSTX = SQUARE_DIM;
    private final int FIRSTY = SQUARE_DIM;


    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

    }

    public void draw(Graphics g, TicTacToeViewer view) {
        int x = FIRSTX + (col * SQUARE_DIM);
        int y = FIRSTY + (row * SQUARE_DIM);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, SQUARE_DIM, SQUARE_DIM);
        if (isWinningSquare) {
            g.setColor(Color.green);
            g.fillRect(x, y, SQUARE_DIM, SQUARE_DIM);
        }
        // Draw X and Y inside the square
        if (marker.equals(TicTacToe.O_MARKER)) {
            g.drawImage(view.getImages()[0],x + 20, y + 20, 60, 60, view);
        }
        else if (marker.equals(TicTacToe.X_MARKER)) {
            g.drawImage(view.getImages()[1],x + 20, y + 20, 60, 60, view);
        }
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
