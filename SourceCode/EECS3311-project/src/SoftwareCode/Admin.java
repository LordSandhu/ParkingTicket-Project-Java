package SoftwareCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
String user="Admin";
String password="testpass";
boolean Status;
ArrayList<ParkingEnFOfficer> PEO_List = new ArrayList<ParkingEnFOfficer>();
public Boolean Login(String user,String paswword)
{
	if(this.user.equals(user)&& this.password.equals(paswword))
	{
		this.Status=true;
		this.read_PEO();
		return this.Status;
	}
	else
	{
		this.Status=false;
		return this.Status;
	}
}
public void logout() 
{
	this.store_PEO();
	this.Status=false;
}

public boolean add_PEO(String fname,String lname,String email,String password)
{
	
	ParkingEnFOfficer x= new ParkingEnFOfficer();
	x.Set_acc(email, password);
	x.Set_name(fname, lname);
	x.setID(email.hashCode());
	if(this.PEO_List.contains(x))
	{
		return false;
	}
	else
	{
	this.PEO_List.add(x);
	this.store_PEO();
	return true;
	}
}
public boolean delete_PEO(int has)
{
	boolean a=false;
	for(int i=0;i<this.PEO_List.size();i++)
	{
		
		if(this.PEO_List.get(i).Email.hashCode()==has)
		{
			this.PEO_List.remove(i);
			a=true;
			break;
		}
	}
	return a;
}
public void read_PEO()
{
	ArrayList<String> temp = new ArrayList<String>();
	try  
	{  
		File file=new File("DataBase\\PEO");
    	Scanner sc=new Scanner(file);    
	      
	      
	while(sc.hasNextLine())  
	{  
	     temp.add(sc.nextLine());
	}  
	sc.close();     //closes the scanner  
	}  
	catch(Exception e)  
	{ 
	   System.out.print("Data_base_error"+e);
	}
	for(int i=0;i<temp.size();i++)
	{
		String x=temp.get(i);
		String a[]=x.split(",");
		ParkingEnFOfficer m=new ParkingEnFOfficer();
		m.Set_name(a[0],a[1]);
		m.Set_acc(a[2], a[3]);
		m.L_status=false;
		m.setID(Integer.parseInt(a[5]));
		this.PEO_List.add(m);
	}
}
public void store_PEO()

{
	try {
    	FileWriter fileWriter = new FileWriter("Database\\PEO");
        PrintWriter p = new PrintWriter(fileWriter);
    	for(int i=0;i<PEO_List.size();i++)
    	{
    		ParkingEnFOfficer x=PEO_List.get(i);
    		p.printf(x.F_name+","+x.L_name+","+x.Email+","+x.Pasword+","+x.L_status+","+x.getID());
    		p.println();
    	}
    	p.close();
    	fileWriter.close();
    	}
    	catch(Exception e)
    	{
    		System.out.print("DatabaseErorr  "+e);
    	}
    	
}
public ArrayList<ParkingEnFOfficer> getPEO_List() {
	return PEO_List;
}
public void setPEO_List(ArrayList<ParkingEnFOfficer> pEO_List) {
	PEO_List = pEO_List;
}

}
