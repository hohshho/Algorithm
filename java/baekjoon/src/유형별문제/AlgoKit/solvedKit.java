package 유형별문제.AlgoKit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class solvedKit {

    public static void main(String[] args) throws ParseException {
        String date1 = "01-03 12:02"; //날짜1
        String date2 = "01-01 01:40"; //날짜2

        Date format1 = new SimpleDateFormat("MM-dd HH:mm").parse(date1);
        Date format2 = new SimpleDateFormat("MM-dd HH:mm").parse(date2);

        long diffSec = (format1.getTime() - format2.getTime()) / 1000; //초 차이
        long diffMin = (format1.getTime() - format2.getTime()) / 60000; //분 차이
        long diffHor = (format1.getTime() - format2.getTime()) / 3600000; //시 차이
        long diffDays = diffSec / (24*60*60); //일자수 차이

        System.out.println(diffSec + "초 차이");
        System.out.println(diffMin + "분 차이");
        System.out.println(diffHor + "시 차이");
        System.out.println(diffDays + "일 차이");
    }






}
