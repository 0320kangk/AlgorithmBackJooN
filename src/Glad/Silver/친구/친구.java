package Glad.Silver.친구;

import java.util.Scanner;

public class 친구 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] relation = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String next = sc.next();
            for (int j = 0; j < next.length(); j++) {
                if (next.charAt(j) == 'Y'){
                    relation[i][j+1] = 1;
                }else{
                    relation[i][j+1] = 50;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if( i == j || j == k || i == k)
                        continue;
                    if( relation[i][j] > relation[i][k] + relation[k][j] ){
                        relation[i][j] = relation[i][k] + relation[k][j];
                    }
                }
            }
        }
        int maxFriends = 0;
//        for (int i = 1; i <= N; i++) {
//            System.out.println( Arrays.toString(relation[i]));
//        }
        for (int i = 1; i <=N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if(relation[i][j] ==1 || relation[i][j] ==2)
                    count++;
            }
            maxFriends = Math.max(maxFriends, count);
        }
        System.out.println(maxFriends);
    }
}
