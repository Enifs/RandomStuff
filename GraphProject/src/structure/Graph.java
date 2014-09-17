/**
 * Created by Enifs
 */

package structure;

import java.util.ArrayList;

public class Graph
{
    public Graph()
    {
    }

    public void addNode(Node node)
    {
        this.nodes.add(node);
    }

    public <T1, T2> void addEdge(Node<T1> source, Node<T2> target)
    {
        this.edges.add(new Edge<T1, T2>(source, target));
    }

    public ArrayList<Node> getNodes()
    {
        return nodes;
    }

    public ArrayList<Edge> getEdges()
    {
        return edges;
    }

    protected ArrayList<Node> nodes = new ArrayList<Node>(32);
    protected ArrayList<Edge> edges = new ArrayList<Edge>(32);
}
