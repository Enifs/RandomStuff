/**
 * Created by Enifs
 */

package neo4jIntegration.databaseCommands;

import debug.Debug;
import org.neo4j.graphdb.*;

public class AddRelationshipCommand implements Neo4jCommand
{
	// ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

	public AddRelationshipCommand(Node source,
			Node target,
			RelationshipType type,
			GraphDatabaseService graphDb)
	{
		this.source = source;
		this.target = target;
		this.type = type;
		this.graphDb = graphDb;
	}

	// ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------

	public boolean isIdObtained()
	{
		return idObtained;
	}

	public long getRelationshipID()
	{
		return relationshipID;
	}

	public Relationship getRelationship()
	{
		return relationship;
	}

	// ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------
    @Override
    public void init ()
    {
		// Nothing to do here.
    }

    @Override
    public Node execute()
    {
		try (Transaction tx = graphDb.beginTx())
		{
			this.relationship = this.source.createRelationshipTo(this.target, this.type);
			this.relationshipID = this.relationship.getId();
			this.idObtained = true;
			tx.success();
		}

		Debug.println("Add relationship[id = " + this.relationshipID + "] executed.");
		return null;
	}
    // ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------

	//End points and type.
	private Node source;
	private Node target;

	private RelationshipType type;

	//Created edge and owner.
	private Relationship relationship;

	// Id of created relationship.
	private long relationshipID;
	private boolean idObtained = false;

	// graphbase that creates the relationship.
	private GraphDatabaseService graphDb;
}
