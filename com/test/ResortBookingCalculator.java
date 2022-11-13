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
	private JLabel lblDetails = new JLabel();
	private JLabel lblNights;
	private JTextField txtNights;
	private JRadioButton rbtStandard, rbtDeluxe;
	private JCheckBox chkDog;
	private JTextArea txtDisplay;
	private JButton btnBook;
	private JButton btnClear;
	private JPanel pnlHeading;
	private JPanel pnlBooking;
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

		//Heading panel
		pnlHeading = new JPanel();
		pnlHeading.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		JLabel lblHeading =new JLabel("MG Resort Booking");
		lblHeading.setForeground(Color.GREEN);
		lblHeading.setFont(new Font("Arial",Font.BOLD,24));
		lblDetails.setForeground(Color.GREEN);
		pnlHeading.add(lblHeading);
		pnlHeading.add(lblDetails);
		pnlHeading.setBackground(Color.BLACK);

		//Panel: Order 4 x 1 grid - No Nights, room type, dog?
		pnlBooking = new JPanel();
		pnlBooking.setLayout(new GridLayout(4, 1));
		pnlBooking.setBorder(BorderFactory.createTitledBorder("Booking Details"));

		//Panel: No nights 
		pnlNights = new JPanel();
		pnlNights.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblNights =new JLabel("Number of nights:");
		txtNights = new JTextField(5);
		pnlNights.add(lblNights);
		pnlNights.add(txtNights);

		//Panel: room type
		pnlRoom = new JPanel();
		pnlRoom.setLayout(new GridLayout(2, 1));
		rbtStandard = new JRadioButton("Standard");
		rbtDeluxe = new JRadioButton("Deluxe");
		btgType.add(rbtStandard);
		btgType.add(rbtDeluxe);
		pnlRoom.add(rbtStandard);
		pnlRoom.add(rbtDeluxe);

		//check box for dog
		chkDog = new JCheckBox("Dog");

		//Panel: for buttons
		pnlButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnBook = new JButton("Book");
		btnBook.setToolTipText("Add your booking details");
		btnClear = new JButton("Clear");
		btnClear.setToolTipText("Clears booking");
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

		pnlBooking.add(pnlNights);
		pnlBooking.add(pnlRoom);
		pnlBooking.add(chkDog);
		pnlBooking.add(pnlButton);

		//add panels to pane
		pane.add(pnlHeading,BorderLayout.NORTH);
		pane.add(pnlBooking,BorderLayout.CENTER);
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



	public void myUpdate(String details)
	{
		custDetails = details;
		lblDetails.setText("  "+custDetails);
	}
}

