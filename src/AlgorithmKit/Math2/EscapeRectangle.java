package Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EscapeRectangle {

    public static void main(String[] args) throws IOException {

        /*
            1. w-x, x-0
            2. h-y, y-0
            가장작은 수를 구하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int shortPath = x;

        int[] arr = {x, w - x, y, h - y};

        for (int i = 0; i < arr.length; i++) {

            if (shortPath > arr[i]) {
                shortPath = arr[i];
            }


        }


        System.out.println(shortPath);


    }
}
