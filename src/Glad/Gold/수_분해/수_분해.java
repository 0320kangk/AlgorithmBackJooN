package Glad.Gold.수_분해;

import java.util.Scanner;

public class 수_분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //2와 3으로표현한다.
        long N = sc.nextLong();
        if(N==0) System.out.println(0);
        else System.out.println(findAnswer(N));

    }
    static long findAnswer(long N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 3;

        long result = 1;

        while ( N > 4){
            result = (result * 3) % 10007;
            N -= 3;
        }

        result = (result * N) % 10007;


        return result;
    }

}
