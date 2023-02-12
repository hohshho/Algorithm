package 유형별문제.해쉬맵;

import java.text.ParseException;
import java.util.*;
import java.io.*;

public class num19583 {
    static HashSet<String> enteredSet = new HashSet<>();;
    static HashSet<String> exitSet = new HashSet<>();;
    static int res = 0;

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] times = br.readLine().split(" ");

        String str = null;

        while((str = br.readLine()) != null){
            String[] items = str.split(" ");

            if(times[0].compareTo(items[0]) >= 0) {
                enteredSet.add(items[1]);
            }

            if(times[1].compareTo(items[0]) <= 0 && times[2].compareTo(items[0]) >= 0) {
                exitSet.add(items[1]);
            }
        }

        for(String name : enteredSet){
            if(exitSet.contains(name)){
                res += 1;
            }
        }

        System.out.println(res);
    }
}
