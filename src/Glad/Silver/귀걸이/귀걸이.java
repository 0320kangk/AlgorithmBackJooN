package Glad.Silver.귀걸이;

import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 귀걸이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scenario = 1;
        while (true){
            int i = sc.nextInt();
            int key = 0;
            sc.nextLine();
            if( i == 0) break;
            HashMap<Integer, String> map= new HashMap<>();
            for (int j = 1; j <= i; j++) {
                map.put(j, sc.nextLine());
            }
            int[] visited = new int[map.size() + 1];
            for (int j = 0; j < i * 2 - 1; j++) {
                String[] split = sc.nextLine().split(" ");
                visited[Integer.parseInt(split[0])]++;
            }
            for (int j = 1; j < visited.length; j++) {
                if(visited[j] < 2) key = j;
            }
            System.out.println(scenario + " " + map.get(key));
            scenario++;
        }

    }
}
