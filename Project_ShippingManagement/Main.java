package shippingmanagement;

import java.util.*;

public class Main
{
	static int sh=1,e=100,f0=0,tw=0,f1=0;
	static String ad="Nivedha";
	public static void main(String[] args) 
	{
		System.out.println("***WELCOME TO SHIPPING MANAGEMENT***");
		int choice;
		Scanner sc=new Scanner(System.in);
		List<customerdetails> customerhistory = new ArrayList();
		ArrayList<Integer> cusidarr = new ArrayList<Integer>();
		ArrayList<String> srcarr = new ArrayList<String>();
		ArrayList<String> desarr= new ArrayList<String>();
		ArrayList<Integer> weightarr = new ArrayList<Integer>();
		ArrayList<String> portclone=new ArrayList<String> 
		(
				Arrays.asList("chennai","kochi","mumbai","gulf","suez")
		);
		boolean c=true; 
		while(c)
		{
		System.out.println("LOGIN AS:");
		System.out.println("1 CUSTOMER");
		System.out.println("2 ADMIN");
		System.out.println("3 EXIT");
		System.out.print("Enter your Choice:");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			String s,d;
			//int f1=0;
			int w,cost=0,choicecus,cusid;
			System.out.println("1 Enter the Shipment Details");
			System.out.println("2 Track the Shipment ");
			System.out.print("Enter your Choice:");
			choicecus=sc.nextInt();
			switch(choicecus)
			{
			case 1:
				e+=1;f0=1;
				customerdetails cobj=new customerdetails();
				System.out.println("Enter name: ");
				cobj.setName(sc.next());
				System.out.println("Enter Phone number: ");
				cobj.setPhno(sc.next());
				System.out.println("Ship Route");
				System.out.println("chennai --> kochi --> mumbai --> gulf ---> suez ");
				System.out.println("Enter Source Port: ");
				s=sc.next();
				cobj.setSrc(s);
				System.out.println("Enter the Destination Port: ");
				d=sc.next();
				while(portclone.indexOf(s)>portclone.indexOf(d))
				{	
				System.out.println("The destination is not in the way of the ship");
				//d=sc.next();
				System.out.println("Re-Enter the Destination Port: ");
				d=sc.next();
				}
				cobj.setDes(d);
				System.out.println("Enter the weight: ");
				w=sc.nextInt();
				tw+=w;
				if(tw<=15000)
				{cobj.setWeight(w);
				cusid=sh*1000+e;
				cobj.setCustomerid(cusid);
				cusidarr.add(cusid);
				srcarr.add(s);
				desarr.add(d);
				port objp=new port();
				cobj.setCost(objp.calcost(s,d,w));
				System.out.println("*********************************************");
				System.out.println("                   RECEIPT   ");
				System.out.println("*********************************************");
				System.out.println("1"+cobj);
				customerhistory.add(cobj);weightarr.add(w);
				}
				else
				{
					System.out.println();
					System.out.println("No space in the ship");
					System.out.println("Wait for the next ship");
					System.out.println();
					//
					break;
					//c=false;
				}
				break;
			case 2:
				
				if(f0==0)
				System.out.println("No customer history found!");
				else if(f1==0)
				{
				System.out.println("Enter customer ID:");
				int cid=sc.nextInt();
				if(cusidarr.contains(cid))
				System.out.println("Still in progress");
				else
				System.out.println("Invalid Customer ID");
				}
				else
				{
				System.out.println("Enter customer ID:");
				int cid=sc.nextInt();
				if(cusidarr.contains(cid))
					System.out.println("Still in progress");
				else
				{
				for(int i=0;i<customerhistory.size();i++) 
				{
					if(cid == customerhistory.get(i).customerid) 
					{
						customerhistory.get(i).getDetails();
						
					}
					else
					System.out.println("Invalid Customer ID");
				}
				}
				}
				break;
			}
		    break;
				
		case 2:
			int choicead;
			String adn;
			System.out.print("Enter Admin UserName: ");
			adn=sc.next();
			if(ad.equals(adn))
			{
			System.out.println("1 Start the Shipment");
			System.out.println("2 View Customer History");
			System.out.print("Enter your Choice:");
			choicead=sc.nextInt();
			switch(choicead)
			{
			case 1:
				
				System.out.println();
				ship shipobj=new ship(sh);
				System.out.println();
				loadunload objload=new loadunload(portclone,srcarr,desarr,weightarr,cusidarr,sh);
				objload.fuel();
				
				srcarr.clear();
				cusidarr.clear();
				desarr.clear();
				weightarr.clear();
				e=100;sh+=1;f1=1;
				break;
			case 2:
				//f1=1;
				for(int i=0;i<customerhistory.size();i++)
				{
					System.out.println(i+1+""+customerhistory.get(i)+"\n---------------------------------");
				}
				break;
			}
			}
			else
			{
				System.out.println("You are not an Admin");
			}
			break;
		case 3:
			c=false;
			System.out.println("Process Completed");
			break;
			
			
			
			
		}
		}
		
	}

}
