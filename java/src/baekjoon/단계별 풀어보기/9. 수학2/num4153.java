package package9;

import java.util.*;

public class num4153 {
    public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);
            int temp=3;            
            while(temp!=0) {
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                int[] arr= {a,b,c};
                Arrays.sort(arr);
                temp=a;
                if(temp==0) {break;}
                    else {
                        if(Math.pow(arr[2], 2)==Math.pow(arr[0], 2)+Math.pow(arr[1], 2)) {
                            System.out.println("right");
 
                        }
                        else {
                            System.out.println("wrong");
                        }
                    }
            }    
          
    }
}