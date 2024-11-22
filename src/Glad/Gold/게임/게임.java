package Glad.Gold.게임;

import java.util.*;

public class 게임 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,-1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[501][501];
        sc.nextLine();
        checkArea(N, sc, map, true);
        int M = sc.nextInt();
        sc.nextLine();
        checkArea(M, sc, map, false);

        //다익스트라, 이것은 bfs 에 pq + dp 배열 (최소 거리)
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((i1, i2) -> i1[2] - i2[2]);
        Integer[][] minDists = new Integer[501][501];
        for (Integer[] minDist : minDists) Arrays.fill(minDist, 500 * 500);
        int dist = -1;
        minDists[0][0] = 0;
        pq.add(new Integer[]{0,0,0});
        while(!pq.isEmpty()) {
            Integer[] poll = pq.poll();
            if (poll[0] == 500 && poll[1] == 500) {
                dist = poll[2];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];
                if( nextX >= 0 && nextX <= 500 &&
                        nextY >=0 && nextY <= 500 &&
                        map[nextY][nextX] != 2
                ) {
                    int newLife = poll[2] + (map[nextY][nextX] == 1 ? 1 : 0);
                    if( newLife < minDists[nextY][nextX]) {
                        minDists[nextY][nextX] = newLife;
                        pq.add(new Integer[]{nextX, nextY, newLife});
                    }
                }
            }
        }

        System.out.println(dist);
    }

    private static void checkArea(int N, Scanner sc, int[][] map, boolean flag) {
        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            int tempX1 = Integer.parseInt(split[0]);
            int tempY1 = Integer.parseInt(split[1]);
            int tempX2 = Integer.parseInt(split[2]);
            int tempY2 = Integer.parseInt(split[3]);

            int x1 = Math.min(tempX1, tempX2);
            int x2 = Math.max(tempX1, tempX2);
            int y1 = Math.min(tempY1, tempY2);
            int y2 = Math.max(tempY1, tempY2);

            for (int j = y1; j <= y2; j++) {
                for (int k = x1; k <= x2; k++) {
                    if(flag) map[j][k] = 1;
                    else map[j][k] = 2;
                }
            }

        }
    }
}
