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

    protected ArrayList<Node> nodes = new ArrayList<Node>(32);
    protected ArrayList<Edge> edges = new ArrayList<Edge>(32);
}
