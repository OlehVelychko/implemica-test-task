// src/task3/FactorialSum.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FactorialSum {

    // Private method to calculate factorial of a number
    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Private method to calculate the sum of digits in a number
    private static int sumOfDigits(BigInteger number) {
        String numberStr = number.toString();
        int sum = 0;
        for (char digit : numberStr.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter a number to calculate the sum of digits in its factorial: ");
            int number = Integer.parseInt(reader.readLine().trim());
            if (number < 0) {
                System.out.println("Number must be non-negative.");
                return;
            }

            BigInteger factorialResult = factorial(number);
            int sum = sumOfDigits(factorialResult);
            System.out.println("Sum of digits in " + number + "! is: " + sum);
        } catch (IOException | NumberFormatException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}