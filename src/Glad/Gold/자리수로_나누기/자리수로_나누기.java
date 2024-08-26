package Glad.Gold.자리수로_나누기;

import java.util.Scanner;

public class 자리수로_나누기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strN = sc.next();
        long N = Long.parseLong(strN);
        String[] split = strN.split("");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        boolean flag = true;
        long answer = N;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] != 0  && N % nums[i] != 0) flag = false;
        }
        long count = 10;
        while(!flag){
            N = N * 10;
            for (long i = 0; i < count; i++) {
                long next = N + i;
                flag = true;
                for (int j = 0; j < nums.length; j++) {
                    if(nums[j] != 0  && next % nums[j] != 0) {
                       flag = false;
                    }
                }
                if(flag) {
                    answer = next;
                    break;
                }
            }
            count *= 10;
        }
        System.out.println(answer);
    }
}
