package threads.chess;

import java.util.List;

public class Validator {
    public static int checker(List<Integer> board) {
        int size = board.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (board.get(i) == board.get(j)) return j;
                if (Math.abs(board.get(i) - board.get(j)) == Math.abs(i - j)) return j;
            }
        }
        return -1;
    }
}
