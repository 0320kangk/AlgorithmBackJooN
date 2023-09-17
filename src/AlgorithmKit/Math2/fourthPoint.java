package AlgorithmKit.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fourthPoint {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arrX = new int[1001];
        int[] arrY = new int[1001];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrX[Integer.parseInt(st.nextToken())]++;
            arrY[Integer.parseInt(st.nextToken())]++;

        }
        for (int i = 0; i < 1001; i++) {

            if (arrX[i] == 1) {
                sb.append(i + " ");
            }

        }

        for (int i = 0; i < 1001; i++) {

            if (arrY[i] == 1) {
                sb.append(i);
            }

        }
        System.out.println(sb);


    }


}
