import structure.Edge;
import structure.Graph;
import structure.Node;

/**
 * Created by Enifs on 2014.09.17..
 */


public class GraphTest
{
    public static void main(String[] args)
    {
        GraphTest test = new GraphTest();
        test.run();
    }

    private void run()
    {
        Graph graph = new Graph();

        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);

        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node1);
        graph.addEdge(node3, node4);

        for (Edge edge : graph.getEdges())
        {
            System.out.println(edge.getSource());
        }
    }
}
