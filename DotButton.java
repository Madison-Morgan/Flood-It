
// Author: Madison Morgan
// Student number: 8287926
// Course: ITI 1121-D
// Assignment: 3
// Question: View


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * In the application <b>FloodIt</b>, a <b>DotButton</b> is a specialized color of
 * <b>JButton</b> that represents a dot in the game. It can have one of six colors
 * 
 * The icon images are stored in a subdirectory ``data''. We have 3 sizes, ``normal'',
 * ``medium'' and ``small'', respectively in directory ``N'', ``M'' and ``S''.
 *
 * The images are 
 * ball-0.png => grey icon
 * ball-1.png => orange icon
 * ball-2.png => blue icon
 * ball-3.png => green icon
 * ball-4.png => purple icon
 * ball-5.png => red icon
 *
 *  <a href=
 * "http://developer.apple.com/library/safari/#samplecode/Puzzler/Introduction/Intro.html%23//apple_ref/doc/uid/DTS10004409"
 * >Based on Puzzler by Apple</a>.
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotButton extends JButton {

    private static final int SMALL_SIZE=1;
    private static final int MEDIUM_SIZE=2;
    private static final int LARGE_SIZE=3;

    private int row;
    private int column;
    private int color;
    private String size;


    /**
     * Constructor used for initializing a cell of a specified color.
     * 
     * @param row
     *            the row of this Cell
     * @param column
     *            the column of this Cell
     * @param color
     *            specifies the color of this cell
     * @param iconSize
     *            specifies the size to use, one of SMALL_SIZE, MEDIUM_SIZE or LARGE_SIZE
     */
    public DotButton(int row, int column, int color, int iconSize) {

        super();
        this.row=row;
        this.column=column;
        this.color=color;

        if (iconSize==SMALL_SIZE){size="S";}
        else if(iconSize==MEDIUM_SIZE){size="M";}
        else if(iconSize==LARGE_SIZE){size="N";}

        setBackground(Color.WHITE);
        setIcon(whatImageIcon());

        Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        setBorder(emptyBorder);
        setBorderPainted(false);
   }



    /**
     * Other constructor used for initializing a cell of a specified color.
     * no row or column info available. Uses "-1, -1" for row and column instead
     * 
     * @param color
     *            specifies the color of this cell
     * @param iconSize
     *            specifies the size to use, one of SMALL_SIZE, MEDIUM_SIZE or MEDIUM_SIZE
     */   
    public DotButton(int color, int iconSize) {
        this(-1,-1,color,iconSize);
    }
 


    /**
     * Changes the cell color of this cell. The image is updated accordingly.
     * 
     * @param color
     *            the color to set
     */
    public void setColor(int color) {
        this.color=color;
        setIcon(whatImageIcon());
   }

    /**
     * Getter for color
     *
     * @return color
     */
    public int getColor(){
        return color;
    }
 
    /**
     * Getter method for the attribute row.
     * 
     * @return the value of the attribute row
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter method for the attribute column.
     * 
     * @return the value of the attribute column
     */
    public int getColumn() {
        return column;
    }

    /**
     * private method to determine path of image icon, to intialize buttons
     *
     * @return the designated Image icon for the particular DotButton
     */
    private ImageIcon whatImageIcon(){

        String colr = Integer.toString(color);
        
        ImageIcon tmp = new ImageIcon(DotButton.class.getResource("/data/"+size+"/ball-"
                + colr + ".png"));
    
        return tmp;
    }


   
}