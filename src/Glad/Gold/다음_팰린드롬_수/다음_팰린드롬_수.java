package Glad.Gold.다음_팰린드롬_수;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class 다음_팰린드롬_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] nums =  (new BigInteger(sc.next())).add(BigInteger.ONE).toString().toCharArray();
        boolean isPalin = true;
        while (true) {
            for (int i = 0; i < nums.length / 2; i++) {
                isPalin = true;
                if (nums[i] > nums[nums.length - i - 1]) {
                    nums[nums.length -i - 1] = nums[i];
                } else if (nums[i] < nums[nums.length - i - 1]){
                    nums[nums.length -i - 1] = nums[i];
                    nums = new BigInteger(new String(nums)).add(BigInteger.valueOf(10).pow(i + 1)).toString().toCharArray();
                }
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] != nums[nums.length -j -1]){
                        isPalin = false;
                        break;
                    }
                }
                if(isPalin) break;
            }
            if(isPalin) break;
        }

        System.out.println(new String(nums));
    }
}
