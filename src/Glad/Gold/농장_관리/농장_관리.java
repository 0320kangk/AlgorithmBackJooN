package Glad.Gold.농장_관리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 농장_관리 {
    static int[] dx = {1, 0, -1, 0, 1,1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1,-1, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String[] nums = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
            }
        }
        boolean[][] visited = new boolean[N][M];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if(!bfs(new int[] {i, j}, map, visited, N, M)){
//                        System.out.println(i + ":" +j);
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
    static boolean bfs(int[] point,int[][] map,boolean[][] visited ,int N, int M) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {point[0], point[1]} );
        boolean flag = false;
        while(!q.isEmpty()) {
            Integer[] xy = q.poll();
            for (int i = 0; i < 8; i++) {
                int x = xy[0] + dx[i];
                int y = xy[1] + dy[i];
                if( x < N  && x >= 0 &&
                  y < M && y >= 0 ) {
                    if (!visited[x][y] && map[x][y] == map[xy[0]][xy[1]]) {
                        visited[x][y] = true;
                        q.add(new Integer[]{x, y});
                    } else if (map[xy[0]][xy[1]] < map[x][y]) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
}
