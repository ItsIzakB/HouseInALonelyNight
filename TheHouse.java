// Kazi Priom
// Fall 2022


import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class TheHouse extends JPanel
{
	// Change these constants to adjust the size and title of the window.
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final String WINDOW_TITLE = "The House in a Lonely Night";
	
	// Do not change the main method.
	public static void main(String[] args)
	{
		JPanel panel = new TheHouse();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));


		
		JFrame frame = new JFrame(WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		frame.pack();
	}
	
	// Add your drawing code to this method.
	public void paintComponent(Graphics g) {
		// Do not change these two lines.
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Night Background
		{
			// The Background was created using a rectangle the size of the JPanel.
			// The color was custom selected using the Color class's constructor
			Rectangle2D.Double rectangle = new Rectangle2D.Double();
			Rectangle2D.Double rectangle2 = new Rectangle2D.Double();

			rectangle.setFrame(0, 0, 640, 480);
			g2d.setColor(new Color(0, 3, 107));
			g2d.draw(rectangle);
			g2d.fill(rectangle);
		}

		// Random Stars
		{
			/*
			The Stars in this program are put in random locations. This was possible because of the Random Class. Then
			stars are written in a for loop to create multiple stars.
			 */

			for(int i = 0; i < 30; i++) {
				Random starRNG = new Random();
				double starX = starRNG.nextDouble() * 700;
				double starY = starRNG.nextDouble() * 300;

				Ellipse2D.Double starP1 = new Ellipse2D.Double();
				starP1.setFrame(starX, starY, 5, 5);
				g2d.setColor(Color.yellow);
				g2d.fill(starP1);
				g2d.draw(starP1);

				Ellipse2D.Double starP1Out = new Ellipse2D.Double();
				starP1Out.setFrame(starX - 2, starY - 2, 10, 10);
				g2d.setColor(Color.BLACK);
				g2d.setStroke(new BasicStroke(2));
				g2d.draw(starP1Out);

			}
		}

		// Big Hill
		{
			//The Hill is simply a large Ellipse.
			Ellipse2D.Double hill = new Ellipse2D.Double();
			hill.setFrame(0, 300, 635, 400);
			g2d.setColor(new Color(4, 98, 8));
			g2d.fill(hill);
			g2d.draw(hill);

			//HillOut is the outline of the hill
			Ellipse2D.Double hillOut = new Ellipse2D.Double();
			hillOut.setFrame(0, 300, 635, 400);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(5));
			g2d.draw(hillOut);
		}

		// House
		{
			//All the objects of the classes represent the different parts of the house.
			//The parts that end with "Out" represent the outline of that part of the house

			RoundRectangle2D.Double base = new RoundRectangle2D.Double();
			base.setRoundRect(275,210,100,100,15,10);
			g2d.setColor(new Color(107, 1, 1, 255));
			g2d.fill(base);
			g2d.draw(base);

			RoundRectangle2D.Double baseOut = new RoundRectangle2D.Double();
			baseOut.setRoundRect(275,210,100,100,15,10);
			g2d.setColor(Color.BLACK);
			g2d.draw(baseOut);

			Ellipse2D.Double window = new Ellipse2D.Double();
			window.setFrame(285,225,35,45);
			g2d.setColor(new Color(250, 235, 161));
			g2d.fill(window);
			g2d.draw(window);

			Ellipse2D.Double windowOut = new Ellipse2D.Double();
			windowOut.setFrame(285,225,35,45);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(5));
			g2d.draw(windowOut);


			Rectangle2D.Double door = new Rectangle2D.Double();
			door.setFrame(330, 250, 35, 60);
			g2d.setColor(new Color(105, 57, 49));
			g2d.draw(door);
			g2d.fill(door);

			Rectangle2D.Double doorOut = new Rectangle2D.Double();
			doorOut.setFrame(330, 250, 35, 60);
			g2d.setColor(Color.BLACK);
			g2d.draw(doorOut);


			//roof is a trapezoid-shaped Polygon
			int[] x = {270,379,364,285};
			int[] y = {210,210,195,195};

			Polygon roof = new Polygon(x,y,4);
			System.out.println(roof.contains(300,190));
			g2d.setColor(new Color(0, 0, 0));
			g2d.fill(roof);
			g2d.draw(roof);



		}


	}
}