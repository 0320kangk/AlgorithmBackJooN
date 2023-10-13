package Glad.Silver.Z;

import java.util.Scanner;

public class Z {

    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        partition(r, c, (int)Math.pow(2,N));
        System.out.println(result);
    }
    public static void partition(int r, int c, int size) {

        if(size == 1)
            return;
        int partSize = size / 2;
        // 1,2,3,4 분면 탐색

        // 1사분면
        if ( r < partSize && c < partSize){
            partition(r,c,partSize);
        } else if (r < partSize && c >= partSize) {
            result += size * size / 4;
            partition(r,c-partSize,partSize);
        } else if (r >= partSize && c < partSize ){
            result += (size * size / 4) * 2;
            partition(r-partSize, c, partSize);
        } else if (r >= partSize && c >= partSize){
            result += (size * size / 4) * 3;
            partition(r-partSize, c-partSize, partSize);
        }

    }

}
