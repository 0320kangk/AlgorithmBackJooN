package Glad.Silver.폴짝폴짝;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 폴짝폴짝 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ladders = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            ladders[i] = sc.nextInt();
        }
        int A = sc.nextInt();
        int B = sc.nextInt();
        if (A == B) System.out.println(0);
        else{
            System.out.println(bfs(ladders,A, B));
        }

    }
    static int bfs(int[] ladders, int A, int B) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{A, 1});
        boolean[] visited = new boolean[ladders.length];
        visited[A] = true;
        while (!q.isEmpty()){
            Integer[] point = q.poll();
            int start = point[0] % ladders[point[0]];
            if (start == 0) start = ladders[point[0]];
            for (int i = start; i < ladders.length; i+=ladders[point[0]]) {
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new Integer[]{i, point[1] + 1});
                    if (i == B) {
                        return point[1];
                    }
                }
            }
        }
        return -1;
    }
}
