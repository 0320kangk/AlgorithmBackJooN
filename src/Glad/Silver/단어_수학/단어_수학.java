package Glad.Silver.단어_수학;

import javax.jws.soap.SOAPBinding;
import java.util.*;

public class 단어_수학 {
    static int value = 9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] array = new int[26];
        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                array[c - 'A'] += (int) Math.pow(10, word.length()- j - 1);
            }
        }
        Arrays.sort(array);

        int num = 9;
        int answer = 0;
        for (int i = array.length - 1; i >= 0 ; i--) {
            answer += array[i] * num--;
        }
        System.out.println(answer);

    }


}
