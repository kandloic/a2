/**
 * Symetrie
 */
/**
 * Symetrie
 * <p>
 * This Class has one method the returns a boolean if the board is symetric
 * @author Jean-Loic Kandikandi and Nicholas Morin
 */
public class Symetrie {

    /*public int[] coord (TicTacToeGame game, int boardIndex){
        int[] xy = new int [2];
        xy[0] = boardIndex/(game.columns);
        xy[1] = boardIndex%(game.lines);
        return xy;
    }*/


    /*public TicTacToeGame rotate (TicTacToeGame game){
        TicTacToeGame newGame = new TicTacToeGame();
        int h=0;

        for (int i=game.columns-1; i>=0; i--){
            for (int j=i; j<game.lines*game.columns; j+=game.columns){
                newGame.board[h] = game.valueAt(j);
                h++;
            }
        }
        return newGame;
    }*/

    /**
 	   * symetry takes two TicTacToeGames and determines wether or not they are symetric
     * the symetry can be up to 3 rotations, vertical, horizontal, diagonal, or counter-diagonal
     * this function only works for square TicTacToeGames
 	   * @param game
 	   *  a TicTacToeGame to compare with newGame
 	   * @param newGame
 	   *  the second TicTacToeGame to compare with game
 	   * @return
 	   * a boolean to represent if the two given TicTacToeGames are symetric in any way
 		 */
    public static boolean symetry (TicTacToeGame game, TicTacToeGame newGame){
        // CODE HERE

        // call on the TicTacToeGame method to make three rotated versions of the game
        TicTacToeGame a = game.rotate();
        TicTacToeGame b = a.rotate();
        TicTacToeGame c = b.rotate();

        // call on the TicTacToeGame methods to make a vertical and horizontal flipped version of game
        TicTacToeGame d = game.verticalFlip();
        TicTacToeGame e = game.horizontalFlip();

        // call on the TicTacToeGame methods to make a diagonal and counter-diagonal flipped version of game
        TicTacToeGame f = game.diagonalSymetry();
        TicTacToeGame g = game.counterDiagonalSymetry();

        // many "or"s to return true for any of the symetries
        return (newGame.equals(a) || newGame.equals(b) || newGame.equals(c) || newGame.equals(d) || newGame.equals(e) || newGame.equals(f) || newGame.equals(g));
    }

    // FOLLOWING CODE IS FOR TESTING PURPOSES - Loic K.

     /* public static void main(String[] args) {
        TicTacToeGame test = new TicTacToeGame();
        test.play(0);
        test.play(4);
        test.play(1);
        test.play(8);
        test.play(5);
        test.play(7);
        test.play(2);
        System.out.println(test);
        System.out.println("******************");

        TicTacToeGame test2 = new TicTacToeGame();
        test2 = test.counterDiagonalSymetry();
        System.out.println(test2);
        // System.out.println("******************");

        // System.out.println(symetry(test, test2));

        TicTacToeGame vtest = new TicTacToeGame();
        vtest.play(1);
        vtest.play(5);
        System.out.println(vtest);
        System.out.println("****************");

        TicTacToeGame vtest2 = new TicTacToeGame();
        vtest2 = vtest.horizontalFlip();
        System.out.println(vtest2);

    } */

}
