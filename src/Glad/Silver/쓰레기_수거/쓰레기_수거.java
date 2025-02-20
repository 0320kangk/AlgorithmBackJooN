package Glad.Silver.쓰레기_수거;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 쓰레기_수거 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while(T > 0 ){
            int answer = 0;
            String[] wn = sc.nextLine().split(" ");
            int w = Integer.parseInt(wn[0]);
            int n = Integer.parseInt(wn[1]);
//            int[][] trashArea = new int[n][2];
            Queue <Integer[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String[] xw = sc.nextLine().split(" ");
                q.add(new Integer[]{Integer.parseInt(xw[0]) , Integer.parseInt(xw[1])});
            }
            int currentWeight = 0;
            int totalDist = 0;
            while(!q.isEmpty()){
                Integer[] peek = q.peek();
                if(peek[1] + currentWeight <= w ){
                    Integer[] poll = q.poll();
                    currentWeight += poll[1];
                    if( currentWeight == w || q.isEmpty()){
                        totalDist += poll[0] * 2;
                        currentWeight = 0;
                    }

                } else {
                    totalDist += (peek[0]) * 2;
                    currentWeight = 0;
                }
            }
            //꽉차있는 경우 고려 + 해야함
            T--;
            answer = totalDist;
            System.out.println(answer);
        }
    }
}
