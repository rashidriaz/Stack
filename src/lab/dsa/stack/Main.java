package lab.dsa.stack;


import java.util.Scanner;

public class Main {
    private static final StackUsingArray arrayStack = new StackUsingArray();
    private static final StackUsingLinkedList<Character> linkedListStack = new StackUsingLinkedList<>();

    public static void main(String[] args) {
        insertData("ArrayStack", "LinkedListStack");
        printStacks();
        System.out.println("-----------------------------------------------------------------------");
        reverseAndPrintString();
        System.out.println("--------------------------------------------------------------------------");
        System.out.print("\nEnter the expression which you want to convert to a prefix expression:\t");
        String expression = new Scanner(System.in).nextLine();
        expression = InfixToPrefix.infixToPrefix(expression.toCharArray());
        System.out.println("Converted expression:\t" + expression);
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void insertData(String arrayStackString, String linkedListStackString) {
        for (int i = 0; i < arrayStackString.length(); i++) {
            arrayStack.push(arrayStackString.charAt(i));
        }
        for (int i = 0; i < linkedListStackString.length(); i++) {
            linkedListStack.push(linkedListStackString.charAt(i));
        }

    }

    private static void printStacks() {
        System.out.println("""


                -----------------------------------Stack using array-----------------------------------

                """);
        int size = arrayStack.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": \t" + arrayStack.pop());
        }
        System.out.println("""


                -----------------------------------Stack using LinkedList-----------------------------------

                """);
        size = linkedListStack.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": \t" + linkedListStack.pop());
        }
    }

    private static void reverseAndPrintString() {
        System.out.print("Please Enter a string which you want to reverse:\t");
        String string = new Scanner(System.in).nextLine();
        insertData(string, string);
        StringBuilder result = new StringBuilder();
        int length = arrayStack.getSize();
        for (int i = 0; i < length; i++) {
            result.append(arrayStack.pop());
        }
        System.out.println("Reversed String from the array stack: \t" + result);
        length = linkedListStack.getSize();
        result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(linkedListStack.pop());
        }
        System.out.println("Reversed String from the Linked List stack: \t" + result);
    }

}
