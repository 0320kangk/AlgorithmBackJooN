package Glad.Silver.이면수와_임현수;

import java.util.HashSet;
import java.util.Scanner;

public class 이면수와_임현수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //이면수
        //2 2 3
       if( check1(N) && check2(N) ){
           System.out.println(4);
       } else{
           if( check1(N)){
               System.out.println(1);
           }else if ( check2(N)){
               System.out.println(2);
           }else {
               System.out.println(3);
           }
       }
    }
    static boolean check2 (int N) {
        if (N ==4 || N == 2) return true;
        if (N==1) return false;
        HashSet<Integer> set = new HashSet<>();
            for (int i = 2; i <= N; i++) {
                while (N % i == 0){
                    N /= i;
                    set.add(i);
                }
            }
            if (set.size() == 1) return false;
            else return (set.size()) % 2 == 0;
    }

    static boolean check1(int N) {
        int sum = 0;
        if (N >= 6) {
            while(N > 0) {
                sum += N % 10;
                N /= 10;
            }
            return sum % 2 == 1;
        }
        return false;
    }
}
