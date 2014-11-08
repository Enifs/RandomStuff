/**
 * Created by Enifs.
 */

package antsimulator.application;

import antsimulator.Arena;
import antsimulator.Food;
import antsimulator.Hive;
import antsimulator.Visualiser;

import java.awt.*;


public class AntSimulator
{
	public static void main(String[] args)
	{
		AntSimulator simulator = new AntSimulator();
		simulator.run();
	}


	private void run()
	{
		this.engine.setArena(new Arena(5, 5));
		this.hive = new Hive(new Point(0, 0), 1, 1);
		this.engine.addHive(hive);
		this.food = new Food(new Point(4, 4), 1, 1);
		this.engine.addFood(food);

		food.setFoodReserve(100);
		hive.addAnt();
		hive.addAnt();
		hive.addAnt();
		hive.addAnt();

		if (this.engine.isReady())
		{
			this.engine.advanceUntil(new OneFoodStocked());
//
//			this.engine.advance(50);

			Visualiser visualiser = new Visualiser(this.engine, 1000, 500, Visualiser.Mode.Ants);
		}
	}

	Engine engine = new Engine();
	Hive hive;
	Food food;

	private class OneFoodStocked implements Engine.StopEvent
	{
		@Override
		public boolean stop()
		{
			return hive.getCollectedFood() > 0;
		}
	}
}
