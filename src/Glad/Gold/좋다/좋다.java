package Glad.Gold.좋다;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 좋다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        sc.nextLine();
        String[] split = sc.nextLine().split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(split[i]);
            arr[i] = num;
            map.put( num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if( arr[i] == 0 && arr[j] != 0 && map.get(arr[j]) < 2) {
                    continue;
                } if (arr[j] == 0 && arr[i] != 0 && map.get(arr[i]) < 2) {
                    continue;
                } if (arr[i] == 0 && arr[j] == 0 && map.get(arr[i]) < 3){
                    continue;
                }

                set.add(arr[i] + arr[j]);
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) count++;
        }
        System.out.println(count);
    }
}
