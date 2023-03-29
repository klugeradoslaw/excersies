import java.util.Scanner;

public class FahrenheitToCelsiusCalc {

    //1. Write a Java program to convert temperature from Fahrenheit to Celsius degree. Test Data:
    //Input a degree in Fahrenheit: 212
    //Expected Output:
    //212.0 degree Fahrenheit is equal to 100.0 in Celsius

    public static void calculateFahrenheitToCelsius () {
        System.out.println("Input a degree in Fahrenheit:");
        Scanner scanner = new Scanner(System.in);
        double fahrenheitDegree = scanner.nextDouble();
        double resultCelsiusDegree = ((5 * (fahrenheitDegree - 32)) / 9);
        System.out.println(fahrenheitDegree + " degree Fahrenheit is equal to " + resultCelsiusDegree + " in Celsius.");
    }


}
