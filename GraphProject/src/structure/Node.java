/**
 * Created by Enifs.
 */

package structure;

public class Node<T>
{
    protected Node(T content)
    {
        this.content = content;
    }

    public T getContent()
    {
        return this.content;
    }

    protected T content;
}
