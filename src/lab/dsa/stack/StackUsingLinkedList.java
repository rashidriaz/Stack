package lab.dsa.stack;

public class StackUsingLinkedList<T> {
    private static final int STACK_SIZE = 25;
    private LinkedList<T> stack;

    public StackUsingLinkedList() {
        this.stack = new LinkedList<>();
    }

    /*
    This method returns the element located at
    the top most location of the stack
     */
    public T peek() {
        return stack.getLast();
    }

    /*
    This method returns and deletes the element
     located at the top most location of the stack
     */
    public T pop() {
        T data = stack.getLast();
        stack.deleteFromTheTail();
        return data;
    }

    /*
    The functionality of this method is to compare
    the given element with the one located at the
    top of the stack without deleting it
     */

    public boolean isEqual(T data) {
        return stack.getLast() == data;
    }

    /*
    This method adds a new element at the top of the stack
     */
    public void push(T data) {
        stack.insert(data);
    }

    /*
    this method checks whether the stack is empty or not
     */
    public boolean isEmpty() {
        return stack.getSize() == 0;
    }

    /*
    This method checks whether the stack is full or not full
     */
    public boolean isFull() {
        return stack.getSize() >= STACK_SIZE;
    }


    /*
    This method returns a string of all the elements stored in the stack.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.getSize(); i++) {
            result.append(stack.getFrom(i).toString());
        }//END OF FOR LOOP
        return result.toString();
    }

    public int getSize(){
        return stack.getSize();
    }
    /*
    This method resets the stack top to 0
     */
    public void reset() {
        this.stack = new LinkedList<>();
    }
}
