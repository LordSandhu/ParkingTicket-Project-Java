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

public class Book extends JFrame {

	private JPanel contentPane;
	public String email;
	public menu x;
	private JTextField month;
	private JTextField year;
	private JTextField S_time;
	private JTextField day;
	private JTextField ID;
	private JTextField E_time;
	private JTextField L_P;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	

	

	/**
	 * Create the frame.
	 */
	public Book(String y) {
		setTitle("Booking Parking Space");
		x=new menu();
		email=y;
		x.Start();
		SoftwareCode.Payment pay=new SoftwareCode.Payment();
		pay.read_p();
		LocalDateTime now = LocalDateTime.now();  
		 int D=now.getDayOfMonth();
		 int M=now.getMonthValue();
		 int Y=now.getYear();
		 double T=(double)now.getHour()+(double)now.getMinute()*0.01;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_W x=new Login_W(email);
				x.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Parking Space ID:-");
		
		JLabel lblDate = new JLabel("Till Date:-");
		
		JLabel lblStartingTime = new JLabel("Starting Time:-");
		
		JLabel lblEndingTime = new JLabel("Ending Time:-");
		
		JLabel lblLicPlate = new JLabel("Car Lic Plate #:-");
		
		ID = new JTextField();
		ID.setColumns(10);
		
		day = new JTextField();
		day.setColumns(10);
		
		S_time = new JTextField();
		S_time.setColumns(10);
		
		E_time = new JTextField();
		E_time.setColumns(10);
		
		L_P = new JTextField();
		L_P.setColumns(10);
		
		month = new JTextField();
		month.setColumns(10);
		
		year = new JTextField();
		year.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("format:-hour.minutes(ex:- 3.20 means 3:20 am");
		
		JLabel lblNewLabel_1_1 = new JLabel("format:-hour.minutes(ex:- 3.20 means 3:20 am");
		
		JLabel lblNewLabel_2 = new JLabel("dd/mm/yyyy (only numbers please)");
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				x.Logout(email);
				x.Store();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int id,l,d,m,y;
					double s_t,e_t;
					id=Integer.parseInt(ID.getText());
					l=Integer.parseInt(L_P.getText());
					d=Integer.parseInt(day.getText());
					m=Integer.parseInt(month.getText());
					y=Integer.parseInt(year.getText());
					s_t=Double.parseDouble(S_time.getText());
					e_t=Double.parseDouble(E_time.getText());
					boolean a=(d<1||d>31)||(m<0||m>12)||(e_t>23.59);
					boolean v=s_t>e_t||(y==Y?(m==M?d<D:false):false)||(y==Y?m<M:false)||y<Y;
					if(a)
					{
						JOptionPane.showMessageDialog(null,"Check your Info and Please try the format given");
						
					}
					else if(v)
					{
						JOptionPane.showMessageDialog(null,"Checking your booking time or Date");
						
					}
					else if(!a)
					{
						int j=x.Book(email, id, l, d, m, y,s_t, e_t);
						if(j==0)
						{
						JOptionPane.showMessageDialog(null,"Temporary booked, you can pay now");
						pay.npaid(id);
						pay.write_p();
						x.Store();
						
						}
						else if(j<0)
						{
							JOptionPane.showMessageDialog(null,"Sorry cant book more then 3");
						}
						else
						JOptionPane.showMessageDialog(null,"Sorry Already Booked");
					}
					

				}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(null,"Input in wrong, please check id from list");
				}
			}
		});
		
		btnNewButton_1 = new JButton("Payment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment x=new Payment(email);
				x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				x.setVisible(true);
				
				
				}
		});
		
		JButton btnNewButton_3 = new JButton("List");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PS_list x=new PS_list(email);
				x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				x.setVisible(true);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblLicPlate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEndingTime, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblStartingTime, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(S_time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(E_time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
								.addComponent(L_P, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(day, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(month, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(year, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartingTime)
						.addComponent(S_time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndingTime)
						.addComponent(E_time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLicPlate)
						.addComponent(L_P, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addGap(33)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
