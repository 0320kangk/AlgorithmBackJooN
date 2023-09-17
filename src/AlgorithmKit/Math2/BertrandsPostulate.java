package AlgorithmKit.Math2;

import java.util.Scanner;

public class BertrandsPostulate {

    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int x = sc.nextInt();

        while (x != 0) {

            int count = x;
            for (int i = x + 1; i <= 2 * x; i++) {

                double sqrt = Math.sqrt(i);

                for (int j = 2; j <= sqrt; j++) {

                    if (i % j == 0) {
                        count--;
                        break;

                    }

                }
            }
            sb.append(count + "\n");
            x = sc.nextInt();
        }
        System.out.print(sb);

    }

}
