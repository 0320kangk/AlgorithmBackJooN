package Glad.Silver.전쟁_땅따먹기;

import java.util.HashMap;
import java.util.Scanner;

public class 전쟁_땅따먹기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            HashMap<Long, Integer> maps = new HashMap<>();
            String[] soldiers = sc.nextLine().split(" ");
            long total = Long.parseLong (soldiers[0]);
            for (int j = 1; j < soldiers.length; j++) {
                long num = Long.parseLong(soldiers[j]);
                int value = maps.getOrDefault(num, 0) + 1;
                maps.put(num, value);
            }
            long[] array = maps.keySet()
                    .stream()
                    .sorted( (key1, key2) -> maps.get(key2) - maps.get(key1))
                    .mapToLong( x-> x)
                    .toArray();
            if (maps.get (array[0]) <= total/ 2 ) sb.append("SYJKGW");
            else sb.append(array[0]);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
