package Glad.Gold.알고스팟;

import java.util.*;

public class 알고스팟 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] arr = new int[N][M];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String walls = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = walls.charAt(j) - '0';
            }
        }
        //가능한 모든 곳을 방문, 방문을 하며 벽으로 막혀있는 곳을 모두 찾기
        //그곳을 모두 0으로 만들기 위 반복
        List<Integer[]> list = new ArrayList<>();
        int count = 0;

        while (!bfs( arr, list)){
            count++;
            for (Integer[] wall : list) {
                arr[wall[0]][wall[1]] = 0;
            }
            list.clear();
        }
        System.out.println(count);
    }

    private static boolean bfs( int[][] arr, List<Integer[]> list) {
        LinkedList<Integer[]> q = new LinkedList<>();
        int M = arr[0].length;
        int N = arr.length;
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        q.add(new Integer[]{0, 0});
        boolean result = false;
        while(!q.isEmpty()){
            Integer[] point = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];
                if ( (x >= 0 && x < N)
                &&( y >= 0 && y < M)
                && !visited[x][y]){
                    if (arr[x][y] == 0){
                        visited[x][y] = true;
                        if (visited[N-1][M-1]) {
                            result =true;
                            break;
                        }
                        q.add(new Integer[]{x, y});
                    } else {
                        list.add(new Integer[]{x, y});
                    }
                }
            }
        }
        return result;
    }
}
