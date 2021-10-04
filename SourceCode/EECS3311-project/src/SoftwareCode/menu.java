package SoftwareCode;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;  

import java.util.ArrayList;

public class menu {

	
		ArrayList<ParkingSpace> PS_List = new ArrayList<ParkingSpace>();
		ArrayList<Customer> C_List = new ArrayList<Customer>();
		ArrayList<ParkingEnFOfficer> PEO_List = new ArrayList<ParkingEnFOfficer>();
		
		
        public void Start()
        {
        	this.read_customer();
        	this.read_PEO();
        	this.read_PS();
        }
        public void Store()
        {
        	this.store_Customer();
        	this.store_PEO();
        	this.store_PS();
        }
 	    public void read_customer()
	    {
	    	ArrayList<String> temp = new ArrayList<String>();
	    	try  
	    	{  
	    	
	    	 
	    	File file=new File("DataBase\\Customer");
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
	    		
	    		Customer m=new Customer();
	    		m.Set_name(a[0],a[1]);
	    		m.Set_acc(a[2], a[3]);
	    		m.L_status=Boolean.parseBoolean(a[4]);
	    		//System.out.println(a[4]);
	    		m.limit=Integer.parseInt(a[5]);
	    		this.C_List.add(m);
	    		
	    	}
	    }
        public void store_Customer()
	    {
	    	try {
	    	   
	    	FileWriter fileWriter = new FileWriter("DataBase\\Customer");
	        PrintWriter p = new PrintWriter(fileWriter);
	    	for(int i=0;i<C_List.size();i++)
	    	{
	    		Customer x=C_List.get(i);
	    		p.printf(x.F_name+","+x.L_name+","+x.Email+","+x.Pasword+","+x.L_status+","+x.limit);
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
            		System.out.print("DatabaseErorr  ");
            	}
            	
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
        public int Login(String email,String password)
        {
        	int val=0;
        	
        		int i;
                 for(i=0;i<this.C_List.size();i++)
                 {
                	 Customer x=this.C_List.get(i);
                	 
                	 if(x.isLog()&&x.Email.equals(email) && x.Pasword.equals(password))
                	 {
                		 //already logined
                		 val=1;
                		 break;
                	 }
                	 else if( x.Email.equals(email) && x.Pasword.equals(password))
                	 {	 
                		 //login succesfull
                		 val=2;
                		 x.L_status=true;
                		 break;
                	 }
                	 else
                	 {
                		 //login failed
                		 val=-1;
                	 }
                		 
                 }
                 
        	
        	return val;
        }
        public void Logout(String email)
        {
        	
        	
        		int i;
                 for(i=0;i<this.C_List.size();i++)
                 {
                	 Customer x=this.C_List.get(i);
                	 
                	  if( x.Email.equals(email))
                	 {	 
                		
                		 x.L_status=false;
                		 break;
                	 }
                		 
                 }
                 
        	
        	
        }
        public Boolean Reg(String fname,String lname,String Email,String Password)
        {
        	Customer x=new Customer();
        	x.Set_acc(Email, Password);
        	x.Set_name(fname, lname);
        	x.L_status=false;
        	x.limit=0;
        	if(this.C_List.contains(x))
        	{
        		return false;
        	}
        	this.C_List.add(x);
        	
        	return true;
        	
        }
        public int Book(String email,int Id,int L_P,int day,int month, int year,Double S_Time,Double E_time )
        {
        	
        	Boolean a;
    		int i,j;
    		for(i=0;i<this.C_List.size();i++)
    		{
    			Customer x=this.C_List.get(i);
    			
    			if(x.Email.equals(email))
    				break;
    		
    		}
    		
            for(j=0;j<this.PS_List.size();j++){
           	      ParkingSpace x=this.PS_List.get(j);
           	      if(x.getID()==Id)	 
           	      break;          	 
            }
            
             a=this.PS_List.get(j).getStatus();
             if(a)
             {
            	 return 1;
             }
             else if(this.C_List.get(i).limit>=3)
             {
            	 return -1;
             }
             
             else
             {
            	 this.PS_List.get(j).setStatus(true);
            	 this.PS_List.get(j).setB_id(10000+L_P+day+month+year);
            	 this.PS_List.get(j).book(email,L_P,day,month,year, S_Time, E_time);
            	 this.C_List.get(i).limit++;
            	 
            	 return 0;
             }
    	
    	
        }
        public Boolean Cancel(String email,int Id)
        {
        	
        	Boolean a;
    		int i,j;
    		for(i=0;i<this.C_List.size();i++)
    		{
    			Customer x=this.C_List.get(i);
    			if(x.Email.endsWith(email))
    				break;
    		
    		}
            for(j=0;j<this.PS_List.size();j++){
           	      ParkingSpace x=this.PS_List.get(j);
           	      if(x.getID()==Id)	 
           	      break;          	 
            }
             a=this.PS_List.get(j).getStatus() && PS_List.get(j).User.equals(email);
             
             if(a )
             {
            	 this.PS_List.get(j).setStatus(false);
            	 this.PS_List.get(j).setF_status(false);
            	 this.PS_List.get(j).book("",0,0,0,0,0.00, 0.00);
            	 this.PS_List.get(j).setB_id(0);
            	 this.C_List.get(i).limit--;
            	 this.Store();
            	 return a;
            	
             }
             else
             {
            	  return a;
             }
    	
    	
        }
        public Customer view_B(String email)
        {
        	int i=0;
        	Customer x=null;
        	for(;i<this.C_List.size();i++){
        		x=this.C_List.get(i);
        		if(x.Email.equals(email))
        		 break;
        	}
        	return x;
        }
        public int login_PEO(String email,String password)
        {
        	int i;
        	int j=0;
        	for(i=0;i<this.PEO_List.size();i++)
        	{
        	    ParkingEnFOfficer x=this.PEO_List.get(i);
        	    if(x.L_status)
        	    {
        	    	j=-1;
        	    	break;
        	    }
        	    else if(x.Email.equals(email)&& x.Pasword.equals(password))
        		{
        			j=1;
        			x.login();
        			break;
        		}
        			
        	}
        	return j;
        }
        public boolean logout_PEO(String email)
        {
        	int i;
        	boolean a=false;
        	for(i=0;i<this.PEO_List.size();i++)
        	{
        	    ParkingEnFOfficer x=this.PEO_List.get(i);
        	    if( x.Email.equals(email))
        	    {
        	    	a=true;
        			x.logout();
        			break;
        	    }
        			
        	}
        	return a;
        }
        public Boolean add_PS(String email,String loc, int id)
        {
        	ParkingSpace y=new ParkingSpace();
    		y.new_PS(loc, id);
        	if(this.PS_List.contains(y))
        	{
        		return false;
        	}
        	else
        	{
        		ParkingEnFOfficer x =this.find_PEO(email);
        		this.PS_List=x.add_P(loc, id);
        		return true;
        	}
        	
        }
        public int remove_PS(String email,int id)
        {
        	int j=this.find_PS(id);
        	
        	if(j!=-1&&this.PS_List.get(j).f_status)
        	{
        		return -1;
        	}
        	else if(j>=0)
        	{
        		ParkingEnFOfficer x =this.find_PEO(email);
        		this.PS_List=x.remove_P(id);
        		
        		return 0;
        		
        	}
        	else
        	{
        		
        		return 1;
        	}
        	
        }
        
        public ParkingEnFOfficer find_PEO(String email)
        {
        	for(ParkingEnFOfficer x:this.PEO_List )
        	{
        		if(x.Email.equals(email))
        		{
        			return x;
        		}
        		
        		
        	}
        	return null;
        }
        public Customer find_C(String Email)
        {
        	for(Customer x:this.C_List )
        	{
        		if(x.Email.equals(Email))
        		{
        			return x;
        		}
        	}
        	return null;
        }
        public int find_PS(int id)
        {
        	int i=0;
        	for(ParkingSpace x:this.PS_List )
        	{
        		
        		if(x.getID()==id)
        		{
        			return i;
        		}
        		i++;
        		
        	}
        	return -1;
        	
        }
        public String find_List(String email)
        {
        	String str="";
        	for(ParkingSpace x:this.PS_List)
        	{
        		if(x.getUser().equals(email))
        		{
        			str=str+"Location:-"+x.Location+" Id="+x.getID()+" car="+x.licPlate+"\nDate="+x.day+"/"+x.month+"/"+x.year+" Booking No="+x.getB_id()+"\nStart Time="+x.Start_t+" End Time="+x.End_time+"\nBooking Status="+x.isF_status()+"\n\n";
        		}
        	}
        	return str;
        	
        }
		public ArrayList<ParkingSpace> getPS_List() {
			return PS_List;
		}
		public void setPS_List(ArrayList<ParkingSpace> pS_List) {
			PS_List = pS_List;
		}
		public ArrayList<Customer> getC_List() {
			return C_List;
		}
		public void setC_List(ArrayList<Customer> c_List) {
			C_List = c_List;
		}
		public ArrayList<ParkingEnFOfficer> getPEO_List() {
			return PEO_List;
		}
		public void setPEO_List(ArrayList<ParkingEnFOfficer> pEO_List) {
			PEO_List = pEO_List;
		}
        public void refresh()
        {
         LocalDateTime now = LocalDateTime.now();  
   		 int D=now.getDayOfMonth();
   		 int M=now.getMonthValue();
   		 int Y=now.getYear();
   		 double T=(double)now.getHour()+(double)now.getMinute()*0.01;
   		 for( ParkingSpace x: this.PS_List)
   		 {
   			 if(x.day==D&&x.month==M&&x.year==Y&&x.End_time<=T)
   			 {
   				 this.Cancel(x.User,x.getID());
   			 }
   		 }

        }
        
        	
        
        
}
