package Glad.Silver.시리얼_번호;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 시리얼_번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Serial[] serials = new Serial[N];
        for (int i = 0; i < N; i++) {
            serials[i] = new Serial(sc.next());
        }
        Arrays.sort(serials);
        for (int i = 0; i < serials.length; i++) {
            System.out.println(serials[i].nums);
        }
    }
    static class Serial implements Comparable<Serial> {
        String nums;

        public Serial(String nums) {
            this.nums = nums;
        }

        @Override
        public int compareTo(Serial serial) {
            String nums1 = this.nums;
            String nums2 = serial.nums;
            if(nums1.length() == nums2.length()) {
                //nums1과 nums2 비교
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < nums1.length(); i++) {
                    if(nums1.charAt(i) - '0' <= 9){
                        sum1 += nums1.charAt(i) - '0';
                    }
                }
                for (int i = 0; i < nums2.length(); i++) {
                    if(nums2.charAt(i) - '0' <= 9){
                        sum2 += nums2.charAt(i) - '0';
                    }
                }
                if (sum1 != sum2) return sum1 - sum2;
                else return nums1.compareTo(nums2);
            } else{
                return nums1.length() - nums2.length();
            }
        }
    }
}
