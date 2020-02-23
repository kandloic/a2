/**
 * ComputerRandomPlayer
 * <p>
 * This Class implements the Player class in this package
 * it implements the play method from Player
 *
 * @author Jean-Loic Kandikandi and Nicholas Morin
 */
public class ComputerRandomPlayer implements Player{
    /**
     * this is the play method
     * it is used to add a value in TicTacToeGame's Cellvalue array
     * @param game The TicTacToeGame object to which you want to add X's or O's
     */
    public void play (TicTacToeGame game){
        if (game.getGameState()!=GameState.PLAYING){
            System.out.println("Error! Game is not playable!");
        } else {
          //value represents a number between 0 and the maximum index
          int value = Utils.generator.nextInt(game.lines*game.columns);
          if (game.valueAt(value)==CellValue.EMPTY){
            game.play(value); 
          } else {
            // recursion to prevent a change of turns before a valid input has been entered
            play(game);
          }
        }
    }
    /**
     * toString shows "Robot Playing" for ComputerRandomPlayer
     * @return String to show the Robot is Playing
     * */
    public String toString(){
        return "Robot Playing";
    }
}
