package Glad.Gold.기타_코드;

import java.util.*;

public class 기타_코드 {

    //11 //13, => 2 + 1 = 3
    static String[] alphabets = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" };
    static String[] tunigLines;
    static String[] codes;
    static Map<String, Integer> map;

    static int answer = 12;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String line1 = sc.nextLine();
        tunigLines = line1.split(" ");
        String line2 = sc.nextLine();
        codes = line2.split(" ");
        map = new HashMap<>();
        int num = 1;
        Line[] lines = new Line[tunigLines.length];
        for (String alphabet : alphabets) {
            map.put(alphabet, num++);
        }
        findCode(lines, 0);
        System.out.println(answer);
    }
    static void findCode(Line[] lines ,int depth) {

        if (depth == tunigLines.length){
            Set<Integer> set = new HashSet<>();
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lines.length; i++) {
                if(lines[i].diff != 0){
                    max = Math.max(lines[i].diff, max);
                    min = Math.min(lines[i].diff, min);
                }
                set.add(lines[i].code);
            }
            if(set.size() == codes.length){
                if(min == Integer.MAX_VALUE) answer = 0;
                else if (max - min + 1 < answer) answer = max - min + 1;
            }


            return;
        }
        Integer tuning = map.get(tunigLines[depth]);
        for (int i = 0; i < codes.length; i++) {
            Integer code = map.get(codes[i]);
            int diff = code - tuning;
            if (diff < 0) diff += 12;
            lines[depth] = new Line(code, diff);
            findCode(lines,depth + 1);
            lines[depth].diff += 12;
            findCode(lines,depth + 1);

        }
    }
    static class Line{
        Integer code;
        int diff;

        public Line(Integer code, int diff) {
            this.code = code;
            this.diff = diff;
        }
    }
}


