package antsimulator;

import java.awt.*;

/**
 * Created by Anna on 16/10/2014.
 */
public class Food extends AntSite
{
	// ----------------------------------------------------------------------------
	// Section: Constructors
	// ----------------------------------------------------------------------------
	public Food(Point topLeftCorner, int height, int width)
	{
		super(topLeftCorner, height, width);
	}

	// ----------------------------------------------------------------------------
	// Section: Getters and Setters
	// ----------------------------------------------------------------------------

	public int getFoodReserve()
	{
		return this.foodReserve;
	}


	public void setFoodReserve(int foodReserve)
	{
		this.foodReserve = foodReserve;
	}

	public void takeFoodBit()
	{
		this.foodReserve--;
	}

	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------
	private int foodReserve = 0;
}
