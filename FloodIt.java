
// Author: Madison Morgan
// Student number: 8287926
// Course: ITI 1121-D
// Assignment: 3
// Question: Controller


/**
 * The class <b>FloodIt</b> launches the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
import java.util.Scanner;

public class FloodIt {

    /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If a game size ( less then 12) is passed as parameter, it is 
     * used as the board size. Otherwise, a default value is passed
     * 
     * @param args
     *            command line parameters
     */

    //just a scanner to get user input of how large they want to play the game
    private static Scanner sc;
    private static final int DEFAULT_SIZE= 12;

    public static void main(String[] args){

    	
    	StudentInfo.display();
        System.out.println("\n\nHow large would you like the game size to be? ");
        sc= new Scanner(System.in);
        int size=sc.nextInt();

        if (size<10){
            size=DEFAULT_SIZE;
            GameController g= new GameController(size);

        }
        else{
            GameController g=new GameController(size);
        }

        //the actual process of enacting the game will take place in the private
        // of game controller because we need access too the instance variables
        // of the game controller and no getters are publicly 
        // aloud according to the given public methods 

    }


}
