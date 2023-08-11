package shippingmanagement;

import java.util.ArrayList;
import java.util.Arrays;

public class port 
{

	ArrayList<String> ports=new ArrayList<String> 
	(
			Arrays.asList("chennai","kochi","mumbai","gulf","suez")
	);
	int calcost(String s,String d,int w)
	{
		int cost=0,a,b;
		a=ports.indexOf(d)-ports.indexOf(s);
		if(a==1)
			cost+=3000;
		if(a==2)
			cost+=6000;
		if(a==3)
			cost+=9000;
		else
			cost+=12000;
		if(w>3000)
			cost+=5000;
		else
			cost+=3000;
		return cost;
	}

}
