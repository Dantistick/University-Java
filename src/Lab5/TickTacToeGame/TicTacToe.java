package Lab5.TickTacToeGame;

public class TicTacToe extends Game{

    private final int ROWS = 3;
    private final int COLS = 3;

    private CellType[][] _board = new CellType[ROWS][COLS];
    private CellType _currentTurn;

    @Override
    protected void startGame() {
        clearBoard();
        _currentTurn = CellType.X;
    }

    @Override
    protected void gameLoop() {
        do
        {
            turn();
            switchTurn();
        }
        while (!isEnded());
    }

    @Override
    protected void endGame() { }

    // --------------------------------------------------------------------

    private void clearBoard(){
        for(int i = 0; i < ROWS; ++i)
            for(int j = 0; j < COLS; ++j)
                _board[i][j] = CellType.Empty;
    }

    private void turn(){
        System.out.println("Turn: " + _currentTurn);
    }

    private void switchTurn(){
        boolean isXTurn = _currentTurn == CellType.X;
        _currentTurn = isXTurn ? CellType.O : CellType.X;
    }

    private boolean isEnded(){
        if(isDraw())
        {
            System.out.println("Is Draw!");
            return true;
        }

        var winner = hasWinner();
        if(winner != CellType.Empty)
        {
            System.out.println("Winner is: " + winner.name());
            return true;
        }

        return false;
    }

    private CellType hasWinner(){
        for (int i = 0; i < 3; i++)
        {
            //строки
            if (_board[i][0] != CellType.Empty &&
                _board[i][0] == _board[i][1] &&
                _board[i][0] == _board[i][2])
            {
                return _board[i][0];
            }

            // столбцы
            if (_board[0][i] != CellType.Empty &&
                _board[0][i] == _board[1][i] &&
                _board[0][i] == _board[2][i])
            {
                return _board[0][i];
            }
        }

        // диагонали
        if (_board[0][0] != CellType.Empty &&
            _board[0][0] == _board[1][1] &&
            _board[0][0] == _board[2][2])
        {
            return _board[0][0];
        }

        if (_board[1][1] != CellType.Empty &&
            _board[1][1] == _board[0][2] &&
            _board[1][1] == _board[2][0])
        {
            return _board[1][1];
        }

        return CellType.Empty;
    }

    private boolean isDraw(){
        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLS; j++)
                if (_board[i][j] == CellType.Empty)
                    return false;

        return true;
    }

}
