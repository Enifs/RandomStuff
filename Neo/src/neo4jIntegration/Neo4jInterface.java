package neo4jIntegration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

public class Neo4jInterface
{
	public Neo4jInterface()
	{
		this.graphDb = this.embeddedNeo4j.getGraphDb();
	}

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

    public void disconnect ()
    {
        this.embeddedNeo4j.shutDown();
    }

    public void clearDb ()
    {
        this.embeddedNeo4j.clearDb();
    }

    private GraphDatabaseService graphDb;
	private EmbeddedNeo4j embeddedNeo4j = new EmbeddedNeo4j();

}
