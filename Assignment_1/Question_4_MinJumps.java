import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question_4_MinJumps {

	public static void main(String[] args) {
		int n,c=0;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			arr.add(sc.nextInt());
		}
		int i=0;
		while(n>0)
		{
			
			if(arr.get(i)>n)
			{
				c+=1;
				break;
			}
			else
			{c+=1;
				ArrayList<Integer> a=new ArrayList<Integer>();
				for(int j=i+1;j<=(i+1+arr.get(i+1));j++)
						{
							a.add(arr.get(j));
						}
				int m=Collections.max(a);
				n-=m;
			}
	
	}
		System.out.println(c+1);

}
}
