package Glad.Silver.팩토리얼5;

import java.util.Scanner;

public class 팩토리얼5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long num = 1;
        long mol = (long) 1e12;
        for (int i = 2; i <= N; i++) {
            num *= i;
            while(num % 10 == 0){
                num /= 10;
            }
            num %= mol;
        }
        System.out.println(String.format("%05d",num % 100000));

    }
}
