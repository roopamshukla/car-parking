import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class print_ticket implements ActionListener {

	auto_mail am=new auto_mail();
	String input_id;
	int slot_no;
	int flag=0;
	public void variables3(String id,int sn)
	{
		input_id=id;
		slot_no=sn;
	}
	public JFrame frame;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					print_ticket window = new print_ticket();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public print_ticket() {
		initialize();
	}

	public void initialize() {
		
		frame = new JFrame("Print Ticket");
		frame.setBounds(450, 175, 768, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblPrintTicket = new JLabel("PRINT TICKET",JLabel.CENTER);
		lblPrintTicket.setBackground(Color.WHITE);
		lblPrintTicket.setOpaque(true);
		lblPrintTicket.setBounds(242, 22, 280, 30);
		frame.getContentPane().add(lblPrintTicket);
		Font label_font= new Font("ARIAL",Font.TRUETYPE_FONT,24);
		lblPrintTicket.setFont(label_font);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed(e);
			}
		});
		textField.setBounds(217, 178, 354, 35);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(lblPrintTicket);
		Font label_font5= new Font("ARIAL",Font.TRUETYPE_FONT,19);
		textField.setFont(label_font5);
		textField.setColumns(10);
		
		JLabel lblEmailId = new JLabel("E-Mail ID");
		lblEmailId.setBounds(324, 131, 170, 35);
		frame.getContentPane().add(lblEmailId);
		Font label_font1= new Font("ubuntu",Font.CENTER_BASELINE,30);
		lblEmailId.setFont(label_font1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setBounds(306, 225, 160, 35);
		frame.getContentPane().add(btnSubmit);
		Font label_font2= new Font("NanumGothic",Font.CENTER_BASELINE,18);
		btnSubmit.setFont(label_font2);
		
		JButton btnPrintErs = new JButton("PRINT ERS");
		btnPrintErs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter f=new FileWriter("ERS_Ticket.txt");
					BufferedWriter b=new BufferedWriter(f);
					Date date =new Date();
					SimpleDateFormat ft = new SimpleDateFormat ("'\nDate : 'E dd-MM-yyyy '\nTime : ' hh:mm:ss a zzz");
					String date1=ft.format(date);
					b.write("Hi! "+input_id+"\nCongratulations!\nYou have a booking confirmed to User ID "+input_id+".\nSlot number : "+slot_no+"."+date1);
					b.close();
					f.close();
					JOptionPane.showMessageDialog(null, "ERS Printed.","Alert",0);
					Runtime rs = Runtime.getRuntime();
					rs.exec("gedit ERS_Ticket.txt ");
					user_id u=new user_id();
					frame.dispose();
					u.initialize();
					u.frame.setVisible(true);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnPrintErs.setBounds(306, 364, 170, 40);
		Font label_font4= new Font("NanumGothic",Font.CENTER_BASELINE,18);
		btnPrintErs.setFont(label_font4);
		frame.getContentPane().add(btnPrintErs);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_id u=new user_id();
				frame.dispose();
				u.initialize();
				u.frame.setVisible(true);
			}
		});
		btnHome.setBounds(12, 426, 74, 30);
		frame.getContentPane().add(btnHome);
		Font label_font3= new Font("NanumGothic",Font.CENTER_BASELINE,12);
		btnHome.setFont(label_font3);
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		btnActionPerformed(e);
	}
	public void btnActionPerformed(ActionEvent e) {
		
		
		String recipient=textField.getText();
		if(textField.getText().equals(""))
		{
		JOptionPane.showMessageDialog(null, "Field is empty.","Alert",0);
		return;
		}
		for(int i=0;i<recipient.length();i++)
		{
			if(recipient.charAt(i)=='@')
			{
				flag=1;
				break;
			}
			else
			{
				flag=0;
			}
		}
		if(flag==1)
		{
			am.send_mail(recipient,slot_no,input_id);
			try {
				FileWriter f=new FileWriter("ERS_Ticket.txt");
				BufferedWriter b=new BufferedWriter(f);
				Date date =new Date();
				SimpleDateFormat ft = new SimpleDateFormat ("'\nDate : 'E dd-MM-yyyy '\nTime : ' hh:mm:ss a zzz");
				String date1=ft.format(date);
				b.write("Hi! "+input_id+"\nCongratulations!\nYou have a booking confirmed to User ID "+input_id+".\nSlot number : "+slot_no+"."+date1);
				b.close();
				f.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "E-mail has been been sent to :\n"+recipient,"Alert",0);		
		}
		else
		{
		JOptionPane.showMessageDialog(null, "Invalid e-mail Address\nShould contain '@'","Alert",0);
		textField.setText("");
		return;
		}
	}
}
