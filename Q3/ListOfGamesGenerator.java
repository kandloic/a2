import java.util.LinkedList;

/**
 * ListOfGamesGenerator
 * <p>
 * This Class has one method the returns a LinkedList of LinkedLists of TicTacToeGames
 * the LinkedLists are from java.util.LinkedList
 *
 * @author Jean-Loic Kandikandi and Nicholas Morin
 */
public class ListOfGamesGenerator {
   /**
	  * generates all different games for the specified
	  * parameters. Each game is recorded only once.
	  * once a game is finished, it is not extended further
	  * @param lines
	  *  the number of lines in the game
	  * @param columns
	  *  the number of columns in the game
	  * @param sizeWin
	  *  the number of cells that must be aligned to win.
	  * @return
	  * a list of lists of game instances, ordered by levels
		*/

	//private static LinkedList<TicTacToeGame> generateLevel(LinkedList<TicTacToeGame> prevLevel, int lines, int columns, int winLength){}


	public static LinkedList<LinkedList<TicTacToeGame>> generateAllGames(int lines, int columns, int winLength){

		//YOUR CODE HERE

		LinkedList<LinkedList<TicTacToeGame>> outer = new LinkedList<LinkedList<TicTacToeGame>>();

		//Initial inner list and board construction
		LinkedList<TicTacToeGame> init = new LinkedList<TicTacToeGame>();
		TicTacToeGame initBoard = new TicTacToeGame(lines, columns, winLength);
		//System.out.println(initBoard);
		init.add(0, initBoard);
		outer.add(0, init);

		//variables for loop
		boolean unique=true;
		boolean playable=true;
		TicTacToeGame gameTemplate;
		boolean symetric;
		int h=0;

		//playable should only be false when all TicTacToeGames at a level are not in GameState.PLAYING
		while(playable){
			LinkedList<TicTacToeGame> inner = new LinkedList<TicTacToeGame>();
			//the code in comments is equivalent but this one goes faster for some unexplained reason
			for(TicTacToeGame niveau : outer.get(h)/*int i=0; i<outer.get(h).size(); i++*/){
				if(niveau.getGameState()==GameState.PLAYING){
					//loop through the board to create a copy that adds a value in the next empty space
					//a new board is created for each empty space
					for(int j=0; j<lines*columns; j++){
						if(niveau.valueAt(j)==CellValue.EMPTY){
							gameTemplate = new TicTacToeGame(niveau,j);
							//System.out.println(gameTemplate);
							unique=true;
							symetric=false;
							//Loops in all games in inner to see if there's a duplicate
							for(TicTacToeGame everyGame : inner){
								if(gameTemplate.equals(everyGame)){
									unique=false;
									break;
									//System.out.println("unique:"+unique);
								}
								//DIFFERENT FROM Q2: if theres a symetric board it breaks from the loop
								if (Symetrie.symetry(gameTemplate, everyGame)){
									symetric = true;
									break;
								}
								//System.out.println("k:"+k);
							}
							//Only add the board if it is unique and not symetric
							if(unique && !symetric){
								inner.add(gameTemplate);
							}
						}
					}
				}
				//count++;
				//System.out.println("i:"+i);
				//System.out.println(count+" INNER LOOP!!!!!!!!!!!!!!!!!!!!!!");
			}
			playable=false;
			//playable will be false unless there's a playable TicTacToeGame in inner
			for(int l=0; l<inner.size(); l++){
				if(inner.get(l).getGameState()==GameState.PLAYING){
					playable=true;
				}
			}

			//always adds the inner to the outer
			outer.add(inner);

			// for(int a=0; a<outer.size(); a++){
			// 	for(int b=0; b<outer.get(a).size(); b++){
			// 			System.out.println(outer.get(a).get(b));
			// 	}
			// }

			//It would have been nice to use a for on the outside, but a while and
			//this variable is the right way to do it.
			h++;
			//System.out.println("h:"+h);
			//System.out.println("OUTER length"+outer.size());
			//System.out.println(count+" OUTER LOOP!!!!!!!!!!!!!!!!!!!!!!");
		}

		//System.out.println("OUTER length"+outer.size());

		return outer;
	}
}
