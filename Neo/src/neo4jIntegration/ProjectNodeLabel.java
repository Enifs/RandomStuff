/**
 * Created by Enifs.
 */
package neo4jIntegration;

import org.neo4j.graphdb.Label;

public class ProjectNodeLabel implements Label
{
	@Override
	public String name()
	{
		return "DR Node";
	}
}
