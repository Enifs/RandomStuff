/**
 * Created by Enifs
 */

package structure;

import java.util.ArrayList;

public class Graph<T>
{
    public Graph()
    {
    }

    public Node<T> addNode(T content)
    {
        Node<T> returnNode = new Node<T>(content, this);
        this.nodes.add(returnNode);
        return returnNode;
    }

    public Edge<T> addEdge(Node<T> source, Node<T> target)
    {
        Edge<T> returnEdge = new Edge<T>(source, target);
        this.edges.add(returnEdge);
        source.outEdges.add(returnEdge);
        target.inEdges.add(returnEdge);

        return returnEdge;
    }

    public ArrayList<Node<T>> getNodes()
    {
        return nodes;
    }

    public ArrayList<Edge<T>> getEdges()
    {
        return edges;
    }

    protected ArrayList<Node<T>> nodes = new ArrayList<Node<T>>(32);
    protected ArrayList<Edge<T>> edges = new ArrayList<Edge<T>>(32);
}
