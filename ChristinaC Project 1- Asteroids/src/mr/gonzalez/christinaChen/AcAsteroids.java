package mr.gonzalez.christinaChen;

import java.awt.Graphics;

/**
* Creates asteroids.
*
* Creates an asteroid, allows it to move, and determines its speed 
*<p>
*ADSB Project 1: Asteroids
*3/23/2019
*
*
 *@author Christina Chen
*/

public class AcAsteroids extends Polygon{ //Asteroid class, named differently for my convenience (AcAsteroids = ActualAsteroids)
	int speed = 7;
	int width;
	int height;
	
	
	public AcAsteroids(Point[] shape, Point pos, double rot, int w, int h) {
		super (shape, pos, rot);
		width = w;
		height = h;
	}
	
	/**
	* Makes asteroid.
    * This method makes the asteroid depending on the points it obtains from the Asteroids class. 
    *
    * @author Christina Chen
	* @param Graphics brush ensures asteroid's appearance on screen
	* @return void
	*/
	public void paint(Graphics brush) {
		Point[] asterS = getPoints();
		int[] x = new int[asterS.length];
		int[] y = new int[asterS.length];
		int i = 0;
		for (Point p : asterS) {
			x[i] = (int) p.x;
			y[i] = (int) p.y;
			i++;
		}
		brush.drawPolygon(x, y, asterS.length);
	}
	
	/**
	* Moves asteroids 
    * This method allows movement for the asteroids using change in their positions
    *
    * @author Christina Chen
	* @return void
	*/
	public void move( ) {
		this.pos.x += speed * Math.cos(Math.toRadians(this.rot));
		this.pos.y += speed * Math.sin(Math.toRadians(this.rot));
	}
	
	/**
	* Moves asteroids 
    * This method allows movement for the asteroids and determines where they start/offset
    *
    * @author Christina Chen
	* @return void
	*/
	public void move(int offset) {
		this.pos.x += offset;
		this.pos.y += offset;
	}
}
