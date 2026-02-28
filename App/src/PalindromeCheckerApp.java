import java.util.Scanner;

/**
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * ------------------------------------------
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.
 *
 * The palindrome logic is encapsulated inside the
 * PalindromeService class.
 *
 * Improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 */
public class PalindromeCheckerApp {

    /**
     * Application entry point for UC11.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create service object
        PalindromeService service = new PalindromeService();

        // Call service method
        boolean result = service.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}


/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     *
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {

        // Handle null or empty input
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Convert to lowercase (optional improvement)
        input = input.toLowerCase();

        // Initialize pointers (as shown in hint on Page 2)
        int start = 0;
        int end = input.length() - 1;

        // Compare characters moving inward
        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}