package Glad.Silver.메시지;

import java.util.HashMap;
import java.util.Scanner;

public class 메시지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String badTalk = " was nasty about ";
        int count = 0;
        while (true) {
            count++;
            int people = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            sc.nextLine();
            if (people == 0) break;
            System.out.println("Group " + count);
            HashMap<Integer, String> map = new HashMap<>();
            String[][] papers = new String[people][people - 1];
            for (int i = 0; i < people; i++) {
                String[] split = sc.nextLine().split(" ");
                papers[i] = split;
                map.put(i, split[0]);
            }
            for (int i = 0; i < papers.length; i++) {
                String[] paper = papers[i];
                for (int j = 1; j < paper.length; j++) {
                    if (paper[j].equals("N")) {
                        int x = people - j;
                        //3-1
                        //2
                        if (i + x >= people){
                            x = (i + x) % people;
                        }else {
                            x = i + x;
                        }
                        sb.append(map.get(x)).append(badTalk).append(map.get(i)).append("\n");
                    }
                }
            }
            if(sb.length() == 0) System.out.println(sb.append("Nobody was nasty").append("\n"));
            else  System.out.println(sb);
        }
    }
}

