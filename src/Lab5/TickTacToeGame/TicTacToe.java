package Lab5.TickTacToeGame;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends Game {

    private static final int SIZE = 3;

    private final CellType[][] _board = new CellType[SIZE][SIZE];
    private final Scanner _scanner;
    private final Random _random = new Random();

    private CellType _currentTurn;
    private boolean _vsComputer;
    private CellType _computerSide;

    public TicTacToe(Scanner scanner) {
        _scanner = scanner;
        clearBoard();
    }

    @Override
    protected void startGame() {
        clearBoard();
        _currentTurn = CellType.X;

        System.out.println("Режим игры: 1 - два игрока, 2 - против компьютера");
        _vsComputer = readNumber(1, 2) == 2;

        if (_vsComputer) {
            System.out.println("Хотите ходить первым (X)? 1 - да, 2 - нет");
            _computerSide = readNumber(1, 2) == 1 ? CellType.O : CellType.X;
        }
    }

    @Override
    protected void gameLoop() {
        while (true) {
            printBoard();

            if (_vsComputer && _currentTurn == _computerSide)
                computerTurn();
            else
                playerTurn();

            if (isEnded()) {
                printBoard();
                return;
            }

            switchTurn();
        }
    }

    @Override
    protected void endGame() {
        System.out.println("Игра окончена.");
    }

    // --------------------------------------------------------------------

    private void clearBoard() {
        for (int i = 0; i < SIZE; ++i)
            for (int j = 0; j < SIZE; ++j)
                _board[i][j] = CellType.EMPTY;
    }

    private void playerTurn() {
        while (true) {
            System.out.println("Ход " + _currentTurn + ". Введите строку (1-3), затем столбец (1-3):");
            int row = readNumber(1, SIZE) - 1;
            int col = readNumber(1, SIZE) - 1;

            if (_board[row][col] == CellType.EMPTY) {
                _board[row][col] = _currentTurn;
                return;
            }

            System.out.println("Клетка занята, выберите другую.");
        }
    }

    private void computerTurn() {
        CellType opponent = _currentTurn == CellType.X ? CellType.O : CellType.X;

        int[] move = findWinningMove(_currentTurn);

        if (move == null)
            move = findWinningMove(opponent);

        if (move == null && _board[1][1] == CellType.EMPTY)
            move = new int[]{1, 1};

        if (move == null)
            move = randomFreeCell();

        _board[move[0]][move[1]] = _currentTurn;
        System.out.println("Компьютер (" + _currentTurn + ") ходит: " + (move[0] + 1) + " " + (move[1] + 1));
    }

    private int[] findWinningMove(CellType side) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (_board[i][j] != CellType.EMPTY)
                    continue;

                _board[i][j] = side;
                boolean wins = getWinner() == side;
                _board[i][j] = CellType.EMPTY;

                if (wins)
                    return new int[]{i, j};
            }
        }

        return null;
    }

    private int[] randomFreeCell() {
        while (true) {
            int row = _random.nextInt(SIZE);
            int col = _random.nextInt(SIZE);

            if (_board[row][col] == CellType.EMPTY)
                return new int[]{row, col};
        }
    }

    private void switchTurn() {
        boolean isXTurn = _currentTurn == CellType.X;
        _currentTurn = isXTurn ? CellType.O : CellType.X;
    }

    private boolean isEnded() {
        CellType winner = getWinner();
        if (winner != CellType.EMPTY) {
            System.out.println("Победил: " + winner);
            return true;
        }

        if (isDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    private CellType getWinner() {
        for (int i = 0; i < SIZE; i++) {
            // строки
            if (_board[i][0] != CellType.EMPTY &&
                _board[i][0] == _board[i][1] &&
                _board[i][0] == _board[i][2]) {
                return _board[i][0];
            }

            // столбцы
            if (_board[0][i] != CellType.EMPTY &&
                _board[0][i] == _board[1][i] &&
                _board[0][i] == _board[2][i]) {
                return _board[0][i];
            }
        }

        // диагонали
        if (_board[0][0] != CellType.EMPTY &&
            _board[0][0] == _board[1][1] &&
            _board[0][0] == _board[2][2]) {
            return _board[0][0];
        }

        if (_board[1][1] != CellType.EMPTY &&
            _board[1][1] == _board[0][2] &&
            _board[1][1] == _board[2][0]) {
            return _board[1][1];
        }

        return CellType.EMPTY;
    }

    private boolean isDraw() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (_board[i][j] == CellType.EMPTY)
                    return false;

        return true;
    }

    private void printBoard() {
        System.out.println();
        System.out.println("    1   2   3");

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "  ");

            for (int j = 0; j < SIZE; j++) {
                String symbol = _board[i][j] == CellType.EMPTY ? " " : _board[i][j].name();
                System.out.print(" " + symbol + " ");

                if (j < SIZE - 1)
                    System.out.print("|");
            }

            System.out.println();

            if (i < SIZE - 1)
                System.out.println("   ---+---+---");
        }

        System.out.println();
    }

    private int readNumber(int min, int max) {
        while (true) {
            System.out.print(">> ");

            if (_scanner.hasNextInt()) {
                int value = _scanner.nextInt();

                if (value >= min && value <= max)
                    return value;
            } else {
                _scanner.next();
            }

            System.out.println("Введите число от " + min + " до " + max);
        }
    }
}
