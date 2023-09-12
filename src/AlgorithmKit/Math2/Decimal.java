package Math2;

import java.util.Scanner;

public class Decimal {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int total = count;

        for (int i = 0; i < count; i++) {
            int number = sc.nextInt();

            if (number == 1) {
                total--;
            }

            double x = Math.sqrt(number);
            for (int j = 2; j <= x; j++) {

                if (number / j == (double) number / j) {
                    total--;
                    break;
                }

            }

        }
        System.out.println(total);
    }

}
