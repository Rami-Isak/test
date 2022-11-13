// Rami Isak
// 07/11/22
// Main Application


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class newframe extends JFrame implements ActionListener
{

	Container pane = getContentPane();
	public static void main(String[] args) 
	{
		newframe frameTabel = new newframe();
	}

	// Labels / Text
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

	// Textboxes for Name, Phone and Address
	private JTextField txtName, txtPhone, txtAdd;
    
	// Address Checkbox
	private JCheckBox chkAdd;

	// Radio Buttons for Basic and Deluxe
	private JRadioButton rbtBasic, rbtDeluxe, rbtSize;

	// Spinner For Quantity
	private JSpinner spnQuan;

	newframe() 
	{
		  setSize(700, 600);
		  setLocation(500, 280);
		  pane.setLayout(null);

		getContentPane().add(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}

}