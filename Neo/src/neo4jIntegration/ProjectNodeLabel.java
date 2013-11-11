package neo4jIntegration;//
// Tom Sawyer Software
// Copyright 1992 - 2013
// All rights reserved.
//
// www.tomsawyer.com
//

import org.neo4j.graphdb.Label;

public class ProjectNodeLabel implements Label
{
	@Override
	public String name()
	{
		return "DR Node";
	}
}
