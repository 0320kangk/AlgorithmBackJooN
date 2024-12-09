package Glad.Gold.가지고_노는_1;

import java.util.LinkedList;
import java.util.Queue;
public class 가지고_노는_1 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int N = sc.nextInt();

        // Queue는 나머지와 자릿수를 저장
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1 % N, 1});

        // 나머지가 동일한 값을 다시 계산하지 않도록 하기 위한 배열
        boolean[] visited = new boolean[N];
        visited[1 % N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int remainder = current[0];
            int length = current[1];

            // 나머지가 0이면 그 자릿수 출력
            if (remainder == 0) {
                System.out.println(length);
                return;
            }

            // 1을 더한 수에 대해서 나머지를 계산
            int nextRemainder1 = (remainder * 10 + 1) % N;

            // 이미 방문한 나머지는 다시 방문하지 않음
            if (!visited[nextRemainder1]) {
                visited[nextRemainder1] = true;
                queue.offer(new int[] {nextRemainder1, length + 1});
            }
        }

        // 불가능한 경우
        System.out.println(-1);
    }
}
