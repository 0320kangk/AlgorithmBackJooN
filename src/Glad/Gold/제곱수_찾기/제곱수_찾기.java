package Glad.Gold.제곱수_찾기;


import java.util.Scanner;

public class 제곱수_찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = -1;
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String num = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = num.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int ni = -9; ni < N; ni++) {
                    for (int mj = -9; mj < M; mj++) {
                        if ( ni == 0 && mj == 0)
                            continue;
                        int num = 0;
                        int nextI = i;
                        int nextJ = j;

                        while( (nextI >= 0 && nextI < N) &&
                                (nextJ >=0 && nextJ < M)){
                            num = num * 10 + arr[nextI][nextJ];
                            nextI += ni;
                            nextJ += mj;
                            if (Math.sqrt(num) == (int)Math.sqrt(num))
                                answer = Math.max(answer, num);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
