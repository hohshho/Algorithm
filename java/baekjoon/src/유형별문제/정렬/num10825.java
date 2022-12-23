package 유형별문제.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class num10825 {
    static int N;
    static ArrayList<Person> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");

            list.add(new Person(input[0], stoi(input[1]), stoi(input[2]), stoi(input[3])));
        }

        Collections.sort(list);

        for(Person person : list){
            System.out.println(person.name);
        }
    }

    static class Person implements Comparable<Person> {
        String name;
        int kor, eng, math;
        public Person(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Person o) {
            // 국어 (내림차순)
            if(this.kor > o.kor)
                return -1;
            else if(this.kor < o.kor)
                return 1;

            // 영어 (오름차순)
            if(this.eng > o.eng)
                return 1;
            else if(this.eng < o.eng)
                return -1;

            // 수학 (내림차순)
            if(this.math > o.math)
                return -1;
            else if(this.math < o.math)
                return 1;

            // 이름 (오름차순)
            return this.name.compareTo(o.name);
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
