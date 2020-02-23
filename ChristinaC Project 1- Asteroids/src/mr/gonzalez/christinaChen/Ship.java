package mr.gonzalez.christinaChen;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
* Creates ship.
*
* Creates an ship, allows it to move, and determines its speed 
*<p>
*ADSB Project 1: Asteroids
*3/23/2019
*
*
 *@author Christina Chen
*/

public class Ship extends Polygon implements java.awt.event.KeyListener{
	boolean forward;
	boolean left;
	boolean right;
	int speed = 10;
	int w;
	int h;
	
	
	public Ship(Point[] inShape, Point inPosition, double inRotation,  int height, int width) {
		super(inShape, inPosition, inRotation);
		this.h = height;
		this.w = width;
	}

	/**
	* Makes ship.
    * This method makes the ship depending on the points it obtains from the Asteroids class. 
    *
    * @author Christina Chen
	* @param Graphics brush ensures ship's appearance on screen
	* @return void
	*/
	public void paint(Graphics brush) {
		Point[] thing = getPoints();
		int[] x = new int[thing.length];
		int[] y = new int[thing.length];
		int i = 0;
		for (Point p : thing) {
			x[i] = (int) p.x;
			y[i] = (int) p.y;
			i++;
		}
		brush.fillPolygon(x, y, thing.length);
	}
	
	/**
	* Moves ship 
    * This method allows movement for the ship using change in their positions and also lets the ship rotate.
    * The degree of rotation is set here.
    *
    * @author Christina Chen
	* @return void
	*/
	public void move() {
		//forward
		if (forward) {
			this.pos.x -= speed * Math.cos(Math.toRadians(this.rot));
			this.pos.y -= speed * Math.sin(Math.toRadians(this.rot));
		}	
		
		//left & right
		if (left) {
			this.rot = this.rot - 10;
		}else if (right) {
			this.rot = this.rot + 10;
		}
	}
	
	/**
	* Keyboard interaction
    * When your chosen keys are pressed, their corresponding boolean values (for forward, left, and right) are changed appropriately
    *
    * @author Christina Chen
	* @return void
	*/
	//intentionally disable DOWN direction
	public void keyPressed (KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP) {
			forward = true;
		}else if (key == KeyEvent.VK_LEFT) {
			left = true;
		}else if (key == KeyEvent.VK_RIGHT) {
			right = true;
		}
	}

	/**
	* Keyboard interaction
    * When your chosen keys are released, their corresponding boolean values (for forward, left, and right) are changed appropriately
    *
    * @author Christina Chen
	* @return void
	*/
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			forward = false;
		}else if (key == KeyEvent.VK_LEFT) {
			left = false;
		}else if (key == KeyEvent.VK_RIGHT) {
			right = false;
		}
	}


	public void keyTyped(KeyEvent e) {
	}	
	
	/*
	public Shot[] Shoot5Bullet()
	{
	     Shot[] shots = new Shot[5];
	     for(int direction = 0; direction < 5; direction++)
	          shots[direction] = new Shot(start_x, start_y, direction);
	     return shots;
	}
	*/
	

}