package SoftwareCode;
import java.util.*;
public class ParkingSpace {
   private int ID;
   String Location;
   Boolean Status;
   String User;
   int licPlate;
   int day;
   int month;
   int year;
   Double Start_t;
   Double End_time;
   int b_id;
   boolean f_status;
   public void new_PS(String location,int number)
   {
	   this.Location=location;
	   this.ID=number;
	   this.Status=false;
	   this.User=null;
	   this.licPlate=0;
	   this.day=0;
	   this.month=0;
	   this.year=0;
	   this.b_id=0;
	   this.Start_t=0.00;
	   this.End_time=0.00;
	   this.f_status=false;
	   
	   
	   
   }
 public int getID() {
	return ID;
} 
public void setID(int iD) {
	ID = iD;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
public Boolean getStatus() {
	return Status;
}
public void setStatus(Boolean status) {
	Status = status;
}
public String getUser() {
	return User;
}
public void setUser(String user) {
	User = user;
}
public Double getStart_t() {
	return Start_t;
}
public void setStart_t(Double start_t) {
	Start_t = start_t;
}
public Double getEnd_time() {
	return End_time;
}
public void setEnd_time(Double end_time) {
	End_time = end_time;
}
public void book(String user,int L_P,int d,int m, int y,Double s, Double e)
{
	this.User=user;
	this.licPlate=L_P;
	this.day=d;
	this.month=m;
	this.year=y;
	this.Start_t=s;
	this.End_time=e;
	this.f_status=false;
	
}

@Override
public String toString() {
	
	
	return "ParkingSpace [ID=" + ID + ", Location=" + Location + ", Status=" + Status + ", User=" + User+", L_plate="+licPlate+", Date="+day+"/"+month+"/"+year+", Start_t="
			+ Start_t + ", End_time=" + End_time + "]";
}

@Override
public boolean equals(Object obj) {
	ParkingSpace x=(ParkingSpace)obj;
	if(this.ID==x.ID)
	{
		return true;
	}
	else
		return false;
}


public int getLicPlate() {
	return licPlate;
}
public void setLicPlate(int licPalte) {
	this.licPlate = licPalte;
}
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getB_id() {
	return b_id;
}
public void setB_id(int b_id) {
	this.b_id = b_id;
}
public boolean isF_status() {
	return f_status;
}
public void setF_status(boolean f_status) {
	this.f_status = f_status;
}

}
