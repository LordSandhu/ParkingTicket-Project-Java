package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import SoftwareCode.ParkingSpace;
import SoftwareCode.menu;

public class GRq extends JFrame {

	private JPanel contentPane;
    String email;
    menu x;
    private JTextField ID;
    private JTextArea textArea;
	String z;

	/**
	 * Create the frame.
	 */
	public GRq(String y) {
		setTitle("Grant Request");
		email=y;
		x=new menu();
		x.Start();
		 z="";
		int size=x.getPS_List().size();
		for(int i=0;i<size;i++)
		{
			ParkingSpace p=x.getPS_List().get(i);
			z=z+"\nLocation="+p.getLocation()+"  Id="+p.getID()+"\nRequest="+(p.getStatus()?"Yes":"no")+"  Granted="+(p.isF_status()?"Yes":"no"+"\n");
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PEO_main a=new PEO_main(email);
				a.setVisible(true);
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("ID:-");
		
		ID = new JTextField();
		ID.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Grant");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					//System.out.print(x.getPS_List().get(0).isF_status());
					String h=ID.getText();
					int id=Integer.parseInt(h);
					int size=x.getPS_List().size();
					int t=0;
					for(int i=0;i<size;i++)
					{
						ParkingSpace p=x.getPS_List().get(i);
						if(p.getID()==id)
						{
							t=1;
							if(p.isF_status())
							{
								JOptionPane.showMessageDialog(null,"Already granted");
							}
							else if(!p.getStatus())
							{
								JOptionPane.showMessageDialog(null,"Not requested");
							}
							else
							{
								x.getPS_List().get(i).setF_status(true);
								x.getPS_List().get(i).setStatus(true);
								x.Store();
								JOptionPane.showMessageDialog(null,"Granted ,please refresh");
								
							}
							break;
						}
						
						
					}
					if(t==0)
					{
						JOptionPane.showMessageDialog(null,"Wrong Id");

					}
					
					
				}
				catch (Exception z)
				{
					JOptionPane.showMessageDialog(null,"wrong Input");
					
				}
				 
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GRq x=new GRq(email);
				x.setVisible(true);
				dispose();
				
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(345, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		System.out.print(size);
		textArea = new JTextArea();
		textArea.setText(z);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
		
		
	}

}
