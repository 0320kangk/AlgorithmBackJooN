package Glad.Bronse;

import java.math.BigInteger;
import java.util.Scanner;

public class 엄청난_부자2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();
        BigInteger bigN = new BigInteger(n);
        BigInteger bigM = new BigInteger(m);
        BigInteger divide = bigN.divide(bigM);
        BigInteger rest = bigN.mod(bigM);
        System.out.println(divide);
        System.out.println(rest);
    }
}
