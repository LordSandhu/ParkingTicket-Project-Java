package SoftwareCode;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Payment {
  
	  ArrayList<Integer> Paid=new ArrayList<Integer>();
      ArrayList<Integer> not_Paid=new ArrayList<Integer>();
      public void read_p()
      {
  	   String paid=null;
  	   String unpaid=null;	   
       try  
  	   {  	 
  	   File file=new File("DataBase\\payments");
  	   Scanner sc=new Scanner(file);     
  	   paid=sc.nextLine(); 
  	   unpaid=sc.nextLine();
  	   sc.close(); 
  	   String a[]=paid.split(",");
	   String b[]=unpaid.split(",");
		for(int y=0;y<a.length;y++)
		{
			Paid.add(Integer.parseInt(a[y]));
		}
		for(int y=0;y<b.length;y++)
		{
			not_Paid.add(Integer.parseInt(b[y]));
		}
  	   }  
  	   catch(Exception e)  
  	   { 
  	    System.out.print("Data_base_error");
  	   }
  		
  		
  	}
      public void npaid(int id)
      {
    	  this.not_Paid.add(id);
      }
      public void ypaid(int id)
      {
    	  int i=this.not_Paid.indexOf(id);
    	  
    	  this.not_Paid.remove(i);
    	  this.Paid.add(id);
      }
      public int contain(int id)
      {
    	  if(this.not_Paid.contains(id))
    	  {
    		  return 1;
    	  }
    	  else if(this.Paid.contains(id))
    	  {
    		  return -1;
    	  }
    	  else
    	  {
    		  return 0;
    	  }
      }
      public void remove(int id)
      {
    	  int i=this.contain(id);
    	  if(i==1)
    	  {
    		  int z=this.not_Paid.indexOf(id);
    		  this.not_Paid.remove(z);
    	  }
    	  if(i==-1)
    	  {
    		  int z=this.Paid.indexOf(id);
    		  this.Paid.remove(z);
    	  }
      }
      public void write_p()
      {
    	  try{
    		     
    		     
	    	     FileWriter fileWriter = new FileWriter("DataBase\\payments",false);
  	             PrintWriter p = new PrintWriter(fileWriter);
  	             
  	             p.printf(Paid.get(0).toString());
  	    	     for(int i=1;i<Paid.size();i++)
  	    	      {
  	    		   p.printf(","+Paid.get(i).toString());	
  	    		   
  	              }
  	    	      p.println();
  	    	      p.printf(not_Paid.get(0).toString());
  	    	    for(int i=1;i<not_Paid.size();i++)
	    	      {
	    		   p.printf(","+not_Paid.get(i).toString());		
	              }
  	    	      p.close();
  	    	      fileWriter.close();
  	    	  }
  	      catch(Exception e)
  	    	{
  	    		System.out.print("DatabaseErorr  "+e);
  	    	}
      }
}
