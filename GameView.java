
// Author: Madison Morgan
// Student number: 8287926
// Course: ITI 1121-D
// Assignment: 3
// Question: View

import java.awt.*;
import javax.swing.*;


/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out the actual game and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

    //instances defining game view
    private GameModel model;
    private GameController gameController;

    //input that updats Number of Steps
    private JLabel inp;

    //Panel to hold the model of the game, the buttons to change the color, 
    // and the control buttons (reset, quit)
    private JPanel buttons;
    private JPanel controlButtons;
    private JPanel board;

    // these are the control buttons, control whether new game to be initiated (reset)
    // or too quit current game
    private JButton reset;
    private JButton quit;

    //Dot buttons to control the current selected color
    private DotButton zero;
    private DotButton one;
    private DotButton two;
    private DotButton three;
    private DotButton four;
    private DotButton five;

    //2D array to hold the actual game model in dotButtons form
    private DotButton[][] game;



    /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */
    public GameView(GameModel model, GameController gameController) {

        // Initializing the JFrame

        super("Flood It");
        this.model=model;
        this.gameController=gameController;

////////////////////////////////////////////////////////////////

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setSize(1000,1000);

 ////////////////////////////////////////////////////////////////////

        //initiallizing the JPanels

       
        buttons=new JPanel(new FlowLayout());
        buttons.setBackground(Color.WHITE);
        buttons.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        controlButtons= new JPanel();
        controlButtons.setBackground(Color.WHITE);

        createBoard();
        board.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));


//////////////////////////////////////////buttons for controlling purpose///////
        
        // Adding action commands/listeners to control action events

        zero= new DotButton(0,3);
        zero.setActionCommand("zero");
        zero.addActionListener(gameController);
        buttons.add(zero);

        one=new DotButton(1,3);
        one.setActionCommand("one");
        one.addActionListener(gameController);
        buttons.add(one);

        two= new DotButton(2,3);
        two.setActionCommand("two");
        two.addActionListener(gameController);
        buttons.add(two);

        three= new DotButton(3,3);
        three.setActionCommand("three");
        three.addActionListener(gameController);
        buttons.add(three);

        four= new DotButton(4,3);
        four.setActionCommand("four");
        four.addActionListener(gameController);
        buttons.add(four);

        five= new DotButton(5,3);
        five.setActionCommand("five");
        five.addActionListener(gameController);
        buttons.add(five);

        inp= new JLabel("Number of Steps: 0");
        controlButtons.add(inp);

        reset = new JButton("Reset");
        reset.setFocusPainted(false);
        reset.addActionListener(gameController);
        reset.setBackground(Color.WHITE);
        controlButtons.add(reset);

        quit = new JButton("Quit");
        quit.setFocusPainted(false);
        quit.addActionListener(gameController);
        quit.setBackground(Color.WHITE);
        controlButtons.add(quit);



///////////////////////////////////////////////////////

        // adding the buttons to the panels, and panels to the frame

        add(buttons, BorderLayout.CENTER);
        add(controlButtons, BorderLayout.SOUTH);
        add(board, BorderLayout.NORTH);

        pack();

		setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }



    /**
     * update the status of the board's DotButton instances based on the current game model
     */
    public void update(){
    
        inp.setText("Number of Steps: "+ Integer.toString(model.getNumberOfSteps())); 

        for (int i=0; i<model.getSize();i++){
            for (int j=0; j<model.getSize(); j++){
                if( model.isCaptured(i,j) ){
                    game[i][j].setColor(model.getCurrentSelectedColor());
                }
            }
        }

    }


    /**
     * <b>createBoard</b> private method to create board, i.e. the game model with all the
     * related DotInfos corresponding to Dotbuttons, also places these buttons
     * onto a board like structure 
     *
     */
    private void createBoard(){

        int modelSize= model.getSize();
        int iconSize;
        game= new DotButton[modelSize][modelSize];

        if(modelSize>=10&& modelSize<=25){  iconSize=2;}
        else if(modelSize>25){ iconSize=1;} //initiate the iconsize 1=small, 2=medium
        else{ iconSize=0;}



        for (int i=0; i<modelSize; i++){
            for (int j=0; j<modelSize; j++){
                game[i][j]=new DotButton(i,j,model.getColor(i,j),iconSize);
            }
        }


        board= new JPanel(new GridLayout(modelSize,modelSize));
        board.setBackground(Color.WHITE);


        // must be backwards loops because the layoutby defaultfollows flow
        // aka left to right, top to bottom
        for(int i=0; i<modelSize; i++){
            for (int j=0; j<modelSize; j++){
                board.add(game[i][j]);
            }
        }
    }

}