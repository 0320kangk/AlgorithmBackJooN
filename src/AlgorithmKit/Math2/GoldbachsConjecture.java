package Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachsConjecture {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        boolean check;
        int[] DecimalArray = new int[10000];
        StringBuilder sb = new StringBuilder();

        int DecimalSize;

        for (int i = 0; i < testCase; i++) {

            DecimalSize = 0;

            int value = Integer.parseInt(br.readLine());

            if (value == 4) {
                sb.append(2 + " " + 2 + "\n");
                continue;
            } else if (value == 6) {
                sb.append(3 + " " + 3 + "\n");
                continue;
            }

            for (int j = 2; j < value - 1; j++) {
                check = true;
                double sqrt = Math.sqrt(j);
                for (int k = 2; k <= sqrt; k++) {

                    if (j % k == 0) {
                        check = false;
                        break;
                    }

                }
                if (check == true) {
                    DecimalArray[DecimalSize++] = j;
                }

            }

            int temp1 = 0;
            int temp2 = 10000;


            for (int l = 0; l < DecimalSize - 1; l++) {
                for (int l2 = l + 1; l2 < DecimalSize; l2++) {
                    if (DecimalArray[l] + DecimalArray[l2] == value) {

                        if (temp2 - temp1 > DecimalArray[l2] - DecimalArray[l]) {

                            temp1 = DecimalArray[l];
                            temp2 = DecimalArray[l2];

                        }
                    }

                }
                if (DecimalArray[l] * 2 == value) {

                    temp1 = DecimalArray[l];
                    temp2 = DecimalArray[l];
                    break;

                }

            }
            sb.append(temp1 + " " + temp2 + "\n");


        }
        System.out.print(sb);

    }

}

/*
    구하는 방법
    1. 8보다 작은 모든 소수를 구한다.
    => 2 3 5 7

    두 소수의 차이가 가장 작은 것?
 */
