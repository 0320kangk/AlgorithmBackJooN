package Glad.Silver.정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt( bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            long[][] points = new long[4][2];
            for (int j = 0; j < 4; j++) {
                String[] split = bf.readLine().split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                points[j][0] = x;
                points[j][1] = y;
            }
            long[] squareLines = new long[6];
            int squareIdx = 0;
            for (int j = 0; j < 4; j++) {
                for (int k = j+1; k < 4; k++) {
                    squareLines[squareIdx++] = findLineLength(points[j], points[k]);
                }
            }
            Arrays.sort(squareLines);
            if(squareLines[0]== squareLines[1] &&
                    squareLines[2]== squareLines[3] &&
                    squareLines[0]== squareLines[2] &&
                    squareLines[4]== squareLines[5]
            ){
                sb.append(1).append("\n");
            }
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
    static long findLineLength(long[] point1, long[] point2) {
        return (long)(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
    }
}
