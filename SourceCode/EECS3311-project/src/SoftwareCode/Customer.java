package SoftwareCode;
import java.awt.List;
import java.io.*;
import java.util.*;

public class Customer extends Person {

	
	public int limit;
	public void Set_name(String F_name, String L_name) {
		this.F_name=F_name;
		this.L_name=L_name;
		

	}

	
	public void Set_acc(String Email, String Password) {
		this.Email=Email;
		this.Pasword=Password;

	}

	
	public void Store_toDatabase() {
		
		
	}


	


	
    public Boolean check_limit()
    { 
    	
    	if(limit<4)
    	{
    		return true;
    	}
    	return false;
    }
   public  Boolean isLog()
    {
    	return this.L_status;
    }
   





@Override
public boolean equals(Object obj) {
	Customer x=(Customer)obj;
	if(this.Email.equals(x.Email))
		return true;
	return false;
	
}


@Override
public String toString() {
	return  ", F_name=" + F_name + ", L_name=" + L_name + ", Email=" + Email
			+ ", Pasword=" + Pasword + ", L_status=" + L_status+"limit="+limit;
}


 
  
   
    
}
