package Glad.Gold.부분_삼각_수열;

import java.util.Arrays;
import java.util.Scanner;

public class 부분_삼각_수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] strNums = sc.nextLine().split(" ");
        if(N < 3 ){
            System.out.println(N);
        } else {
            int[] nums = new int[strNums.length];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(strNums[i]);
            }
            Arrays.sort(nums);
            int max = 0;
            for (int i = 0; i < N - 2; i++) {
                int count = 0;
                for (int j = i + 2; j < N ; j++) {
                    if(nums[i] + nums[i+1] > nums[j]) count++;
                    else break;
                }
                if (count > max) max = count;
            }
            int answer = max + 2;
            System.out.println(answer);
        }

    }
}
