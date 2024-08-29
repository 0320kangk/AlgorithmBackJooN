package Glad.Gold.영어_읽기;

import java.util.*;

public class 영어_읽기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];
        sc.nextLine();
        List<Map<Character, Integer>> maps = new ArrayList<Map<Character, Integer>>();
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 1; j < words[i].length() - 1; j++) {
                map.put(words[i].charAt(j), map.getOrDefault(words[i].charAt(j), 0) + 1);
            }
            maps.add(map);
        }
        int M = sc.nextInt();
        String[] sentences = new String[M];
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            sentences[i] = sc.nextLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int total = 1;
            List<Map<Character, Integer>> sentenceMaps = new ArrayList<Map<Character, Integer>>();
            String[] split = sentences[i].split(" ");
            for (int j = 0; j < split.length; j++) {
                Map<Character, Integer> map = new HashMap<>();
                for (int k = 1; k < split[j].length() - 1; k++) {
                    map.put(split[j].charAt(k), map.getOrDefault(split[j].charAt(k), 0) + 1);
                }
                sentenceMaps.add(map);
            }
            for (int j = 0; j < sentenceMaps.size(); j++) {
                int count =0;
                Map<Character, Integer> map = sentenceMaps.get(j);
                for (int k = 0; k < N; k++) {
                    if( words[k].charAt(0) == split[j].charAt(0)  &&
                            words[k].charAt(words[k].length() - 1)  == split[j].charAt(split[j].length() - 1) &&
                            words[k].length() == split[j].length()){
                        if(map.equals(maps.get(k)) ) {
                            count++;
                        }
                    }
                }
                total *= count;
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}
