package Glad.Silver.나선;

import java.util.Scanner;
public class 나선 {
    //오른쪽으로 돌기
    static boolean[][] visited;
    static int[][ ] directions = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        visited = new boolean[N][M];
        int[] point = {0, 0};
        visited[0][0] = true;
        int directionIdx = 0;
        while(findNext(point)){
            while(true){
                int nextRow = point[0] + directions[directionIdx][0];
                int nextCol = point[1] + directions[directionIdx][1];
                if ((nextRow < N && nextRow >= 0 &&
                            nextCol >= 0 && nextCol < M &&
                            !visited[nextRow][nextCol])) {
                    point[0] = nextRow;
                    point[1] = nextCol;
                    visited[point[0]][point[1]] = true;
                } else {
                    break;
                }

            }
            directionIdx++;
            directionIdx = directionIdx % 4;
        }
        System.out.println(point[1] + " " + point[0]);
    }
    static boolean findNext (int[] point){
        if (  ( point[0] + 1 < N && !visited[point[0] + 1][point[1]] )  ||
                ( point[0] - 1 >= 0 && !visited[point[0] - 1][point[1]])  ||
        ( point[1] + 1 < M && !visited[point[0]][point[1] + 1]) ||
        (point[1] - 1 >= 0 && !visited[point[0]][point[1]- 1]))
            return true;
        else return false;
    }
}
