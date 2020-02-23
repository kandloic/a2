/**
 * HumanPlayer
 * <p>
 * This Class implements the Player class in this package
 * it implements the play method from Player
 *
 * @author Jean-Loic Kandikandi and Nicholas Morin
 */

public class HumanPlayer implements Player{

    /**
     *this is the play method
     *it is used to add a value in TicTacToeGame's Cellvalue array
     *@param game The TicTacToeGame object to which you want to add X's or O's
     */

    public void play (TicTacToeGame game){
        if (game.getGameState()!=GameState.PLAYING){
            System.out.println("Error! Game is not playable!");
        } else {
          //two prints for the user to visualize the game
          System.out.println(game);
        	System.out.print(game.nextCellValue() + " to play: ");
        	String answer = Utils.console.readLine(); //reads the given number
        	int value;

            value = Integer.parseInt(answer)-1; //because 1rst index is 0

            if(value < 0 || value >= (game.lines*game.columns)){
                //out of bounds case
                System.out.println("The value should be between 1 and " + (game.lines*game.columns));
                play(game);
            } else if(game.valueAt(value) != CellValue.EMPTY) {
                //Cell played case
                System.out.println("This cell has already been played");
                play(game); // recursion to prevent a change of turns before a valid input has been entered
            } else {
              //adds the X or O to the TicTacToeGame object
            	game.play(value);
            }
        }
    }
    /**
    *toString shows "Human Playing" for HumanPlayer
    *@return String to show the Human is Playing
    */
    public String toString(){
        return "Human Playing";
    }
}
