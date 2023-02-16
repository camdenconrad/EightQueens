package EightQueens;

import java.awt.*;

public class Board {
    // has 8 queens
    // an 8 x 8

    public int boardSize = 8;
    public Queen[] queens = new Queen[boardSize];
    public int h;
    private int[][] board = new int[boardSize][boardSize];

    public Board() {


        // initialize board to 0s
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = 0;
            }
        }

        // add eight queens
        for (int i = 0; i < boardSize; i++) {
            int random = new java.util.Random().nextInt(boardSize);

            board[random][i] = 1;
            queens[i] = new Queen(new Point(random, i));
        }
    }

    public Board(Board b) {
        this.queens = b.getQueens();
        this.board = b.getBoard();
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int[][] getBoard() {
        return board;
    }

    public String printBoard() {
        this.updateBoard();

        StringBuilder inString = new StringBuilder();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                inString.append(board[i][j]).append(" ");
            }
            inString.append("\n");
        }

        return inString.toString();
    }

    public Queen[] getQueens() {
        return queens;
    }

    private void updateBoard() {
        // update board
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = 0;
            }
        }

        for (Queen q : queens) {
            board[q.getPosition().x][q.getPosition().y] = 1;
        }
    }

    protected void restart() {

        // initialize board to 0s
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = 0;
            }
        }

        // add eight queens
        for (int i = 0; i < boardSize; i++) {
            int random = new java.util.Random().nextInt(boardSize);

            board[random][i] = 1;
            queens[i] = new Queen(new Point(random, i));
        }
    }
}
