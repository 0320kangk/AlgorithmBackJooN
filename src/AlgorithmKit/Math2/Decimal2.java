package AlgorithmKit.Math2;

import java.util.Scanner;
import java.util.Arrays;


public class Decimal2 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int[] array = new int[10000];

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int size = 0;
        boolean check = true;

        for (int i = num1; i <= num2; i++) {

            check = true;
            double x = Math.sqrt(i);

            for (int j = 2; j <= x; j++) {

                if (i / j == (double) i / j) {
                    check = false;
                    break;
                }
            }
            if (check && i > 1) {
                array[size++] = i;
            }

        }

        if (size > 0) {

            System.out.println(Arrays.stream(array).sum());
            System.out.print(array[0]);

        } else {

            System.out.println(-1);

        }


    }
}
