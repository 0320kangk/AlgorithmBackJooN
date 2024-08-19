package Glad.Silver.밑_줄;

import java.util.Scanner;

public class 밑_줄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] words = new String[N];
        int wordsLength = 0;
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
            wordsLength += words[i].length();
        }
        int _count = M - wordsLength;
        int _space = words.length - 1;
        int share = _count / _space;
        int rest = _count % _space;

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < share; j++) {
                sb.append("_");
            }
            if(words[i].charAt(0)  >= 'a' &&
                    words[i].charAt(0) <= 'z'&& rest > 0){
                rest--;
                sb.append("_");
            }
            sb.append(words[i]);
        }
        if( rest > 0 ){
            for (int i = sb.length() - 1; i >= 0 ; i--) {
                char c = sb.charAt(i);
                if(c >= 'A' && c <='Z'
                        && i >0 && sb.charAt(i - 1) == '_'
                        && rest > 0
                ){
                    rest--;
                    sb.insert(i,'_');
                }
                if (rest == 0) break;
            }
        }
        System.out.println(sb);

    }
}
