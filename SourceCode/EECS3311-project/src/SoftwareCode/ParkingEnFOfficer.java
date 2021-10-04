package SoftwareCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class ParkingEnFOfficer extends Person{

	private int ID;
	ArrayList<ParkingSpace> PS_List = new ArrayList<ParkingSpace>();
	public void Set_name(String F_name, String L_name) {
		this.F_name=F_name;
		this.L_name=L_name;
		

	}

	
	public void Set_acc(String Email, String Password) {
		this.Email=Email;
		this.Pasword=Password;
		this.L_status=false;

	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}
	public Boolean isLog()
    {
    	return this.L_status;
    }
	public void login()
	{
		this.L_status=true;
		this.read_PS();
		
	}
	public void logout()
	{
		this.L_status=false;
	}
 	public ArrayList<ParkingSpace>  add_P(String Location,int Id)
	{
 		this.read_PS();
		ParkingSpace x=new ParkingSpace();
		x.new_PS(Location, Id);
		
			this.PS_List.add(x);
			
			return this.PS_List;
		
	}
 	public ArrayList<ParkingSpace>  remove_P(int Id)
	{
 		this.read_PS();
		
		for(int i=0;i<this.PS_List.size();i++)
		{
			if(this.PS_List.get(i).getID()==Id)
			{
				this.PS_List.remove(i);
				break;
			}
		}
			
			
			return this.PS_List;
		
	}
 	
	public void read_PS()
    {
    	ArrayList<String> temp = new ArrayList<String>();
    	try  
    	{  
    	      
    		File file=new File("DataBase\\ParkingSpace");
	    	Scanner sc=new Scanner(file);       
    	while(sc.hasNextLine())  
    	{  
    	     temp.add(sc.nextLine());
    	}  
    	sc.close();     //closes the scanner  
    	}  
    	catch(Exception e)  
    	{ 
    	   System.out.print("Data_base_error");
    	}
    	for(int i=0;i<temp.size();i++)
    	{
    		String x=temp.get(i);
    		String a[]=x.split(",");
    		ParkingSpace m=new ParkingSpace();
    		m.setID(Integer.parseInt(a[0]));
    		m.setLocation(a[1]);
    		m.setStatus(Boolean.parseBoolean(a[2]));
    		m.setUser(a[3]);
    		m.setLicPlate(Integer.parseInt(a[4]));
    		m.setDay(Integer.parseInt(a[5]));
    		m.setMonth(Integer.parseInt(a[6]));
    		m.setYear(Integer.parseInt(a[7])); 		
    		m.setStart_t(Double.parseDouble(a[8]));
    		m.setEnd_time(Double.parseDouble(a[9]));
    		m.setB_id(Integer.parseInt(a[10]));
    		m.setF_status(Boolean.parseBoolean(a[11]));
    		this.PS_List.add(m);
    	}
    }

    public void store_PS()
    {
    	try {
	    	FileWriter fileWriter = new FileWriter("Database\\ParkingSpace");
	        PrintWriter p = new PrintWriter(fileWriter);
	    	for(int i=0;i<PS_List.size();i++)
	    	{
	    		ParkingSpace x=PS_List.get(i);
	    		
	    		{
	    		p.printf(x.getID()+","+x.getLocation()+","+x.getStatus()+","+x.getUser()+","+x.getLicPlate()+","+x.getDay()+","+x.getMonth()+","+x.getYear()+","+x.getEnd_time()+","+x.getEnd_time()+","+x.getB_id()+","+x.isF_status());
	    		p.println();
	    		}
	    	}
	    	p.close();
	    	fileWriter.close();
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.print("DatabaseErorr  "+e);
	    	}
    }

	public String toString()
	   {
		   
		   return("F="+this.F_name+"  L="+this.L_name+"  E="+this.Email+"  P="+this.Pasword+"  S="+this.L_status+"  ID="+this.ID);
	   }


	

	@Override
	public boolean equals(Object obj) {
		ParkingEnFOfficer x=(ParkingEnFOfficer)obj;
		if(this.ID==x.ID && this.Email.equals(x.Email))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
