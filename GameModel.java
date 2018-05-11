

// Author: Madison Morgan
// Student number: 8287926
// Course: ITI 1121-D
// Assignment: 3
// Question: Model

import java.util.Random;

/**
 * The class <b>GameModel</b> holds the model, the state of the systems. 
 * It stores the followiung information:
 * - the state of all the ``dots'' on the board (color, captured or not)
 * - the size of the board
 * - the number of steps since the last reset
 * - the current color of selection
 *
 * The model provides all of this informations to the other classes trough 
 *  appropriate Getters. 
 * The controller can also update the model through Setters.
 * Finally, the model is also in charge of initializing the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class GameModel{


    /**
     * predefined values to capture the color of a DotInfo
     */
    public static final int COLOR_0           = 0;
    public static final int COLOR_1           = 1;
    public static final int COLOR_2           = 2;
    public static final int COLOR_3           = 3;
    public static final int COLOR_4           = 4;
    public static final int COLOR_5           = 5;
    public static final int NUMBER_OF_COLORS  = 6;
    

    //used to  generate random colors
    private Random generator= new Random();


    //user input/ predetermined size of board. ie. generates model with sizexsize dots
    private int size;

    //contains every dot on board & its info, size designated by size formal parameter
    private DotInfo[][] model;

    //the number of steps that the player has taken in the course of the game
    private int numberOfSteps;

    //the current selected color that the player has chosen
    private int currentSelectedColor;

    //the number of dots that have been captured by the player
    private int numDotsCaptured;

    /**
     * Constructor to initialize the model to a given size of board.
     * 
     * @param size
     *            the size of the board, preconditions size less then 12
     */
    public GameModel(int size) {
        if(size<10){
            this.size=12;
        }
        else{
            this.size=size;
        }

        numberOfSteps=0;
        model= new DotInfo[size][size];
        numDotsCaptured=0;

        //intialize the 2D array containing each dot
        for (int i=0; i<size; i++){
            for (int j=0; j<size;j++){
                int aRandomColor= generator.nextInt(NUMBER_OF_COLORS);
                model[i][j]= new DotInfo(i,j,aRandomColor);
            }
        }

        //the current color will be the top left dot, which will also be captured// also all related dots that are the samecolor
        capture(0,0);
        currentSelectedColor=model[0][0].getColor();
        captureNearDots();
    }






    /**
     * Resets the model to (re)start a game. The previous game (if there is one)
     * is cleared up . 
     */
    public void reset(){
    
        for (int i=0; i<size; i++){
            for (int j=0; j<size;j++){
                int aRandomColor= generator.nextInt(NUMBER_OF_COLORS);
                model[i][j]= new DotInfo(i,j,aRandomColor);
            }
        }

        numberOfSteps=0;
        numDotsCaptured=0;
        capture(0,0);
        currentSelectedColor=model[0][0].getColor();  
    }






    /**
     * Getter method for the size of the game
     * 
     * @return the value of the attribute sizeOfGame
     */   
    public int getSize(){
        return size;
    }






    /**
     * returns the current color  of a given dot in the game
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public int getColor(int i, int j){
        return model[i][j].getColor();
    }






    /**
     * returns true is the dot is captured, false otherwise
    * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isCaptured(int i, int j){
        return model[i][j].isCaptured();
    }





    /**
     * Sets the status of the dot at coordinate (i,j) to captured
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */   
    public void capture(int i, int j){
        model[i][j].setCaptured(true);
        numDotsCaptured++;
   }






    /**
     * Getter method for the current number of steps
     * 
     * @return the current number of steps
     */   
    public int getNumberOfSteps(){
        return numberOfSteps;
    }





    /**
     * Setter method for currentSelectedColor
     * 
     * @param val
     *            the new value for currentSelectedColor
    */   
    public void setCurrentSelectedColor(int val) {
        currentSelectedColor=val;
        step();
    }






    /**
     * Getter method for currentSelectedColor
     * 
     * @return currentSelectedColor
     */   
    public int getCurrentSelectedColor() {
        return currentSelectedColor;
    }







    /**
     * Getter method for the model's dotInfo reference
     * at location (i,j)
     *
      * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     *
     * @return model[i][j]
     */   
    public DotInfo get(int i, int j) {
        return model[i][j];
    }






   /**
     * The metod <b>step</b> updates the number of steps. It must be called 
     * once the model has been updated after the payer selected a new color.
     */
     public void step(){
        numberOfSteps++;
    }
 





   /**
     * The metod <b>isFinished</b> returns true iff the game is finished, that
     * is, all the dots are captured.
     *
     * @return true if the game is finished, false otherwise
     */
    public boolean isFinished(){
        return numDotsCaptured==(size*size);
    }






   /**
     * Builds a String representation of the model
     *
     * @return String representation of the model
     */
    public String toString(){

        String print=new String();

        for(int i=0; i<size;i++){
            for (int j=0; j<size; j++){
                print=print+ Integer.toString( model[i][j].getColor() ) + " ";
            }

            print= print + "\n";
        }

        return print;
    }

    /** 
      * The metod <b>captureNearDots</b> captures the dots around the
      * dot at position (0,0); only done with the creation of new model
      */
    public void captureNearDots(){

        if(getColor(1,0)==getCurrentSelectedColor()){
            capture(1,0);
        }

        if(getColor(0,1)== getCurrentSelectedColor()){
            capture(0,1);
        }

    }
}