/**
 * Created by Anna on 16/10/2014.
 */
package antsimulator;

import java.awt.*;
import java.util.Set;


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
	// Section: Ant Management
	// ----------------------------------------------------------------------------

	public void addAnt()
	{
		this.residentAnts.add(new Ant(this.getTopLeftPoint()));
	}

	// ----------------------------------------------------------------------------
	// Section: Getters and Setters
	// ----------------------------------------------------------------------------

	public Set<Ant> getResidentAnts()
	{
		return residentAnts;
	}

	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------

	private Set<Ant> residentAnts;
}
