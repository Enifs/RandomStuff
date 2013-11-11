package neo4jIntegration; /**
 * Created by Enifs
 */

import org.neo4j.graphdb.RelationshipType;


public enum RelTypes implements RelationshipType
{
    KNOWS,
	IS_RELATED
}
