package Glad.Gold.발전소_설치;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 발전소_설치 {

    private static final int INF = 2000001;
    static Point[] points;
    static List<List<Integer>> lines = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] NW = sc.nextLine().split(" ");
        int N = Integer.parseInt(NW[0]);
        int W = Integer.parseInt(NW[1]);
        double dist = sc.nextDouble();
       lines = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            lines.add(new ArrayList<>());
        }
        sc.nextLine();
        points = new Point[N + 1];
        for (int i = 1; i < N + 1; i++) {
            String[] xy = sc.nextLine().split(" ");
            points[i] = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
        }
        for (int i = 0; i < W; i++) {
            String[] xy = sc.nextLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            lines.get(x).add(y);
            lines.get(y).add(x);
        }
        //다익스트라
        double[] distances = new double[N + 1];
        for (int i = 0; i < N + 1; i++) {
            distances[i] = INF;
        }
        distances[1] = 0;
        List<Integer> nodes = lines.get(1);
        for (Integer node : nodes) {
            distances[node] = 0;
        }

        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            double minDist = INF;
            int node = 0;

            //현재 가장 짧은 거리 찾기
            for (int j = 1; j < N + 1; j++) {
                if (!visited[j] && minDist >= distances[j]){
                    minDist = distances[j];
                    node = j;
                    System.out.println(node);
                }
            }
            if (node == N)break;
            visited[node] = true;
            for(int next = 1; next < N +1; next++) {
                if ( next == node) continue;
                double v = distances[node] + getDistance(node, next);
                if ( distances[next] > v ){
                    distances[next] = v;
                }
            }
        }
        System.out.println( (long) (distances[N] * 1000));

    }
    private static double getDistance(int node, int next) {
        if(lines.get(node).contains(next)) return 0;
        Point start = points[node];
        Point dest = points[next];
        double dist = Math.pow(start.x - dest.x,2) + Math.pow(start.y - dest.y, 2);
        return Math.sqrt(dist);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
