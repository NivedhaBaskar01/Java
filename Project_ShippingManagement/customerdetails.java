package shippingmanagement;

public class customerdetails 
{
private String name;
private String phno;
String src;
String des;
int weight;
public int customerid;
int cost;

public  void getDetails() {
	System.out.println("Shipment Summary");
	System.out.println("Name: "+name);
	System.out.println("Phone Number: "+phno);
	System.out.println("Source: "+src);
	System.out.println("Destination: "+des);
	System.out.println("Weight: "+weight);
	System.out.println("Shipment Arrived Successfully");
}
public customerdetails() 
{
	super();
	this.name=null;
	this.phno=null;
	this.src=null;
	this.des=null;
	this.weight=0;
	this.customerid=0;
	this.cost=0;
}

public customerdetails(String name, String phno, String src, String des, int weight,int customerid,int cost) 
{
	super();
	this.name = name;
	this.phno = phno;
	this.src = src;
	this.des = des;
	this.weight = weight;
	this.customerid=customerid;
	this.cost=cost;
}

public String getName() {
	return name;
}

public int getCustomerid() {
	return customerid;
}

public void setCustomerid(int customerid) {
	this.customerid = customerid;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return " Customer Id:" + customerid + "\n  Name:" + name + "\n  Phno:" + phno + "\n  Sorce Port:" + src + "\n  Destination Port:" + des + "\n  "
			+ "Weight:" + weight+ "\n  Cost: Rs." + cost + "";
}

public int getCost() {
	return cost;
}

public void setCost(int cost) {
	this.cost = cost;
}

public String getPhno() {
	return phno;
}

public void setPhno(String phno) {
	this.phno = phno;
}

public String getSrc() {
	return src;
}

public void setSrc(String src) {
	this.src = src;
}

public String getDes() {
	return des;
}

public void setDes(String des) {
	this.des = des;
}

public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	this.weight = weight;
}

}
