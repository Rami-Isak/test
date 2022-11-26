// Rami Isak
// 15/11/22
// Class for Calculating Prices
// Test comment online

package com.test;

import java.util.ArrayList;

public class Calculate 
{
    private Customer customer;
	private ArrayList<Pizza> pizzas;
	private boolean delivery;
	private boolean discount;
	private double totalCost;

	public Calculate()
	{

	}

	// Variables Used 
	public Calculate(Customer cus, ArrayList<Pizza> piz, boolean deli)
	{
		customer = cus;
		pizzas = piz;
		delivery = deli;
		discount = false;
		totalCost = calculateTotalCost(pizzas, delivery);
	}
    
    // Displays Yes or No depending on the Selection
	public String isDelivered(boolean del)
	{
		if(del)

			return "Yes";

		else
			return "No";
	}
	
	// Displays Yes or No depending on the Selection
	public String isDiscounted(boolean dis)
	{
		if(dis)

			return "Yes";

		else
			return "No";
	}
	public double calculateTotalCost(ArrayList<Pizza> pizzas, boolean delivery)
	{
		// Default Cost
		double cost = 0;
		int i;

		// Gets How Many Pizzas There Are
		for(i=0; i<pizzas.size(); i++)
		{
			cost += pizzas.get(i).getCost();
		}
        
		// Applies Discount if more that 2 Pizzas are Ordered
		if(pizzas.size() >= 2)
		{
			cost = 0.9 *cost;
			discount = true;
		}
        
		// Adds $5 to the cost if Delivery is Checked
		if(delivery)
			cost +=5.00;
		return cost;
	}

	public String displayPizzas(ArrayList<Pizza> piz)
	{
		String pizzaInfo="";
		for(int i=0; i< pizzas.size(); i++)
		{
			pizzaInfo += pizzas.get(i).toString() +"\n";
		}

		return pizzaInfo;
	}
    
	@Override
	public String toString() 
	{
		StringBuffer sb = new StringBuffer();
		sb.append(customer.toString());
		sb.append("\nPizzas: " + displayPizzas(pizzas));
		sb.append("\nNumber of Pizzas: " + pizzas.size());
		sb.append("\nDiscountred: " + isDiscounted(discount));
		sb.append("\nTotal Cost:$ "+ totalCost);
		
		return(sb.toString());
	}

}
