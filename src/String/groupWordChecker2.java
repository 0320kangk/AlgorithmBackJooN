package String;

import java.util.Scanner;

public class groupWordChecker2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int count = 0;

        for (int i = 0 ; i < n; i++) {

            if (checker()) {
                count++;
            }

        }
        System.out.println(count);
        //하나 입력받고 하나 세고 하나 입력받고 세고..


    }

    public static boolean checker() {

        boolean[] check = new boolean[26];
        int past = 0;
        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);

            if( past != now) {

                if ( check[ now - 'a'] == true) {
                    return false;

                }
                else {
                    check[ now - 'a'] = true;
                    past = now;

                }

            }

        }
        return true;

    }


}
