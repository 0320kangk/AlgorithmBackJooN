package Glad.Silver.등수_구하기;

import java.util.Scanner;

public class 등수_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 점수 리스트에 있는 점수 수
        int tesuScore = sc.nextInt();// 태수 점수
        int P = sc.nextInt();// 리스트에 올라갈 수 있는 개수
        int rank = 1;
        int[] scores = new int[N];
        if ( N > 0) {
            sc.nextLine();
            String allScore = sc.nextLine();
            String[] split = allScore.split(" ");
            for (int i = 0; i < split.length; i++) {
                scores[i] = Integer.parseInt(split[i]);
            }
            for (int i = 0; i < scores.length; i++) {
                if(scores[i] > tesuScore){
                    rank++;
                }
            }
            if ( scores.length == P && tesuScore <= scores[scores.length -1]) rank = -1;
        }
        System.out.println(rank);
    }
}
