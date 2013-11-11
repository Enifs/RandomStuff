package neo4jIntegration.databaseCommands;

import org.neo4j.graphdb.Node;

/**
 * Created by Enifs
 */
public interface Neo4jCommand
{
    public void init();
    public Node execute();
}
