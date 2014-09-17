/**
 * Created by Enifs.
 */

package structure;

import java.util.ArrayList;
import java.util.List;

public class Node<T>
{
    protected Node(T content, Graph<T> owner)
    {
        this.content = content;
        this.owner = owner;
    }

    public T getContent()
    {
        return this.content;
    }

    protected T content;

    protected List<Edge<T>> inEdges = new ArrayList<Edge<T>>(32);
    protected List<Edge<T>> outEdges = new ArrayList<Edge<T>>(32);

    protected Graph<T> owner;
}
