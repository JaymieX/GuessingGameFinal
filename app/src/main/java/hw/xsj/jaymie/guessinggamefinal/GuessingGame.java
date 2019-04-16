package hw.xsj.jaymie.guessinggamefinal;

import java.util.ArrayList;
import java.util.Random;

public class GuessingGame {

    private int[][] board;

    private ArrayList<Integer> tokens;

    public GuessingGame() {
        // Init board
        board = new int[4][4];
        tokens = new ArrayList<>();

        tokens.add(0);
        tokens.add(0);
        tokens.add(1);
        tokens.add(1);
        tokens.add(2);
        tokens.add(2);
        tokens.add(3);
        tokens.add(3);
        tokens.add(4);
        tokens.add(4);
        tokens.add(5);
        tokens.add(5);
        tokens.add(6);
        tokens.add(6);
        tokens.add(7);
        tokens.add(7);

        flushBoard();
    }

    public void flushBoard() {
        Random rng = new Random();

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int index = rng.nextInt(tokens.size());

                board[row][col] = tokens.get(index);
                tokens.remove(index);
            }
        }
    }

    public int getItemAt(int row, int col) {
        return board[row][col];
    }
}
