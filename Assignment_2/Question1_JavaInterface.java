package Test;

import java.util.Scanner;

interface AdvancedArithmetic
{
	int divisor_sum(int n);
}
class MyCalculator implements AdvancedArithmetic
{
	static int s=0;
	@Override
	public int divisor_sum(int n) 
	{
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				s+=i;
			}
		}
		return s;
	}
	
}
public class Question1_JavaInterface {

	public static void main(String[] args) 
	{
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		AdvancedArithmetic obj=new MyCalculator();
		System.out.println(obj.divisor_sum(n));

	}

}
