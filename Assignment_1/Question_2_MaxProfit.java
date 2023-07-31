import java.util.*;

public class Question_2_MaxProfit {
	public static void main(String[] args) 
	{
		ArrayList<Integer> arr=new ArrayList<Integer>();
		ArrayList<Integer> a=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		int l,c=0;
		l=sc.nextInt();
		for(int i=0;i<8;i++)
		{
			arr.add(sc.nextInt());
		}
		for(int i=0;i<l;i++)
		{
			c=arr.get(i);
			for(int j=i+1;j<l;j++)
			{
				c=c+arr.get(j);
				a.add(c);
			}
		}
		System.out.print(Collections.max(a));
		
		

	}

}
