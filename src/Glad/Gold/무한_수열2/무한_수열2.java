package Glad.Gold.무한_수열2;

import java.util.HashMap;
import java.util.Scanner;

public class 무한_수열2 {

    public static long X;
    public static long Y;
    public static long P;
    public static long Q;
    public static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();
        X = sc.nextLong();
        Y = sc.nextLong();
        System.out.println(findAn(n));
    }
    public static long findAn(long n){
        if(n <= 0) return 1;
        if(map.containsKey(n)) return map.get(n);

        map.put(n, findAn(n / P - X) + findAn(n / Q - Y));
        Long An = map.get(n);
        return An;
    }
}
