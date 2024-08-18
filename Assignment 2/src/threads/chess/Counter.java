package threads.chess;

import java.util.List;

public class Counter {
    public static boolean counter(List<Integer> board, int size, int error) {
        for (int i = size - 1; i >= 0; i--) {
            if (board.get(i) < size - 1) {
                board.set(i, board.get(i) + 1);
                for (int j = i + 1; j < size; j++) {
                    board.set(j, 0);
                }
                return true;
            }
        }
        return false;
    }
}
