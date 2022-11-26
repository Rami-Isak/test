// Rami Isak
// 17/11/22
// Customer Class

package com.test;

public class Customer 
{

	private String cusName;
	private String cusPhone;
	private String cusAddress;


	public Customer (String cusName, String cusPhone, String cusAddress)
	{
		this.cusName = cusName;
		this.cusPhone = cusPhone;
		this.cusAddress = cusAddress;

	}


	public Customer() 
	{
		// TODO Auto-generated constructor stub
	}

	public String getName() 
	{
		return cusName;
	}


	public void setName(String cusName) 
	{
		this.cusName = cusName;
	}


	public String getPhone() 
	{
		return cusPhone;
	}


	public void setPhone(String cusPhone) 
	{
		this.cusPhone = cusPhone;
	}


	public String getAddress() 
	{
		return cusAddress;
	}


	public void setAddress(String cusAddress) 
	{
		this.cusAddress = cusAddress;
	}

	@Override
	public String toString() 
	{	StringBuffer sb = new StringBuffer();
		sb.append("\n "+cusName);
		sb.append("\n "+cusPhone);
		sb.append("\n "+cusAddress);
	return (sb.toString());
	}

}
