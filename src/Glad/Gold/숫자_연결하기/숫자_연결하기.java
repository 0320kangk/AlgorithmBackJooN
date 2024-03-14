package Glad.Gold.숫자_연결하기;

import java.util.Scanner;

public class 숫자_연결하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        long N = Integer.parseInt(nums[0]);
        long K = Integer.parseInt(nums[1]);
        long result = N;
        long rest = 0;
        int count = 0;
        long pow = (long) Math.pow(10, nums[0].length());
        boolean[] visited = new boolean[(int)K];
        while (true){
            count++;
            rest = result % K;
            if ( rest == 0){
                System.out.println(count);
                break;
            }
            else if (!visited[(int)rest]){
                visited[(int) rest] = true;
                result = (rest * pow + N);
            } else {
                System.out.println(-1);
                break;
            }

        }

    }
}
