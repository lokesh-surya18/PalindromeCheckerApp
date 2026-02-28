/**
 * @author Developer
 * @version 9.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input = ");
        String input = scanner.nextLine();

        // Remove spaces and convert to lowercase (optional improvement)
        input = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = check(input, 0, input.length() - 1);

        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }


    private static boolean check(String s, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        return check(s, start + 1, end - 1);
    }
}