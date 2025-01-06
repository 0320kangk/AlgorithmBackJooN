package Glad.Gold.오민식;

import java.util.Scanner;

public class 오민식 {

    public static void main(String[] args) {
        //1,2,3,4,5,6,7,8,9,10

        //gcd 구해보기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = 987654321;
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) isPrime[i] = true;
        // 1~N까지의 수 중
        // N이하의 거듭제곱 소수중 가장 큰 수 찾기
        for (int i = 2; i <= N; i++) {
            if(isPrime[i]){
                for (int j = i*2; j < isPrime.length; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        long lcm = 1;
        for(int i = 2; i < isPrime.length; i++) {
            long power = i;
            if(isPrime[i]){
                while(power * i <= N){
                    power *= i;
                }
                lcm = (power * lcm) % max;
            }
        }
        System.out.println(lcm);
    }
}
