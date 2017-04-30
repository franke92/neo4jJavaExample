package exampleCQL;

import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class javaNeo4jCQL{
    
   public static void main(String[] args) {
	   
      File file = new File ("C:/EXAMPLE_NEO4J_PROJECT");
      
      GraphDatabaseFactory graphDbFactory = new GraphDatabaseFactory();
      GraphDatabaseService graphDb = graphDbFactory.newEmbeddedDatabase(file);

      Result result = graphDb.execute("MATCH (A:PERSON)-[r:IS_FRIEND_OF]->(P:PERSON) RETURN A.Name,A.Surname,P.Name,P.Surname,r.SINCE");
     
      
      System.out.println( result.resultAsString());
     }
   
}

