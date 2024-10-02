package Glad.Silver.비숍;

import java.math.BigInteger;
import java.util.Scanner;

public class 비숍 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger N= new BigInteger(sc.next());
        if( N.equals(BigInteger.ONE)) System.out.println(N);
        else System.out.println(N.add(N.subtract(new BigInteger("2"))));
    }
}
