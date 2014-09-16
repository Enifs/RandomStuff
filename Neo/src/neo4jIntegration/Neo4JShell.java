/**
 * Created by Enifs
 */
package neo4jIntegration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Neo4JShell
{
    // ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

	/**
	 * Creates or connects to database at the given relative path.
	 * @param path Path relative to working directory or absolute path.
	 */
	public Neo4JShell(String path)
	{
		this.graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(path);
		this.registerShutdownHook(graphDb);

//		Debug.println("Connected to Neo4j database at : " + path + "");
	}


	/**
	 * Default constructor creates a database with a default path "data/defaultDatabase".
	 * The pat is relative to working directory of the project.
	 */
	public Neo4JShell()
	{
		this(Neo4JShell.DEFAULT_PATH);
	}
	// ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------

	/**
	 * Returns an dataBase service instance for further interactions.
	 * @return  <code>org.neo4j.graphdb.GraphDatabaseService</code> instance.
	 */
	public GraphDatabaseService getGraphDb()
	{
		return graphDb;
	}

    // ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------

	private static void registerShutdownHook(final GraphDatabaseService graphDb)
	{
		// Registers a shutdown hook for the Neo4j instance so that it
		// shuts down nicely when the VM exits (even if you "Ctrl-C" the
		// running application).
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			@Override
			public void run()
			{
				graphDb.shutdown();

//				Debug.println("Database shutdown happened via the shutdown hook.");
			}
		});

	}


	void shutDown()
	{
		this.graphDb.shutdown();

//		Debug.println("Database shutdown happened.");
	}


	/**
	 * Linear deletion of all nodes and relationships in database. Does not restart ID numbers.
	 */
	public void clearDb ()
	{
		try (Transaction tx = graphDb.beginTx())
		{

			for (Node node : this.graphDb.getAllNodes())
			{
				for (Relationship rel : node.getRelationships())
				{
					rel.delete();
				}
				node.delete();
			}
			tx.success();

//			Debug.println("Database cleared via Neo4JShell.clearDb");
		}

	}
    // ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------

	private GraphDatabaseService graphDb;

	private static final String DEFAULT_PATH = "data/defaultDatabase";
}
