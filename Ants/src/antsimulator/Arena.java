/**
 * Created by Enifs.
 */

package antsimulator;

import java.awt.*;


/**
 * Arena represents rectangle in ++ quadrant. with one corner in (0,0).
 * Width and Height represents number of rows and collums respectively.
 */
public class Arena
{
	// ----------------------------------------------------------------------------
	// Section: Constructors
	// ----------------------------------------------------------------------------

	public Arena(int width, int heigth)
	{
		this.width = width;
		this.heigth = heigth;
	}

	// ----------------------------------------------------------------------------
	// Section: Topology methods
	// ----------------------------------------------------------------------------

	public boolean contains(Point point)
	{
		boolean returnValue = point.getX() >= 0 && point.getX() < this.width &&
				point.getY() >= 0 && point.getY() < this.heigth;
		return returnValue;
	}

	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------

	int width = 0;
	int heigth = 0;
}
