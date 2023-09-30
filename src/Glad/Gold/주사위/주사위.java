package Glad.Gold.주사위;

import java.util.Arrays;
import java.util.Scanner;

public class 주사위 {
    public static void main(String[] args) {
        /*
        규칙
        3면만 보이는 주사위 :4, 마주 보는 면만 제외하고, 3면의 합중 가장 작은 값 구하기
        2면만 보이는 주사위의 개수 : 8N-12;
        1면만 보이는 주사위의 개수 : 4*(n-2)(n-1) + (n-2)(n-2) = (n-2)(5n-6) = 5n^2- 16n +12;
         */
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        int[] diceNum = new int[6];
        for (int i = 0; i < 6; i++) {
            diceNum[i] = sc.nextInt();
        }
        if (N == 1){
            Arrays.sort(diceNum);
            System.out.println(Arrays.stream(diceNum).sum() - diceNum[5]);
            return;
        }

        long sum = 0;
        long sides1min = 50;
        for (int i = 0; i < 6; i++) {
            sides1min = Math.min(diceNum[i], sides1min);
        }
        sum += sides1min * ((5 * N *N) - 16 *N + 12);
        long sides2min = 100;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (j != 5-i) {
                    sides2min = Math.min(diceNum[i] + diceNum[j], sides2min);
                }
            }
        }
        sum += sides2min * (8*N - 12);
        long sides3min = 0;
        for (int i = 0; i < 3; i++) {
            sides3min += Math.min(diceNum[i], diceNum[5-i]);
        }
        sum += sides3min * 4;

        System.out.println(sum);

    }
}
