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
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JPanel pnlCustomer;
	private JPanel pnlOrder;
    private JTextArea txtDisplay;
	
	

	Container pane = getContentPane();

	public ResortBookingCalculator()
	{
		pane.setLayout(new BorderLayout());


		// Creates Gridlayout
		pnlOrder = new JPanel();
		pnlOrder.setLayout(new GridLayout(4, 1));
		pnlOrder.setBorder(BorderFactory.createTitledBorder("Customer Details"));

        //Panel: Customer
		pnlCustomer = new JPanel();
		pnlCustomer.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblName =new JLabel("Customer Name");
		txtName = new JTextField(30);
		lblPhone =new JLabel("Customer Phone");
		txtPhone = new JTextField(30);
		lblAddress =new JLabel("Address");
		txtAddress = new JTextField(30);
		pnlCustomer.add(lblName);
		pnlCustomer.add(txtName);
		pnlCustomer.add(lblPhone);
		pnlCustomer.add(txtPhone);
		pnlCustomer.add(lblAddress);
		pnlCustomer.add(txtAddress);

		//Display panel
		txtDisplay = new JTextArea(25, 20);
		JPanel pnlDisplay = new JPanel();
		pnlDisplay.setLayout(new FlowLayout());
		JScrollPane scroll = new JScrollPane(txtDisplay);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		txtDisplay.setLineWrap(true);
		txtDisplay.setWrapStyleWord(true);
		txtDisplay.setEditable(false);
		txtDisplay.setBorder(BorderFactory.createTitledBorder("Orders"));
		txtDisplay.setFont(new Font("Arial",Font.BOLD,15));
		pnlDisplay.add(scroll);

		pnlOrder.add(pnlCustomer);

		//add panels to pane
		pane.add(pnlOrder,BorderLayout.CENTER);
		pane.add(pnlDisplay,BorderLayout.EAST);

		//add action listeners 

	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
}

