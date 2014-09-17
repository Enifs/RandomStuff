/**
 * Created by Enifs on 2014.09.17..
 */

package structure;

public class Edge<T1, T2>
{
    public Edge(Node<T1> source, Node<T2> target)
    {
        this.source = source;
        this.target = target;
    }

    public Node<T1> getSource()
    {
        return source;
    }

    public Node<T2> getTarget()
    {
        return target;
    }

    protected Node<T1> source;
    protected Node<T2> target;
}
