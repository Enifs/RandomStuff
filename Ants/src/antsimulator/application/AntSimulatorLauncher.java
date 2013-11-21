/**
 * Created by Enifs
 */
package antsimulator.application;

import antsimulator.Farm;
import antsimulator.ui.AntSimulatorUI;

import javax.swing.*;
import java.awt.*;

public class AntSimulatorLauncher extends JFrame
{
    // ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

	public AntSimulatorLauncher() throws HeadlessException
	{
		this.setSize(600, 460);
		//setBackground(Color.WHITE);

		AntSimulatorUI ui = new AntSimulatorUI();

		Farm farm = new Farm(ui.getFarmCanvas(), ui.getNumberOfAnts());

		ui.setFarm(farm);

		getContentPane().add(ui.getMainPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	// ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------
	private void run()
	{
		init();
	}

	private void init()
	{

	}

	// ----------------------------------------------------------------------------
	// Section: Entry point.
	// ----------------------------------------------------------------------------
	public static void main(String[] args)
	{
		AntSimulatorLauncher antSimulatorLauncher = new AntSimulatorLauncher();
		antSimulatorLauncher.run();
	}
	// ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------

}
