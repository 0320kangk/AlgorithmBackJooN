package Math2;

import java.util.Scanner;

public class Factorization {

    StringBuilder br = new StringBuilder();

    void Decomposition(int x) {

        double y = Math.sqrt(x);

        for (int i = 2; i <= y; i++) {

            if (x / i == (double) x / i) {
                br.append(i).append('\n');
                Decomposition(x / i);
                return;
            }
        }
        if (x != 1) {
            br.append(x).append('\n');
        }


    }


    public static void main(String[] args) {

        Factorization test = new Factorization();
        Scanner sc = new Scanner(System.in);
        test.Decomposition(sc.nextInt());

        System.out.print(test.br);


    }


}
