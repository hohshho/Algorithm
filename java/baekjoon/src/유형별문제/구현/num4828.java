package 유형별문제.구현;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class num4828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String inputLine;

    public static void main(String[] args) throws IOException {
        while(inputData()){
            XMLchecker checker = new XMLchecker(inputLine);

            System.out.println(checker.run(inputLine) ? "valid" : "invalid");
        }
    }

    static boolean inputData() throws IOException {
        inputLine = br.readLine();

        if(inputLine == null) return false;

        return true;
    }

    static class XMLchecker{
        String line;

        XMLchecker(String line){
            this.line = line;
        }

        boolean run(String line) {
            // 1. escape 문자 제거 (&lt; &gt; &amp;)
            deleteExceptionCharacter();

            // 2. 16진수 검증 & 제거
            if(!verificateAndDeleteHexadecimal()) return false;

            // 3. xml 태그 검증 & 제거
            if(!verificateAndDeleteXML()) return false;

            // 4. 위 3가지가 제거된 plain text의 검증
            if(!verificatePlainText()) return false;

            return true;
        }

        boolean verificatePlainText(){
            if (this.line.contains("<") || this.line.contains(">") || this.line.contains("&")) {
                return false;
            }

            for (char ch : this.line.toCharArray()) {
                if (ch < 32 || 127 < ch) {
                    return false;
                }
            }

            return true;
        }

        boolean verificateAndDeleteXML(){
            Stack<String> ctx = new Stack<>();

            this.line = this.line.replaceAll("<[a-z0-9]+/>", "0"); // test case : <a><<a/>/a> /
            Matcher m = Pattern.compile("</?[a-z0-9]+>").matcher(this.line);

            while (m.find()) {
                String rawTag = m.group();

                if (rawTag.startsWith("</")) {
                    if(ctx.empty()) return false; // empty stack check

                    String openTag = ctx.pop().replaceAll("[<>/]", "");
                    String closeTag = rawTag.replaceAll("[<>/]", "");

                    if (openTag.equals(closeTag) == false) {
                        return false;
                    }
                } else {
                    ctx.push(rawTag);
                }
            }

            if (ctx.isEmpty() == false) {
                return false;
            }

            this.line = this.line.replaceAll("</?[a-z0-9]+>", "");

            return true;
        }

        boolean verificateAndDeleteHexadecimal(){
            Matcher m = Pattern.compile("&x[a-fA-F0-9]+;").matcher(this.line);

            while (m.find()) {
                String hex = m.group().replaceAll("[&x;]", "");

                if (hex.length() % 2 != 0) {
                    return false;
                }
            }

            this.line = this.line.replaceAll("&x[a-fA-F0-9]+;", "");

            return true;
        }

        void deleteExceptionCharacter(){
            this.line = this.line.replaceAll("(&amp;)|(&lt;)|(&gt;)", "");
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}