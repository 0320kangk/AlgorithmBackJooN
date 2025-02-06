package Glad.Gold.최고의_팀_만들기;

import java.util.Scanner;

public class 최고의_팀_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        어떻게 풀기로 해지?
        일단 화이트 정렬
        그리고 모든값 다 넣어버리기
        블랙 도 정렬
        이제 블랙의 1위부터 비교
        만약 블랙 1위가 화이트가 갖고있는 값이라면

        화이트를 버리는게 이득인가 블랙을 버리는게 이득인가?
        while > black
        ex ) 1)white: 100 black : 101
            2)white: 99 black: 30
            balck> whilte 이므로
            black 픽

         */
        while(sc.hasNext()){
            String[] split = sc.nextLine().split(" ");
            if(split[0].equals("EOF"))  break;
            int white = Integer.parseInt(split[0]);
            int black = Integer.parseInt(split[1]);
        }

        //dp 라고?
        /*
        dp [] = value
        dp[흑][벡] = ?

        값이 머가 되야지?
        00 11 과 같이 행렬이 같으면 그냥 넘김

         */




    }
}
