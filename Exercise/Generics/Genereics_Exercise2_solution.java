import java.util.Stack;

public class StackUtils {

    public static <T extends Comparable<T>> Stack<T> reduceStack(Stack<T> stack, T element) {
        Stack<T> tempStack = new Stack<>();

        // Iterate over all elements in the stack
        while (!stack.isEmpty()) {
            T current = stack.pop();
            // Keep elements that are less than or equal to the provided element in the temporary stack
            if (current.compareTo(element) <= 0) {
                tempStack.push(current);
            }
        }

        // Restore the elements back to the original stack in the correct order
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(5);
        stack.push(30);
        stack.push(15);

        System.out.println("Original stack: " + stack);

        Stack<Integer> reducedStack = reduceStack(stack, 15);
        System.out.println("Reduced stack: " + reducedStack);
    }
}
