package Glad.Gold.거의_소수;

import java.util.Scanner;

public class 거의_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        boolean[] notPrimes = new boolean[10000001];
        for (int i = 2; i < notPrimes.length; i++) {
            if(notPrimes[i]) continue;
            for (int j = i * 2; j < notPrimes.length; j+=i) {
                notPrimes[j] = true;
            }
        }
        int count = 0;
        for (int i = 2; i < notPrimes.length; i++) {
            if(!notPrimes[i]) {
                if(getLength(i) * 2 > 15) continue;
                long value = (long)i * (long)i;
                while(value <= B){
                    if(value >= A && value <= B) count++;
                    if(getLength(value) + getLength(i) > 15) break;
                    value = value * i;
                }
            }
        }
        System.out.println(count);
    }
    static int getLength(long value){
        int length = 1;
        while(value / 10 > 0) {
            value /= 10;
            length++;
        }
        return length;
    }
}
