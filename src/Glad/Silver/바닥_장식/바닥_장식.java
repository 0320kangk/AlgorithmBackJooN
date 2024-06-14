package Glad.Silver.바닥_장식;

import java.util.Scanner;

public class 바닥_장식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] room = new String[N];
        for (int i = 0; i < N; i++) {
            room[i] = sc.nextLine();
        }
        int totalWall = 0;
        // 세로 검사
        for (int i = 0; i < M; i++) {
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if(room[j].charAt(i) == '|' ){
                    flag = true;
                } else {
                    if(flag) totalWall++;
                    flag = false;
                }
            }
            if( flag) totalWall++;
        }
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            for (int j = 0; j < M; j++) {
                if(room[i].charAt(j) == '-' ){
                    flag = true;
                } else {
                    if(flag) totalWall++;
                    flag = false;
                }
            }
            if( flag) totalWall++;
        }

        System.out.println(totalWall);
    }
}
