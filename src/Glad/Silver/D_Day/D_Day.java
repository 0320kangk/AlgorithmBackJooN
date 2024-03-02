package Glad.Silver.D_Day;

import java.text.ParseException;
import java.util.Scanner;
public class D_Day {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String[] today = sc.nextLine().split(" ");
        String[] endDay = sc.nextLine().split(" ");

        int yearToday = Integer.parseInt(today[0]);
        int monthToday = Integer.parseInt(today[1]);
        int dayToday = Integer.parseInt(today[2]);

        int yearEndDay = Integer.parseInt(endDay[0]);
        int monthEndDay = Integer.parseInt(endDay[1]);
        int dayEndDay = Integer.parseInt(endDay[2]);

        if (yearEndDay - yearToday > 1000 ||
                ( yearEndDay - yearToday == 1000 && (monthEndDay > monthToday ||
                        (monthEndDay == monthToday && dayEndDay >= dayToday)))){
            System.out.println("gg");
        }else {
            int totalDays = totalDays(yearEndDay, monthEndDay, dayEndDay) -totalDays(yearToday, monthToday, dayToday);
            System.out.println("D-" + totalDays);
        }
    }
    private static int totalDays(int year, int month ,int day) {
        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        for (int i = 1; i < year; i++) {
            totalDays += findLeapYear(i) + 365;
        }
        for (int i = 1; i < month; i++) {
            totalDays += daysOfMonth[i];
            if(i == 2) totalDays += findLeapYear(year);
        }
        return  totalDays + day;
    }
    private static int findLeapYear(int year){
        if (year % 4 == 0){
            if (year % 100 == 0) {
                if( year % 400 == 0) return 1; //윤년
                else return 0; //평년
            }else return 1;
        }else return 0;
    }
}
