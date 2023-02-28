package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            File file = new File("input.csv");
            Scanner scanner = new Scanner(file);

            FileWriter fw = new FileWriter("output.csv");

            String[] orders = new String[0];
            while (scanner.hasNextLine()) {
                String order = scanner.nextLine();

                //create array of orders

                System.out.println(orders.length);
                orders = order.split(",");
                System.out.println(Arrays.toString(orders));

                for (int i = 0; i < orders.length; i++) {
                    fw.write(orders[i] + ";");
                }
            }

            fw.close();

        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}

				