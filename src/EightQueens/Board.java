package EightQueens;

import java.awt.*;

public class Board {
    // has 8 queens
    // an 8 x 8

    public Queen[] queens = new Queen[8];
    private int[][] board = new int[8][8];

    public Board() {

        // initialize board to 0s
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }

        // add eight queens
        for (int i = 0; i < 8; i++) {
            int random = new java.util.Random().nextInt(8);

            board[random][i] = 1;
            queens[i] = new Queen(new Point(random, i));
        }
    }

    public Board(Board b) {
        this.queens = b.getQueens();
        this.board = b.getBoard();
    }

    public int getNumConflicts() {
        return Helper.findConflicts(this.queens);
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public String printBoard() {
        this.updateBoard();

        StringBuilder inString = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                inString.append(" ").append(board[i][j]);
            }
            inString.append("\n");
        }

        return inString.toString();
    }

    public Queen[] getQueens() {
        return queens;
    }

    public void setQueens(Queen[] queens) {
        this.queens = queens;
    }

    private void updateBoard() {
        // update board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }

        for (Queen q : queens) {
            board[q.getPosition().x][q.getPosition().y] = 1;
        }
    }

    protected void restart() {

        // initialize board to 0s
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }

        // add eight queens
        for (int i = 0; i < 8; i++) {
            int random = new java.util.Random().nextInt(8);

            board[random][i] = 1;
            queens[i] = new Queen(new Point(random, i));
        }
    }
}
