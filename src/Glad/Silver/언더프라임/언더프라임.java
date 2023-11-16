package Glad.Silver.언더프라임;

import java.util.Scanner;
public class 언더프라임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int count = 0;
        for (int i = A; i <= B; i++) {
            int size = 1;
            int num = i;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if(num % j == 0){
                    num /= j;
                    j = 1;
                    size++;
                }
            }
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(size); j++) {
                if( size % j == 0)
                    flag = false;
            }
            if (flag && size >= 2)
                count++;
        }
        System.out.println(count);
    }
}
