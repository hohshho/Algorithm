package 유형별문제.save;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cSolution1 {
    public static String getFinalString(String s) {
        // Write your code here
        Pattern awsPattern = Pattern.compile("AWS");
        Matcher matcher = awsPattern.matcher(s);

        while(matcher.find()){
            s = s.replaceAll("AWS", "");
            matcher = awsPattern.matcher(s);
        }

        return s;
    }

    public static void main(String[] args) throws IOException {

        String result = cSolution1.getFinalString("AWSAWSB");

        System.out.println(result);
    }

}
