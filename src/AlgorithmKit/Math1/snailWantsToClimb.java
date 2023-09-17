package AlgorithmKit.Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class snailWantsToClimb {

    public static void main(String args[]) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            double speed = Integer.parseInt(st.nextToken());
            double slip = Integer.parseInt(st.nextToken());
            double height = Integer.parseInt(st.nextToken());

            double day = (height - slip) / (speed - slip);
            /*

            (height - down) % (up - down) != 0 if 문 조건으로 가능
            나머지가 0 이 아니라면 정수가 아니라는 뜻 이기 떄문문

           */
            if ((int) day != day) {

                day = (int) day + 1;

            }

            System.out.println((int) day);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
