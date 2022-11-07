// Rami Isak
// 07/11/22
// Main Application


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class newframe extends JFrame 
{

	public static void main(String[] args) 
	{
		newframe frameTabel = new newframe();
	}

	JLabel welcome = new JLabel("New Frame");
	JPanel panel = new JPanel();

	newframe() 
	{
		  setSize(700, 600);
		  setLocation(500, 280);
		  panel.setLayout(null);

		welcome.setBounds(70, 50, 150, 60);

		panel.add(welcome);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}