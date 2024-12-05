package Glad.Gold.민식어;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 민식어 {

    static String[] minSikAlphabet = {"a", "b", "k", "d", "e", "g", "h", "i", "l", "m", "n", "ng", "o", "p", "r", "s", "t", "u", "w", "y"};
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < minSikAlphabet.length; i++) {
            map.put(minSikAlphabet[i], i);
        }
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] =  sc.nextLine();
        }
        Arrays.sort(words, (word1, word2) -> minSikCompare(word1, word2, map));
        for (String word : words) {
            System.out.println(word);
        }
    }
    public static int minSikCompare(String word1, String word2, HashMap<String, Integer> map){
        int length1 = word1.length();
        int length2 = word2.length();
        int i = 0, j = 0;
        while( i < length1 && j < length2){
            String nextCharWord1 = getNextChar(word1, i);
            String nextCharWord2 = getNextChar(word2, j);

            if(!nextCharWord1.equals(nextCharWord2)){
                return map.get(nextCharWord1) - map.get(nextCharWord2);
            }
            //우선순위 뽑기
            i += nextCharWord1.length();
            j += nextCharWord2.length();
        }
        return length1 - length2;
    }
    public static String getNextChar(String word, int idx){
        if( idx + 1 < word.length() && word.substring(idx, idx + 2).equals("ng")){
            return "ng";
        }
        return String.valueOf(word.charAt(idx));
    }
}
