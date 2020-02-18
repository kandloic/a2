/**
 * HumanPlayer
 */
public class HumanPlayer implements Player{
    public void play (TicTacToeGame game){
        if (game.getGameState()!=GameState.PLAYING){
            System.out.println("Error! Game is not playable!");
        } else {
            System.out.println(game);
        	System.out.print(game.nextCellValue() + " to play: ");
        	String answer = Utils.console.readLine();
        	int value;
            
            value = Integer.parseInt(answer)-1;
           
            if(value < 0 || value >= (game.lines*game.columns)){
                System.out.println("The value should be between 1 and " + (game.lines*game.columns));
                play(game);
            } else if(game.valueAt(value) != CellValue.EMPTY) {
                System.out.println("This cell has already been played");
                play(game);
            } else {
            	game.play(value);
            }
        }
    }
    public String toString(){
        return "Human Playing";
    }
}