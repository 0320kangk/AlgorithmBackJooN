package Glad.Silver.금민수의_개수;

import java.util.Scanner;

public class 금민수의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int count = 0;
        for (int i = A; i <= B; i++) {
            int num = i;
            boolean flag = false;
            while(num > 0){
                if( num % 10 != 7 && num % 10 != 4){
                    flag = true;
                    break;
                }
                num = num / 10;
            }
            if(!flag) count++;
        }
        System.out.println(count);
    }
}
