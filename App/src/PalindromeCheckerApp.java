public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Hardcoded string
        String input = "madam";

        // Variable to store reversed string
        String reversed = "";

        // Iterate from last character to first
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        // Compare original and reversed string
        if (input.equals(reversed)) {
            System.out.println("Input text: " + input);
            System.out.println("Reversed text: " + reversed);
            System.out.println("Is it a Palindrome? : true");
        } else {
            System.out.println("Input text: " + input);
            System.out.println("Reversed text: " + reversed);
            System.out.println("Is it a Palindrome? : false");
        }
    }
}