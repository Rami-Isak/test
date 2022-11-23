/*
 * Marg Graham 23/10/2022
 * MG REsort booking form
 */
package com.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Order extends JFrame implements ActionListener

{
	// Components Used
	private JLabel lblDetails = new JLabel();
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JPanel pnlCustomer;
    private JTextArea txtDisplay;
	private JLabel lblDelivery;
	private JCheckBox chkDelivery;
	private JPanel pnlHeading;
	private JPanel pnlAction;
	private JButton btnAtl;
	private JButton btnOrder;
	private JButton btnClear;
	private JSpinner spnQuantity;
	private JTextField txtTotal;
	private JLabel lblQuantity;
	private JLabel lblTotal;
	private JLabel lblBasic;
	private JRadioButton rdAussie;
	private JRadioButton rdHawa;
	private JRadioButton rdVege;
	private JLabel lblDeluxe;
	private JRadioButton rdMarin;
	private JRadioButton rdMeat;
	private JRadioButton rdMexi;
	private JLabel lblSize;
	private JRadioButton rdSmall;
	private JRadioButton rdMedium;
	private JRadioButton rdLarge;

	Container pane = getContentPane();

	String custInfo; 
	int quantity;
	boolean delivery = false;
	int i=0;
	String display = "";
	ArrayList <Pizza> thePizzas = new ArrayList <Pizza>();
	ButtonGroup bgPizza = new ButtonGroup();
	ButtonGroup bgSize = new ButtonGroup();
	

	public Order()
	{
		pane.setLayout(new BorderLayout());

		// Heading Panel
		pnlHeading = new JPanel();
		pnlHeading.setLayout(new FlowLayout(FlowLayout.CENTER,0,11));
		JLabel lblHeading =new JLabel("MG Pizza");
		lblHeading.setForeground(Color.RED);
		lblHeading.setFont(new Font("Arial",Font.BOLD,16));
		lblDetails.setForeground(Color.RED);
		pnlHeading.add(lblHeading);
		pnlHeading.add(lblDetails);
		pnlHeading.setBackground(Color.BLACK);

        // Customer Panel
		pnlCustomer = new JPanel();
		pnlCustomer.setLayout(null);
		pnlCustomer.setBorder(BorderFactory.createTitledBorder("Customer Details"));
		lblName =new JLabel(" Customer Name");
		txtName = new JTextField(10);
		lblPhone =new JLabel(" Customer Phone");
		txtPhone = new JTextField(10);
		lblDelivery =new JLabel("Delivery $5 Extra");
		chkDelivery =new JCheckBox();
		lblAddress =new JLabel("Address");
		txtAddress = new JTextField(10);
		lblBasic =new JLabel("Basic Pizza");
		rdAussie =new JRadioButton("Aussie");
	    rdHawa =new JRadioButton("Hawaiian");
	    rdVege =new JRadioButton("Vegetarian");
		lblDeluxe =new JLabel("Deluxe Pizza");
		rdMarin =new JRadioButton("Marinara");
	    rdMeat =new JRadioButton("Meat Lovers");
	    rdMexi =new JRadioButton("Mexicana");
		lblSize =new JLabel("Size");
		rdSmall =new JRadioButton("Small");
	    rdMedium =new JRadioButton("Medium");
	    rdLarge =new JRadioButton("Large");

		// Button Groups for selection
		rdAussie.setSelected(true);
		bgPizza.add(rdAussie);
		bgPizza.add(rdHawa);
		bgPizza.add(rdVege);
		bgPizza.add(rdMarin);
		bgPizza.add(rdMeat);
		bgPizza.add(rdMexi);
		rdSmall.setSelected(true);
		bgSize.add(rdSmall);
		bgSize.add(rdMedium);
		bgSize.add(rdLarge);

		// Adds And Sets Bounds in Panel
		pnlCustomer.add(txtName);
		txtName.setBounds(20, 35, 470, 30);
		pnlCustomer.add(lblName);
		lblName.setBounds(20, 55, 200, 30);
		pnlCustomer.add(txtPhone);
		txtPhone.setBounds(20, 95, 470, 30);
		pnlCustomer.add(lblPhone);
		lblPhone.setBounds(20, 115, 200, 30);
		pnlCustomer.add(lblDelivery);
		lblDelivery.setBounds(50, 155, 200, 30);
		pnlCustomer.add(chkDelivery);
		chkDelivery.setBounds(20, 155, 200, 30);
		pnlCustomer.add(lblAddress);
		lblAddress.setBounds(190, 175, 200, 30);
		pnlCustomer.add(txtAddress);
		txtAddress.setBounds(185, 155, 305, 30);
		pnlCustomer.add(lblBasic);
		lblBasic.setBounds(112,210, 200, 30);
		pnlCustomer.add(rdAussie);
		rdAussie.setBounds(112,250, 200, 30);
		pnlCustomer.add(rdHawa);
		rdHawa.setBounds(112,310, 200, 30);
		pnlCustomer.add(rdVege);
		rdVege.setBounds(112,370, 200, 30);
		pnlCustomer.add(lblDeluxe);
		lblDeluxe.setBounds(337,210, 200, 30);
		pnlCustomer.add(rdMarin);
		rdMarin.setBounds(337,250, 200, 30);
		pnlCustomer.add(rdMeat);
		rdMeat.setBounds(337,310, 200, 30);
		pnlCustomer.add(rdMexi);
		rdMexi.setBounds(337,370, 200, 30);
		pnlCustomer.add(lblSize);
		lblSize.setBounds(260,420, 200, 30);
		pnlCustomer.add(rdSmall);
		rdSmall.setBounds(30, 450, 200, 30);
		pnlCustomer.add(rdMedium);
		rdMedium.setBounds(225, 450, 200, 30);
		pnlCustomer.add(rdLarge);
		rdLarge.setBounds(410, 450, 200, 30);

		// Action Panel
		pnlAction = new JPanel();
		pnlAction.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        btnAtl =new JButton("Add To List");
		lblQuantity =new JLabel("Quantity");
		spnQuantity =new JSpinner();
		lblTotal =new JLabel("Total");
		txtTotal =new JTextField(5);
		txtTotal.setEditable(false);
		btnOrder =new JButton("Order");
		btnClear =new JButton("Clear");
		pnlAction.add(btnAtl);
		pnlAction.add(lblQuantity);
		pnlAction.add(spnQuantity);
		pnlAction.add(lblTotal);
		pnlAction.add(txtTotal);
		pnlAction.add(btnOrder);
		pnlAction.add(btnClear);

		// Order Panel
		txtDisplay = new JTextArea(25, 20);
		JPanel pnlDisplay = new JPanel();
		pnlDisplay.setLayout(new FlowLayout());
		JScrollPane scroll = new JScrollPane(txtDisplay);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		txtDisplay.setLineWrap(true);
		txtDisplay.setWrapStyleWord(true);
		txtDisplay.setEditable(false);
		txtDisplay.setBorder(BorderFactory.createTitledBorder("Current Orders"));
		txtDisplay.setFont(new Font("Arial",Font.BOLD,15));
		pnlDisplay.add(scroll);

		// Adds Panels to pane
		pane.add(pnlCustomer,BorderLayout.CENTER);
		pane.add(pnlDisplay,BorderLayout.EAST);
		pane.add(pnlHeading,BorderLayout.NORTH);
		pane.add(pnlAction,BorderLayout.SOUTH);

		// Adds Action Listeners 
		btnAtl.addActionListener(this);
		btnOrder.addActionListener(this);
		btnClear.addActionListener(this);

		if (!chkDelivery.isSelected())
		{
			txtAddress.setEditable(false);
		}
		else
		{
		
		}

	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnAtl)
		{	
			String pizzaInfo = "";

			if(!notEntered()) //if no details are missing - calls notEntered()
			{
				
			}
		}

		if(e.getSource()==btnClear)
		{
			clearEverything(); 
		}
	}
     

	public boolean notEntered()
	{

		if(txtName.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter the Customers Name", null, JOptionPane.ERROR_MESSAGE);
			return true;
		}

		if(txtPhone.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter the Customers Phone", null, JOptionPane.ERROR_MESSAGE);
			return true;
		}

		if(!rdAussie.isSelected() && !rdHawa.isSelected() && !rdVege.isSelected() && !rdMarin.isSelected() && !rdMeat.isSelected() && !rdMexi.isSelected())
		{
			JOptionPane.showMessageDialog(null, "Choose the Pizza Type", null, JOptionPane.ERROR_MESSAGE);
			return true;
		}

		if(!rdSmall.isSelected() && !rdMedium.isSelected() && !rdLarge.isSelected())
		{
			JOptionPane.showMessageDialog(null, "Choose the Pizza Size", null, JOptionPane.ERROR_MESSAGE);
			return true;
		}

		if(chkDelivery.isSelected())
		{
			if(txtAddress.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Enter the Customers Address", null, JOptionPane.ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	public void clearEverything()
	{
		txtName.setText("");
		txtPhone.setText("");
		txtAddress.setText("");
		txtDisplay.setText("");
		bgPizza.clearSelection();
		bgSize.clearSelection();
		chkDelivery.setSelected(false);
		delivery = false;
	}
	
}