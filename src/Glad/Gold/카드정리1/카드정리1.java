package Glad.Gold.카드정리1;

import java.util.Arrays;
import java.util.Scanner;

public class 카드정리1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] boxColors = new int[N];
        int[][] boxes = new int[N][M];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String sCards = sc.nextLine();
            String[] split = sCards.split(" ");
            for (int j = 0; j < M; j++) {
                int colorCount = Integer.parseInt(split[j]);
                boxes[i][j] = colorCount;
                if(colorCount > 0)
                    boxColors[i]++;
            }
        }

        //모든 박스를 한번씩 조커카드라 가정
        //카드가 2종류 이상인 경우 이동 필수
        //카드가 1종류만 있는데 박스가 2개 이상이면 이동 필수
        int minMove = N-1;
        System.out.println(Arrays.toString(boxColors));
        for (int jokerBox = 0; jokerBox < N; jokerBox++) {
            boolean[] usedBox = new boolean [M];
            int move = 0;
            for (int i = 0; i < N; i++) {
                if(i == jokerBox) continue;
                if(boxColors[i] == 1){ //색 1개
                    int color = -1; //몇번 색깔인지 찾기
                    for (int j = 0; j < M; j++) {
                        if(boxes[i][j] > 0)
                            color = j;
                    }
                    //사용된 색깔인지 찾기, 처음이면 냅둬도 됨
                    if(!usedBox[color]){
                        usedBox[color] = true;
                    }else {
                        move++;
                    }
                }else if (boxColors[i] > 1 )
                    move++;
            }
            minMove = Math.min(move, minMove);
        }
        System.out.println(minMove);
    }
}
