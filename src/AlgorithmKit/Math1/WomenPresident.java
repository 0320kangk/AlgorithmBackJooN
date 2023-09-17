package AlgorithmKit.Math1;

import java.util.Scanner;


public class WomenPresident {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
        int k = 0, n;
        int[][] array;
        String answer = "";
        for (int i = 0; i < TestCase; i++) {

            k = sc.nextInt();
            n = sc.nextInt();
            array = new int[k + 1][n];

            for (int j = 0; j < k + 1; j++) {

                array[j][0] = 1;

            }
            for (int l = 0; l < n; l++) {

                array[0][l] = l + 1;
            }

            for (int a = 1; a < k + 1; a++) {
                for (int b = 1; b < n; b++) {

                    array[a][b] = array[a - 1][b] + array[a][b - 1];

                }
            }
            answer = answer + Integer.toString(array[k][n - 1]) + "\n";

        }
        System.out.print(answer);

    }

}
