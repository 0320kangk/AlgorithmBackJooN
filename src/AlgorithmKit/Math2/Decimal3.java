package AlgorithmKit.Math2;

import java.util.Scanner;

public class Decimal3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        boolean check;
        StringBuilder sb = new StringBuilder();
        for (int i = x; i <= y; i++) {
            check = true;

            double sqrt = Math.sqrt(i);

            for (int j = 2; j <= sqrt; j++) {

                if (i % j == 0) {
                    check = false;
                    break;
                }

            }
            if (check == true && i != 1) {

                sb.append(i).append('\n');

            }
        }
        System.out.print(sb);

    }

}
