import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParenthesisCounter {

    // Private method to calculate the nth Catalan number
    private static long catalan(int n) {
        long[] catalan = new long[n + 1];
        catalan[0] = 1;

        for (int i = 1; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - 1 - j];
            }
        }
        return catalan[n];
    }

    // Generate all valid parentheses combinations using recursion
    private static void generate(int open, int close, String current, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }
        if (open > 0) {
            generate(open - 1, close, current + "(", result);
        }
        if (close > open) {
            generate(open, close - 1, current + ")", result);
        }
    }

    // Wrapper method to generate parentheses
    private static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, "", result);
        return result;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter N (non-negative integer): ");
            int n = Integer.parseInt(reader.readLine().trim()); // Read input and convert to integer
            if (n < 0) {
                System.out.println("N must be non-negative.");
                return;
            }

            // Calculate and display the number of valid combinations
            long numberOfCombinations = catalan(n);
            System.out.println("Number of valid parentheses combinations: " + numberOfCombinations);

            // Generate and display all valid combinations
            List<String> combinations = generateParentheses(n);
            System.out.println("All combinations for N = " + n + ":");
            for (String combination : combinations) {
                System.out.println(combination);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a non-negative integer.");
        }
    }
}