/**
 * Created by Enifs.
 */

package antsimulator.application;

import antsimulator.Arena;
import antsimulator.Food;
import antsimulator.Hive;

import java.util.ArrayList;


public class Engine
{
	// ----------------------------------------------------------------------------
	// Section: Time control
	// ----------------------------------------------------------------------------

		public void advance()
		{
			assert this.isReady() : "Engine is not ready to work yet!";
			// do stuff
			this.timePassed++;
		}

		public void advance(long time)
		{
			for (int i = 0; i < time; i++)
			{
				this.advance();
			}
		}

		public void advanceUntil(StopEvent stopEvent)
		{
			while  (!stopEvent.stop())
			{
				advance();
			}
		}
	// ----------------------------------------------------------------------------
	// Section: Accessors
	// ----------------------------------------------------------------------------

	public boolean isReady()
	{
		return arena != null && !this.food.isEmpty() && !this.hives.isEmpty();
	}

	public void addHive(Hive hive)
	{
		this.hives.add(hive);
	}

	public void addFood(Food food)
	{
		this.food.add(food);
	}

	public void setArena(Arena arena)
	{
		this.arena = arena;
	}
	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------

	private Arena arena;
	private ArrayList<Food> food = new ArrayList<Food>();
	private ArrayList<Hive> hives = new ArrayList<Hive>();

	long timePassed = 0;

	// ----------------------------------------------------------------------------
	// Section: Inner classes
	// ----------------------------------------------------------------------------

	public interface StopEvent
	{
		public boolean stop();
	}
}
