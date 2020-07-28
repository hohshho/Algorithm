package package7;

public class num4673 {
	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		int i;
		int sum=0, n;
		
		for(i=1;i<10000;i++) {
			int dn = getDn(i);
			if(dn<=10000) {
				arr[dn]=true;
			}
		}
		
		for(i=1;i<10001;i++) {
			if(!arr[i])
				System.out.println(i);
		}
	}
	
	public static int getDn(int n ) {
		int dn = n;
		while(n>0) {
			dn+= n%10;
			n/=10;
		}
		return dn;
	}
	
}
