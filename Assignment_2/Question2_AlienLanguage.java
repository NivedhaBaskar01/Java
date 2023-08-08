package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class order
{   //static int flag=0;
	int findorder(int n,int k,ArrayList<String> s,String o)
	{
		String sg;
		int flag=0;
		char[] c=o.toCharArray();
		Arrays.sort(c);
		sg= new String(c);
		/*for(int i=0;i<c.length;i++)
		{
			System.out.print(c[i]);
		}*/
		//sg=c.toString();
		//System.out.println(sg);
		ArrayList<String> sorts=new ArrayList<String>();
		for(int i=0;i<n;i++)
		{
			String st=s.get(i);
			char[] ch=st.toCharArray();
			Arrays.sort(ch);
			//sh=ch.toString();
			//System.out.println(sh);
			String sh= new String(ch);
			//System.out.println(sh);
			//sorts.add(sh);
			if(sg.compareTo(sh)==1)
			{
				return 1;
			}
		}
		return 0;
		
	}
}

public class Question2_AlienLanguage {

	public static void main(String[] args) 
	{
		int n,k;
		ArrayList<String> s=new ArrayList<String>();
		String o;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			s.add(sc.next());
		}
		o=sc.next();
		order obj=new order();
		System.out.println(obj.findorder(n,k,s,o));
	}

}
