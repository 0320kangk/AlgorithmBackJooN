package Glad.Gold.단어_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, HashMap<Character, Integer>> wordsMap = new HashMap<>();
        while(true){
            String word = br.readLine();
            if (word.equals("-"))
                break;
            HashMap<Character, Integer> charMap = new HashMap<>();
            wordsMap.put(word, charMap);
            for (int i = 0; i < word.length(); i++) {
                charMap.put(word.charAt(i), charMap.getOrDefault(word.charAt(i), 0) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(true){
            String puzzle = br.readLine();
            int[] charCount = new int[26];
            int min = wordsMap.size();
            int max = 0;
            if (puzzle.equals("#"))
                break;
            HashMap<Character, Integer> puzzleMap = new HashMap<>();
            for (int i = 0; i < puzzle.length(); i++) {
                puzzleMap.put(puzzle.charAt(i), puzzleMap.getOrDefault(puzzle.charAt(i),0) + 1);
            }
            for (String word : wordsMap.keySet()) {
                HashMap<Character, Integer> charMap = wordsMap.get(word);
                boolean flag = false;
                for (int k = 0; k < word.length(); k++) {
                    char c = word.charAt(k);
                    if(!(puzzleMap.containsKey(c) && puzzleMap.get(c) >= charMap.get(c))){
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    for (int i = 0; i < 26; i++) {
                        if(charMap.containsKey((char)(i + 'A'))) charCount[i]++;
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if (!puzzleMap.containsKey((char)(i + 'A'))) continue;
                if (min > charCount[i]) min = charCount[i];
                if (max < charCount[i]) max = charCount[i];
            }
            StringBuilder minSb = new StringBuilder();
            StringBuilder maxSb = new StringBuilder();
            for (int i = 0; i < charCount.length; i++) {
                if ( puzzleMap.containsKey((char)('A' + i )) && charCount[i] == min) minSb.append( (char)('A' + i ));
                if ( puzzleMap.containsKey((char)('A' + i )) &&  charCount[i] >= max) maxSb.append((char)('A' + i ));


            }
            minSb.append(' ').append(min).append(' ');
            maxSb.append(' ').append(max).append(' ').append('\n');
            sb.append(minSb).append(maxSb);
        }
        System.out.println(sb);
    }

}
