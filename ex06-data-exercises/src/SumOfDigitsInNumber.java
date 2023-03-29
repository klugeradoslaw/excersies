import java.util.Scanner;

public class SumOfDigitsInNumber {

    public static void sum() {
        System.out.println("Input number between 0-1000: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int firstDigit = number % 10;
        int left = number / 10;
        int secondDigit = left % 10;

        left = left / 10;
        int thirdDigit = left % 10;

        left = left / 10;
        int fourthDigit = left % 10;

        int sum = firstDigit + secondDigit + thirdDigit + fourthDigit;

        System.out.println("Sum of digits in " + number + " is " + sum);
    }


}
