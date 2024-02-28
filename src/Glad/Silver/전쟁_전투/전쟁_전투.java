package Glad.Silver.전쟁_전투;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 전쟁_전투 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static String[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //가로
        int M = sc.nextInt(); // 세로
        arr = new String[M];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.next();
        }
        int blue = 0;
        int white = 0;
        //bfs
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    int visitedCount = bfs(i, j, visited);
                    int power = (int) Math.pow(visitedCount, 2);
                    if(arr[i].charAt(j) == 'W'){
                        white += power;
                    } else {
                        blue += power;
                    }
                }
            }
        }
        System.out.println(white + " " + blue);

    }
    static int bfs(int x, int y, boolean[][] visited){
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{x ,y});
        char color = arr[x].charAt(y);
        visited[x][y] = true;
        int count = 1;
        while (!q.isEmpty()){
            Integer[] point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = point[0] + dx[i];
                int nY = point[1] + dy[i];
                if ((nX >= 0 && nX < arr.length) &&
                        (nY >= 0 && nY < arr[0].length()) &&
                        (!visited[nX][nY])){
//                    System.out.println(color + ":" +  arr[nX].charAt(nY));
                    if (color == arr[nX].charAt(nY)) {
                        visited[nX][nY] = true;
                        q.add(new Integer[]{nX, nY});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
