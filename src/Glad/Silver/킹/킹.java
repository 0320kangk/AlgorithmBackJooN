package Glad.Silver.킹;

import java.util.Arrays;
import java.util.Scanner;

public class 킹 {
    public static void main(String[] args) {

        /*
        왕을 움직인다.
        만약 왕과 돌의 좌표가 같다면
        둘다 같이 움직인다.
        멤 밖으로 나가는 움직임은 그냥 넘긴다.
         */
        Scanner sc = new Scanner(System.in);
        String king = sc.next();
        int[] kingPoint = {king.charAt(0) - 'A' + 1, king.charAt(1)-'0'};
        String rock = sc.next();
        int[] rockPoint = {rock.charAt(0) - 'A' + 1, rock.charAt(1) - '0'};
        int move = sc.nextInt();
        String[] moves = new String[move];
        for (int i = 0; i < move; i++) {
            moves[i] = sc.next();
        }
        for (int i = 0; i < moves.length; i++) {
                int[] moveKing = move(kingPoint, moves[i].length(), moves[i]);
                int[] copyRock = Arrays.copyOf(rockPoint, rockPoint.length);
                if(moveKing[0] == copyRock[0] &&
                moveKing[1] == copyRock[1]){
                    copyRock = move(copyRock, moves[i].length(), moves[i]);
                }
                if ( (moveKing[0] > 0 && moveKing[0] < 9) &&
                        (moveKing[1] > 0 && moveKing[1] < 9) &&
                        (copyRock[0] > 0 && copyRock[0] < 9) &&
                        (copyRock[1] > 0 && copyRock[1] < 9)){
                    kingPoint = moveKing;
                    rockPoint = copyRock;
                }

        }
        king = String.valueOf((char)(kingPoint[0] + 'A' - 1)) + kingPoint[1];
        rock = String.valueOf((char)(rockPoint[0] + 'A' - 1)) + rockPoint[1];
        System.out.println(king);
        System.out.println(rock);
    }

    private static int[] move(int[] point, int length, String moves) {
        int x = point[0]; //열
        int y = point[1]; //행
        for (int i = 0; i < length; i++) {
            char direction = moves.charAt(i);
            switch (direction){
                case 'B' : y--;
                           break;
                case 'T' : y++;
                           break;
                case 'R' : x++;
                           break;
                case 'L' : x--;
                           break;
            }
        }

        return new int[]{x, y};
    }
}
