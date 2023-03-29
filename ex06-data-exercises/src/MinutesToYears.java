import java.util.Scanner;

public class MinutesToYears {


    public static void minutesToYear() {
        System.out.println("Input minutes: ");
        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();
        int years = minutes / (60 * 24 * 365);
        int days = (minutes / (60 * 24)) - (years * 365);

        System.out.println(minutes + "minutes is approx. " + years + " years and " + days + " days.");
    }

}
