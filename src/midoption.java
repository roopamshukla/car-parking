import java.awt.EventQueue;
import java.awt.Font;
import java.awt.color.*;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class midoption {
	int status=0;
	String input_id;
	public void variables1(String id)
	{
		input_id=id;
		
	}

	public JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					midoption window = new midoption();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public midoption() {
		initialize();
	}

	public void initialize() {
		final sqlcon sc=new sqlcon();
		sc.initialize_connection();
		
		frame = new JFrame("Select Option");
		frame.getContentPane().setIgnoreRepaint(true);
		frame.getContentPane().setFont(new Font("Courier 10 Pitch", Font.PLAIN, 12));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(450, 175, 768, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnSelect = new JButton("Select Parking");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(input_id.equals(sc.inputs[i])&&sc.slot_no[i]!=0)
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
					
					JOptionPane.showMessageDialog(null, "You already own a space.","Alert",0);
					
				}
				else if(status==0)
				{
					parking pa=new parking();
					pa.variables2(input_id);
					frame.dispose();
					pa.initialize();
					pa.frame.setVisible(true);
					
				}
				
			}
		});
		btnSelect.setBounds(149, 119, 186, 186);
		frame.getContentPane().add(btnSelect);
		Font label_font1= new Font("ubuntu",Font.CENTER_BASELINE,18);
		btnSelect.setFont(label_font1);
		
		JButton btnReturnParking = new JButton("Return Parking");
		btnReturnParking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<sc.inputs.length;i++)
				{
					if(input_id.equals(sc.inputs[i])&&sc.slot_no[i]!=0)
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
					sc.update_sn(input_id,0);
					JOptionPane.showMessageDialog(null, "Space Returned\nThank you.","Alert",0);
					sc.initialize_connection();
					
				}
				else if(status==0)
				{
					JOptionPane.showMessageDialog(null, "Please book a space first.","Alert",0);
					
				}
				
			}
		});
		btnReturnParking.setFont(new Font("Ubuntu", Font.BOLD, 18));
		btnReturnParking.setBounds(429, 119, 186, 186);
		frame.getContentPane().add(btnReturnParking);
		
		JLabel lblWhatsUp = new JLabel("SELECT OPTION",JLabel.CENTER);
		lblWhatsUp.setBackground(Color.WHITE);
		lblWhatsUp.setText("SELECT OPTION");
		lblWhatsUp.setBounds(212, 22, 338, 30);
		frame.getContentPane().add(lblWhatsUp);
		Font label_font2= new Font("ARIAL",Font.BOLD,20);
		lblWhatsUp.setFont(label_font2);
		lblWhatsUp.setBackground(Color.WHITE);
		lblWhatsUp.setOpaque(true);
		
		
		
		
	}
}
