package neo4jIntegration.databaseCommands;

import debug.Debug;
import neo4jIntegration.Neo4jInterface;
import neo4jIntegration.Neo4jProperty;
import neo4jIntegration.ProjectNodeLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.Label;

import java.util.LinkedList;

/**
 * Created by Enifs
 */
public class AddNodeCommand implements Neo4jCommand
{
    // ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

    public AddNodeCommand (
        Neo4jProperty property,
        Label label,
        Neo4jInterface owner)
    {
        this.properties.add(property);
        this.labels.add(label);
        this.owner = owner;
    }

    public AddNodeCommand (
            LinkedList<Label> labels,
            LinkedList<Neo4jProperty> properties,
            Neo4jInterface owner)
    {
        this.labels = labels;
        this.properties = properties;
        this.owner = owner;
    }

    // ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------

    public Node getNode ()
    {
        return node;
    }

    public long getNodeID ()
    {
        return nodeID;
    }

    public boolean isIdObtained ()
    {
        return idObtained;
    }

    // ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------

    @Override
    public void init ()
    {
        this.graphDb = this.owner.getGraphDb();
    }

    @Override
    public Node execute()
    {
        this.init();

        try (Transaction tx = graphDb.beginTx())
        {
            Node node = this.graphDb.createNode();
            for (Neo4jProperty property : properties)
            {
                node.setProperty(property.getName(), property.getContent());
                node.setProperty("type:" + property.getName(), property.getContentType());
            }
            for (Label label : labels)
            {
                node.addLabel(label);
            }
            node.addLabel(new ProjectNodeLabel());

            this.node = node;
            this.nodeID = node.getId();
            this.idObtained = true;

            tx.success();
        }

		Debug.println("Add node[id = " + this.nodeID + "] executed.");
		return null;
	}

    // ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------


    //Node content.
    private LinkedList<Neo4jProperty> properties = new LinkedList<>();
    private LinkedList<Label> labels = new LinkedList<>();

    //Created node and owner.
    private Node node;
    private Neo4jInterface owner;

    // Id of created node.
    private long nodeID;
    private boolean idObtained = false;

    // graphbase that creates a node.
    private GraphDatabaseService graphDb;
}
