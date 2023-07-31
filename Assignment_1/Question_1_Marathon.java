import java.util.*;

public class Question_1_Marathon {

	public static void main(String[] args) 
	{
		int n,f=0;
		Scanner sc=new Scanner(System.in);
	System.out.println("Enter a starting distance between 5km to 8km");
	n=sc.nextInt();
	while(f==0)
	{
	if(n<5|| n>8)
	{
		System.out.println("Sorry choose between 5km to 8km");
		System.out.println("Enter a starting distance between 5km to 8km");
		n=sc.nextInt();
	}
	else
	{
		f=1;
	}
	}
	for(int i=n;i>0;i--)
	{
		System.out.println("Distance to run:"+i);
		if(i==n-1)
		{
		System.out.println("Good start keep it up");
		}
		else if(i<3)
		{
			System.out.println("Almost there");
		}
		if(i==1)
		{
			System.out.println("Done for the day");
		}
	}

		
	}
}
