package Glad.Silver.물병;

import java.util.Scanner;

public class 물병 {
    public static void main(String[] args) {
        /*
        1L = 1
        2L => 2개
        4L => 4개
        8L => 8개
        16L => 16개
        31, 16,
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int tempN = N;
        int pow = 0;
        while(tempN > 0){
            tempN /= 2;
            pow++;
        }
        int[] bottles = new int[pow + 1];
        bottles[0] = 1;
        for (int i = 1; i < bottles.length; i++) {
            bottles[i] = bottles[i - 1] * 2;
        }
        int bottle = findBottle(N, K, bottles);
        System.out.println(bottle);
    }

    private static int findBottle(int N, int K, int[] bottles) {
        if (N <= K) return 1;
        //K-1 만큼 반복해라, 1병 1병씩 만들기, 마지막병은 나머지 병
        int countBottle = 0;
        for (int i = 0; i < bottles.length && countBottle < K - 1; i++) {
            if (bottles[bottles.length - i - 1] <= N){
                N -= bottles[bottles.length - i - 1];
                countBottle++;
            }
            if (N == 0)return 0;
        }
        int extraBottle = 0;
        for (int i = 0; i < bottles.length; i++) {
            if (bottles[i] >= N){
                extraBottle = bottles[i] - N;
                break;
            }
        }
        return extraBottle;
    }
}
