// Rami Isak
// 07/11/22
// Main Application


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class newframe extends JFrame implements ActionListener
{

	public static void main(String[] args) 
	{
		newframe frameTabel = new newframe();
	}

	public static JLabel lblMG = new JLabel("MG Pizza");
	public static JLabel lblCus = new JLabel("Customer Name");
	public static JLabel lblPhn = new JLabel("Phone Number");
	public static JLabel lblAdd = new JLabel("Address");
	public static JLabel lblDel = new JLabel("Delivery $5 Extra");
	public static JLabel lblBas = new JLabel("Basic Pizza's");
	public static JLabel lblDlx = new JLabel("Deluxe Pizza's");
	public static JLabel lblSiz = new JLabel("Size");
	public static JLabel lblQun = new JLabel("Quantity");
	public static JLabel lblTol = new JLabel("Total");
	public static JLabel lblCur = new JLabel("Current Orders");	

	

	newframe() 
	{
		  setSize(700, 600);
		  setLocation(500, 280);
		  panel.setLayout(null);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}