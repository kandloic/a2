

public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If two parameters line  and column
     * are passed, they are used. 
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {

        StudentInfo.display();

        TicTacToeGame game;
        int lines = 3;
        int columns = 3;
        int win = 3;

   
        try{
            if (args.length >= 2) {
                lines = Integer.parseInt(args[0]);
                if(lines<2){
                    System.out.println("Invalid argument, using default...");
                    lines = 3;
                }
                columns = Integer.parseInt(args[1]);
                if(columns<2){
                    System.out.println("Invalid argument, using default...");
                    columns = 3;
                }
            }
            if (args.length >= 3){
                win = Integer.parseInt(args[2]);
                if(win<2){
                    System.out.println("Invalid argument, using default...");
                    win = 3;
                }
            } 
            if (args.length > 3){
                System.out.println("Too many arguments. Only the first 3 are used.");
            } 

        } catch(NumberFormatException e){
            System.out.println("Invalid argument, using default...");
            lines   = 3;
            columns  = 3;
            win = 3;
        }

        game = new TicTacToeGame(lines, columns, win);
        
        HumanPlayer human = new HumanPlayer();
        ComputerRandomPlayer comp = new ComputerRandomPlayer();
        Player[] players = {human, comp};

        // YOUR CODE HERE    

        int first = Utils.generator.nextInt(2);

        int turn = first;

        while (game.getGameState()==GameState.PLAYING){
            System.out.println("Player "+(turn+1)+"s turn.");
            System.out.println(players[turn]+" - cue :"+turn);
            players[turn].play(game);
            turn = Math.abs(turn-1);
            

            if (game.getGameState()!=GameState.PLAYING) {
                System.out.println("Game over");
                System.out.println(game);
                System.out.println("Result: "+game.getGameState());

                String replay = Utils.console.readLine("Want to play again?");

                if(replay.equals("y") || replay.equals("Y")){
                    first = Math.abs(first-1);
                    turn = first;
                    TicTacToeGame newGame = new TicTacToeGame(game.lines, game.columns, game.sizeWin);
                    game = newGame;
                }

            }
        }

    }

}