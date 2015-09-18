package com.example.daniel.homework1app;

/**
 * Stack Algorithm using arrays
 * Main functions implemented are push(), pop(), isFull(), and isEmpty()
 * Push pushes elements onto the stack if size < 3
 * pop removes elements from the stack if size > 0
 * isFull returns true if the stack is full and false if not
 * isEmpty returns true if stack is empty and false if not
 * max size of stack is 3
 * stackSize differs depending on pushed and popped elements
 * maxSize doesn't change
 */


public class Stack {

    public final static int max_size = 3;
    int[] stackArray;
    int stackSize;



    public Stack()
    {
        //Initializes a simple 3 element array to be used for the stack
        stackArray = new int[3];
        stackSize = 0;



    }
    //push function takes value to be pushed as input
    //pushes onto stack if not full
    public void push(int val)
    {
        //declare array
        int[] new_array;

        //check to see if stackSize < max_size
        if(stackSize < max_size)
        {
            //initialize new array as 1 extra previous stack
            new_array = new int[stackSize+1];

            for(int i=0;i<stackSize+1;i++)
            {
                //set last element in new stack to pushed val
                if(i == stackSize)
                {
                    new_array[i] = val;
                }
                //else copy all of the existing elements into new array
                else
                {
                    new_array[i] = stackArray[i];
                }
            }
            //set stackArray = new_array add 1 to stackSize
            stackArray = new_array;
            stackSize += 1;

        }

        else
        {
            System.out.println("The stack is currently full. Please try again later.");

        }

    }
    //function to pop elements out of stack
    public int pop()
    {

        int value;
        int newsize = stackSize -1;

        //makes sure the new size >= 0
        if(newsize >= 0) {
            //initializes new array to 1 less than old
            int[] newarray = new int[newsize];

            //sets the values for the newarray
            for (int j = 0; j < newsize; j++) {
                newarray[j] = stackArray[j];
            }
            //used in StackActivity popInteger function
            value = stackArray[newsize];

            stackArray = newarray;
            stackSize = newsize;

            return value;
        }

        else
        {
            //System.out.println("The Stack is Empty");
            return 0;
        }
    }
    //checks if stack is full
    public boolean isFull()
    {
        if(stackSize == max_size)
        {
            return true;
        }

        else
        {
            return false;
        }
    }
    //checsk if stack is empty
    public boolean isEmpty()
    {
        if(stackSize == 0)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

}
