/**
 * Symetrie
 */
public class Symetrie {
    
    /*public int[] coord (TicTacToeGame game, int boardIndex){
        int[] xy = new int [2];
        xy[0] = boardIndex/(game.columns);
        xy[1] = boardIndex%(game.lines);
        return xy;
    }*/


    public TicTacToeGame rotate (TicTacToeGame game){
        TicTacToeGame newGame = new TicTacToeGame();
        for (int i=game.columns-1; i>=0; i--){
            for (int j=i; j<game.lines*game.columns; j+=game.columns){
                newGame = new TicTacToeGame(newGame, j);
            }
        }
        return newGame;
    }

    public boolean symetry (TicTacToeGame game, TicTacToeGame newGame){
        // CODE HERE
        TicTacToeGame a = rotate(game);
        TicTacToeGame b = rotate(a);
        TicTacToeGame c = rotate(b);
        return (newGame.equals(a) || newGame.equals(b) || newGame.equals(c));
    }

}