package Glad.Silver.베스트셀러;


import java.util.*;
import java.util.stream.Collectors;

public class 베스트셀러 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String next = sc.next();
            map.put(next, map.getOrDefault(next, 0) + 1);
        }
        //1번째 풀이
    /*  String title = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
            if (entry.getValue() > max){
                title = entry.getKey();
                max = entry.getValue();
            }
        }*/
        //stream을 이용한 풀이
        List<Map.Entry<String, Integer>> list = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(list.get(0).getKey());

    }
}
