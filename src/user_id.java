import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

public class user_id extends sqlcon implements ActionListener{
	
	public int status=0;
	public int same=0;
	public String input_id;
	public JFrame frame;
	private JFrame frame1;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_id window = new user_id();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public user_id() {
		initialize();
	}
	public void initialize() {
	 
		frame = new JFrame("Login Window | User ID");
		frame.setBounds(450, 175, 768, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
				
		JLabel label1 = new JLabel("User Name");
		label1.setBounds(316, 131, 170, 35);
		frame.getContentPane().add(label1);
		Font label_font= new Font("ubuntu",Font.CENTER_BASELINE,30);
		label1.setFont(label_font);
		
		
		
		JButton submit = new JButton("Submit");
		submit.setBounds(316, 225, 160, 35);
		submit.addActionListener(this);
		frame.getContentPane().add(submit);
		Font label_font1= new Font("NanumGothic",Font.CENTER_BASELINE,18);
		submit.setFont(label_font1);
		
		textField = new JTextField();
		textField.setBounds(217, 178, 354, 35);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed(e);
			}
		});
		frame.getContentPane().add(textField);
		Font label_font7= new Font("NanumGothic",Font.BOLD,24);
		textField.setFont(label_font7);
		textField.setColumns(20);
		
		final ImageIcon i=new ImageIcon("images/left.gif");
		final JLabel label2= new JLabel();
		label2.setBounds(420, 15, 146, 40);
		frame.getContentPane().add(label2);
		Font label_font6= new Font("Arial",Font.BOLD,12);
		label2.setFont(label_font6);
		
		final ImageIcon i1=new ImageIcon("images/right.gif");
		final JLabel label = new JLabel();
		label.setBounds(284, 15, 146, 50);
		frame.getContentPane().add(label);
		Font label_font5= new Font("Arial",Font.BOLD,12);
		label.setFont(label_font5);
		
		
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(420, 15, 146, 35);
		final JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(204, 15, 146, 35);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status=1;
				btnLogin.setVisible(false);
				label2.setIcon(i);
			}
		});
		frame.getContentPane().add(btnSignUp);
		Font label_font2= new Font("NanumGothic",Font.BOLD,18);
		btnSignUp.setFont(label_font2);
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status=0;
				btnSignUp.setVisible(false);
				label.setIcon(i1);
				
				
			}
		});
		Font label_font3= new Font("NanumGothic",Font.BOLD,18);
		btnLogin.setFont(label_font3);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("PARKING MANAGEMENT SYSTEM",JLabel.CENTER);
		lblNewLabel.setBounds(154, 371, 488, 47);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		frame.getContentPane().add(lblNewLabel);
		Font label_font4= new Font("NanumGothic",Font.BOLD,26);
		lblNewLabel.setFont(label_font4);
		
		JButton btnBack = new JButton();
		btnBack.setBounds(5, 5, 35, 35);
		ImageIcon i2=new ImageIcon("images/reff.jpg");
		btnBack.setIcon(i2);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_id u=new user_id();
				frame.dispose();
				u.initialize();
				u.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnBack);
		Font font= new Font("NanumGothic",Font.CENTER_BASELINE,12);
		btnBack.setFont(font);
		
		JTextArea textArea = new JTextArea(20,20);
		textArea.setBounds(376, 67, 1, 15);
		frame.getContentPane().add(textArea);
		
		
		
	}

	public void actionPerformed(ActionEvent e)
	{
		btnActionPerformed(e);
	}
	public void btnActionPerformed(ActionEvent e) {
	
			sqlcon sc=new sqlcon();
			sc.initialize_connection();
		input_id=textField.getText();
		if(status==1)
			{
			for(int i=0;i<sc.inputs.length;i++)
				{
				if(input_id.equals(sc.inputs[i]))
						{
						same=0;
						break;
						}
				else
						{
						same=1;
						}
					
				}
			if(textField.getText().equals(""))
				{
				JOptionPane.showMessageDialog(null, "Field is empty.","Alert",0);
				}
			else if(same==0)
				{
				textField.setText("");
				JOptionPane.showMessageDialog(null, "User ID already in use.","Display",0);
				}
			else if(same==1)
				{
				password p=new password();
				p.variables(status,input_id);
				sc.input_userid(input_id);
				frame.dispose();
				p.initialize();
				p.frame.setVisible(true);
				}
			
			}
		if(status==0)
		{
		for(int i=0;i<sc.inputs.length;i++)
			{
			if(input_id.equals(sc.inputs[i]))
					{
					same=0;
					break;
					}
			else
					{
					same=1;
					}
				
			}
	if(textField.getText().equals(""))
		{
		JOptionPane.showMessageDialog(null, "Field is empty.","Alert",0);
		}
	else if(same==1)
		{
		textField.setText("");
		JOptionPane.showMessageDialog(null, "Wrong User ID","Alert",0);
		}
	else if(same==0)
		{
		password p=new password();
		p.variables(status,input_id);
		frame.dispose();
		p.initialize();
		p.frame.setVisible(true);
		}
		}
		
	}
}
