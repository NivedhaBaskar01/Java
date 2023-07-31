import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Question_3_Treasure {

	public static void main(String[] args) 
	{
		int n,c;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			arr.add(sc.nextInt());
		}
		Collections.sort(arr);
		Collections.reverse(arr);
		c=arr.get(0);
		int f=0;
		for(int i=1;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum+=arr.get(j);
				
			}
			if(sum==c)
			{
				System.out.println("True");
				f=1;
				break;
			}
			else
			{
				c+=arr.get(i);
			}
		}
		if(f==0)
		{
			System.out.println("False");
		}
	}

}
