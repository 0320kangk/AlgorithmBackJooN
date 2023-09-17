package AlgorithmKit.Function;

import java.util.Scanner;

public class Hansoo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int hansooCount = 0;

        if (N / 100 <= 0) {

            System.out.println(N);

        } else {

            for (int i = 100; i <= N; i++) {

                int num1 = i / 100;
                int num2 = i % 100 / 10;
                int num3 = i % 10;
                if (num2 - num1 == num3 - num2) {

                    hansooCount++;

                }

            }
            System.out.println(hansooCount + 99);
        }

    }


}
