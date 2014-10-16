package antsimulator;

import java.awt.*;

/**
 * Created by Anna on 16/10/2014.
 */
public class Hive extends AntSite
{
	// ----------------------------------------------------------------------------
	// Section: Constructors
	// ----------------------------------------------------------------------------
	public Hive(Point topLeftCorner, int height, int width)
	{
		super(topLeftCorner, height, width);
	}


	// ----------------------------------------------------------------------------
	// Section: Getters and Setters
	// ----------------------------------------------------------------------------
	public int getResidentAnts()
	{
		return residentAnts;
	}


	public void setResidentAnts(int residentAnts)
	{
		this.residentAnts = residentAnts;
	}


	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------
	private int residentAnts;
}
