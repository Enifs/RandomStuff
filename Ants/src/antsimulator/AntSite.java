package antsimulator;

import java.awt.*;

/**
 * Created by Anna on 16/10/2014.
 */
public abstract class AntSite {

	// ----------------------------------------------------------------------------
	// Section: Constructors
	// ----------------------------------------------------------------------------

	/**
	 * Creates an AntSite where
	 * @param point represents the top left point of site location on the farm and
	 * @param height is measured downwards and
	 * @param width is measured to the right of the point
	 */
	public AntSite(Point point, int height, int width) {
		this.point = point;
		this.height = height;
		this.width = width;
	}

	// ----------------------------------------------------------------------------
	// Section: Other methods
	// ----------------------------------------------------------------------------

	/**
	 * Detects whether given ant has stepped into the site
	 * @param antPoint - the given ant
	 * @return - true if ant is in, false otherwise
	 */
	private boolean containsAnt(Point antPoint) {
		if (this.point.getX() <= antPoint.getX() && this.point.getY() <= antPoint.getY()) {
			if (this.point.getX() + this.width >= antPoint.getX() && this.point.getY() + this.height >=
					antPoint.getY()){
				return true;
			}
		}
		return false;
	}

	// ----------------------------------------------------------------------------
	// Section: Fields
	// ----------------------------------------------------------------------------
	private Point point;
	private int   height;
	private int   width;
}
