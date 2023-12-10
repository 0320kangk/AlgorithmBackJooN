package Glad.Silver.컴백홈;

import java.util.*;

public class 컴백홈 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1 , 0, 1};
    static boolean[][] visited;
    static String[] map;
    static int K;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        K = sc.nextInt();

        map = new String[R];
        for (int i = 0; i < R; i++) {
            map[i] = sc.next();
        }
        visited = new boolean[R][C];
        //BFS로 풀기
        int[] startPoint = new int[]{R-1,0};
        visited[startPoint[0]][startPoint[1]] = true;
        dfs(startPoint, 1);
        System.out.println(count);
    }
    static void dfs(int[] point, int length) {
        int row = map.length;
        int col = map[0].length();
        if (length == K &&
                point[0] == 0 &&
                point[1] == col - 1) {
            count++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[] move = {point[0] + dx[i], point[1] + dy[i]};
            if ((move[0] >= 0&& move[0] < row) &&
                    (move[1] >= 0 && move[1] < col) &&
                length <= K &&
                    map[move[0]].charAt(move[1]) != 'T' &&
                    !visited[move[0]][move[1]]) {
                visited[move[0]][move[1]] = true;
                dfs(move, length + 1);
                visited[move[0]][move[1]] = false;
            }
        }
    }

}
