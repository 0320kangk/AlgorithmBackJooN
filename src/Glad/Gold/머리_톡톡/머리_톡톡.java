package Glad.Gold.머리_톡톡;

import java.util.HashMap;
import java.util.Scanner;

public class 머리_톡톡 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stds = new int[N];
        for (int i = 0; i < N; i++) {
            stds[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(stds[i],  map.getOrDefault(stds[i], 0) + 1);
        }
        for (int i = 0; i < N; i++) {
            int sqrt = (int)Math.sqrt(stds[i]);
            int count = 0;
            for (int j = 1; j <= sqrt; j++) {
                if (stds[i] % j == 0 ){
                    count += map.getOrDefault(j, 0) + map.getOrDefault(stds[i] / j , 0);
                }
            }
            if (map.containsKey(sqrt) && sqrt * sqrt == stds[i]) count -= map.get(sqrt);
            count--;
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
