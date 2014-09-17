/**
 * Created by Enifs.
 */

package structure;

public class Node<T>
{
    public Node(T content)
    {
        this.content = content;
    }

    public T getContent()
    {
        return this.content;
    }

    protected T content;
}
