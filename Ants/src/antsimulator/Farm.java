/**
 * Created by Enifs
 */

package antsimulator;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;


public class Farm implements Runnable
{
	// ----------------------------------------------------------------------------
	// Section: Constructors
	// ----------------------------------------------------------------------------


	public Farm(JPanel associatedCanvas, int numberOfAnts)
	{
		this.associatedCanvas = associatedCanvas;
		this.ants = new LinkedList<Ant>();
		this.map = new HashMap<Point, LinkedList<Feramon>>();

		for (int i = 0; i < numberOfAnts; i++)
		{
			this.ants.add(new Ant(null, new Point(this.hive)));
		}

	}

	// ----------------------------------------------------------------------------
	// Section: Getters and Setters
	// ----------------------------------------------------------------------------


	public int getTime()
	{
		return time;
	}


	public static void setGoOn(boolean goOn)
	{
		Farm.goOn = goOn;
	}


	// ----------------------------------------------------------------------------
	// Section: Other methods
	// ----------------------------------------------------------------------------
	public void drawOval(int x, int y, int w, int h)
	{
		this.associatedCanvas.getGraphics().fillOval(x, y, w, h);
	}


	public void drawAnts()
	{
		for (Ant ant : ants)
		{
			this.drawAnt(ant);
		}
	}


	private void drawAnt(Ant ant)
	{
		Graphics g = this.associatedCanvas.getGraphics();

		g.setColor(new Color(255, 0, 0));
		g.fillOval(ant.getLocation().x,
				ant.getLocation().y,
				4,
				4);
	}


	private void drawHive(int x, int y)
	{
		Graphics g = this.associatedCanvas.getGraphics();

		g.setColor(new Color(0, 0, 255));
		g.fillRect(x - 5, y - 5, 10, 10);
	}


	private void drawFood(int x, int y)
	{
		Graphics g = this.associatedCanvas.getGraphics();

		g.setColor(new Color(255, 150, 160));
		g.fillRect(x - 5, y - 5, 10, 10);
	}


	private void drawFeramon()
	{
		Graphics g = this.associatedCanvas.getGraphics();

		g.setColor(Color.gray);

		for (Point point : map.keySet())
		{
			g.fillOval(point.x - 1, point.y - 1, 2, 2);
		}
	}


	public void antActions()
	{
		for (Ant ant : ants)
		{
			HashMap<RelativeDirection, Point> goToCells = ant.getMoveToCells();

			switch (ant.getBehaviour())
			{
				case SEARCH:
					RelativeDirection dir = this.searchDecision(goToCells);
					break;
				case GO_HOME:
					break;
				case RANDOM:
					int x = RandomFactory.getRandomInteger() % 8;
					switch (x)
					{
						case 0:
							ant.moveLeft();
							break;
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
							ant.moveForward();
							break;
						case 7:
							ant.moveRight();
							break;
					}
					break;
			}
		}
	}


	private RelativeDirection searchDecision(HashMap<RelativeDirection, Point> goToCells)
	{
		RelativeDirection direction = RelativeDirection.FORWARD;

		return null;
	}


	public void go() throws InterruptedException
	{
		while (Farm.goOn)
		{
			Graphics g = this.associatedCanvas.getGraphics();
			g.setColor(new Color(204, 255, 204));
			g.fillRect(0, 0, 400, 400);

			this.antActions();

			this.drawFeramon();

			this.drawAnts();

			this.drawHive(this.hive.x, this.hive.y);
			this.drawFood(this.food.x, this.food.y);


			//this.associatedCanvas.revalidate();
			Thread.sleep(200);
			this.time++;
		}
	}


	public void run()
	{
		try
		{
			this.go();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------

	JPanel associatedCanvas;

	LinkedList<Ant> ants;
	//LinkedList<Hive> hives;
	//LinkedList<Food> food;

	private Point hive = new Point(150, 150);

	private Point food = new Point(100, 100);

	HashMap<Point, LinkedList<Feramon>> map;

	int time = 0;

	static boolean goOn = true;

}
