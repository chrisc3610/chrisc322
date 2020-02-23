package mr.gonzalez.christinaChen;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.util.concurrent.TimeUnit;

import java.awt.event.*;
import java.util.Random;
import mr.gonzalez.christinaChen.Ship;

/**
*Control center for whole program.
*
*Creates the ship, asteroids(creates new ship and asteroid objects), and displays all the messages.
*<p>
 *ADSB Project 1: Asteroids
*3/23/2019
*
*
 *@author Christina Chen
*/

class Asteroids extends Game {
	static int counter = 1000;
	static int score = 0;
	static int maxCollides = 3;
	static int timeoutSec = 180;
	static String author = "Christina Chen";

	long mStartTime = 0;
	long cntPaint = 0;

	int timerSec = 0;
	int cntCollides = 0;

	boolean yikes = false;
	boolean isTimeout=false;

	Random rand = new Random();

	public Asteroids() {
		super("Asteroids Game",1000,1000);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener((KeyListener) theShip);
	}
	
	// the ship
	Point[] acShip = {new Point(-10, 0), new Point(20, 10), new Point(10, 0), new Point(20, -10)};
	Ship theShip = new Ship(acShip, new Point(430, 430), 0.0, height, width);
		
	// the stars
	Point[][] stars = {
		{new Point(42, 38), new Point(52, 62), new Point(72, 68), new Point(52, 80), new Point(60, 105), new Point(40, 85), new Point(15, 102), new Point(28, 75), new Point(9, 58), new Point(32, 60), new Point(42, 38)}
	};
	
	AcAsteroids starA1 = new AcAsteroids(stars[0], new Point(100, 400 ), 100  , width, height);
	AcAsteroids starA2 = new AcAsteroids(stars[0], new Point(50, 100 ), 100  , width, height);	
	AcAsteroids starA3 = new AcAsteroids(stars[0], new Point(300, 200 ), 100  , width, height);	
	AcAsteroids starA4 = new AcAsteroids(stars[0], new Point(600, 600 ), 100  , width, height);	
	AcAsteroids starA5 = new AcAsteroids(stars[0], new Point(800, 300 ), 100  , width, height);
	AcAsteroids starA6 = new AcAsteroids(stars[0], new Point(750, 30 ), 100  , width, height);
	AcAsteroids[] astyStar = {starA1, starA2, starA3, starA4, starA5, starA6};

	// asteroids
	Point [][] asters = {
		{new Point(30, 0), new Point(32, 8), new Point(44, 4), new Point(50, 24), new Point(64, 54), new Point(72, 60), new Point(64, 76), new Point(35, 53), new Point(7, 62), new Point(4, 37), new Point(8, 43), new Point(4, 17), new Point(16, 0)},
		{new Point(10, 0), new Point(13, 2), new Point(26, 1), new Point(30, 6), new Point(29, 15), new Point(31, 20), new Point(26, 31), new Point(22, 31), new Point(8, 29), new Point(1, 22), new Point(2, 16), new Point(1, 7), new Point(4, 0)},
		{new Point(20, 0), new Point(52, 8), new Point(104, 4), new Point(120, 24), new Point(116, 30), new Point(109, 40), new Point(96, 62), new Point(88, 62), new Point(32, 116), new Point(4, 44), new Point(8, 64), new Point(4, 28), new Point(16, 0)},
		{new Point(20, 0), new Point(24, 4), new Point(46, 2), new Point(55, 12), new Point(58, 30), new Point(59, 40), new Point(46, 31), new Point(44, 31), new Point(20, 59), new Point(3, 44), new Point(5, 32), new Point(2, 14), new Point(7, 0)},
		{new Point(25, 0), new Point(42, 6), new Point(74, 6), new Point(90, 18), new Point(96, 75), new Point(104, 67), new Point(114, 124), new Point(67, 90), new Point(32, 116), new Point(4, 88), new Point(8, 94), new Point(9, 28), new Point(16, 0)},
		{new Point(40, 0), new Point(52, 8), new Point(104, 4), new Point(120, 24), new Point(116, 60), new Point(124, 80), new Point(104, 124), new Point(88, 124), new Point(32, 116), new Point(4, 88), new Point(8, 64), new Point(4, 28), new Point(16, 0)},
	};

