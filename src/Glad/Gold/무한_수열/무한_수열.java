package Glad.Gold.무한_수열;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 무한_수열 {
    public static Map<Long, Long> map = new HashMap<>();
    public static long N, P, Q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();
        System.out.println(findAn(N));
    }
    static long findAn(long n){
        if(n == 0) return 1;
        if(map.containsKey(n)) return map.get(n);
        map.put(n, findAn(n / P) + findAn(n / Q));

        Long An = map.get(n);
        return An;
    }
}
