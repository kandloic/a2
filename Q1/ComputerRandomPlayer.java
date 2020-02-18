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
            int value = Utils.generator.nextInt(game.lines*game.columns);

            if (game.valueAt(value)==CellValue.EMPTY){
                game.play(value);
            } else {
                play(game);
            }
                       
        }
    }
    public String toString(){
        return "Robot Playing";
    }
}