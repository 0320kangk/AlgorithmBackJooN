package Glad.Gold._2로_몇_번_나누어질까;


import java.util.Scanner;

public class _2로_몇_번_나누어질까 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long answer = findOneToXBinarySum(B) - findOneToXBinarySum(A-1);
        System.out.println(answer);
    }
    public static long findOneToXBinarySum(long x){
        long sum = x;
        for (long i = 2; i <= x; i<<=1) {
            sum += (x / i) * (i>>1);
        }
        return sum;
    }
}
