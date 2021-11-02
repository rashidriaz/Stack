package lab.dsa.stack;

public class InfixToPrefix {
    private static boolean isAlphabet(char character)
    {
        return character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z';
    }
    private static boolean isDigit(char character)
    {
        return character >= '0' && character <= '9';
    }

    static boolean isOperator(char character)
    {
        return (!isAlphabet(character) && !isDigit(character));
    }
    private static int getPrecedence(char character)
    {
        return switch (character) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }


    private static String reverseTheString(char[] characterArray, int start, int end)
    {

        char temporaryCharacter;
        while (start < end)
        {
            temporaryCharacter = characterArray[start];
            characterArray[start] = characterArray[end];
            characterArray[end] = temporaryCharacter;
            start++;
            end--;
        }
        return String.valueOf(characterArray);
    }

    private static String infixToPostfix(char[] infix)
    {
        String newInfix = '(' + String.valueOf(infix) + ')';

        int length = newInfix.length();
        StackUsingArray characterStack = new StackUsingArray();
        StringBuilder output= new StringBuilder();

        for (int i = 0; i < length; i++)
        {
            if (isAlphabet(newInfix.charAt(i)) || isDigit(newInfix.charAt(i)))
                output.append(newInfix.charAt(i));
            else if (newInfix.charAt(i) == '(') {
                characterStack.push('(');
            }else if (newInfix.charAt(i) == ')')
            {
                while (characterStack.peek() != '(')
                {
                    output.append(characterStack.pop());
                }
                characterStack.pop();
            }
            else {
                if (isOperator(characterStack.peek()))
                {
                    while ((getPrecedence(newInfix.charAt(i)) <
                            getPrecedence(characterStack.peek()))
                            || (getPrecedence(newInfix.charAt(i)) <=
                            getPrecedence(characterStack.peek())
                            && newInfix.charAt(i) == '^'))
                    {
                        output.append(characterStack.peek());
                        characterStack.pop();
                    }
                    characterStack.push(newInfix.charAt(i));
                }
            }
        }
        return output.toString();
    }
    public static String infixToPrefix(char[] infix)
    {
        int infixLength = infix.length;
        String reversedInfix = reverseTheString(infix, 0, infixLength - 1);
        infix = reversedInfix.toCharArray();

        for (int i = 0; i < infixLength; i++)
        {
            if (infix[i] == '(')
            {
                infix[i] = ')';
                i++;
            }
            else if (infix[i] == ')')
            {
                infix[i] = '(';
                i++;
            }
        }

        String prefix = infixToPostfix(infix);
        prefix = reverseTheString(prefix.toCharArray(), 0, infixLength-1);

        return prefix;
    }
}
