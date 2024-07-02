package Glad.Silver.지름길;

import java.util.Scanner;

public class 지름길 {
    static int[][] roads;
    static int N;
    static int D;
    static int min = 10000;
    static   boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         N = sc.nextInt();
        D = sc.nextInt();
        roads = new int[N][3];
        sc.nextLine();
       for (int i = 0; i < roads.length; i++) {
            String[] split = sc.nextLine().split(" ");
            roads[i][0] = Integer.parseInt(split[0]);
            roads[i][1] = Integer.parseInt(split[1]);
            roads[i][2] = Integer.parseInt(split[2]);
        }
        visited = new boolean[N];
       dfs(0,0);
        System.out.println(min);
    }
    static void dfs(int location, int dist) {
        //끝나는곳
        if (location == D) {
            if (dist < min) min = dist;
            return;
        }
        if(D - location + dist  < min) min = D - location + dist;
        for (int i = 0; i < roads.length; i++) {
            if(location <= roads[i][0] && roads[i][1] <= D){
                visited[i] = true;
                dfs(roads[i][1], roads[i][0] - location + dist + roads[i][2]);
                visited[i] = false;
            }
        }
        //다음 길 찾는 곳

    }
}
