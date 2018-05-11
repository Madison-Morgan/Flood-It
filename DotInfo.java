

// Author: Madison Morgan
// Student number: 8287926
// Course: ITI 1121-D
// Assignment: 3
// Question: Model

// It should be noted that code given too us does not contain a public setter method
// for Color, therefore even know in the game view, the DotButtons will change color
// in the model, the DotInfo colors will not!! But this is okay because all we need is the
// status of the dot, whether its captured or not, and whether the dot were comparing
// is the same color as the selected color
// I do not think this is good practice, but there are strict guidelines indicating
// that adding public methods to the outlined code is not aloud! However we could
// have easily changed the colors of the game model, and simply updated the module accordingly
// by adding a public setter to this .java file...


/**
 * The class <b>DotInfo</b> is a simple helper class to store the initial color and state
 * (captured or not) at the dot position (x,y)
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotInfo {


	private int x;
	private int y;
	private int color;
	private boolean captured;


    /**
     * Constructor 
     * 
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     * @param color
     *            the initial color
     */
    public DotInfo(int x, int y, int color){

    	this.x=x;
    	this.y=y;
    	this.color=color;
    	captured=false;
    }



    /**
     * Getter method for the attribute x.
     * 
     * @return the value of the attribute x
     */
    public int getX(){
    	return x;
    }
    
    /**
     * Getter method for the attribute y.
     * 
     * @return the value of the attribute y
     */
    public int getY(){
    	return y;
    }
    
 
    /**
     * Setter for captured
     * @param captured
     *            the new value for captured
     */
    public void setCaptured(boolean captured) {
    	this.captured=captured;
    }

    /**
     * Get for captured
     *
     * @return captured
     */
    public boolean isCaptured(){
    	return captured;
    }

    /**
     * Get for color
     *
     * @return color
     */
    public int getColor() {
    	return color;
    }
 }