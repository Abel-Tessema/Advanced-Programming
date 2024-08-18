package threads.chess;

import java.util.ArrayList;
import java.util.List;

public class Worker implements Runnable {
    private final List<Integer> initialBoard;
    private final int startRow;
    private final int size;
    private final List<List<String>> solutions;

    public Worker(int startRow, int size, List<List<String>> solutions) {
        this.initialBoard = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            initialBoard.add(0);
        }
        this.startRow = startRow;
        this.size = size;
        this.solutions = solutions;
    }

    @Override
    public void run() {
        List<Integer> board = new ArrayList<>(initialBoard);
        board.set(0, startRow);

        while (true) {
            int error = Validator.checker(board);
            if (error == -1) {
                List<String> combination = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    char[] row = new char[size];
                    for (int j = 0; j < size; j++) {
                        row[j] = '.';
                    }
                    row[board.get(i)] = 'Q';
                    combination.add(new String(row));
                }
                synchronized (solutions) {
                    solutions.add(combination);
                }
            }

            if (!Counter.counter(board, size, error)) break;
        }
    }
}
