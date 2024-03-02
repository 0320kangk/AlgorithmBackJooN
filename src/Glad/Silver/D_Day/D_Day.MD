# D_Day 풀이

### [문제 링크](https://www.acmicpc.net/problem/1308)

### 문제 풀이
이 문제는 주어진 날짜 사이의 기간이 며칠 인지 나타내는 문제이다. </br>
주어진 날짜의 연, 월, 일에 대하여 며칠인지 나타낸 뒤 두 날짜의 차를 구하면 답을 구할 수 있다.</br>

+ 연도 -> 일 구하기
  +  주의할 점은 윤년에 대한 것이다.   </br>
     윤년이 얼마나 포함되는지 정확히 계산하여 나타내야 한다. </br>
    먼저 1년 부터 주어진 날짜의 년도 -1 까지 윤년이 얼마나 포함되는지 계산해야 한다. </br> 
   만약 윤년이라면 평년보다 하루 더 많은 날짜를 갖게 된다.</br> 


+ 월 -> 일 구하기
  + 1월부터 주어진 월 사이의 날짜에 대한 일수를 더하여 총 월 수를 구한다. </br>
    주의할 점은 윤년이다. 주어진 날짜의 연도가 윤년이라면 2월은 29로 계산해야 한다.</br>

위와 같이 각 연도와 월을 일수로 변환하여 답을 구한다. <br>
### 소스 코드
```java
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
            int totalDays = totalDays(yearEndDay, monthEndDay, dayEndDay) - totalDays(yearToday, monthToday, dayToday);
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
```