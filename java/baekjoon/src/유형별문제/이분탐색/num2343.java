package 유형별문제.이분탐색;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num2343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputNM = br.readLine().split(" ");
		int N = stoi(inputNM[0]);
		int M = stoi(inputNM[1]);
		int[] lesson = new int[N];
		String[] lessonData = br.readLine().split(" ");
		int sum = 0;
		int lessonMin = 0;
	
		for(int i=0; i<N; i++) {
			lesson[i] = stoi(lessonData[i]);
			sum+=lesson[i];
			lessonMin = lessonMin > lesson[i] ? lessonMin : lesson[i];
		}
		System.out.println(bsearch(lesson, sum, M, lessonMin));
	}
	
	public static int bsearch(int[] lesson, int sum, int M, int lessonMin) {
		int min = sum;
		int start = lessonMin;
		int end = sum;
		
		while(start <= end) {
			int mid = (start+end)/2;
			if(!checkLesson(lesson,M,mid)){
				start = mid + 1;
			}else {
				min = mid < min ? mid : min;
				end = mid -1 ;
			}
		}
		return min;
	}
	
	public static boolean checkLesson(int[] lesson, int M, int mid) {
		int count = 0;
		int sum = 0;
		for(int i=0;i<lesson.length;i++) {
			sum += lesson[i];
			if(sum>mid) {
				sum = lesson[i];
				count++;
			}
		}
		return count>=M ? false : true;
	}

	public static int stoi(String string) {
		return Integer.parseInt(string);
	}
}
