package Glad.Silver.미로_만들기;

import java.util.Scanner;

public class 미로_만들기 {

    static int[] dx ={1, 0,-1, 0};
    static int[] dy ={0, -1,0,1 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String move = sc.next();
        //배열 최대 크기는 100 100
        char[][] miro = new char[100][100];
        for (int i = 0; i < miro.length; i++) {
            for (int j = 0; j < miro[0].length; j++) {
                miro[i][j] = '#';
            }
        }
        int[] point = {50, 50};
        int[] arrPointMin = {50, 50};
        int[] arrPointMax = {50, 50};
        miro[point[0]][point[1]] = '.';
        int direction = 0;
        for (int i = 0; i < move.length(); i++) {
            char cmd = move.charAt(i);
            switch (cmd){
                case 'R': direction++;
                    break;
                case 'L': direction--;
                    break;
            }
            if (direction == -1){
                direction +=4;
            } else if (direction == 4){
                direction -= 4;
            }
            if(cmd == 'F'){
                point[0] += dx[direction];
                point[1] += dy[direction];
                miro[point[0]][point[1]] = '.';

                if(arrPointMin[0] > point[0]) arrPointMin[0] = point[0];
                if(arrPointMin[1] > point[1]) arrPointMin[1] = point[1];
                if(arrPointMax[0] < point[0]) arrPointMax[0] = point[0];
                if(arrPointMax[1] < point[1]) arrPointMax[1] = point[1];
            }
        }


        for (int i = arrPointMin[0]; i <=  arrPointMax[0] ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = arrPointMin[1]; j <= arrPointMax[1]; j++) {
                sb.append(miro[i][j]);
            }
            System.out.println(sb);
        }
    }
}
