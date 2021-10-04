package SoftwareCode;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestCases {

	menu x;
	Payment pay;
	@Before
	public void setUp() throws Exception {
		x=new menu();
		pay=new Payment();
		Customer c1=new Customer();
		c1.Set_name("fname","lname");
		c1.Set_acc("abc","123");
		c1.L_status=true;
		x.C_List.add(c1);
		Customer c2=new Customer();
		c2.Set_name("Fname","Lname");
		c2.Set_acc("def","456");
		c2.L_status=false;
		x.C_List.add(c2);
		
		ParkingSpace p1=new ParkingSpace();
		p1.new_PS("tims", 1234);
		x.PS_List.add(p1);
		ParkingSpace p2=new ParkingSpace();
		p2.new_PS("Starbucks", 4568);
		x.PS_List.add(p1);
		
		ParkingEnFOfficer peo=new ParkingEnFOfficer();
		peo.Set_name("qwe","rty");
		peo.Set_acc("sss","sss");
		x.PEO_List.add(peo);
		
		pay.not_Paid.add(0);
		pay.not_Paid.add(0);
		pay.npaid(1234);
		pay.Paid.add(0);
		pay.Paid.add(0);
		pay.Paid.add(4568);
		
		
				
	}
	@Test
	public void DataBase()
	{
		x.Start();
		x.Store();
		x.view_B("abc");	
		pay.read_p();
		pay.write_p();
	}
	
	//Already Customer Logged in
	@Test
	public void login_customer1() {
		Assert.assertEquals(1,x.Login("abc","123"));
	}
	//Wrong ID or Password
	@Test
	public void login_customer2() {
		Assert.assertEquals(-1,x.Login("abd","123"));
		Assert.assertEquals(-1,x.Login("abc","1233"));
	}
	//correct login
	@Test
	public void login_customer3() {
		Assert.assertEquals(2,x.Login("def","456"));
	}
	//wrong register
	@Test
	public void register_customer1() {
		assertFalse(x.Reg("Fname","Lname", "def","456"));
	}
	@Test
	public void register_customer2() {
		assertTrue(x.Reg("Fname","Lname", "has","123"));
	}
	@Test
	public void booking1() {
		Assert.assertEquals(0,x.Book("abc",1234, 8222, 23, 2, 2021, 2.3, 6.9));
	}
	@Test
	public void booking2() {
		
		Assert.assertEquals(0,x.Book("abc",1234, 8222, 23, 2, 2021, 2.3, 6.9));
		Assert.assertEquals(1,x.Book("abc",1234, 8222, 23, 2, 2021, 2.3, 6.9));
	}
	@Test
	public void booking3() {
		x.C_List.get(1).limit=3;
		Assert.assertEquals(-1,x.Book("def",1234, 8222, 23, 2, 2021, 2.3, 6.9));
	}
	
	@Test
	public void Logout_Customer()
	{
		x.Logout("abc");
		Assert.assertFalse(x.C_List.get(0).L_status);
	}
	@Test
	public void Cancel()
	{
		
		
		x.Book("def",1234, 1, 1,1, 1, 23.3, 23.6);
		Assert.assertTrue(x.Cancel("def",1234));
	}
	@Test
	public void Cancel2()
	{
		
		
		x.Book("def",1234, 1, 1,1, 1, 23.3, 23.6);
		Assert.assertFalse(x.Cancel("abc",1234));
	}
	@Test
	public void login_peo()
	{
		
		Assert.assertTrue(x.login_PEO("ss","sss")==0);
		
		Assert.assertTrue(x.login_PEO("sss","sss")==1);
		
		Assert.assertTrue(x.login_PEO("sss","sss")==-1);
		
	}
	@Test
	public void logout_peo()
	{
		
		
		Assert.assertFalse(x.logout_PEO("ss"));
		Assert.assertTrue(x.login_PEO("sss","sss")==1);
		Assert.assertTrue(x.logout_PEO("sss"));
			
	}
	@Test
	public void add_parkingSpace()
	{
		Assert.assertTrue(x.add_PS("sss","mac",12378));
		Assert.assertFalse(x.add_PS("sss","mac",12378));
	}
	@Test
	public void remove_parkingSpace()
	{
		Assert.assertTrue(x.remove_PS("sss",134)==1);
		Assert.assertTrue(x.remove_PS("sss",1234)==0);
		
		
	}
	@Test
	public void remove_parkingSpace2()
	{
		x.PS_List.get(0).f_status=true;
		Assert.assertTrue(x.remove_PS("sss",1234)==-1);
		
	}
	@Test
	public void extra_fuctions()
	{
		ParkingEnFOfficer m=new ParkingEnFOfficer();
		m.read_PS();
		m.store_PS();
		x.Book("abc",1234, 8222, 23, 2, 2021, 2.3, 6.9);
		x.find_List("abc");
		Assert.assertEquals(x.C_List.get(0),x.find_C("abc"));
		
		Assert.assertEquals(x.PEO_List.get(0),x.find_PEO("sss"));
		
		Assert.assertEquals(0,x.find_PS(1234));
		
		Assert.assertEquals(x.PEO_List,x.getPEO_List());
		
		Assert.assertEquals(x.C_List,x.getC_List());
		
		Assert.assertEquals(x.PS_List,x.getPS_List());
		
		
	}
	@Test
	public void admin_check()
	{
		Admin ad=new Admin();
		Assert.assertTrue(ad.Login("Admin","testpass"));
		
		Assert.assertFalse(ad.Login("A234dmin","testpass"));
		
		ad.logout();
		Assert.assertTrue(!ad.Status);
		
		Assert.assertTrue(ad.add_PEO("mexy","kilo","yoyo","ashd"));
		
		Assert.assertFalse(ad.add_PEO("mexy","kilo","yoyo","ashd"));
		
		Assert.assertTrue(ad.delete_PEO("yoyo".hashCode()));
		
		Assert.assertFalse(ad.delete_PEO("yoyo".hashCode()+1234));
		
		ad.read_PEO();
		ad.store_PEO();
		Assert.assertEquals(ad.PEO_List,ad.getPEO_List());
		
		
		
		
	}
	@Test
	public void ref()
	{
		 LocalDateTime now = LocalDateTime.now();  
		 int D=now.getDayOfMonth();
   		 int M=now.getMonthValue();
   		 int Y=now.getYear();
   		 double T=(double)now.getHour()+(double)now.getMinute()*0.01;
		 x.PS_List.get(0).End_time=T-1;
		 x.refresh();
		 Assert.assertFalse( x.PS_List.get(0).getStatus());
		
	}
	@Test
	public void check_Payment()
	{
		Assert.assertEquals(1,pay.contain(1234));
		Assert.assertEquals(-1,pay.contain(4568));
		Assert.assertEquals(0,pay.contain(1223));
		pay.ypaid(1234);
		
		
	}
	
	

}
