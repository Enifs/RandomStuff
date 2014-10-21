/**
 * Created by Enifs.
 */

package antsimulator;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FeramonManager
{
	public FeramonManager()
	{
		for (Feramon.Type type : Feramon.Type.values())
		{
			this.map.put(type, new HashMap<CustomPoint, Feramon>());
		}
	}


	public void layFeramon(Feramon feramon, Point point, int time)
	{
		Map<CustomPoint, Feramon> map = this.map.get(feramon.getType());
		CustomPoint cPoint = new CustomPoint(point);
		Feramon oldFeramon = map.get(cPoint);

		if (oldFeramon == null)
		{
			map.put(cPoint, feramon);
		}
		else
		{
			if (oldFeramon.intensity(time) < feramon.intensity(time))
			{
				map.put(cPoint, feramon);
			}
		}
	}

	public Feramon fetchFeramon(Feramon.Type type, Point point)
	{
		CustomPoint cPoint = new CustomPoint(point);
		return this.map.get(type).get(cPoint);
	}

	Map<Feramon.Type, Map<CustomPoint, Feramon>> map = new HashMap<Feramon.Type, Map<CustomPoint, Feramon>>();

	private class CustomPoint
	{
		public CustomPoint(Point point)
		{
			this.x = point.x;
			this.y = point.y;
		}

		@Override
		public boolean equals(Object obj)
		{
			CustomPoint point = (CustomPoint) obj;
			return this.x == point.x && this.y == point.y;
		}

		int x;
		int y;
	}
}
