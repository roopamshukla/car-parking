import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JTextField;

public class parking {
	
	int status=0;
	int check=0;
	String input_id;
	public void variables2(String id)
	{
		input_id=id;
		
	}

	public JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parking window = new parking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public parking() {
		initialize();
	}

	public void initialize() {
		final sqlcon sc=new sqlcon();
		sc.initialize_connection();
		
		frame = new JFrame("Selection Window");
		frame.setBounds(450, 175, 768, 468);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		final JButton button1 = new JButton("1");
		button1.setBounds(22, 12, 118, 181);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==1)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button1.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 1);
					button1.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 1 Booked..","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,1);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
					
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button1);
		
		final JButton button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==2)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button2.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 2);
					button2.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 2 Booked.","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,2);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
				}
			}
		});
		button2.setBounds(164, 12, 118, 181);
		frame.getContentPane().add(button2);
		
		final JButton button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==3)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button3.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 3);
					button3.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 3 Booked.","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,3);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
					
				}
			}
		});
		button3.setBounds(306, 12, 118, 181);
		frame.getContentPane().add(button3);
		
		final JButton button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==4)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button4.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 4);
					button4.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 4 Booked.","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,4);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
					
				}
			}
		});
		button4.setBounds(450, 12, 118, 181);
		frame.getContentPane().add(button4);
		
		final JButton button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==5)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button5.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 5);
					button5.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 5 Booked.","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,5);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
					
				}
			}
		});
		button5.setBounds(595, 12, 118, 181);
		frame.getContentPane().add(button5);
		
		final JButton button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==6)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button6.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 6);
					button6.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 6 Booked.","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,6);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
					
				}
			}
		});
		button6.setBounds(53, 233, 118, 181);
		frame.getContentPane().add(button6);
		
		final JButton button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==7)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button7.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 7);
					button7.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 7 Booked.","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,7);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
					
				}
			}
		});
		button7.setBounds(195, 233, 118, 181);
		frame.getContentPane().add(button7);
		
		final JButton button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==8)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button8.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 8);
					button8.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 8 Booked.","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,8);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
					
				}
			}
		});
		button8.setBounds(337, 233, 118, 181);
		frame.getContentPane().add(button8);
		
		final JButton button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==9)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button9.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 9);
					button9.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 9 Booked.","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,9);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
					
				}
			}
		});
		button9.setBounds(482, 233, 118, 181);
		frame.getContentPane().add(button9);
		
		final JButton button10 = new JButton("10");
		button10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(sc.slot_no[i]==10)
						{
						status=1;
						break;
						}
					else
						{
						status=0;
						}
				}	
				if(status==1)
				{
					
					JOptionPane.showMessageDialog(null, "Not Vacant","Alert",0);
					button10.setBackground(Color.RED);
					
				}
				else if(status==0)
				{
					sc.update_sn(input_id, 10);
					button10.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Slot 10 Booked.","Alert",0);
					print_ticket pt=new print_ticket();
					pt.variables3(input_id,10);
					frame.dispose();
					pt.initialize();
					pt.frame.setVisible(true);
					
				}
			}
		});
		button10.setBounds(625, 233, 118, 181);
		frame.getContentPane().add(button10);
		
		JButton[] btn=new JButton[11];
		btn[1]=button1;
		btn[2]=button2;
		btn[3]=button3;
		btn[4]=button4;
		btn[5]=button5;
		btn[6]=button6;
		btn[7]=button7;
		btn[8]=button8;
		btn[9]=button9;
		btn[10]=button10;
		
		ImageIcon i1=new ImageIcon("images/gate2.png");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(i1);
		lblNewLabel.setBounds(16, 244, 37, 146);;
		frame.getContentPane().add(lblNewLabel);
		
		ImageIcon i2=new ImageIcon("images/gate1.png");
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(i2);
		lblNewLabel_1.setBounds(732, 22, 37, 146);
		frame.getContentPane().add(lblNewLabel_1);
		
		ImageIcon i3=new ImageIcon("images/sr.png");
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(i3);
		lblNewLabel_2.setBounds(208, 430, 21, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblVacant = new JLabel("Vacant");
		lblVacant.setBounds(470, 423, 100, 35);
		Font label_font= new Font("ubuntu",Font.CENTER_BASELINE,22);
		lblVacant.setFont(label_font);
		frame.getContentPane().add(lblVacant);
		
		JLabel lblOccupied = new JLabel("Occupied");
		lblOccupied.setBounds(235, 423, 146, 35);
		Font label_font1= new Font("ubuntu",Font.CENTER_BASELINE,22);
		lblOccupied.setFont(label_font1);
		frame.getContentPane().add(lblOccupied);
		
		ImageIcon i4=new ImageIcon("images/sg.png");
		JLabel label = new JLabel();
		label.setIcon(i4);
		label.setBounds(442, 430, 21, 21);
		frame.getContentPane().add(label);

		for(int j=1;j<=10;j++)
		{
			for(int i=0;i<sc.inputs.length;i++)
			{
				if(sc.slot_no[i]==j)
					{
					check=0;
					break;
					}
				else
					{
					check=1;
					}
			}
			if(check==0)
			{
				btn[j].setBackground(Color.RED);
			}
			else if(check==1)
			{
				btn[j].setBackground(Color.GREEN);
			}
		}
	
	}
}
