package application;

import debug.Debug;
import neo4jIntegration.Neo4jInterface;
import application.ui.NeoUI;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame
{
	public Application() throws HeadlessException
	{
		this.neo4jInterface = new Neo4jInterface("data/database1");
		setSize(400, 400);
		setBackground(Color.WHITE);

		NeoUI ui = new NeoUI(this.neo4jInterface);

		getContentPane().add(ui.getMainPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Debug.println("Application initialized.");
	}


	public static void main(String[] args)
	{
		Debug.println("Application entry point.");

		Application application = new Application();
	}

	private Neo4jInterface neo4jInterface;
}
