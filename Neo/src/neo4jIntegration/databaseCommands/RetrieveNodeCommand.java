/**
 * Created by Enifs
 */
package neo4jIntegration.databaseCommands;

import neo4jIntegration.DefaultLabel;
import org.neo4j.graphdb.*;

public class RetrieveNodeCommand implements Neo4jCommand
{
    // ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

	public RetrieveNodeCommand(long id, GraphDatabaseService graphDb)
	{
		this.id = id;
		this.graphDb = graphDb;

		this.mode = Mode.GET_BY_ID;
	}

	public RetrieveNodeCommand(Label label,
			String attributeName,
			Object attributeValue,
			GraphDatabaseService graphDb)
	{
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
		this.label = label;
		this.graphDb = graphDb;

		this.mode = Mode.GET_BY_ATTRIBUTE_AND_LABEL;
	}

	public RetrieveNodeCommand(String attributeName, Object attributeValue, GraphDatabaseService graphDb)
	{
		this(new DefaultLabel(), attributeName, attributeValue, graphDb);
	}

	// ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------

	@Override
	public Node execute()
	{
		Node node = null;
		switch (this.mode)
		{
			case GET_BY_ID:
			{
				node = this.getByIdExecute();
				break;
			}
			case GET_BY_ATTRIBUTE_AND_LABEL:
			{
				node = this.getByAttributeAndLabelExecute();
				break;
			}
		}

		return node;
	}

	private Node getByAttributeAndLabelExecute()
	{
		Node node;
		ResourceIterable<Node> nodes = null;

		try (Transaction tx = graphDb.beginTx())
		{
			nodes =  this.graphDb.findNodesByLabelAndProperty(
					this.label,
					this.attributeName,
					this.attributeValue);

			node = nodes.iterator().next();
			tx.success();
		}

		return node;
	}

	private Node getByIdExecute()
	{
		Node node = null;

		try (Transaction tx = graphDb.beginTx())
		{
			node = this.graphDb.getNodeById(this.id);

			tx.success();
		}

		return node;
	}

	@Override
	public void init()
	{
		// Nothing to do here;
	}


	// ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------

	private Mode mode;

	private long id;

	private String attributeName;
	private Object attributeValue;

	private Label label;

	private GraphDatabaseService graphDb;

	private enum Mode
	{
		GET_BY_ID,
		GET_BY_ATTRIBUTE_AND_LABEL
	}
}
