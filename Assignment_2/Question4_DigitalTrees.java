package Test;

import java.util.Scanner;

interface DigitalTrees
{
	int absun(int h);
	void td(int h);
}
class bt implements DigitalTrees
{

	@Override
	public int absun(int h) {
		
		return 2*h;
	}

	@Override
	public void td(int h) 
	{
		
		System.out.println("Binary Tree:"+2*h);
	}

	
}
class Qt implements DigitalTrees
{

	@Override
	public int absun(int h) 
	{
		return (int) (3*(Math.pow(h, 2)));
	}

	@Override
	public  void td(int h) 
	{
		System.out.println("Quantum Tree:"+(int) (3*(Math.pow(h, 2))));
		//return 0;
	}
	
}
class nt implements DigitalTrees 
{

	@Override
	public int absun(int h) 
	{
		
		return (int) Math.pow(h, 3);
	}

	@Override
	public void td(int h) {
		
		System.out.println("Neural tree:"+(int) Math.pow(h, 3));
		//return 0;
	}
	
}
class officer
{
	DigitalTrees obj=new bt();
	DigitalTrees obj1=new Qt();
	DigitalTrees obj2=new nt();
	void calculate(int h)
	{
		int sum=0;
		//DigitalTrees obj=new bt();
		//DigitalTrees obj1=new Qt();
		//DigitalTrees obj2=new nt();
		sum+=obj1.absun(h)+obj2.absun(h)+obj2.absun(h);
		 System.out.println("Total Energy: "+sum);
	}
	void report(int h)
	{
		System.out.println("Tree Report");
		obj.td(h);
		obj1.td(h);
		obj2.td(h);
		calculate(h);
		
	}
}

public class Question4_DigitalTrees {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int h;
		h=sc.nextInt();
		officer obj4=new officer();
		obj4.report(h);

	}

}
