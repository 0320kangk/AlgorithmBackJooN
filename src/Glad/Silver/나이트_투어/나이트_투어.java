package Glad.Silver.나이트_투어;

import java.util.Scanner;

public class 나이트_투어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] board = new boolean[6][6];
        String[] prePoint = sc.next().split("");
        String[] startPoint = prePoint;
        String answer = "Valid";
        for (int i = 0; i < 35; i++) {
            String[] nextPoint = sc.next().split("");
            if(!check(prePoint, nextPoint, board)){
                answer="Invalid";
            }
            prePoint = nextPoint;
        }
        if(!check(prePoint,startPoint, board)) {
            answer = "Invalid";
        }
        System.out.println(answer);
    }

    private static boolean check(String[] prePoint, String[] nextPoint, boolean[][] board) {
        int x1 = prePoint[0].charAt(0) - 'A';
        int y1 = Math.abs(6 - Integer.parseInt(prePoint[1]));

        int x2 = nextPoint[0].charAt(0) - 'A';
        int y2 = Math.abs(6 - Integer.parseInt(nextPoint[1]));
        if(5 == (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))){
            if (!board[y2][x2]){
                board[y2][x2] = true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
