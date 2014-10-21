/**
 * Created by Enifs
 */
package antsimulator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class RandomFactory
{
	// ----------------------------------------------------------------------------
	// Section: Constructors
	// ----------------------------------------------------------------------------

	// ----------------------------------------------------------------------------
	// Section: Getters and Setters
	// ----------------------------------------------------------------------------


	// ----------------------------------------------------------------------------
	// Section: Other methods
	// ----------------------------------------------------------------------------
	public static int getRandomInteger()
	{
		if (RandomFactory.numbers.size() == 0)
		{
			Random r = new Random(System.currentTimeMillis());

			for (int i = 0; i < 100000; i++)
			{
				RandomFactory.numbers.add(r.nextInt());
			}
		}

		return RandomFactory.numbers.poll();
	}


	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------

	private static Queue<Integer> numbers = new LinkedList<Integer>();
}
