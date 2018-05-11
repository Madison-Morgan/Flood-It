
// Author: Madison Morgan
// Student number: 8287926
// Course: ITI 1121-D
// Assignment: 3
// Question: Controller


public class MyStack implements Stack<DotInfo>{

    /**
     * declare instance variables, this is simple stack implementation
     */
	private int top;
	private DotInfo[] arr;
    private static int size;


    /**
     * Constructor, initializes the stack: size, top elemt, stack
     *
     * @param size
     *          size of stack
     */
	public MyStack(int size){
        this.size=size;
        arr=new DotInfo[size*size];
		top=0;
	}


	 /**
     * Tests if this Stack is empty.
     *
     * @return true if this Stack is empty; and false otherwise.
     */
    public boolean isEmpty(){
    	return top==0;
    }






    /**
     * Returns a reference to the top element; does not change
     * the state of this Stack.
     *
     * @return The top element of this stack without removing it.
     */
    public DotInfo peek(){
    	if(!(this.isEmpty())){
    		return arr[top-1];
    	}
    	else{
    		return null;
    	}
    }




    /**
     * Removes and returns the element at the top of this stack.
     *
     * @return The top element of this stack.
     */
    public DotInfo pop(){
    	if(!(this.isEmpty())){
    		DotInfo temp = this.peek();
    		arr[top-1]=null; //scrub memory
    		top--;
    		return temp;
    	}
    	else{
    		return null;
    	}

    }




    /**
     * Puts an element onto the top of this stack.
     *
     * @param element the element be put onto the top of this stack.
     */
    public void push ( DotInfo element ){

    	if(top< (size*size)){
    		arr[top]=element;
    		top++;
    	}
    	else{
    		System.out.println("Stack Overflow");
    	}
    }
}