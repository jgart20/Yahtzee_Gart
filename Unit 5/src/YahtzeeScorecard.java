public class YahtzeeScorecard
{
	/* instance data given */
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int threeKind;
	private int fourKind;
	private int fiveKind;
	private int chance;
	private int fullHouse;
	private int smStraight;
	private int lgStraight;
	private boolean bonus;

	/* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
	public YahtzeeScorecard()
	{
		ones = -1;
		twos = -1;
		threes = -1;
		fours = -1;
		fives = -1;
		sixes = -1;
		threeKind = -1;
		fourKind = -1;
		fiveKind = -1;
		chance = -1;
		fullHouse = -1;
		smStraight = -1;
		lgStraight = -1;
		bonus = false;
	}

	/* 1. If the field is already full, return false
	   2. Set data value ones equal to number of ones rolled multiplied by one.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markOnes(int die1, int die2, int die3, int die4, int die5)
	{
		if (ones != -1)
		    return false;

		int numRolled = 0;
		if (die1 == 1)
		    numRolled++;
        if (die2 == 1)
            numRolled++;
        if (die3 == 1)
            numRolled++;
        if (die4 == 1)
            numRolled++;
        if (die5 == 1)
            numRolled++;
        ones = numRolled*1;
        updateBonus();
        return true;
	}

	/* 1. If the field is already full, return false
	   2. Set data value twos equal to number of twos rolled multiplied by two.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markTwos(int die1, int die2, int die3, int die4, int die5)
	{
        if (twos != -1)
            return false;

        int numRolled = 0;
        if (die1 == 2)
            numRolled++;
        if (die2 == 2)
            numRolled++;
        if (die3 == 2)
            numRolled++;
        if (die4 == 2)
            numRolled++;
        if (die5 == 2)
            numRolled++;
        twos = numRolled*2;
        updateBonus();
        return true;
	}

	/* 1. If the field is already full, return false
	   2. Set data value threes equal to number of threes rolled multiplied by three.
	   3. Update the bonus (call updateBonus())
	   4. Return true  */
	public boolean markThrees(int die1, int die2, int die3, int die4, int die5)
	{
        if (threes != -1)
            return false;

        int numRolled = 0;
        if (die1 == 3)
            numRolled++;
        if (die2 == 3)
            numRolled++;
        if (die3 == 3)
            numRolled++;
        if (die4 == 3)
            numRolled++;
        if (die5 == 3)
            numRolled++;
        threes = numRolled*3;
        updateBonus();
        return true;
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fours equal to number of fours rolled multiplied by four.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFours(int die1, int die2, int die3, int die4, int die5)
	{
        if (fours != -1)
            return false;

        int numRolled = 0;
        if (die1 == 4)
            numRolled++;
        if (die2 == 4)
            numRolled++;
        if (die3 == 4)
            numRolled++;
        if (die4 == 4)
            numRolled++;
        if (die5 == 4)
            numRolled++;
        fours = numRolled*4;
        updateBonus();
        return true;
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fives equal to number of fives rolled multiplied by five.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFives(int die1, int die2, int die3, int die4, int die5)
	{
        if (fives != -1)
            return false;

        int numRolled = 0;
        if (die1 == 5)
            numRolled++;
        if (die2 == 5)
            numRolled++;
        if (die3 == 5)
            numRolled++;
        if (die4 == 5)
            numRolled++;
        if (die5 == 5)
            numRolled++;
        fives = numRolled*5;
        updateBonus();
        return true;
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value sixes equal to number of sixes rolled multiplied by six.
	   3. Update the bonus (call updateBonus())
	   4. Returns true */
	public boolean markSixes(int die1, int die2, int die3, int die4, int die5)
	{
        if (sixes != -1)
            return false;

        int numRolled = 0;
        if (die1 == 6)
            numRolled++;
        if (die2 == 6)
            numRolled++;
        if (die3 == 6)
            numRolled++;
        if (die4 == 6)
            numRolled++;
        if (die5 == 6)
            numRolled++;
        sixes = numRolled*6;
        updateBonus();
        return true;
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually three of the same value.
		   If there are, set the data value threeKind to the value of all five dice.
		   If there aren�t set the value to 0.
	   	   (Hint: use YahtzeeSortDice class!)
	   	4. Return true   */
	public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
        if (threeKind != -1)
            return false;

        YahtzeeSortDice d = new YahtzeeSortDice(die1,die2,die3,die4,die5);
        boolean areThree = (d.getFifth()==d.getFourth() && d.getFourth() == d.getThird()) ||
                (d.getSecond()==d.getFourth() && d.getFourth() == d.getThird()) ||
                (d.getSecond()==d.getFirst() && d.getFirst() == d.getThird());
        if (areThree) threeKind = die1+die2+die3+die4+die5;
        else if (!areThree) threeKind = 0;
        return true;
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four of the same value.
		   If there are, set the data value fourKind to the value of all five dice.
		   If there aren�t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		4. Return true  */
	public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
        if (fourKind != -1)
            return false;

        YahtzeeSortDice d = new YahtzeeSortDice(die1,die2,die3,die4,die5);
        boolean areFour = (d.getFifth()==d.getFourth() && d.getFourth() == d.getThird() && d.getThird() == d.getSecond()) ||
                (d.getFourth() == d.getThird() && d.getThird() == d.getSecond() && d.getSecond() == d.getFirst());
        if (areFour) fourKind = die1+die2+die3+die4+die5;
        else if (!areFour) fourKind = 0;
        return true;
	}

	/* 1. If the field is already full, return false
	   2. Check to see if there are actually three die with the same value, and two with another value.
	      If there are, set the data value fullHouse to 25.
	      If there aren�t set the value to 0.
	      (Hint: Use YahtzeeSortedDice class!)
       3. Return true   */
	public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5)
	{
        if (fullHouse != -1)
            return false;

        YahtzeeSortDice d = new YahtzeeSortDice(die1,die2,die3,die4,die5);
        boolean areFull = (d.getFirst()==d.getSecond()&&d.getSecond()==d.getThird()&&d.getFourth()==d.getFifth()) ||
                (d.getFirst()==d.getSecond()&&d.getThird()==d.getFourth()&&d.getFourth()==d.getFifth());
        if (areFull) fullHouse = 25;
        else if (!areFull) fullHouse = 0;
        return true;
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four consecutive dice numbers.
		   If there are, set the data value smStraight to 30.
		   If there aren�t set the value to 0.
		   (Hint: Use YahtzeeSortedDice class)
		4. Return true  */
	public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5)
	{
		if (smStraight != -1)
			return false;

		YahtzeeSortDice d = new YahtzeeSortDice(die1,die2,die3,die4,die5);
		boolean areFour = (d.getFirst()+1==d.getSecond()&&d.getSecond()+1==d.getThird()&&d.getThird()+1==d.getFourth()) ||
                (d.getSecond()+1==d.getThird()&&d.getThird()+1==d.getFourth()&&d.getFourth()+1==d.getFifth());
		if (areFour) smStraight = 30;
		else if (!areFour) smStraight = 0;
		return true;
    }

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually five consecutive dice numbers.
		   If there are, set the data value lgStraight to 40.
		   If there aren�t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		3. Return true  */
	public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
	{
        if (lgStraight != -1)
            return false;

        YahtzeeSortDice d = new YahtzeeSortDice(die1,die2,die3,die4,die5);
        boolean areFive = (d.getFirst()+1==d.getSecond()&&d.getSecond()+1==d.getThird()&&d.getThird()+1==d.getFourth()&&d.getFourth()+1==d.getFifth());
        if (areFive) lgStraight = 40;
        else if (!areFive) lgStraight = 0;
        return true;
	}

	/* 1. If the field is already full, return false
	   2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there aren�t set the value to 0;
       3. Return true   */
	public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5)
	{
        if (fiveKind != -1)
            return false;

        YahtzeeSortDice d = new YahtzeeSortDice(die1,die2,die3,die4,die5);
        boolean areFiveEqual = (die1==die2&&die2==die3&&die3==die4&&die4==die5);
        if (areFiveEqual) fiveKind = 50;
        else if (!areFiveEqual) fiveKind = 0;
        return true;
	}

	/* 1. If the field is already full, return false
	   2. Set the data value chance to the value of all five dice.
	   3. Return true  */
	public boolean markChance(int die1, int die2, int die3, int die4, int die5)
	{
        if (chance != -1)
            return false;

        chance = die1+die2+die3+die4+die5;
        return true;
	}

	/* 	1. If the bonus has already been assigned, do nothing
		2. If the upper section�s total is 63 or greater, set the data value bonus to true */
	private void updateBonus()
	{
		if (!bonus){
            if (getUpperTotal() >= 63) {
                bonus = true;
            }
        }
	}

	/* 	returns the upper total, remember incompletes (-1s) should not be factored in! */
	public int getUpperTotal()
	{
		int upperTotal = 0;
		if (ones!=-1)
		    upperTotal += ones;
        if (twos!=-1)
            upperTotal += twos;
        if (threes!=-1)
            upperTotal += threes;
        if (fours!=-1)
            upperTotal += fours;
        if (fives!=-1)
            upperTotal += fives;
        if (sixes!=-1)
            upperTotal += sixes;

        return upperTotal;
	}

	/* 	returns the lower total, remember incompletes (-1s) should not be factored in! */
	public int getLowerTotal()
	{
		int lowerTotal =0;
        if (threeKind!=-1)
            lowerTotal += threeKind;
        if (fourKind!=-1)
            lowerTotal += fourKind;
        if (fullHouse!=-1)
            lowerTotal += fullHouse;
        if (smStraight!=-1)
            lowerTotal += smStraight;
        if (lgStraight!=-1)
            lowerTotal += lgStraight;
        if (fiveKind!=-1)
            lowerTotal += fiveKind;
        if (chance!=-1)
            lowerTotal += chance;

        return lowerTotal;
	}

	/* 	returns the grand total, remember incompletes (-1s) should not be factored in! */
	public int getGrandTotal()
	{
		return getLowerTotal()+ getUpperTotal();
	}

	/*	Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
		Sample:
		**********************************
		*  	    Yahtzee Score Card		 *
		*  			        		  	 *
		* 	Ones:				__		 *
		* 	Twos:				__		 *
		* 	Threes:				__		 *
		* 	Fours:				__		 *
		* 	Fives:				25		 *
		* 	Sixes:				__		 *
		*								 *
		*	Upper Bonus:		 0		 *
		* 	Upper Total:   		25		 *
		*								 *
		*	3 of Kind:			__		 *
		* 	4 of Kind:			__		 *
		* 	Full House:			25		 *
		* 	Sm Straight:		__		 *
		* 	Lg  Straight:		__		 *
		* 	Yahtzee:	  		 0		 *
		* 	Chance:				__		 *
		*								 *
		* 	Lower Total:		25		 *
		*								 *
		* 	Grand Total:		50		 *
		**********************************
		already implemented
	*/
	public void printScoreCard()
	{
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*      Yahtzee Score Card       *");
		System.out.println("*                               *");
		System.out.print("*  Ones:\t\t");
		if(ones==-1)System.out.print("__");
		else System.out.print(ones);
		System.out.println("\t*");
		System.out.print("*  Twos:\t\t");
		if(twos==-1)System.out.print("__");
		else System.out.print(twos);
		System.out.println("\t*");
		System.out.print("*  Threes:\t\t");
		if(threes==-1)System.out.print("__");
		else System.out.print(threes);
		System.out.println("\t*");
		System.out.print("*  Fours:\t\t");
		if(fours==-1)System.out.print("__");
		else System.out.print(fours);
		System.out.println("\t*");
		System.out.print("*  Fives:\t\t");
		if(fives==-1)System.out.print("__");
		else System.out.print(fives);
		System.out.println("\t*");
		System.out.print("*  Sixes:\t\t");
		if(sixes==-1)System.out.print("__");
		else System.out.print(sixes);
		System.out.println("\t*");
		System.out.println("*\t\t\t\t*");
		System.out.print("*  Upper Bonus:\t\t");
		if(bonus)System.out.print("35");
		else System.out.print("0");
		System.out.println("\t*");
		System.out.print("*  Upper Total:\t\t");
		System.out.print(this.getUpperTotal());
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  3 of Kind:\t\t");
		if(threeKind==-1)System.out.print("__");
		else System.out.print(threeKind);
		System.out.println("\t*");
		System.out.print("*  4 of Kind:\t\t");
		if(fourKind==-1)System.out.print("__");
		else System.out.print(fourKind);
		System.out.println("\t*");
		System.out.print("*  Full House:\t\t");
		if(fullHouse==-1)System.out.print("__");
		else System.out.print(fullHouse);
		System.out.println("\t*");
		System.out.print("*  Sm Straight:\t\t");
		if(smStraight==-1)System.out.print("__");
		else System.out.print(smStraight);
		System.out.println("\t*");
		System.out.print("*  Lg Straight:\t\t");
		if(lgStraight==-1)System.out.print("__");
		else System.out.print(lgStraight);
		System.out.println("\t*");
		System.out.print("*  Yahtzee:\t\t");
		if(fiveKind==-1)System.out.print("__");
		else System.out.print(fiveKind);
		System.out.println("\t*");
		System.out.print("*  Chance:\t\t");
		if(chance==-1)System.out.print("__");
		else System.out.print(chance);
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  Lower Total:\t\t");
		System.out.print(this.getLowerTotal());
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  Grand Total:\t\t");
		System.out.print(this.getGrandTotal());
		System.out.println("\t*");
		System.out.println("**********************************");
		System.out.println();
	}


}