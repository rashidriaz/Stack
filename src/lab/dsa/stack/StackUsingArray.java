package lab.dsa.stack;

import java.lang.reflect.Array;

public class StackUsingArray {
    private static final int ARRAY_SIZE = 25;
    private final char[] stack;
    private int top;

    public StackUsingArray() {
        this.stack = new char[ARRAY_SIZE];
        this.top = 0;
    }

    /*
    This method returns the element located at
    the top most location of the stack
     */
    public char peek() {
        return stack[top - 1];
    }

    /*
    This method returns and deletes the element
     located at the top most location of the stack
     */
    public char pop() {
        return stack[--top];
    }

    /*
    The functionality of thi method is to compare
    the given element with the one located at the
    top of the stack without deleting it
     */
    public boolean isEqual(char character) {
        return stack[top - 1] == character;
    }

    /*
    This method adds a new element at the top of the stack
     */
    public void push(char character) {
        stack[top++] = character;
    }

    /*
    this method checks whether the stack is empty or not
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /*
    This method checks whether the stack is full or not full
     */
    public boolean isFull() {
        return top >= ARRAY_SIZE;
    }


    /*
    This method returns a string of all the elements stored in the stack.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < top; i++) {
            result.append(stack[i]);
        }//END OF FOR LOOP
        return result.toString();
    }
    public int getSize(){
        return top;
    }

    /*
    This method resets the stack top to 0
     */
    public void reset() {
        top = 0;
    }
}
