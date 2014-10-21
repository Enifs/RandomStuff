/**
 * Created by Enifs.
 */

package antsimulator.application;

import antsimulator.*;

import java.util.ArrayList;


public class Engine
{
	// ----------------------------------------------------------------------------
	// Section: Time control
	// ----------------------------------------------------------------------------

		public void advance()
		{
			assert this.isReady() : "Engine is not ready to work yet!";

			for (Hive hive : this.hives)
			{
				for (Ant ant : hive.getResidentAnts())
				{
					this.moveAnt(ant);
				}
			}
			// do stuff
			this.timePassed++;
		}


	private void moveAnt(Ant ant)
	{
		switch(ant.getBehaviour())
		{
			case SEARCH:
//				break;
			case GO_HOME:
//				break;
			case RANDOM:
				this.randomMovement(ant);
				break;
		}
	}


	private void randomMovement(Ant ant)
	{
		int x = RandomFactory.getRandomInteger();
		x = x % 4;

		switch(x)
		{
			case 0:
				ant.moveStaticDown();

				if (!this.arena.contains(ant.getLocation()))
				{
					ant.moveStaticUp();
				}
				break;
			case 1:
				ant.moveStaticUp();

				if (!this.arena.contains(ant.getLocation()))
				{
					ant.moveStaticDown();
				}
				break;
			case 2:
				ant.moveStaticLeft();

				if (!this.arena.contains(ant.getLocation()))
				{
					ant.moveStaticRight();
				}
				break;
			case 3:
				ant.moveStaticRight();

				if (!this.arena.contains(ant.getLocation()))
				{
					ant.moveStaticLeft();
				}
				break;
		}

		if (ant.isCarryingFood())
		{
			if (ant.getHive().containsAnt(ant.getLocation()))
			{
				ant.getHive().storeFood();
				ant.setCarryingFood(false);
			}
		}
		else
		{
			for (Food f : this.food)
			{
				if (f.containsAnt(ant.getLocation()))
				{
					f.takeFoodBit();
					ant.setCarryingFood(true);
				}
			}
		}
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
			while (!stopEvent.stop())
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


	public ArrayList<Food> getFood()
	{
		return this.food;
	}


	public ArrayList<Hive> getHives()
	{
		return this.hives;
	}

	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------

	private Arena arena;
	private ArrayList<Food> food = new ArrayList<Food>();
	private ArrayList<Hive> hives = new ArrayList<Hive>();

	private FeramonManager feramonManager = new FeramonManager();

	long timePassed = 0;

	// ----------------------------------------------------------------------------
	// Section: Inner classes
	// ----------------------------------------------------------------------------

	public interface StopEvent
	{
		public boolean stop();
	}
}
