package shippingmanagement;

interface Container
{
//int hc=0;
void calcon();
void create();
void display();	
}
class heavy implements Container
{
	static int hc=0;
	public void create()
	{
	
	System.out.println("Heavy container created");
	}
	@Override
	public void calcon() 
	{
		hc+=1;
		
	}
	public void calcon(int w)
	{
		hc-=1;
	}
	public void display()
	{
		System.out.println("Heavy container count in the ship: "+hc);
	}
	

	
}
class basic implements Container
{
	static int bc=0;
    public void create()
    {
	
	System.out.println("Basic Container Created");
     }
	@Override
	public void calcon() 
	{
		bc+=1;
		
	}
	public void calcon(int w)
	{
		bc-=1;
		
	}
	public void display()
	{
		System.out.println("Basic container count in the ship: "+bc);
	}
	
}