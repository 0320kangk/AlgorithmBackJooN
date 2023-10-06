package Glad.Silver.체스판_다시_칠하기;

import Glad.Silver.기타줄.기타줄;

import java.util.Scanner;

public class 체스판_다시_칠하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] board = new int[row][col];
        for (int i = 0; i < row; i++) {
            String rowColor = sc.next();
            for (int j = 0; j < col; j++) {
                if (rowColor.charAt(j) == 'W') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < col - 7; j++) {
                minCount = Math.min(minCount, checkColor(i, j, 0, board));
                minCount = Math.min(minCount, checkColor(i, j, 1, board));
            }
        }
        System.out.println(minCount);
    }
    static int checkColor(int row, int col, int startColor, int[][] board){
        int count = 0;
        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if(board[i][j] != startColor){
                    count++;
                }
                if (j + 1 != col + 8)
                    startColor = startColor == 0 ?  1 : 0;
            }
        }
        return count;
    }
}
