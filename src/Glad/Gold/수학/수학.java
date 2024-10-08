package Glad.Gold.수학;
import java.util.*;

public class 수학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeD = sc.nextInt();
        int sizeM = sc.nextInt();

        int[] Ds = new int[sizeD];
        for (int i = 0; i < sizeD; i++) {
            Ds[i] = sc.nextInt();
        }

        int[] Ms = new int[sizeM];
        for (int i = 0; i < sizeM; i++) {
            Ms[i] = sc.nextInt();
        }

        // Ds 배열의 최소 공배수 구하기
        long lcm = Ds[0];
        for (int i = 1; i < Ds.length; i++) {
            lcm = getLCM(lcm, Ds[i]);
        }

        // Ms 배열의 최대 공약수 구하기
        long gcd = Ms[0];
        for (int i = 1; i < Ms.length; i++) {
            gcd = getGCD(gcd, Ms[i]);
        }

        // LCM이 GCD의 배수가 아니라면, 답은 0
        if (gcd % lcm != 0) {
            System.out.println(0);
            return;
        }

        // LCM과 GCD 사이의 배수 관계를 바로 계산
        //36 , 12
        long result = gcd / lcm;
        int count = 0;
        for (long i = 1; i * i <= result; i++) {
            if (result % i == 0) {
                count++; // i는 약수
                if (i != result / i) count++; // i와 result / i가 다르면 약수는 하나 더
            }
        }

        System.out.println(count);
    }

    // 두 숫자의 GCD 구하기 (유클리드 호제법)
    static long getGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 두 숫자의 LCM 구하기
    static long getLCM(long a, long b) {
        return (a * b) / getGCD(a, b);
    }
}