/**
 * Created by Anna on 16/10/2014.
 */

package antsimulator;

import java.awt.*;


public abstract class AntSite
{
	// ----------------------------------------------------------------------------
	// Section: Constructors
	// ----------------------------------------------------------------------------

	/**
	 * Creates an AntSite where
	 * @param topLeftPoint represents the top left point of site location on the farm;
	 * @param height is measured downwards;
	 * @param width is measured to the right of the topLeftPoint.
	 */
	public AntSite(Point topLeftPoint, int height, int width)
	{
		this.topLeftPoint = topLeftPoint;
		this.height = height;
		this.width = width;
	}

	// ----------------------------------------------------------------------------
	// Section: Getters and Setters
	// ----------------------------------------------------------------------------


	public Point getTopLeftPoint()
	{
		return topLeftPoint;
	}


	public int getHeight()
	{
		return height;
	}


	public int getWidth()
	{
		return width;
	}

	// ----------------------------------------------------------------------------
	// Section: Other methods
	// ----------------------------------------------------------------------------

	/**
	 * Detects whether given ant has stepped into the site
	 * @param antPoint - the given ant
	 * @return - true if ant is in, false otherwise
	 */
	private boolean containsAnt(Point antPoint)
	{
		if (this.topLeftPoint.getX() <= antPoint.getX() && this.topLeftPoint.getY() <= antPoint.getY())
		{
			if (this.topLeftPoint.getX() + this.width >= antPoint.getX() &&
					this.topLeftPoint.getY() + this.height >= antPoint.getY())
			{
				return true;
			}
		}
		return false;
	}

	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------

	private Point topLeftPoint;
	private int height;
	private int width;
}
