package Glad.Silver.기타콘서트;

import java.util.Scanner;

public class 기타콘서트 {
    static long maxMusic;
    static long[] guitarMusicData;
    static int N;
    static long min;
    public static void main(String[] args) {
        /*
        이진수로 표현하기?
         */
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        min = N;
        sc.nextLine();
        guitarMusicData = new long[N];
        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            long num = 0L;
            for (int j = 0; j < split[1].length(); j++) {
                if(split[1].charAt(j) == 'Y'){
                    num = num *2 + 1;
                } else {
                    num = num * 2;
                }
            }
            guitarMusicData[i] = num;
        }
        maxMusic = 0L;
        for (int i = 0; i < N; i++) {
          maxMusic =  maxMusic | guitarMusicData[i];
        }
        findWantGuitar(0, 0L, 0);
        if(maxMusic == 0 ) min = -1;
        System.out.println(min);
    }
    public static void findWantGuitar(int depth, long musics, int idx) {
        if(maxMusic == musics && min > depth){
            min = depth;
        }
        if (idx == N || depth >= min) {
            return;
        }

        for (int i = idx; i < guitarMusicData.length; i++) {
            if( (musics | (long) guitarMusicData[i]) > musics){
                findWantGuitar(depth + 1 , musics | guitarMusicData[i], i + 1);
            }
        }

    }

}
