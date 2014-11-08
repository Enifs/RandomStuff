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
		double scaleX;
		double scaleY;
		AntGround antGround = new AntGround();
		if (width < engine.getArena().width || heigth < engine.getArena().heigth)
		{
			this.setSize(engine.getArena().width, engine.getArena().heigth + 19);
		}
		else
		{

			scaleX = width / engine.getArena().width;
			scaleY = heigth / engine.getArena().heigth;
			if (scaleX > scaleY)
			{
				antGround.setScale((int) scaleY);
				this.setSize((int) (engine.getArena().width * scaleY), heigth + 19);
			}
			else
			{
				antGround.setScale((int) scaleX);
				this.setSize(width, (int) (engine.getArena().heigth * scaleX) + 19);
			}
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		antGround.setBackground(new Color(172, 225, 175));
		this.setContentPane(antGround);
		this.setVisible(true);
	}


	private class AntGround extends JPanel
	{
		@Override
		public void paintComponent(Graphics g)
		{

			for (Hive hive : engine.getHives())
			{
				g.setColor(Color.GREEN);
				g.fillRect((int) (hive.getTopLeftPoint().getX() * scale), (int) (hive.getTopLeftPoint()
								.getY() * scale),
						((int) (hive.getWidth() * scale)),
						((int) (hive.getHeight() * scale)));
				for (Ant ant : hive.getResidentAnts())
				{
					g.setColor(Color.RED);
					g.fillOval((int) (ant.getLocation().getX() * scale), (int) (ant.getLocation().getY() * scale), (int) scale,
							(int) scale);
				}
			}

			for (Food food : engine.getFood())
			{
				g.setColor(Color.YELLOW);
				g.fillRect((int) (food.getTopLeftPoint().getX() * scale), (int) (food.getTopLeftPoint()
								.getY
										() * scale),
						((int) (food.getWidth() * scale)),
						((int) (food.getHeight() * scale)));
			}
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, ((int) (engine.getArena().width * scale)), ((int) (engine.getArena().heigth
					* scale)));
		}

		public void setScale(int scale)
		{
			this.scale = scale;
		}

		private double scale;
	}

	private Engine engine;
}
