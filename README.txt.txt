
For this assignment, we are tasked with re-creating the game Flood-It using Java code.
It is a simple game, and the description can be found on the assignment page.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 
This archive contains all the files for Assignment 3, 
that is, this zip file contains the following files:

-README.txt
-a sub directory doc -> containing all JavaDocs for each .java/class 
-sub directory data -> containing .png for the images to be displayed in the game
		sub direc. data : S, N, M -> storing .png of the indicated size of the balls

-For the "Model" portion of this lab 
	* GameModel.java
	* DotInfo.java

-For the "Controller" portion of this lab
	* GameController.java
	* Stack.java (Interface)
	* MyStack.java (Implements Stack.java interface)
	* FloodIt.java

-For the "View" portion of this lab
	* GameView.java
	* DotButton.java

RUN FLOODIT.JAVA TO RUN GAME
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------


NOTE:
(In DotInfo.java)
// It should be noted that code given too us does not contain a public setter method
// for instance variable Color, therefore even though in the game view, the 
// DotButtons will  change 
// color.
// in the model, the DotInfo colors will not!! But this is okay  and the program will // still run correctly because all we need 
// is the
// status of the dot, whether its captured or not, and whether the dot were comparing
// is the same color as the selected color. (and there are getters in DotInfo)
// I do not think this is good practice, (i myself wouldve added a public setter) to 
// be able to update the color on the model as well.
// However there are strict guidelines indicating
// that adding public methods to the outlined code is not aloud! However we could
// have easily changed the colors of the game model, and simply updated the module 
// accordingly
// by adding a public setter to this .java file...