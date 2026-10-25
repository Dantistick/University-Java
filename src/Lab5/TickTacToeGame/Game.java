package Lab5.TickTacToeGame;

public abstract class Game
{
    public void launch(){
        startGame();
        gameLoop();
        endGame();
    }

    protected abstract void startGame();
    protected abstract void gameLoop();
    protected abstract void endGame();
}
