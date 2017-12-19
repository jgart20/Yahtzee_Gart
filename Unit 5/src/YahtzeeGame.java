import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
private YahtzeeDie die1;
private YahtzeeDie die2;
private YahtzeeDie die3;
private YahtzeeDie die4;
private YahtzeeDie die5;
private YahtzeeScorecard scoreboard;
public static final int SIDES = 6;


	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		die1 = new YahtzeeDie(SIDES);
        die2 = new YahtzeeDie(SIDES);
        die3 = new YahtzeeDie(SIDES);
        die4 = new YahtzeeDie(SIDES);
        die5 = new YahtzeeDie(SIDES);
        scoreboard = new YahtzeeScorecard();
	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for (int i = 0; i < 13; i++){
		    takeTurn();
        }
        scoreboard.printScoreCard();

        return scoreboard.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn() {
        Scanner s = new Scanner(System.in);
        rollDice();
        printDice();
        System.out.println("Are you (s)atisfied with your roll, or would you like to (r)oll again? (s/r)");
        String result = s.nextLine();
        if (result.equals("s")) {
            markScore();
        }
        else if (result.equals("r")) {
            chooseFrozen();
            rollDice();
            printDice();
            System.out.println("Are you (s)atisfied with your roll, or would you like to (r)oll again? (s/r)");
            String result2 = s.nextLine();
            if (result2.equals("s"))
                markScore();

            chooseFrozen();
            rollDice();
            printDice();
            markScore();
        }
    }
	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if (!die1.isFrozen()) {
            die1.rollDie();}
            die1.unfreezeDie();

        if (!die2.isFrozen()) {
            die2.rollDie();}
            die2.unfreezeDie();

        if (!die3.isFrozen()) {
            die3.rollDie();}
            die3.unfreezeDie();

        if (!die4.isFrozen()) {
            die4.rollDie();}
            die4.unfreezeDie();

        if (!die5.isFrozen()) {
            die5.rollDie();}
            die5.unfreezeDie();

	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
        Scanner s = new Scanner(System.in);
        System.out.println("Which die would you like to be frozen? enter 1 - 5 separated by spaces");
        String frozenDie = s.nextLine();
        for (int i = 0; i< frozenDie.length(); i++){
            if (frozenDie.charAt(i) == '1')
                die1.freezeDie();
            if (frozenDie.charAt(i) == '2')
                die2.freezeDie();
            if (frozenDie.charAt(i) == '3')
                die3.freezeDie();
            if (frozenDie.charAt(i) == '4')
                die4.freezeDie();
            if (frozenDie.charAt(i) == '5')
                die5.freezeDie();

        }
    }

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
        System.out.println(die1.getValue() + "\t" + die2.getValue() + "\t" + die3.getValue() + "\t" + die4.getValue() + "\t" + die5.getValue());
    }

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
        Scanner s = new Scanner(System.in);
        scoreboard.printScoreCard();
        System.out.print("Where would you like to place your score?\n" +
                "1. Ones \t7.  3 of Kind\n" +
                "2. Twos \t8.  4 of Kind\n" +
                "3. Threes \t9.  Full House\n" +
                "4. Fours \t10. Sm Straight\n" +
                "5. Fives \t11. Lg Straight\n" +
                "6. Sixes \t12. Yahtzee\n" +
                "\t\t13. Chance\n" +
                "Enter 1-13:");
        int result = s.nextInt();
        boolean results;
        if (result == 1 ) {
             results = scoreboard.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 2) {
            results = scoreboard.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 3) {
            results = scoreboard.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 4) {
            results = scoreboard.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 5) {
            results = scoreboard.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 6) {
            results = scoreboard.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 7) {
            results = scoreboard.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 8) {
            results = scoreboard.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 9) {
            results = scoreboard.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 10) {
            results = scoreboard.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 11) {
            results = scoreboard.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 12) {
            results = scoreboard.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else if (result == 13) {
            results = scoreboard.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
        }
        else {markScore();
            results = true;}

        if (!results) markScore();
    }
}