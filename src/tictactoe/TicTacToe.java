package tictactoe;
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe!");
        boolean keepPlaying = true; //variabel för att kontrollera om spelet är igång
        int xWinCounter = 0;
        int oWinCounter = 0;
        int nrOfPlayers;
        String playerOne;
        String playerTwo;
        
        System.out.println("How many will be playing? 1-2");
        while(!keyboard.hasNextInt())
        {
            System.out.println("Invalid number of players, please enter 1-2");
            keyboard.next();
        }
        nrOfPlayers= keyboard.nextInt();
        
        if (nrOfPlayers == 2)
        {
            //skapa spelare ett (X)
            Player playerX = new Player('X');
            playerX.setName();
            playerOne = playerX.getName();

            //Skapa spelare två (O)
            Player playerO = new Player('O');
            playerO.setName();
            playerTwo = playerO.getName();
        }
        else
        {
             //skapa spelare ett (X)
            Player playerX = new Player('X');
            playerX.setName();
            playerOne = playerX.getName();

            //Skapa AI spelare (O)
            PlayerAI playerO = new PlayerAI('O');
            playerO.setName();
            playerTwo = playerO.getName();
        }
        
        
        while (keepPlaying)
        {
            GameBoard myGame = new GameBoard(); //skapa objekt GameBoard
            myGame.drawBoard(); //kör metoden drawBoard
            int turnCounter = 1; //bestämt att det är första rundan
            

            while(myGame.gameActive() && turnCounter < 10 && keepPlaying)
            {
                //om rundan är jämnt delbart med 2 är det spelare 2's tur
                if (turnCounter % 2 == 0 && nrOfPlayers == 2 ) 
                    myGame.askPlayer(playerTwo, 'O');
                else if (nrOfPlayers == 2)
                    myGame.askPlayer(playerOne, 'X');
                else if (turnCounter % 2 == 0 && nrOfPlayers == 1)
                    myGame.askPlayerAI(playerTwo, 'O');
                else if (nrOfPlayers == 1)
                    myGame.askPlayer(playerOne, 'X');
                turnCounter++;
            
                System.out.println("\n");
                myGame.drawBoard();
                myGame.checkForWinner(turnCounter);
                /*
                håller reda på vem som vunnit hur många gånger
                Om spelet är slut i början av spelare O's tur innebär det att X
                vunnit och vice versa.
                */
                if(myGame.gameActive() == false && turnCounter != 10)
                {
                    if(turnCounter % 2 == 0)
                    {
                        xWinCounter++;
                    }
                    else
                    {
                        oWinCounter++;
                    }
                }

            }
            System.out.println("Player "+playerOne+" has won "+xWinCounter
                    +" times and "+playerTwo+" has won "+oWinCounter+" times");
            System.out.println("Want to play again? Yes or no");
            String choice = keyboard.nextLine(); //skapa variabel för valet
            if (choice.equalsIgnoreCase("no")) //se om input är no, se allt som små bokstäver
            {
                keepPlaying = false; //om spelare väljer no, sätt spelet som inaktivt               
            }
        }
        System.out.println("Thanks for playing!");
    }

}