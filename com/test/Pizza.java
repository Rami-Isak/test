// Rami Isak
// 17/11/22
// Class for Pizza Arraylist

package com.test;

public class Pizza 
{
    // Variables
	String pizzaCatagory;
	private String pizzaSize;
	private String pizzaType;
	private double cost;

	public Pizza()
	{
		
	}

	public Pizza(String pizzaSize, String pizzaType)
	{
		this.pizzaSize = pizzaSize;
		setType(pizzaType);
		this.cost = calculateCost(pizzaSize, pizzaType);
	}


	public String getSize() 
	{
		return pizzaSize;
	}


	public void setSize(String pizzaSize) 
	{
		this.pizzaSize = pizzaSize;
	}


	public String getType() 
	{
		return pizzaType;
	}


	public void setType(String pizzaType) 
	{
		this.pizzaType = pizzaType;

        // Catagorises the Pizza Types since prices are different
        if (pizzaType.equals("Marinara") || pizzaType.equals("Meat Lovers") || pizzaType.equals("Mexicana")) 
        {
        	pizzaCatagory = "Deluxe";
        }
        else 
        {
        	pizzaCatagory = "Basic";
        }
	}


	public double getCost() 
	{
		return cost;
	}


	public void setCost(double cost) 
	{
		this.cost = cost;
	}
 

	public double calculateCost(String pizzaSize, String pizzaType)
	{
        int size_ = 0;
        switch (getSize()) 
		{
            case "Small":
                size_ = 1;
                break;
            case "Medium":
                size_ = 2;
                break;
            case "Large":
                size_ = 3;
                break;
        }
        
		// Calculates cost with sizes
        cost = 4.0 * (double)size_ + 2.0;
        
        return cost;
	}
		@Override
		public String toString() 
		{
			StringBuffer sb = new StringBuffer();
			sb.append("\n "+ pizzaSize);
			sb.append("\n "+pizzaType);
			return (sb.toString());
			
		}


	}