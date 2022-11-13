package com.test;

public class Booking
{
	private String customer;
	private int nights;
	private String roomType;
	private boolean dog;
	private boolean discount;
	private double totalCost;
	
	// constructor
	public Booking()
	{
		
	}
	
	public Booking(String customer, int nights, String roomType, boolean dog)
	{
		this.customer = customer;
		this.nights = nights;
		this.roomType = roomType;
		this.dog = dog;
		discount = false;
		totalCost = calculateTotalCost(nights, roomType, dog);
	}
	
	public String hasDog(boolean dog)
	{
		if(dog)
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
	
	public double calculateTotalCost(int nights, String roomType, boolean dog)
	{
		double cost=0;
		
		if(roomType.equalsIgnoreCase("Standard"))
		{
			cost = nights * 120;
		}
		else
		{
			cost = nights * 150;
		}
		if(nights>= 5)
		{
			cost = 0.8 * cost;
			discount = true;
		}
		
		if(dog)
			cost +=20;
	
		return cost;
	}
	
	
	@Override
	public String toString()
	{
		StringBuffer sb =new StringBuffer();
	
		sb.append("Customer: " +customer);
		sb.append("\nNumber of nights: "+nights);
		sb.append("\nRoom Type: "+roomType);
		sb.append("\nDog: "+hasDog(dog));
		sb.append("\nDiscounted: " +isDiscounted(discount));
		sb.append("\nTotal Cost:$ "+totalCost);
		
		return(sb.toString());
	}
	
}
