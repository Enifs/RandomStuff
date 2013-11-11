package neo4jIntegration;

/**
 * Created by Enifs
 */
public class Neo4jProperty
{
    // ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

    public Neo4jProperty (String name, Object content, String contentType)
    {
        this.content = content;
        this.contentType = contentType;
        this.name = name;
    }

    public Neo4jProperty (String name, Object content)
    {
        this(name, content, DatabaseContentType.STRING);
    }

    // ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------

    public Object getContent ()
    {
        return content;
    }

    public String getContentType ()
    {
        return contentType;
    }

    public String getName ()
    {
        return name;
    }

    // ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------
    String name;
    String contentType;
    Object content;
}
