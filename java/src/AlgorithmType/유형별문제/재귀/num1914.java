package rescursion;
import java.math.BigInteger;
import java.util.Scanner;
 
public class num1914 {
    
    static void hanoi(int num, char one, char two, char three)
    {
        if(num == 1)
            System.out.println(one + " " + three);
        
        else
        {
            hanoi(num - 1, one, three, two);
            System.out.println(one + " " + three);
            hanoi(num - 1, two, one, three);
        }
        
    }  
    
    public static void main(String[] args)
    {
        BigInteger c = new BigInteger("2");
        Scanner sc = new Scanner(System.in);
               
        int n = sc.nextInt();
        
        c = c.pow(n).subtract(BigInteger.ONE);
        
        System.out.println(c);
        
        if(n <= 20)
            hanoi(n,'1','2','3');
    }
    
}
