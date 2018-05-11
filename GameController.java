
// Author: Madison Morgan
// Student number: 8287926
// Course: ITI 1121-D
// Assignment: 3
// Question: Controller

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


/**
 * The class <b>GameController</b> is the controller of the game. It has a method
 * <b>selectColor</b> which is called by the view when the player selects the next
 * color. It then computesthe next step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class GameController implements ActionListener {

    private int size;
    private GameModel gm;
    private GameView gv;
    

    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played
     */
    public GameController(int size) {

        this.size=size;
        gm=new GameModel(size);
        gv=new GameView(gm,this);
    }



    /**
     * resets the game
     */
    public void reset(){
        gm.reset();
        gv.dispose();
        gv=new GameView(gm,this);

    }





    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {

        String command= e.getActionCommand();
               
        if(command.equals("Reset")){
            reset();

        }
        else if (command.equals("Quit")) {
            gv.dispose();
            System.exit(0);
        }
        else if (command.equals("zero")){
            //capture all near dots with samecolor
            // update game view and model
            // check if games over
            selectColor(0);
            gm.setCurrentSelectedColor(0);
            gv.update();
            isGameOver();

        }
        else if(command.equals("one")){
            selectColor(1);
            gm.setCurrentSelectedColor(1);
            gv.update();
            isGameOver();
        }
        else if(command.equals("two")){
            selectColor(2);
            gm.setCurrentSelectedColor(2);
            gv.update();
            isGameOver();
        }
        else if(command.equals("three")){
            selectColor(3);
            gm.setCurrentSelectedColor(3);
            gv.update();
            isGameOver();
        }
        else if(command.equals("four")){
            selectColor(4);
            gm.setCurrentSelectedColor(4);
            gv.update();
            isGameOver();
        }
        else if(command.equals("five")){
            selectColor(5);
            gm.setCurrentSelectedColor(5);
            gv.update();
            isGameOver();
        }
    }





    /**
     * <b>selectColor</b> is the method called when the user selects a new color.
     * If that color is not the currently selected one, then it applies the logic
     * of the game to capture possible locations. It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives two options: start a new game, or exit
     * @param color
     *            the newly selected color
     */
    public void selectColor(int color){


        if( color != gm.getCurrentSelectedColor()){


            MyStack stack= new MyStack(size);


            //this is just the algorithm

            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if(gm.isCaptured(i,j)){
                        stack.push(gm.get(i,j));
                    }
                }
            }


            //while stack is not empty, keep searching left,right, up, down
            // dots to try to find dot of same color
            while ( !(stack.isEmpty()) ){

                DotInfo d = stack.pop();
                int dY= d.getY();
                int dX= d.getX();

                
                if (dY - 1 >= 0 && color== gm.getColor(dX,dY-1)
                && (!(gm.isCaptured(dX, dY - 1)) )) {
                    //capture n,push n to stack
                    gm.capture(dX,dY-1);
                    stack.push(gm.get(dX,dY-1));
                }



                if (dY + 1 < size && color== gm.getColor(dX,dY+1)
                && (!(gm.isCaptured(dX, dY + 1)) )) {
                    //capture n,push n to stack
                    gm.capture(dX,dY+1);
                    stack.push(gm.get(dX,dY+1));
                }

                


                if (dX - 1 >= 0 && color== gm.getColor(dX-1,dY)
                && (!(gm.isCaptured(dX-1, dY)) )) {
                    //capture n,push n to stack
                    gm.capture(dX-1,dY);
                    stack.push(gm.get(dX-1,dY));
                }





                if (dX + 1 < size && color==gm.getColor(dX+1,dY)
                && (!(gm.isCaptured(dX+1, dY)) )) {
                    //capture n,push n to stack
                    gm.capture(dX+1,dY);
                    stack.push(gm.get(dX+1,dY));
                }

            }
        }
    }       


// ADD YOUR PRIVATE METHODS HERE

    /**
     * <b>isGameOver</b> is a private method that 
     *  checks if the game is over, if so: displays the appropiate JOptionPane
     *  deciding if the user has won or loss - and asks user to quit or play again
     *
     */
    private void isGameOver(){

    	String[] options= { "Quit", " Play Again"};
    	int opt;

        //somehow return this information to gameView, maybe add parameter into constructor        
        if ( gm.isFinished() ){

            opt= JOptionPane.showOptionDialog(gv, "Congratulations, you have won in 20 steps!\n  Would you like to play again?", "WIN", 0, JOptionPane.INFORMATION_MESSAGE, null, options, options[0] );
        }

        else if( gm.getNumberOfSteps() == 20 ){
            opt= JOptionPane.showOptionDialog(gv, "Failure, you have lost the game!\n  Would you like to play again?", "LOSE", 0, JOptionPane.INFORMATION_MESSAGE, null, options, options[0] );
        } 
        //checks if game is finished, if so congratualte player: showing
        // the number of moves and gives two options:
        // start a new game or exit
        else{
        	opt=-1;
        }
        

        if(opt==0){
        	System.exit(0);
        }
        if(opt==1){
        	reset();
        }

    }


}