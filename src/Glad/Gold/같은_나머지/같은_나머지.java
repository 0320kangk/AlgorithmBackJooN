package Glad.Gold.같은_나머지;

import java.util.Scanner;

public class 같은_나머지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] numsStr = sc.nextLine().split(" ");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        int answer = 0;
        for (int i = 1; i <= 1000000; i++) {
            boolean flag = false;
            int rest = nums[0] % i;
            if (rest < 0 ) rest = i + rest;
            for (int j = 1; j < nums.length; j++) {
                int nextRest = nums[j] % i;
                if (nextRest < 0 ) nextRest = i + nextRest;
                if(nextRest != rest ){
                    flag = true;
                    break;
                }
            }
            if(!flag) answer= i;
        }
        System.out.println(answer);

    }
}
