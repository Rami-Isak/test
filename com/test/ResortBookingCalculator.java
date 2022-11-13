/*
 * Marg Graham 23/10/2022
 * MG REsort booking form
 */
package com.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ResortBookingCalculator extends JFrame implements ActionListener

{
	private JLabel lblNights;
	private JTextField txtNights;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JPanel pnlCustomer;
	private JPanel pnlOrder;
	

	private JRadioButton rbtStandard, rbtDeluxe;
	private JCheckBox chkDog;
	private JTextArea txtDisplay;
	private JButton btnBook;
	private JButton btnClear;
	private JPanel pnlNights;
	private JPanel pnlRoom;
	private JPanel pnlButton;
	
	

	Container pane = getContentPane();

	String custDetails; 
	int nights;
	String roomtype;
	boolean dog = false;
	int i=0;
	String display = "";
	ButtonGroup btgType = new ButtonGroup();

	public ResortBookingCalculator()
	{
		pane.setLayout(new BorderLayout());


		//Panel: Order 4 x 1 grid - No Nights, room type, dog?
		pnlOrder = new JPanel();
		pnlOrder.setLayout(new GridLayout(4, 1));
		pnlOrder.setBorder(BorderFactory.createTitledBorder("Book Details"));

        //Panel: Customer
		pnlCustomer = new JPanel();
		pnlCustomer.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblName =new JLabel("Customer Name");
		txtName = new JTextField(5);
		lblPhone =new JLabel("Customer Phone");
		txtPhone = new JTextField(5);
		lblAddress =new JLabel("Address");
		txtAddress = new JTextField(5);
		pnlCustomer.add(lblName);
		pnlCustomer.add(txtName);
		pnlCustomer.add(lblPhone);
		pnlCustomer.add(txtPhone);
		pnlCustomer.add(lblAddress);
		pnlCustomer.add(txtAddress);

		//Panel: No nights 
		pnlNights = new JPanel();
		pnlNights.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblNights =new JLabel("Number of nights:");
		txtNights = new JTextField(5);
		pnlNights.add(lblNights);
		pnlNights.add(txtNights);

		pnlButton.add(btnBook);
		pnlButton.add(btnClear);

		//Display panel
		txtDisplay = new JTextArea(25, 20);
		JPanel pnlDisplay = new JPanel();
		pnlDisplay.setLayout(new FlowLayout());
		JScrollPane scroll = new JScrollPane(txtDisplay);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		txtDisplay.setLineWrap(true);
		txtDisplay.setWrapStyleWord(true);
		txtDisplay.setEditable(false);
		txtDisplay.setBorder(BorderFactory.createTitledBorder("Room Booking"));
		txtDisplay.setFont(new Font("Arial",Font.BOLD,15));
		pnlDisplay.add(scroll);

		pnlOrder.add(pnlCustomer);
		pnlOrder.add(pnlRoom);
		pnlOrder.add(pnlButton);

		//add panels to pane
		pane.add(pnlOrder,BorderLayout.CENTER);
		pane.add(pnlDisplay,BorderLayout.EAST);

		//add action listeners 
		btnBook.addActionListener(this);
		btnClear.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnBook)
		{	
			String bookingDetails = "";

			if(!detailsMissing()) //if no details are missing - calls detailsMissing()
			{
				nights = Integer.parseInt(txtNights.getText()); //get the number of nights and convert to integer

				if (rbtStandard.isSelected())
				{
					roomtype = rbtStandard.getText();
				}
				else
				{
					roomtype = rbtDeluxe.getText();
				}

				if(chkDog.isSelected())
				{
					dog = true;
				}
				else
					dog = false;

				Booking theBooking = new Booking(custDetails, nights, roomtype,dog); //create the Booking object with the data chosen
				bookingDetails = theBooking.toString();
				txtDisplay.setText(bookingDetails);
			}
		}

		if(e.getSource()==btnClear)
		{
			clearScreen(); //calls clearScreen
		}
	}



	public void clearScreen()
	{
		txtNights.setText("");
		txtDisplay.setText("");
		btgType.clearSelection();
		chkDog.setSelected(false);
		dog = false;

	}

	public boolean detailsMissing()
	{

		if(txtNights.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Must enter number of nights", null, JOptionPane.ERROR_MESSAGE);
			return true;
		}

		if(!rbtStandard.isSelected() && !rbtDeluxe.isSelected())
		{
			JOptionPane.showMessageDialog(null, "Must choose room type", null, JOptionPane.ERROR_MESSAGE);
			return true;
		}

		return false;
	}



}

