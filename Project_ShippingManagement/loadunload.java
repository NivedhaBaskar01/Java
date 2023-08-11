package shippingmanagement;

import java.util.ArrayList;
import java.util.Scanner;
abstract class impex
{
	abstract void fuel();
}
public class loadunload extends impex
{
	String yn;
	Scanner sc=new Scanner(System.in);
	public loadunload(ArrayList<String> port,ArrayList<String> src,ArrayList<String> des,ArrayList<Integer> weight,ArrayList<Integer> cus,int sh)
	{
		ArrayList<Integer> desc=new ArrayList<Integer>();
		desc=(ArrayList<Integer>) des.clone();
		ArrayList<Integer> cusdes=new ArrayList<Integer>();
		cusdes=(ArrayList<Integer>) cus.clone();
		ArrayList<Integer> weightdes=new ArrayList<Integer>();
		weightdes=(ArrayList<Integer>) weight.clone();
		for(int i=0;i<port.size();i++)
		{
			System.out.println("The ship is in the port: "+port.get(i));
			if(src.contains(port.get(i))|| des.contains(port.get(i)))
			{
				for(int j=0;j<src.size();j++)
				{
					if(src.get(j).equals(port.get(i)))
					{
						System.out.println();
						System.out.println("Available : Loading")	;
						System.out.println("Customer Id: "+cus.get(j));
						System.out.println("Weight: "+weight.get(j));
						
						System.out.print("Do you want to load? Y?N ");
						 yn=sc.next();
						 System.out.println();
						 Container objhev=new heavy();
						 Container objbas=new basic();
						 if(weight.get(j)>3000)
						 {
							
							objhev.create();
							objhev.calcon();
						 }
						 else
						 {
							
							objbas.create();
							objbas.calcon();
						 }
						 objhev.display();
						 objbas.display();
						 
						 //totalweight+=weight.get(0);
						 System.out.println("Customer ID "+cus.get(j)+" loaded at the port "+src.get(j)+
								" with weight "+weight.get(j));
					}
					if(des.get(j).equals(port.get(i)))
					{
						System.out.println();
						System.out.println("Available : Unloading")	;
						
						System.out.println("Customer Id: "+cusdes.get(j));
						System.out.println("Weight: "+weightdes.get(j));
						System.out.print("Do you want to Unload? Y?N ");
						yn=sc.next();
						System.out.println();
						heavy objhev=new heavy();
						basic objbas=new basic();
						if(weightdes.get(j)>3000)
						{
							
							objhev.calcon(weightdes.get(0));
							
						}
						 
						else
						{
						
						objbas.calcon(weightdes.get(0));
							
						}
						objhev.display();
						objbas.display();
						
						System.out.println("Customer ID "+cusdes.get(j)+" unloaded at the port "+des.get(j)+
								" with weight "+weightdes.get(j));
						desc.remove(des.get(j));
							
						
						
					}
				}
				if(desc.size()==0)
				{
					System.out.println();
					System.out.println("Ship "+sh+" Reached the Destination");
					break;
				}
				System.out.println("***********************************************************************");
				System.out.println("                     MOVING TO THE NEXT PORT");
				System.out.println("***********************************************************************");
			}
			else
			{
				System.out.println();
				System.out.println("No Loading or Unloading Available");
				System.out.println();
				System.out.println("************************************************************************");
				System.out.println("                     MOVING TO THE NEXT PORT");
				System.out.println("************************************************************************");
				
			}
		}
		
	}
	@Override
	void fuel() 
	{
		
		System.out.println("Fuel Consumed "+1000*0.159+"L");
	}

}
