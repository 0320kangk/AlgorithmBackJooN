package Glad.Gold.리모컨;

import java.util.*;
public class 리모컨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //리모컨으로 전체를 눌러 보기
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] brokenButton = new boolean[10];
        for (int i = 0; i < M; i++) {
            brokenButton[sc.nextInt()] = true;
        }
        //시작 번호는 100번
        int min = Math.abs(N - 100);//최소 움직임은, 위 아래 버튼을 눌러서 움직였을 때를 시작으로 가정
        for (int i = 0; i <= 999999; i++) {
            boolean flag = false;
            String ch = Integer.toString(i);
            for (int j = 0; j <ch.length(); j++) {
                if(brokenButton[ch.charAt(j) - '0'])
                    flag = true;
            }
            if(flag) continue;
            min = Math.min(min ,ch.length() + Math.abs(N-i));
        }
        System.out.println(min);
    }
}
