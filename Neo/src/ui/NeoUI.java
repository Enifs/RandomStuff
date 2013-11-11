package ui;

import neo4jIntegration.DefaultLabel;
import neo4jIntegration.Neo4jInterface;
import neo4jIntegration.Neo4jProperty;
import neo4jIntegration.RelTypes;
import neo4jIntegration.databaseCommands.AddNodeCommand;
import neo4jIntegration.databaseCommands.AddRelationshipCommand;
import neo4jIntegration.databaseCommands.RetrieveNodeCommand;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NeoUI
{
	public NeoUI(final Neo4jInterface neo4jInterface)
	{
		this.addEdgeButton.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String keyA = edgeInputA.getText();
				String keyB = edgeInputB.getText();

				RetrieveNodeCommand getSourceNodeCommand =
						new RetrieveNodeCommand(keyA, keyA, neo4jInterface.getGraphDb());

				RetrieveNodeCommand getTargetNodeCommand =
						new RetrieveNodeCommand(keyB, keyB, neo4jInterface.getGraphDb());

				AddRelationshipCommand addRelCommand =
						new AddRelationshipCommand(getSourceNodeCommand.execute(),
								getTargetNodeCommand.execute(),
								RelTypes.IS_RELATED,
								neo4jInterface.getGraphDb());

				addRelCommand.execute();

				System.out.println("Added a relationship.");
			}


			@Override
			public void mousePressed(MouseEvent e)
			{
			}


			@Override
			public void mouseReleased(MouseEvent e)
			{
			}


			@Override
			public void mouseEntered(MouseEvent e)
			{
			}


			@Override
			public void mouseExited(MouseEvent e)
			{
			}
		});
		this.addNodeButton.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String key = nodeInput.getText();

                Neo4jProperty property = new Neo4jProperty(key, key);
                AddNodeCommand command =
                        new AddNodeCommand(property, new DefaultLabel(), neo4jInterface);
			    command.execute();

				System.out.println("Added a node.");
            }


			@Override
			public void mousePressed(MouseEvent e)
			{
			}


			@Override
			public void mouseReleased(MouseEvent e)
			{
			}


			@Override
			public void mouseEntered(MouseEvent e)
			{
			}


			@Override
			public void mouseExited(MouseEvent e)
			{
			}
		});
        this.disconnectButton.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                neo4jInterface.disconnect();
            }

            @Override
            public void mousePressed (MouseEvent e)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseReleased (MouseEvent e)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseEntered (MouseEvent e)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseExited (MouseEvent e)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        this.clearDatabaseButton.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                neo4jInterface.clearDb();
				System.out.println("Database cleared.");
			}

            @Override
            public void mousePressed (MouseEvent e)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseReleased (MouseEvent e)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseEntered (MouseEvent e)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseExited (MouseEvent e)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
	}


	public JPanel getMainPanel()
	{
		return mainPanel;
	}


	public JButton getAddEdgeButton()
	{
		return addEdgeButton;
	}


	public JPanel getAddEdgePanel()
	{
		return addEdgePanel;
	}


	public JButton getAddNodeButton()
	{
		return addNodeButton;
	}


	public JPanel getAddNodePanel()
	{
		return addNodePanel;
	}


	public JTextField getEdgeInputA()
	{
		return edgeInputA;
	}


	public JTextField getEdgeInputB()
	{
		return edgeInputB;
	}


	public JTextField getNodeInput()
	{
		return nodeInput;
	}


	public JTabbedPane getTabbedPane()
	{
		return tabbedPane;
	}

    public JButton getDisconnectButton ()
    {
        return disconnectButton;
    }


    public JButton getClearDatabaseButton ()
    {
        return clearDatabaseButton;
    }

    private JButton addNodeButton;
	private JButton addEdgeButton;
	private JTextField edgeInputB;
	private JPanel mainPanel;
	private JTabbedPane tabbedPane;
	private JPanel addNodePanel;
	private JPanel addEdgePanel;
	private JTextField nodeInput;
	private JTextField edgeInputA;
    private JButton disconnectButton;
    private JButton clearDatabaseButton;
}
