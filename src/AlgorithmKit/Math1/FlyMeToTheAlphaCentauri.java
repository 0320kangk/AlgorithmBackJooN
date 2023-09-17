package AlgorithmKit.Math1;

import java.util.Scanner;

public class FlyMeToTheAlphaCentauri {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int distance = y - x; // 1. 이동해야할 거리
            int max = (int) Math.sqrt(distance); // 2. 한번에 이동할 수 있는 최대 이동 칸수
            int count = 0; // 몇번 가동했나

            for (int j = max; j > 0; j--) { // 최대 이동 칸수부터 1씩 줄이면서 검사
                int num = (distance - (j - 1) * j) / j; // 3. 1부터 j-1까지 다 2개씩 (최소한의 갯수만큼)있다면 남게될 값에다가 최댓값을 나눈것 (최댓값이 들어갈수있는 최대갯수)
                count += num; // 최댓값이 들어갈수 있는 최대개수만큼 count에 + 해주기
                distance -= j * num; // 이제 그만큼의 값을 빼고 다음 수 검사
            }

            System.out.println(count);
        }
    }

}