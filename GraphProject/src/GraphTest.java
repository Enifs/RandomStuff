/**
 * Created by Enifs.
 */


import structure.Edge;
import structure.Graph;
import structure.Node;

public class GraphTest
{
    public static void main(String[] args)
    {
        GraphTest test = new GraphTest();
        test.run();
    }

    private void run()
    {
        Graph<Integer> graph = new Graph();

        Node<Integer> node1 = graph.addNode(1);
        Node<Integer> node2 = graph.addNode(2);
        Node<Integer> node3 = graph.addNode(3);
        Node<Integer> node4 = graph.addNode(4);

        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node1);
        graph.addEdge(node3, node4);

        for (Node<Integer> node : graph.getNodes())
        {
            System.out.println(node.getContent());
        }

        for (Edge<Integer> edge : graph.getEdges())
        {
            System.out.println(edge.getSource().getContent() +
                    " " +
                    edge.getTarget().getContent());
        }
    }
}
