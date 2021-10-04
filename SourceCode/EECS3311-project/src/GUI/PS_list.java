package GUI;
import SoftwareCode.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;

public class PS_list extends JFrame {

	private JPanel contentPane;
    menu x;
    private JTextArea textArea;
	
	public PS_list(String y) {
		x=new menu();
		x.Start();
		String email=y;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		String s="";
		for(int i=0;i<x.getPS_List().size();i++)
		{
			ParkingSpace ps=x.getPS_List().get(i);
			s=s+(i+1)+". Loaction="+ps.getLocation()+"  Id="+ps.getID()+"  Already Book="+((ps.getStatus()||ps.isF_status())?"Yes":"No")+"\n\n";
			
			
		}
		System.out.print(x.getPS_List().toString());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
		);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
		textArea.setText(s);
		textArea.setEditable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
		       
				
				x.Store();
			}
		});
	}

}
