package 유형별문제.AlgoKit;

import java.text.*;
import java.util.*;
import java.io.*;

public class solvedKit {

    public static void main(String[] args) throws ParseException {

        System.out.println(checkPrimeNumber(121));
    }

    public static boolean checkPrimeNumber(int value) {
        if (value < 2) return false;

        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void makePrimeNumbers(int value) {
        // 사용할 때 prime 외부로 꺼냄
        boolean[] prime = new boolean[value + 1];

        if (value <= 2) return;

        for (int i = 2; i * i <= value; i++) {
            if (prime[i]) continue;

            for(int j = i * i; j < prime.length; j = j + i){
                prime[j] = true;
            }
        }
    }

    public static void item(String[] args) throws ParseException {
        // 1. 날짜 형식 변환
        String sdate = "20220209";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        //string => date
        Date date = format.parse(sdate);

        //date => string
        sdate = format.format(date);

        // 2. 바로 계산
        String date1 = "01-03 12:02"; //날짜1
        String date2 = "01-01 01:40"; //날짜2

        Date format1 = new SimpleDateFormat("MM-dd HH:mm").parse(date1);
        Date format2 = new SimpleDateFormat("MM-dd HH:mm").parse(date2);

        long diffSec = (format1.getTime() - format2.getTime()) / 1000; //초 차이
        long diffMin = (format1.getTime() - format2.getTime()) / 60000; //분 차이
        long diffHor = (format1.getTime() - format2.getTime()) / 3600000; //시 차이
        long diffDays = diffSec / (24 * 60 * 60); //일자수 차이

        Date now = new Date();

        // 3. Calendar 사용 계산
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        cal.add(Calendar.YEAR, 1);          // 1년 더하기
        cal.add(Calendar.MONTH, -3);        // 3개월 빼기
        cal.add(Calendar.DATE, 2);          // 2일 더하기
        cal.add(Calendar.HOUR_OF_DAY, -2);  // 2시간빼기
        cal.add(Calendar.MINUTE, 20);       // 20분 더하기
        cal.add(Calendar.SECOND, -10);      // 10초 빼기

        Date item = cal.getTime();

        // 4. 날짜 비교
        Date item1 = format.parse("20210629");
        Date item2 = format.parse("20110328");

        if (item1.compareTo(item2) > 0) {
            System.out.println("date1이 더 미래 날짜");
        } else if (item1.compareTo(item2) < 0) {
            System.out.println("date1이 더 과거 날짜");
        } else {
            System.out.println("같은 날짜");
        }
    }
}
