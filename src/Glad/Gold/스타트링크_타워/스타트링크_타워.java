package Glad.Gold.스타트링크_타워;

import java.util.Arrays;
import java.util.Scanner;

public class 스타트링크_타워 {
    static boolean[][][] nums;
    static boolean[][] impossibleNums;
    static int N;
    public static void main(String[] args) {
        /*
        1. 3차원 배열 정의 arr[N][3][3] 정의
        -> 각 숫자에 맞는 '#', '.' 넣기
        2. impossible 배열 정의?
        각 숫자들은 특정 공간에 '#'이 있다면 만들 수 없는 불가능한 숫자들이 있다.
        그것을 찾자
         */
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new boolean[N][5][3];
        //5줄의 입력을 받음
        //1줄 받을 때 마다 한번에 다 처리해야 함
        for (int i = 0; i < 5; i++) {
            //bulbs를 N개의 배열에 쪼개서 넣어야함, 4N-1
            String line = sc.next();
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < 3; j++) {//첫 째항은 3 공차는 4, + (n-1)4
                    if (line.charAt(4*k+j) == '#')
                        nums[k][i][j] = true;
                }
            }
        }
    /*    for (int k = 0; k < N; k++) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Arrays.toString(nums[k][i]));
            }
        }*/
        impossibleNums = new boolean[N][10];
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    if (nums[k][i][j])
                        findNums(k, i, j);
                }
            }
        }
        //가능한 모든 수의 총 합의 평균을 구해야 함
        //개수 구하기 평균을 구하기 위해
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(impossibleNums[i]));
        }
        System.out.println(findAverage());

    }
    static void findNums(int k, int i, int j){
        //0행
        if ( i == 0){
            if (j == 0){
                impossibleNums[k][1] = true;
            } if (j == 1){
                impossibleNums[k][1] = true;
                impossibleNums[k][4] = true;
            }
        } else if ( i == 1){
            if( j == 0){
                impossibleNums[k][1] = true;
                impossibleNums[k][2] = true;
                impossibleNums[k][3] = true;
                impossibleNums[k][7] = true;
            } if ( j == 1){//모든 숫자가 불가능한 경우
                System.out.println(-1);
                System.exit(0);
            } if ( j == 2) {
                impossibleNums[k][5] = true;
                impossibleNums[k][6] = true;
            }
        } else if ( i == 2){
            if( j == 0) {
                impossibleNums[k][1] = true;
                impossibleNums[k][7] = true;

            } if ( j == 1) {
                impossibleNums[k][0] = true;
                impossibleNums[k][1] = true;
                impossibleNums[k][7] = true;
            }
            //2행 2열은 모든 숫자 필수
        } else if (i == 3){
            if ( j == 0) {
                impossibleNums[k][1] = true;
                impossibleNums[k][3] = true;
                impossibleNums[k][4] = true;
                impossibleNums[k][5] = true;
                impossibleNums[k][7] = true;
                impossibleNums[k][9] = true;
            } if(j == 1) {
                System.out.println(-1);
                System.exit(0);;
            } if(j == 2) {
                impossibleNums[k][2] = true;
            }
        } else if ( i == 4) {
            if(j == 0) {
                impossibleNums[k][1] = true;
                impossibleNums[k][4] = true;
                impossibleNums[k][7] = true;
            }
            if(j == 1) {
                impossibleNums[k][1] = true;
                impossibleNums[k][4] = true;
                impossibleNums[k][7] = true;
            }
            //j ==2 는 모든경우 필수
        }
    }
    static double findAverage() {
        double totalCount = 1;
        for (int i = 0; i < N; i++) {
            int nCount = 0;
            for (int j = 0; j < 10; j++) {
                if (!impossibleNums[i][j])
                    nCount++;
            }
            totalCount *= nCount;
        }
        int multi = 1;
        for (int i = 1; i < N; i++) {
            multi *= 10;
        }
        //가능한 총 합 구하기
        double sum = 0;

        for (int i = 0; i < N; i++) {
            int nCount = 0;
            double nSum = 0;
            for (int j = 0; j < 10; j++) {
                if (!impossibleNums[i][j]){
                    nCount++;
                    nSum += j * multi;
                }
            }
            sum += nSum * (totalCount / nCount);
            multi /= 10;
        }
        return sum  / totalCount;
    }

}
