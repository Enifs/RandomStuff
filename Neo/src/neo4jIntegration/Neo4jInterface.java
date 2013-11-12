package neo4jIntegration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

public class Neo4jInterface
{
	// ----------------------------------------------------------------------------
	// Section: Constructors
	// ----------------------------------------------------------------------------
	public Neo4jInterface(String path)
	{
		this.neoShell = new Neo4JShell(path);
		this.graphDb = this.neoShell.getGraphDb();
	}

	public Neo4jInterface()
	{
		this.neoShell = new Neo4JShell();
		this.graphDb = this.neoShell.getGraphDb();
	}

	// ----------------------------------------------------------------------------
	// Section: Other methods
	// ----------------------------------------------------------------------------
	public void addNode(String key)
	{
		try (Transaction tx = graphDb.beginTx())
		{
			Node node = this.graphDb.createNode();
			node.setProperty("key", key);
			node.addLabel(new ProjectNodeLabel());
			tx.success();
		}
	}

	public void addEdge(String keyA, String keyB)
	{
		try (Transaction tx = graphDb.beginTx())
		{
			Node nodeA = (Node) this.graphDb.findNodesByLabelAndProperty(new ProjectNodeLabel(), "key", keyA);
			Node nodeB = (Node) this.graphDb.findNodesByLabelAndProperty(new ProjectNodeLabel(), "key", keyB);

			Relationship rel = nodeA.createRelationshipTo(nodeB, RelTypes.IS_RELATED);
			tx.success();
		}
	}

    public GraphDatabaseService getGraphDb()
    {
        return graphDb;
    }

    public void shutDown ()
    {
        this.neoShell.shutDown();
    }

    public void clearDb ()
    {
        this.neoShell.clearDb();
    }

	// ----------------------------------------------------------------------------
	// Section: Instance fields
	// ----------------------------------------------------------------------------

    private GraphDatabaseService graphDb;
	private Neo4JShell neoShell;
}
