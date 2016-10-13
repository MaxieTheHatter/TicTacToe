package tictactoe;
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //intro();
        boolean keepPlaying = true;

        
        while (keepPlaying)
        {
        GameBoard myGame = new GameBoard();
        myGame.drawBoard();
        int turnCounter = 1;

            while(myGame.gameActive() && turnCounter < 10 && keepPlaying)
            {
                if (turnCounter % 2 == 0 )
                    myGame.askPlayer('O');
                else
                    myGame.askPlayer('X');
                turnCounter++;
            
                System.out.println("\n");
                myGame.drawBoard();
                myGame.checkForWinner();
            
                if(turnCounter == 10)
                {
                System.out.println("It's a draw!");
                }
            }
            System.out.println("Want to play again? Yes or no");
            String choice = keyboard.nextLine();
            if (choice.equalsIgnoreCase("no"))
            {
                keepPlaying = false;               
            }
        }
        System.out.println("Thanks for playing!");
    }
    
    public static void intro() {
        System.out.println("Welcome to TicTacToe!\n"
                + "How many will be playing today?");
    }
    
    

}