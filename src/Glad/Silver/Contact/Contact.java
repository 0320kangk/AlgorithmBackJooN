package Glad.Silver.Contact;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("(100+1+|01)+");
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            String inputPattern = sc.next();
            Matcher matcher = compile.matcher(inputPattern);
            if (matcher.matches())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
