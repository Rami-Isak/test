package com.test;

public class Pizza
{
	private String pizzaType;
	private String sizeType;
	private boolean delivery;
	private boolean discount;
	private double totalCost;
	
	// constructor
	public Pizza()
	{
		
	}
	
	public Pizza(String pizzaType, String sizeType, boolean delivery)
	{
		this.pizzaType = pizzaType;
		this.delivery = delivery;
		discount = false;
		totalCost = calculateTotalCost(size, pizzaType, sizeType, delivery);
	}

	int size = 0;
	
	public String hasdelivery(boolean delivery)
	{
		if(delivery)
			return "Yes";
		else
			return "No";
	}
	public String isDiscounted(boolean dis)
	{
		if(dis)
			return "Yes";
		else
			return "No";
	}
	
	public double calculateTotalCost(int quantity, String pizzaType, String sizeType, boolean delivery)
	{
		double cost=0;
		
		

		if(quantity>= 2)
		{
			cost = 0.9 * cost;
			discount = true;
		}
		
		if(delivery)
			cost +=5;
	
		return cost;
	}
	
	
	@Override
	public String toString()
	{
		StringBuffer sb =new StringBuffer();
	
		sb.append("Customer: " );
		sb.append("\nNumber of quantity: ");
		sb.append("\nPizza: "+pizzaType);
		sb.append("\nSize: "+sizeType);
		sb.append("\nDelivery: "+hasdelivery(delivery));
		sb.append("\nDiscounted: " +isDiscounted(discount));
		sb.append("\nTotal Cost:$ "+totalCost);
		
		return(sb.toString());
	}
	
}
