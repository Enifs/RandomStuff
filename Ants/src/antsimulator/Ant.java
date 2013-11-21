/**
 * Created by Enifs
 */
package antsimulator;

import java.awt.*;
import java.util.HashMap;

public class Ant
{
    // ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

	public Ant(Point location, Farm ownerFarm)
	{
		this.location = location;
		this.ownerFarm = ownerFarm;
		this.id = IdFactory.getNextIntId();
		this.behaviour = Behaviour.RANDOM;
		this.direction = this.randomDirection();
	}

	// ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------

	public Point getLocation()
	{
		return location;
	}

	public Behaviour getBehaviour()
	{
		return behaviour;
	}
    // ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------

	private Direction randomDirection()
	{
		Direction rd = Direction.UP;
		int x = RandomFactory.getRandomInteger() % 4;

		switch (x)
		{
			case 0:
				rd = Direction.DOWN;
				break;
			case 1:
				rd = Direction.LEFT;
				break;
			case 2:
				rd = Direction.RIGHT;
				break;
			case 3:
				rd = Direction.UP;
				break;
		}

		return rd;
	}

	public void move(int deltax, int deltay)
	{
		int x = this.location.x;
		int y = this.location.y;

		x += deltax;
		y += deltay;

		this.location.setLocation(x, y);
	}

	public void move(Direction direction)
	{
		switch (direction)
		{
			case UP:
				this.location.move(0, 1);
				break;
			case DOWN:
				this.location.move(0, -1);
				break;
			case LEFT:
				this.location.move(-1, 0);
				break;
			case RIGHT:
				this.location.move(1, 0);
				break;
		}
	}

	public void relativeMove(RelativeDirection relativeDirection)
	{
		switch (relativeDirection)
		{
			case FORWARD:
				this.moveForward();
				break;
			case BACKWARD:
				this.moveBackward();
				break;
			case LEFT:
				this.moveLeft();
				break;
			case RIGHT:
				this.moveRight();
				break;
		}
	}

	public void moveForward()
	{
	 	switch (this.direction)
		{
			case UP:
				this.move(0, -1);
				break;
			case DOWN:
				this.move(0, 1);
				break;
			case LEFT:
				this.move(-1 , 0);
				break;
			case RIGHT:
				this.move(1, 0);
				break;
		}
	}


	public void moveBackward()
	{
		switch (this.direction)
		{
			case UP:
				this.move(0, 1);
				this.direction = Direction.DOWN;
				break;
			case DOWN:
				this.move(0, -1);
				this.direction = Direction.UP;
				break;
			case LEFT:
				this.move(1 , 0);
				this.direction = Direction.RIGHT;
				break;
			case RIGHT:
				this.move(-1, 0);
				this.direction = Direction.LEFT;
				break;
		}
	}


	public void moveLeft()
	{
		switch (this.direction)
		{
			case UP:
				this.move(-1, 0);
				this.direction = Direction.LEFT;
				break;
			case DOWN:
				this.move(1, 0);
				this.direction = Direction.RIGHT;
				break;
			case LEFT:
				this.move(0 , -1);
				this.direction = Direction.DOWN;
				break;
			case RIGHT:
				this.move(0, 1);
				this.direction = Direction.UP;
				break;
		}
	}


	public void moveRight()
	{
		switch (this.direction)
		{
			case UP:
				this.move(1, 0);
				this.direction = Direction.RIGHT;
				break;
			case DOWN:
				this.move(-1, 0);
				this.direction = Direction.LEFT;
				break;
			case LEFT:
				this.move(0 , 1);
				this.direction = Direction.UP;
				break;
			case RIGHT:
				this.move(0, -1);
				this.direction = Direction.DOWN;
				break;
		}
	}

	public HashMap<RelativeDirection, Point> getMoveToCells()
	{
		HashMap<RelativeDirection, Point> map = new HashMap<RelativeDirection, Point>();
		// Ants are allowed to scan only left, right and the cell right in front of it.
		switch (this.direction)
		{
			case UP:
				map.put(RelativeDirection.FORWARD, new Point(this.location.x, this.location.y - 1));
				map.put(RelativeDirection.LEFT, new Point(this.location.x - 1, this.location.y));
				map.put(RelativeDirection.RIGHT, new Point(this.location.x + 1, this.location.y));
				break;
			case DOWN:
				map.put(RelativeDirection.FORWARD, new Point(this.location.x, this.location.y + 1));
				map.put(RelativeDirection.LEFT, new Point(this.location.x + 1, this.location.y));
				map.put(RelativeDirection.RIGHT, new Point(this.location.x - 1, this.location.y));
				break;
			case LEFT:
				map.put(RelativeDirection.FORWARD, new Point(this.location.x - 1, this.location.y));
				map.put(RelativeDirection.LEFT, new Point(this.location.x, this.location.y + 1));
				map.put(RelativeDirection.RIGHT, new Point(this.location.x, this.location.y - 1));
				break;
			case RIGHT:
				map.put(RelativeDirection.FORWARD, new Point(this.location.x + 1, this.location.y));
				map.put(RelativeDirection.LEFT, new Point(this.location.x, this.location.y - 1));
				map.put(RelativeDirection.RIGHT, new Point(this.location.x, this.location.y + 1));
				break;
		}

		return map;
	}

	// ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------
	private Point location;
	private Direction direction;

	private long id;

	private Farm ownerFarm;

	private Behaviour behaviour;
}
