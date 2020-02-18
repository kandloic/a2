/**
 * ComputerRandomPlayer
 */
public class ComputerRandomPlayer implements Player{
    public void play (TicTacToeGame game){
        if (game.getGameState()!=GameState.PLAYING){
            System.out.println("Error! Game is not playable!");
        } else {
            // System.out.println(game);
        	// System.out.print(game.nextCellValue() + " to play: ");
        	// String answer = Utils.console.readLine();
            int value = Utils.generator.nextInt(game.lines*game.columns+1);
                       
            if(value <= 0 || value >= (game.lines*game.columns)){
            	System.out.println("The value should be between 1 and " + (game.lines*game.columns));
            } else if(game.valueAt(value-1) != CellValue.EMPTY) {
            	System.out.println("This cell has already been played");
            } else {
            	game.play(value-1);
            }
        }
    }
}