import java.util.Scanner;

public class YahtzeeDriver

{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/

	public static void main(String [] args)
	{
	    Scanner s = new Scanner(System.in);
			int score;
			int numGames = 0;
			int min = 0;
			int max = 0;
			int total = 0;
			String choice;
			YahtzeeGame myGame=new YahtzeeGame();
			System.out.println("Welcome to Jeremy's APCSA Yahtzee Game!");

			do {
                score= myGame.playGame();
                if (numGames == 0)
                    min = score;
                    max = score;
                numGames++;
                total += score;
                if (score<min)
                    min = score;
                if (score>max)
                    max = score;
                System.out.println("Would you like to play again? enter y or n");
                choice = s.nextLine();
            }while (choice.equals("y"));

        System.out.println(numGames);
        System.out.println(min);
        System.out.println(max);
        System.out.println(1.0*total/numGames);




    }
}
