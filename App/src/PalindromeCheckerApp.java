import java.util.*;

public class PalindromeCheckerApp {

    // Method 1: Using Reverse String
    public static boolean checkUsingReverse(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }

    // Method 2: Using Two Pointer Technique
    public static boolean checkUsingTwoPointers(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (Character.toLowerCase(input.charAt(left)) !=
                    Character.toLowerCase(input.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method 3: Using Deque
    public static boolean checkUsingDeque(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toLowerCase().toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Remove spaces for fair comparison
        input = input.replaceAll("\\s+", "");

        System.out.println("\n----- Performance Comparison -----");

        // Reverse Method
        long start1 = System.nanoTime();
        boolean result1 = checkUsingReverse(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Two Pointer Method
        long start2 = System.nanoTime();
        boolean result2 = checkUsingTwoPointers(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // Deque Method
        long start3 = System.nanoTime();
        boolean result3 = checkUsingDeque(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        // Display Results
        System.out.println("\nInput: " + input);
        System.out.println("Is Palindrome? " + result1); // all results should match

        System.out.println("\nExecution Time (nanoseconds):");
        System.out.println("Reverse Method      : " + time1 + " ns");
        System.out.println("Two Pointer Method  : " + time2 + " ns");
        System.out.println("Deque Method        : " + time3 + " ns");

        scanner.close();
    }
}