import java.util.LinkedList;

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

		//level seperation (for/case by case)
			//
			// remove duplicates
			// put level in the large LinkedList

		//

		LinkedList<LinkedList<TicTacToeGame>> outer = new LinkedList<LinkedList<TicTacToeGame>>();

		LinkedList<TicTacToeGame> init = new LinkedList<TicTacToeGame>();
		TicTacToeGame initBoard = new TicTacToeGame(lines, columns, winLength);
		//System.out.println(initBoard);
		init.add(0, initBoard);
		outer.add(0, init);
		boolean unique=true;
		boolean playable=true;
		TicTacToeGame gameTemplate;

		int h=0;
		while(playable){
			LinkedList<TicTacToeGame> inner = new LinkedList<TicTacToeGame>();
			for(int i=0; i<outer.get(h).size(); i++){
				if(outer.get(h).get(i).getGameState()==GameState.PLAYING){
					for(int j=0; j<lines*columns; j++){
						if(outer.get(h).get(i).valueAt(j)==CellValue.EMPTY){
							gameTemplate = new TicTacToeGame(outer.get(h).get(i),j);
							//System.out.println(gameTemplate);
							unique=true;
							for(int k=0; k<inner.size(); k++){
								if(gameTemplate.equals(inner.get(k))){
									unique=false;
									break;
									//System.out.println("unique:"+unique);
								}
								//System.out.println("k:"+k);
							}
							if(unique){
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
			for(int l=0; l<inner.size(); l++){
				if(inner.get(l).getGameState()==GameState.PLAYING){
					playable=true;
				}
			}

			outer.add(inner);

			// for(int a=0; a<outer.size(); a++){
			// 	for(int b=0; b<outer.get(a).size(); b++){
			// 			System.out.println(outer.get(a).get(b));
			// 	}
			// }

			h++;
			//System.out.println("h:"+h);
			//System.out.println("OUTER length"+outer.size());
			//System.out.println(count+" OUTER LOOP!!!!!!!!!!!!!!!!!!!!!!");
		}

		//System.out.println("OUTER length"+outer.size());

		return outer;
	}
}
