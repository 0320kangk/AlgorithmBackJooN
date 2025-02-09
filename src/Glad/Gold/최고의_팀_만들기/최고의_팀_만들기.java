package Glad.Gold.최고의_팀_만들기;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.Scanner;

public class 최고의_팀_만들기 {
    static int[] white;
    static int[] black;
    static int[][][] dp;
    public static void main(String[] args) {
        white = new int[1001];
        black = new int[1001];
        dp =new int [1001][16][16];
        int index = 0;
        Scanner sc = new Scanner(System.in);
        /*
        분기점은 3개
        선택안함 or 화이트 or 블랙
        */
        while(sc.hasNext()){
            String[] split = sc.nextLine().split(" ");
            if(split[0].equals("EOF"))  break;
            white[index] = Integer.parseInt(split[0]);
            black[index] = Integer.parseInt(split[1]);
            index++;
        }
        //dp 라고?
        /*
        dp [] = value
        dp[흑][벡] = ?

        값이 머가 되야지?
        00 11 과 같이 행렬이 같으면 그냥 넘김

         */
        System.out.println(solution(0,0,0,index));


    }
    public static int solution(int i, int wIndex, int bIndex, int N) {
        // 블랙 or 화이트의 끝
        if (wIndex == 15 && bIndex == 15) return 0;
        // 끝
        if (i == N) return 0;
        // 중복 선택일 경우
        if (dp[i][wIndex][bIndex] != 0) return dp[i][wIndex][bIndex];
        // 선택 x
        int anw = solution(i + 1, wIndex, bIndex, N);
        // 화이트 선택
        if (wIndex < 15) anw = Math.max(anw, solution(i + 1, wIndex + 1, bIndex, N) + white[i]);
        // 블랙 선택
        if (bIndex < 15) anw = Math.max(anw, solution(i + 1, wIndex, bIndex + 1, N) + black[i]);
        dp[i][wIndex][bIndex] = anw;
        return dp[i][wIndex][bIndex];
    }

  /*  public static int solution(int i, int wIndex, int bIndex, int N){
        if(wIndex == 15 && bIndex == 15) return 0;
        if(i == N) return 0;
        //이미 선택을 한 경우
        if(dp[i][wIndex][bIndex] != 0) return dp[i][wIndex][bIndex];

        //선택을 안한 경우
        int ans = solution(i + 1, wIndex, bIndex, N);
        //화이트 선택
        if(wIndex < 15) ans = Math.max(ans, solution(i + 1, wIndex + 1, bIndex, N)+white[i]);
        //블랙 선택
        if(bIndex < 15) ans = Math.max(ans, solution(i + 1, wIndex, bIndex + 1, N)+black[i]);
        dp[i][wIndex][bIndex] = ans;
        return dp[i][wIndex][bIndex];
    }*/
}