	AcAsteroids asty_1 = new AcAsteroids(asters[rand.nextInt(6)], new Point(100, 100), 0, width, height);
	AcAsteroids asty_2 = new AcAsteroids(asters[rand.nextInt(6)], new Point(100, 100), 100, width, height);
	AcAsteroids asty_3 = new AcAsteroids(asters[rand.nextInt(6)], new Point(500, 100), 60, width, height);
	AcAsteroids asty_4 = new AcAsteroids(asters[rand.nextInt(6)], new Point(100, 100), 286, width, height);
	AcAsteroids asty_5 = new AcAsteroids(asters[rand.nextInt(6)], new Point(500, 100), 320, width, height);
	AcAsteroids asty_6 = new AcAsteroids(asters[rand.nextInt(6)], new Point(330, 100), 98, width, height);
	AcAsteroids[] astyT = {asty_1, asty_2, asty_3, asty_4, asty_5, asty_6};

	/**
    * Draws ship
    * This method draws the ship and makes it appear on screen. 
    * If the ship goes off screen, it wraps around to the other side.
    *
    * @author Christina Chen
	* @param Graphics brush paints the ship
	* @return void
	*/
	//ship
	private void drawShip(Graphics brush) {	
		brush.setColor(Color.GREEN);
		theShip.paint(brush);
		theShip.move();
		
		// check boundary
		if (theShip.pos.x > theShip.w)
			theShip.pos.x -= theShip.w;
		else if (theShip.pos.x < 0)
			theShip.pos.x += theShip.w;
		
		if (theShip.pos.y >= theShip.h)
			theShip.pos.y -= theShip.h;
		else if (theShip.pos.y < 0)
			theShip.pos.y += theShip.h;
	}
	
	/**
	* Draws stars
	* This method draws the stars and makes them appear on screen. 
	*
	* @author Christina Chen
	* @param Graphics brush paints the stars
	* @return void
	*/
	//draw stars
	private void drawStar(Graphics brush) {	
		brush.setColor(Color.YELLOW);
    	//brush.drawString("Inside drawStar " + System.currentTimeMillis() ,10,40);

		for (AcAsteroids s : astyStar) {
			s.paint(brush);
		}
	}
	
	/**
	* Records time.
	* This method records the amount of time in seconds the player was able to stay alive. 
	*
	* @author Christina Chen
	* @param Graphics brush displays the timer on screen
	* @return void
	*/
	private void chkTimer(Graphics brush) {	
		// stop the game on timeout
		timerSec = (int)  (System.currentTimeMillis() - mStartTime) / 1000;
		brush.setColor(Color.WHITE);
		//brush.setFont(new Font("Century", Font.LAYOUT_LEFT_TO_RIGHT, 60));
		brush.drawString("Timer: " + timerSec + " sec",15,40);
				
		if (timerSec >= timeoutSec ) {
			isTimeout=true;		
	   	}				
	}
	
	/**
	* Sets canvas.
	* This method draws the canvas which is the background for the game. 
	*
	* @author Christina Chen
	* @param Graphics brush paints the canvas/background.
	* @return void
	*/
	/// Cleanup Canvas 
	private void resetCanvas(Graphics brush) {	
		// reset canvas
		brush.setColor(Color.DARK_GRAY);
	    brush.fillRect(0,0,width,height);
	}
	
	/**
	* Pauses program.
	* This method uses try catch to put the program to "sleep" when needed
	*
	* @author Christina Chen
	* @param int seconds is when it should sleep
	* @return void
	* @throws InterruptedException
	*/
	
