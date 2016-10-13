package tictactoe;
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean keepPlaying = true; //variabel för att kontrollera om spelet är igång
        
        while (keepPlaying)
        {
            GameBoard myGame = new GameBoard(); //importera klassen GameBoard
            myGame.drawBoard(); //kör metoden drawBoard
            int turnCounter = 1; //bestämt att det är första rundan

            while(myGame.gameActive() && turnCounter < 10 && keepPlaying)
            {
                if (turnCounter % 2 == 0 ) //om rundan är jämnt delbart med 2 är det spelare 2's tur
                    myGame.askPlayer('O');
                else
                    myGame.askPlayer('X');
                turnCounter++;
            
                System.out.println("\n");
                myGame.drawBoard();
                myGame.checkForWinner(turnCounter);

            }
            System.out.println("Want to play again? Yes or no");
            String choice = keyboard.nextLine(); //skapa variabel för valet
            if (choice.equalsIgnoreCase("no")) //se om input är no, se allt som små bokstäver
            {
                keepPlaying = false; //om spelare väljer no, sätt spelet som inaktivt               
            }
        }
        System.out.println("Thanks for playing!");
    }
    
    public static void intro() {
        System.out.println("Welcome to TicTacToe!\n"
                + "How many will be playing today?");
    }
    
    

}