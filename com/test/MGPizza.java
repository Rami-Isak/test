// Rami Isak
// 20/10/22
// Login Screen for MG Pizza

package com.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MGPizza extends JFrame implements ActionListener
{

	private int choice = 0;
	public static void main(String[] args) 
	{
		MGPizza frame = new MGPizza();
	}
    
	 // Components Used in the program
	 public static JButton logBtn = new JButton("Login");
	 public static JButton extBtn = new JButton("Exit");
	 public static JPanel panel = new JPanel();
	 public static JTextField textField = new JTextField(30);
	 public static JPasswordField jPasswordField = new JPasswordField(30);
	 public static JLabel lblU = new JLabel();
	 public static JLabel lblP = new JLabel();
	 public static JLabel lblMG = new JLabel();
	 MGPizza() 

	{
		// Sets title of window and labels
		super("MG Pizza Login");
		lblU.setText("Username");
		lblP.setText("Password");
		lblMG.setText("MG Pizza");

		// Sets placement of components in panel
        lblU.setBounds(90, 65, 100, 20);
		lblP.setBounds(350,65,  100,  20);
		lblMG.setBounds(13,5,  100,  20);
		textField.setBounds(10, 30, 230, 30);
		jPasswordField.setBounds(263, 30, 230, 30);
		logBtn.setBounds(180, 100, 150, 40);
        extBtn.setBounds(410, 100, 80, 35);
        
		// Style of Buttons
		logBtn.setBorderPainted(true);
        logBtn.setFocusPainted(false);
        logBtn.setContentAreaFilled(true);
		extBtn.setBorderPainted(true);
        extBtn.setFocusPainted(false);
        extBtn.setContentAreaFilled(true);
		
		// Adds components to panel
		panel.add(lblU);
		panel.add(lblP);
		panel.add(lblMG);
		panel.add(logBtn);
	    panel.add(extBtn);
		panel.add(textField);
		panel.add(jPasswordField);

	    // Sets fonts and sizes for labels
		lblMG.setFont(new Font("Arial",Font.BOLD,15));
		lblMG.setForeground(Color.red);

		// Sets background of panel 
        panel.setBackground(Color.white); 
        
		// Sets size of window
		setSize(500, 170);
		
		// Location of panel when started
		setLocation(500, 280);
		panel.setLayout(null);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionbtns();
	}
    
	public void actionbtns() 
	{
		// Action listener for Login Button
		logBtn.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent ae) 
			{ 
				// If username and password match
				String name = textField.getText();
				String pwd = jPasswordField.getText();
				if (name.equals("") && pwd.equals("")) 
				{
					ResortBookingCalculator theApp = new ResortBookingCalculator();

			        theApp.setTitle ("MG Pizza");
			        theApp.setSize (800, 600);
			        theApp.setLocationRelativeTo(theApp);
			        theApp.setVisible(true);
			        theApp.setResizable(false);
			        theApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        dispose();
				} 
				else 
				{
                    // If username and password dont match
					// Displays error message
					JOptionPane.showMessageDialog(null,"Wrong Password or Username", "Error", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					jPasswordField.setText("");
					textField.requestFocus();
				}

			}
		});

		// Action listener for Exit Button
		extBtn.addActionListener(new ActionListener() 
		{
				
			public void actionPerformed(ActionEvent ae) 
			{ 
				choice = JOptionPane.showConfirmDialog(null,"Do you really want to exit?","Exiting MG Pizza",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	}
}