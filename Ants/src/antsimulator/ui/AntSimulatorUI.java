/**
 * Created by Enifs
 */
package antsimulator.ui;

import antsimulator.Farm;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class AntSimulatorUI
{
	// ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

	public AntSimulatorUI()
	{
		startButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				super.mouseClicked(e);

				int n = Integer.parseInt(antsPerHiveTextField.getText());

				t = new Thread(new Farm(farmCanvas, n));
				t.start();

				statusBar.setText("Farm has been launched!");
			}
		});

		farmCanvas.addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent e)
			{
				super.mouseMoved(e);
				cursorCoordinates.setText(e.getX() + ":" + e.getY());
			}

		});

		farmCanvas.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseExited(MouseEvent e)
			{
				super.mouseExited(e);
				cursorCoordinates.setText("-:-");
			}
		});

		stopButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				super.mouseClicked(e);
				Farm.setGoOn(false);
				t.interrupt();
				t.stop();
				statusBar.setText("Farm should be closed & animals should be dead.");
			}
		});
	}

	// ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------
	public JPanel getMainPanel()
	{
		return mainPanel;
	}

	public JPanel getFarmCanvas()
	{
		return farmCanvas;
	}

	public void setFarm(Farm farm)
	{
		this.farm = farm;
	}


	public int getNumberOfAnts()
	{
		return Integer.parseInt(antsPerHiveTextField.getText());
	}
	// ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------

	private JPanel mainPanel;
	private JPanel farmCanvas;
	private JTextField antsPerHiveTextField;
	private JTextField numberOfHivesTextField;
	private JTextField foodBitsTextField;
	private JButton startButton;
	private JButton stopButton;
	private JLabel cursorCoordinates;
	private JLabel statusBar;
	private JPanel farmWrapper;

	private Farm farm;
	Thread t;
}
