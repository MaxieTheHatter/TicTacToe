package tictactoe;
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //intro();
        GameBoard myGame = new GameBoard();
        myGame.drawBoard();
        int counter = 1;
        boolean keepPlaying = true;
        String choice = null;
        
        //while (keepPlaying)
        //{
            while(myGame.gameActive() && counter < 10 && keepPlaying)
            {
                if (counter % 2 == 0 )
                    myGame.askPlayer('O');
                else
                    myGame.askPlayer('X');
                counter++;
            
                System.out.println("\n");
                myGame.drawBoard();
                myGame.checkForWinner();
            
                if(counter == 10)
                {
                System.out.println("It's a draw!");
                }
            }
            System.out.println("Want to play again? Yes or no");
            choice = keyboard.nextLine();
            if (choice.equals("No") || choice.equals("no"))
            {
                keepPlaying = false;               
            }
            else if (choice.equals("Yes") || choice.equals("yes"))
            {
                GameBoard newGame = new GameBoard();
            }
        //}
        System.out.println("Thanks for playing!");
    }
    
    public static void intro() {
        System.out.println("Welcome to TicTacToe!\n"
                + "How many will be playing today?");
    }
    
    

}