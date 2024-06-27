package Glad.Gold.공격;

import java.util.*;

public class 공격 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        int D = sc.nextInt();
        int[] enemyPoint = new int[2];
        enemyPoint[0] =  sc.nextInt();
        enemyPoint[1] = sc.nextInt();
        sc.nextLine();
        int[][] point = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            point[i][0] = Integer.parseInt(split[0]);
            point[i][1] = Integer.parseInt(split[1]);
        }
        int rPow = (int)Math.pow(R, 2);
        double totalEnergy= 0;
        for (int i = 0 ; i < N ; i++) {
            Queue<Tower> q = new LinkedList<>();
            q.add(new Tower(i, D));
            boolean[] visited = new boolean[N];
            visited[i] = true;
            while(!q.isEmpty()){
                Tower poll = q.poll();
                if(getDist(point[poll.index], enemyPoint ) <= rPow){
                    totalEnergy += poll.energy;
                    break;
                }
                System.out.println(1);
                for (int j = 0; j < visited.length; j++) {
                    if(!visited[j] && getDist(point[poll.index], point[j]) <= rPow){
                        visited[j] = true;
                        q.add(new Tower(j, poll.energy / 2.0));
                    }
                }
            }
        }
        System.out.println(totalEnergy);
    }
    public static class Tower {
        int index;
        double energy;

        public Tower(int index, double energy) {
            this.index = index;
            this.energy = energy;
        }
    }
    private static int getDist(int[] enemyPoint, int[] point) {
        return (int) (Math.pow(point[0] - enemyPoint[0], 2) + Math.pow(point[1] - enemyPoint[1], 2));
    }
}
