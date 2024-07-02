package Glad.Silver.지름길;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 지름길 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[][] roads = new int[N][3];
        sc.nextLine();
        for (int i = 0; i < roads.length; i++) {
            String[] split = sc.nextLine().split(" ");
            roads[i][0] = Integer.parseInt(split[0]);
            roads[i][1] = Integer.parseInt(split[1]);
            roads[i][2] = Integer.parseInt(split[2]);
        }
        Queue<Integer[]> q = new LinkedList<>();
        boolean[] visited = new boolean[roads.length];
        q.add(new Integer[]{0, 0});//시작위치, 움직인 거리
        int min = D;
        while (!q.isEmpty()){
            for (Integer[] integers : q) {
                System.out.println(Arrays.toString(integers));
            }
            System.out.println(Arrays.toString(visited));
            Integer[] poll = q.poll();
            //add해야함 지름길 안타는 루트를
            //dfs로 하는게 맞네
            if (poll[0] == D && poll[1] < min) min = poll[1];
            if(poll[1] + D - poll[0] < min) min = poll[1] + D - poll[0];

            for (int i = 0; i < roads.length; i++) {
                if(!visited[i]
                        && poll[0] <= roads[i][0]
                        &&  roads[i][1] <= D ){
                    visited[i] = true;
                    //다음 위치, 움직인 총 거리
                    q.add(new Integer[]{roads[i][1], poll[1] + roads[i][2]});
                }
            }
        }
        System.out.println(min);
    }
    
}
