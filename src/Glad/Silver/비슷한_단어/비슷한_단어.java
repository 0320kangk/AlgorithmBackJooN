package Glad.Silver.비슷한_단어;

import java.util.HashMap;
import java.util.Scanner;

public class 비슷한_단어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = mapping(sc.next());
        }
        System.out.println(bruteForce(words));

    }
    public static int bruteForce(String[] words) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if(words[i].equals(words[j])){
                    answer++;
                }
            }
        }
        return answer;
    }
    public static String mapping(String word) {
        HashMap<Character, Character> map = new HashMap<>();
        char value = 'a';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            if(!map.containsKey(key)){
                map.put(word.charAt(i), value++);
            }
            sb.append(map.get(key));
        }
        return sb.toString();
    }
}