	// pause the program when needed
	public void sleep(int seconds) {
    		try {
				TimeUnit.SECONDS.sleep(seconds);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
	}
	
	/**
	* Displays String messages and shapes.
	* This method draws most of everything on screen including asteroids and the String labels.
	* The String include messages that tell the score, counter, time, game over, etc.  
	* Checks for collision.
	*
	* @author Christina Chen
	* @param Graphics brush draws the shapes and letters
	* @return void
	*/
	public void paint(Graphics brush) {	
		// first time call
		cntPaint++;
		resetCanvas(brush); 
		
	    if ( cntPaint <= 1 ) {
			// Loading ...
			brush.setColor(Color.WHITE);
	    	brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 48));
	    	brush.drawString(" Loading .... ", 260, 300); 
	    	brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 15));
    		brush.drawString("Asteroids by " + author , 300, 330);
		}

		// ship
		drawShip(brush);
		// star
		drawStar(brush);	
		
		if ( cntPaint == 1 ) {
			// save the start time
			mStartTime = System.currentTimeMillis();
		}
		
		
		
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	counter--;
    	brush.setColor(Color.white);
    	brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 16));
    	brush.drawString("Counter is " + counter,15, 20);
    	score++;
    	brush.drawString("Score: " + score,15, 60);

    	//stop the game when counter reaches max
		if (counter <= 0 ) {
    		brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 30));
    		brush.drawString("Counter Full ...", 360, 260);
    		yikes=true;
		}
		else if (isTimeout){
	    	brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 30));
	    	brush.drawString("Oops, time out ..." , 360, 330);    		
		}
			
		//asteroids
    	if (!yikes & !isTimeout ) {
    		// everything is OK
    		chkTimer(brush);
	    	for (AcAsteroids a : astyT) {
	        		brush.setColor(new Color(rand.nextInt(256),rand.nextInt(200),rand.nextInt(256)));
	    			a.paint(brush);
	        		chkTimer(brush);

	    			//collision?
	    			if (a.collides(theShip)) {
	    				cntCollides++;
	    				brush.setColor(Color.WHITE);
	    		    	brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 13));
	    		    	brush.drawString("Number of Collisions: " + cntCollides,15,45);
	    		    	
	    				if (cntCollides >= maxCollides ) {
		    				brush.setColor(Color.WHITE);
		    		    	brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 13));
		    		    	brush.drawString("Reach max-Number of Collisions: " + cntCollides,15,60);
	    					yikes = true;
	    				}
	    			}

	    			a.move();	
	    			if (a.pos.x < 0)
	    				a.pos.x += a.width;
	    			else if (a.pos.x > a.width)
	    				a.pos.x -= a.width;
	    			
	    			if (a.pos.y < 0)
	    				a.pos.y += a.height;
	    			else if (a.pos.y >= a.height)
	    				a.pos.y -= a.height;			
	    		} //end for loop
    	}
    	else {	
  			// reset canvas
    		resetCanvas(brush); 
			drawStar(brush);	

	    	//report
	    	brush.setColor(Color.WHITE);
	    	brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 16));
	 	    brush.drawString("Counter is " + counter,15,20);
			brush.drawString("Timer: " + timerSec,15,40);
	    	brush.drawString("Number of Collisions: " + cntCollides,15,60);
	    	brush.drawString("Score: " + score, 15, 80);

	    	brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 48));
	    	brush.drawString("GAME OVER !", 370, 360);   
	    	
	    	brush.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 15));
    		brush.drawString("Asteroids by " + author , 400, 390);
    		this.setFlag(false);  //stop 
    	}
	}
	
	/**
	* Main method.
	* Creates new Asteroids object and executes the while program. 
	*
	* @author Christina Chen
	* @return void
	*/
	public static void main (String[] args) {
   		Asteroids a = new Asteroids();
		a.repaint();
	}
}