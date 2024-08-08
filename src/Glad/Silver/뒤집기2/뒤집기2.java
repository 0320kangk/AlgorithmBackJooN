package Glad.Silver.뒤집기2;

import java.util.Scanner;

public class 뒤집기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String next = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = next.charAt(j) - '0';
            }
        }
        //가장 거리가 먼 1 부터 무한히 뒤집기
        int count = 0;
        while(true){
            int maxDist = 0;
            boolean visited = false;
            int[] targetPoint = new int[2];
            //가장 먼 동전 뒷면 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 1) {
                        visited = true;
                        int dist = (int) (Math.pow(i, 2) + Math.pow(j, 2));
                        if(maxDist <= dist) {
                            maxDist = dist;
                            targetPoint[0] = i;
                            targetPoint[1] = j;
                        }
                    }
                }
            }
            //모두가 0인지 검사
            if(!visited){
                break;
            } else {
                count++;
                //뒤집기
                for (int i = 0; i <= targetPoint[0]; i++) {
                    for (int j = 0; j <= targetPoint[1]; j++) {
                        if(arr[i][j] == 1) arr[i][j] = 0;
                        else arr[i][j] = 1;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
