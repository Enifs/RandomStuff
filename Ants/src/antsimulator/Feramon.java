/**
 * Created by Enifs
 */
package antsimulator;

public class Feramon
{
	public Feramon(Type type, Farm farm)
	{
		this.type = type;
		this.creationTime = farm.getTime();
	}


	public int getcreationTime()
	{
		return creationTime;
	}
	// ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------
	private Ant ownerAnt;
	private Strength strength = Strength.NORMAL;
	private int creationTime;
	private Type type;

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
