import java.util.*;

/*
 * ============================================================
 * SRM CLASS - UseCase12PalindromeCheckerApp
 * ============================================================
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome validation
 * algorithms can be selected dynamically at runtime using
 * the Strategy Design Pattern.
 *
 * Key Concepts:
 * - Interface
 * - Polymorphism
 * - Strategy Pattern
 * ============================================================
 */

public class PalindromeCheckerApp {

    // ============================================================
    // INTERFACE - PalindromeStrategy
    // ============================================================
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // ============================================================
    // CLASS - StackStrategy
    // ============================================================
    static class StackStrategy implements PalindromeStrategy {

        @Override
        public boolean check(String input) {

            Stack<Character> stack = new Stack<>();

            // Push all characters into stack
            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            // Compare with original string
            for (char c : input.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // ============================================================
    // CLASS - DequeStrategy
    // ============================================================
    static class DequeStrategy implements PalindromeStrategy {

        @Override
        public boolean check(String input) {

            Deque<Character> deque = new ArrayDeque<>();

            // Insert all characters into deque
            for (char c : input.toCharArray()) {
                deque.addLast(c);
            }

            // Compare front and rear
            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) {
                    return false;
                }
            }

            return true;
        }
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");

        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.check(input);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? " + result);

        scanner.close();
    }
}