package example;

import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Label;


public class Neo4JJavaAPI{
	//declaration of neo4j's Labels
	public enum LabelExample implements Label {
		PERSON,MOVIES;
	}
//declaration of neo4j's relationships
public enum TutorialRelationships implements RelationshipType{
		IS_FUN_OF,LIKES,ACTED,IS_FRIEND_OF;
	}
public static void main(String[] args) {
	//Before to execute this, it must turn off the neo4j connection on browser client.
	//path of directory where it will be saved the neo4j project
	File file = new File("C:/EXAMPLE_NEO4J_PROJECT");
	
	//To create Database in neo4j 
	GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
	GraphDatabaseService db= dbFactory.newEmbeddedDatabase(file);
	try (Transaction tx = db.beginTx()) {
		
		//to create node
		Node personNode1 = db.createNode(LabelExample.PERSON);
		personNode1.setProperty("ID", "PERSON001");
		personNode1.setProperty("Name", "Davide");
		personNode1.setProperty("Surname", "Francesconi");
		personNode1.setProperty("Age", "24");	
		
		Node personNode2 = db.createNode(LabelExample.PERSON);
		personNode2.setProperty("ID", "PERSON003");
		personNode2.setProperty("Name", "Mario");
		personNode2.setProperty("Surname", "Rossi");
		personNode2.setProperty("Age", "23");
		
		Node personNode3 = db.createNode(LabelExample.PERSON);
		personNode3.setProperty("ID", "PERSON002");
		personNode3.setProperty("Name", "Pinko");
		personNode3.setProperty("Surname", "Pallino");
		personNode3.setProperty("Age", "21");				
		
		
		Node movieNode1 = db.createNode(LabelExample.MOVIES);
		movieNode1.setProperty("ID", "OBJECT001");
		movieNode1.setProperty("Name", "The wolf of wall street");
		movieNode1.setProperty("Author", "Martin Scorsese");
		
		Node actorNode1= db.createNode(LabelExample.PERSON);
		actorNode1.setProperty("ID", "ACTOR001");
		actorNode1.setProperty("Name", "Leonardo");
		actorNode1.setProperty("Surname", "Dicaprio");
	
		
		Relationship relationship = personNode1.createRelationshipTo
		(movieNode1,TutorialRelationships.LIKES);
		relationship.setProperty("Id","1234");
		relationship.setProperty("Rating","10");

		Relationship relationship1 = actorNode1.createRelationshipTo
		(movieNode1,TutorialRelationships.ACTED);
		relationship1.setProperty("Id","01");
		relationship1.setProperty("Date", "2013");
		
		Relationship relationship2 = personNode1.createRelationshipTo
				(actorNode1,TutorialRelationships.IS_FUN_OF);
		
		Relationship relationship3 = personNode2.createRelationshipTo
				(personNode1, TutorialRelationships.IS_FRIEND_OF);
		relationship3.setProperty("SINCE","2001");

		Relationship relationship4 = personNode1.createRelationshipTo
				(personNode2, TutorialRelationships.IS_FRIEND_OF);
		relationship4.setProperty("SINCE","2001");

		Relationship relationship5 = personNode3.createRelationshipTo
				(personNode1, TutorialRelationships.IS_FRIEND_OF);
		relationship5.setProperty("SINCE","2011");
		

		Relationship relationship6 = personNode1.createRelationshipTo
				(personNode3, TutorialRelationships.IS_FRIEND_OF);
		relationship6.setProperty("SINCE","2011");
		
		//if success end connection
		tx.success();
	}
	   System.out.println("Done successfully");
}
}