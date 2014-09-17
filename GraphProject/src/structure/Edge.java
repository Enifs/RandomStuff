/**
 * Created by Enifs on 2014.09.17..
 */

package structure;

public class Edge<T>
{
    public Edge(Node<T> source, Node<T> target)
    {
        this.source = source;
        this.target = target;
    }

    public Node<T> getSource()
    {
        return source;
    }

    public Node<T> getTarget()
    {
        return target;
    }

    protected Node<T> source;
    protected Node<T> target;
}
