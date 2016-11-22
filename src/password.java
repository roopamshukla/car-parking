import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class password extends user_id{
	int status;
	String input_id;
	int same=0;
	public void variables(int stat,String id)
	{
		status=stat;
		input_id=id;
		
	}
	
	public JFrame frame;
	private JPasswordField passwordField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					password window = new password();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public password() {
		initialize();
	}
	public void initialize() {
		
		
		frame = new JFrame("Login Window | Password");
		frame.setBounds(450, 175, 768, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel label2 = new JLabel("Password");
		label2.setBounds(324, 131, 170, 35);
		frame.getContentPane().add(label2);
		Font label_font= new Font("ubuntu",Font.CENTER_BASELINE,30);
		label2.setFont(label_font);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 178, 354, 35);
		frame.getContentPane().add(passwordField);
		Font label_font3= new Font("ubuntu",Font.CENTER_BASELINE,24);
		passwordField.setFont(label_font3);
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed(e);
			}
		});
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setBounds(316, 225, 160, 35);
		frame.getContentPane().add(btnSubmit);
		Font label_font1= new Font("NanumGothic",Font.CENTER_BASELINE,18);
		btnSubmit.setFont(label_font1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_id u=new user_id();
				frame.dispose();
				u.initialize();
				u.frame.setVisible(true);
			}
		});
		btnBack.setBounds(12, 438, 79, 24);
		frame.getContentPane().add(btnBack);
		Font label_font2= new Font("NanumGothic",Font.CENTER_BASELINE,14);
		btnBack.setFont(label_font2);
		
		
	}
	

	public void actionPerformed(ActionEvent e)
	{
		btnActionPerformed(e);
	}
	public void btnActionPerformed(ActionEvent e){
		sqlcon sc=new sqlcon();
		sc.initialize_connection();
		user_id ui=new user_id();
		String pwd=String.valueOf(passwordField.getPassword());
		if(status==1)
		{	
			if(pwd.equals(""))
			{
			JOptionPane.showMessageDialog(null, "Field is empty.","Alert",0);
			}
			else if(pwd.length()<6)
			{
				passwordField.setText("");
				JOptionPane.showMessageDialog(null, "Password should contain atleast 6\ncharacters.","Display",0);
			}
			else
			{
			sc.update_pwd(input_id,pwd);
			JOptionPane.showMessageDialog(null, "ID Created.","Display",0);
			midoption mo=new midoption();
			mo.variables1(input_id);
			frame.dispose();
			mo.initialize();
			mo.frame.setVisible(true);
			}
		}
		else if(status==0)
		{
			for(int i=0;i<sc.inputs.length;i++)
			{
			if(input_id.equals(sc.inputs[i])&&pwd.equals(sc.passwords[i]))
				{
				same=0;
				break;
				}
			else
				{
				same=1;
				}
			}
		if(pwd.equals(""))
			{
			JOptionPane.showMessageDialog(null, "Field is empty.","Alert",0);
			}
		else if(same==1)
			{
			passwordField.setText("");
			JOptionPane.showMessageDialog(null, "Wrong Password.","Alert",0);
			}
		else if(same==0)
			{
			midoption mo=new midoption();
			mo.variables1(input_id);
			frame.dispose();
			mo.initialize();
			mo.frame.setVisible(true);
			}
			
		}
		
	
}
}
