package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Sandwich
{
	ArrayList<String> sw=new ArrayList<String>(
			Arrays.asList("Cheeseburger","Club sandwich"));
	ArrayList<Integer> sp=new ArrayList<Integer>(
			Arrays.asList(200,300));
	void printsw()
	{
		for(int i=0;i<sw.size();i++)
		{
			System.out.println(sw.get(i)+" "+sp.get(i));
		}
		
	}
	
}
class salad extends Sandwich
{
	ArrayList<String> s=new ArrayList<String>(
			Arrays.asList("Spinach","Coleslaw"));
	ArrayList<Integer> spp=new ArrayList<Integer>(
			Arrays.asList(450,350));
	void prints()
	{
		for(int i=0;i<s.size();i++)
		{
			System.out.println(s.get(i)+" "+spp.get(i));
		}
		
	}
}
class drinks extends salad
{
	ArrayList<String> d=new ArrayList<String>(
			Arrays.asList("pepsi","coke"));
	ArrayList<Integer> dp=new ArrayList<Integer>(
			Arrays.asList(500,250));
	void printd()
	{
		for(int i=0;i<sw.size();i++)
		{
			System.out.println(d.get(i)+" "+dp.get(i));
		}
		
	}
}
class trio extends drinks
{
	ArrayList<Integer> arr=new ArrayList<Integer>();
	int a,b,c;
	int x,y,z,sum;
	int CalculatePrice(String swi,String si,String di)
	{
		a=sw.indexOf(swi);
		x=sp.get(a);
		//System.out.print(x);
		arr.add(x);
		b=s.indexOf(si);
		y=spp.get(b);
		//System.out.print(y);
		arr.add(y);
		a=d.indexOf(di);
		z=dp.get(a);
		arr.add(z);
		//System.out.print(z);
		//System.out.print(arr);
		for(int i=0;i<2;i++)
		{
		sum+=Collections.max(arr);
		arr.remove(Collections.max(arr));
		}
		return sum;
	}
}
public class Question3_Trio extends trio {

	public static void main(String[] args) 
	{
		String sw,s,d;
		int summ;
		Scanner sc=new Scanner(System.in);
		System.out.println("Order the trio");
		System.out.println("Select the sandwich from the list");
		trio obj=new trio();
		obj.printsw();
		sw=sc.next();
		System.out.println("Select the salad from the list");
		obj.prints();
		s=sc.next();
		System.out.println("Select the drinks from the list");
		obj.printd();
		d=sc.next();
		summ=obj.CalculatePrice(sw, s, d);
		System.out.println(sw+"/"+s+"/"+d+"Trio and the Price: "+summ);
		
		
	}

}
