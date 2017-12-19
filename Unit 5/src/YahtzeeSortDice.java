import java.util.ArrayList;
import java.util.Collections;

public class YahtzeeSortDice{
	int first;
	int second;
	int third;
	int fourth;
	int fifth;

	/* constructor: initializes the private data by sorting the order of the dice */
	public YahtzeeSortDice(int a, int b, int c, int d, int e)
	{
        ArrayList sorter = new ArrayList();
        sorter.add(a);
        sorter.add(b);
        sorter.add(c);
        sorter.add(d);
        sorter.add(e);

        Collections.sort(sorter);
        first = (int)sorter.get(0);
        second = (int)sorter.get(1);
        third = (int)sorter.get(2);
        fourth = (int)sorter.get(3);
        fifth = (int)sorter.get(4);

    }

	/* returns the minimum of the five numbers */
	public int getFirst()
	{
		return first;
	}

	/* returns the second smallest of the five number */
	public int getSecond()
	{
		return second;
	}

	/* returns the middle of the five numbers */
	public int getThird()
	{
		return third;
	}

	/* returns the second largest of the five numbers */
	public int getFourth()
	{
		return fourth;
	}

	/* returns the biggest of the five numbers */
	public int getFifth()
	{
		return fifth;
	}
}