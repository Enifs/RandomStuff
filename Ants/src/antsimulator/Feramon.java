/**
 * Created by Enifs
 */
package antsimulator;

import java.util.HashMap;
import java.util.Map;


public class Feramon
{
	// ----------------------------------------------------------------------------
    // Section: Constructors And Initialization
    // ----------------------------------------------------------------------------

	public Feramon(Type type, Farm farm)
	{
		this.initStrengthValueMap();
		this.type = type;
		this.creationTime = farm.getTime();
	}

	public Feramon(Type type, int creationTime)
	{
		this.initStrengthValueMap();
		this.creationTime = creationTime;
		this.type = type;
	}

	private void initStrengthValueMap()
	{
		this.strengthMap.put(Strength.WEAK, 100);
		this.strengthMap.put(Strength.NORMAL, 200);
		this.strengthMap.put(Strength.STRONG, 400);
	}
	// ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------

	public Type getType()
	{
		return this.type;
	}


	public int getCreationTime()
	{
		return creationTime;
	}

	// ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------

	public int intensity(int currentTime)
	{
		int intensity = this.strengthMap.get(this.strength) - currentTime + this.getCreationTime();

		if (intensity < 1)
		{
			this.active = false;
			intensity = 0;
		}

		return intensity;
	}

    // ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------
	private Ant ownerAnt;

	private Strength strength = Strength.NORMAL;
	private Map<Strength, Integer> strengthMap = new HashMap<Strength, Integer>();

	private int creationTime;
	private Type type = Type.A;

	private boolean active = true;

	private enum Strength
	{
		WEAK,
		NORMAL,
		STRONG
	}

	public enum Type
	{
		A,B
	}
}
