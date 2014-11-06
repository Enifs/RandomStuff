package antsimulator;

import antsimulator.application.Engine;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Anna on 06/11/2014.
 */
public class Visualiser extends JFrame
{

	public Visualiser(Engine engine, int width, int heigth) throws HeadlessException
	{
		this.engine = engine;
		this.setSize(width, heigth);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new AntGround());
		this.setVisible(true);
	}


	private class AntGround extends JPanel
	{
		@Override
		public void paintComponent(Graphics g)
		{
			g.fillOval(100, 100, 50, 50);
			engine.getHives();
			for (Hive hive : engine.getHives())
			{
			  g.fillRect(0,0,hive.getWidth(), hive.getHeight());
			}
		}
	}

	private Engine engine;
}
