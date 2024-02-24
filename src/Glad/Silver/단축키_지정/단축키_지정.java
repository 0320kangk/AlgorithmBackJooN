package Glad.Silver.단축키_지정;

import java.util.*;

public class 단축키_지정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashSet<Character> alphaSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String[] splitWords = sc.nextLine().split(" ");
            boolean flag = false;
            for (int j = 0; j < splitWords.length ;j++) {
                String splitWord = splitWords[j];
                char c = splitWord.charAt(0);
                if(!alphaSet.contains(c)){
                    alphaSet.add(Character.toLowerCase(c));
                    alphaSet.add(Character.toUpperCase(c));
                    splitWords[j] = splitWord.replaceFirst(String.valueOf(c), "[" + c + "]");
                    flag = true;
                    break;
                }
            }
            if (flag){
                addWord(splitWords, sb);
                continue;
            }
            for (int j = 0; j < splitWords.length; j++) {
                String splitWord = splitWords[j];
                for (int k = 0; k < splitWord.length(); k++) {
                    char c = splitWord.charAt(k);
                    if(!alphaSet.contains(splitWord.charAt(k))){
                        alphaSet.add(Character.toLowerCase(c));
                        alphaSet.add(Character.toUpperCase(c));
                        splitWords[j] = splitWord.replaceFirst(String.valueOf(c), "[" + c + "]");
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            addWord(splitWords, sb);
        }
        System.out.println(sb);
    }

    private static void addWord(String[] splitWords, StringBuilder sb) {
        for (String splitWord : splitWords) {
            sb.append(splitWord).append(" ");
        }
        sb.append("\n");
    }
}
