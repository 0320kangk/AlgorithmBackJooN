package Glad.Gold.가르침;

import java.util.*;
public class 가르침 {
    static Character[] chars;
    static int K;
    static int max = 0;
    static List<HashSet<Character>> words;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt() - 5;
        words = new ArrayList<>();
        Set<Character> allChar = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            HashSet<Character> charSet = new HashSet<>();
            for (int j = 0; j < word.length(); j++) {
                if(word.charAt(j) !='a' &&
                        word.charAt(j) !='n' &&
                        word.charAt(j) !='t' &&
                        word.charAt(j) !='i' &&
                        word.charAt(j) !='c' )
                    charSet.add(word.charAt(j));
            }
            if(charSet.size() <= K){

                words.add(charSet);
                allChar.addAll(charSet);
            }
        }
        chars = allChar.toArray(new Character[0]);
        System.out.println(Arrays.toString(chars));
        if (chars.length > K && K > 0)
            findWords(0, K,new boolean[chars.length]);
        else if ( K < 0)
            max = 0;
        else
            max = words.size();
        System.out.println(max);
    }
    static void findWords(int start, int draw,boolean[] learn){
        if (draw == 0){
            int count = 0;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < learn.length; i++) {
                if(learn[i])
                    set.add(chars[i]);
            }

            for (int i = 0; i < words.size(); i++) {
                if(set.containsAll(words.get(i)))
                    count++;
            }
            max = Math.max(count, max);
            return;
        }
        for (int i = start; i < chars.length; i++) {
            learn[i] = true;
            findWords(i + 1, draw - 1, learn);
            learn[i] = false;
        }
    }
}
