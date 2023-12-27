package Glad.Silver.학생_번호;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 학생_번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String [] nums = new String[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.next();
        }
        int answer = 1;
        for (int i = 0; i < nums[0].length(); i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                String rest = nums[j].substring( nums[0].length() - i - 1, nums[0].length());
                set.add(rest);
            }
            if (set.size() == nums.length) {
                answer = i + 1;
                break;
            }
        }
        System.out.println(answer);
    }
}
