package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import SoftwareCode.menu;

public class Cancel extends JFrame {

	private JPanel contentPane;
	public String email;
	menu x;
	private JTextField Id;
	private JTextField B_Id;

	
	public Cancel(String q) {
		setTitle("Canceling Parking Space");
		
		email=q;
		x=new menu();
		x.Start();
		SoftwareCode.Payment pay= new SoftwareCode.Payment();
		pay.read_p();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				x.Logout(email);
				x.Store();
			}
		});
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_W x=new Login_W(email);
				x.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Parking Space id");
		
		JLabel lblBookingId = new JLabel("Booking ID");
		
		Id = new JTextField();
		Id.setColumns(10);
		
		B_Id = new JTextField();
		B_Id.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					int c=-1;
					int i;
					String u=Id.getText();
					String p=B_Id.getText();
					if(u.length()==0||p.length()==0)
					{
						throw new Exception("wrong parking space id ");
					}
				     int id=Integer.parseInt(u);
				     int b_id=Integer.parseInt(p);
					int size=x.getPS_List().size();
				     for(i=0;i<size;i++)
				     {
				    	 if(x.getPS_List().get(i).getID()==id)
				    	 {
				    		 c=i;
				    		 break;
				    	 }
				     }
				     if(c==-1)
				     {
				    	 throw new Exception("wrong parking space id");
				     }
				     else
				     {
				    	 if(!x.getPS_List().get(i).getUser().equals(email))
				    	 {
				    		 throw new Exception("sorry this Parking Space is not booked by you");
				    	 }
				    	 else
				    	 {
				    		 if(!(x.getPS_List().get(i).getB_id()==b_id))
				    		 {
				    			throw new Exception("Wrong Booking id");
				    		 }
				    		 else
				    		 {
				    			 x.Cancel(email, id);
				    			 x.Store();
				    			 pay.remove(id);
				    			 pay.write_p();
				    			 JOptionPane.showMessageDialog(null,"canceled");
				    			 Login_W f=new Login_W(email);
				    			 f.setVisible(true);
				    			 dispose();
				    			 
				    		 }
				    	 }
				     }
				     
				}
				catch(Exception z)
				{
					JOptionPane.showMessageDialog(null,z.getMessage());
				}
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("List");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View x=new View(email);
				x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				x.setVisible(true);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(331, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(144, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBookingId, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(B_Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(235, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookingId)
						.addComponent(B_Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
