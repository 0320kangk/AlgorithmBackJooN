package Glad.Gold.도미노_찾기;

import java.util.Scanner;

public class 도미노_찾기 {
    static boolean[][] visited;
    static boolean[][] domino;
    static int answer = 0;
    static  String[] lines;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lines = new String[8];
        for (int i = 0; i < 8; i++) {
            lines[i] = sc.nextLine();
        }
        visited = new boolean[8][7];
        domino = new boolean[7][7];
        back(0,0);
        System.out.println(answer);

    }
    static void back(int r, int c){
        if(r == 8){
            answer++;
            return;
        }
        if(c == 7){
            back(r + 1, 0);
            return;
        }

        if(!visited[r][c]){
            visited[r][c] = true;
            int cur = lines[r].charAt(c) - '0';

            for (int i = 0; i < 2; i++) {
                if(i==0){
                    int nextR = r + 1;
                    int nextC = c;

                    if(nextR >= 8 || nextC >= 7){
                        continue;
                    }
                    int pair = lines[nextR].charAt(nextC) - '0';

                    if(visited[nextR][nextC]){
                        continue;
                    }
                    if(domino[cur][pair]) {
                        continue;
                    }
                    visited[nextR][nextC] = true;
                    domino[cur][pair] = true;
                    domino[pair][cur] = true;
                    back(r, c + 1);
                    visited[nextR][nextC] = false;
                    domino[cur][pair] = false;
                    domino[pair][cur] = false;
                }
                if( i == 1){
                    int nextR = r;
                    int nextC = c + 1;

                    if(nextR >= 8 || nextC >= 7){
                        continue;
                    }
                    int pair = lines[nextR].charAt(nextC) - '0';

                    if(visited[nextR][nextC]){
                        continue;
                    }
                    if(domino[cur][pair]) {
                        continue;
                    }
                    visited[nextR][nextC] = true;
                    domino[cur][pair] = true;
                    domino[pair][cur] = true;
                    back(nextR, nextC);
                    visited[nextR][nextC] = false;
                    domino[cur][pair] = false;
                    domino[pair][cur] = false;
                }
            }
            visited[r][c] = false;
        } else {
            back(r, c+ 1);
        }
    }
}
