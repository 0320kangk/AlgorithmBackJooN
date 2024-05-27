package Glad.Silver.행운의_문자열;

import java.util.Scanner;

public class 행운의_문자열 {
    public static String word;
    public static int[] alphabets = new int[26];
    public static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        word = sc.next();
        //양옆에 문자열의 유무를 확인하는 로직 만들기
        //모든 문자열을 만들어 보기
        alphabets = new int[26];
        for (int i = 0; i < word.length(); i++) {
            alphabets[word.charAt(i) - 'a']++;
        }
        search(' ', 0);
        System.out.println(answer);
    }
    public static void search(char alphabet, int count ) {
        if (word.length() == count ){
            answer++;
            return;//재귀함수를 문자열 길이 만큼 부르지
        }
        for (int i = 0; i < alphabets.length; i++) {
           if(alphabets[i] == 0) continue;
           if((char)(i + 'a') != alphabet){
               alphabets[i]--;
               search((char)(i + 'a'), count + 1);
               alphabets[i]++;
           }
        }
    }
}
//aaaabbb
