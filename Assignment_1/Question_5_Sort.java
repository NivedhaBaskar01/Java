import java.util.*;

public class Question_5_Sort {

	public static void main(String[] args) 
	{
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		n=n+1;
		String[] s=new String[n];
		for(int i=0;i<n;i++)
		{
			s[i]=sc.nextLine();
		}
		String temp;
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
			if(s[i].compareTo(s[j])>0)
			{
				temp=s[i];
				s[i]=s[j];
				s[j]=temp;
			}
			}
		}
		for(int i=0;i<n;i++)
		{
		System.out.println(s[i]);
		}

	}

}
