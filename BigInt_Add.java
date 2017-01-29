/**
 * 
 * @author Christopher Wells
 *CSC 202 Section 001N
 * 
 * 	The Goal of the program is to add, subtract, divide and multiply large integers (up to 1000 digit).
 * 
 * Program Start: 01/13/2017
 * 
 * Program Update: 01/18/2017
 * 	The Changes to the program were as follows.  
 * 	1.  The program was ported form the NetBeans IDE to Eclipse to be more compatible with class computers.
 * 	2.  The toString() method was updated to return a string in the form -454654646556 
 * 	3.  The methods have been modified to make the program more readable,and easier to maintain
 *
 * Program Updated 01/29/2017
 * 1.  The Add function was added to allow for the addition of two BigInt
 * 2.  THe Subtract Function was added to allow for the subtraction of two BigInts
 */

import java.util.ArrayList;


public class BigInt {
	//Private Class Data
	//private String enteredString;  //Stores the user entered String, this is here for testing and comparison
	protected int length = 0;  //Stores the length of the array of integers.
	private ArrayList<Integer> theBigInt = new ArrayList<Integer>();
	private ArrayList<Integer> tempInt = new ArrayList<Integer>();
	private boolean isPositive = true;
	
	//Constructors
	BigInt()
	{
		
	}
	
	BigInt( String s)
	{
		this.setLength(0);
		this.setTheBigInt(s);
	}
	
	//Limited the Constructors to two cases.
	
	//Accessors
	//public String getEnteredString()
	//{
	//	return enteredString;
	//}
	
	protected boolean greaterThan( BigInt b) // a > b
	{
		boolean isGreater = true;
		
		if ( this.length < b.length)
		{
			isGreater = false; //The second number is a larger number by looking at the length
		}
		if ( this.length == b.length)
		{
			//We can not determine by looking at the lengths which is larger now we have to look in more detail
			int index = b.length;
			index--;
			while ( index >= 0)
			{
				//System.out.println("False" + index + " " + this.theBigInt.get(index) + " " + b.theBigInt.get(index));
				if ( this.theBigInt.get(index) < b.theBigInt.get(index))
				{
					isGreater = false; //here is a point where the second number is greater than the first
					//index = -1; //We know the answer no use in looking further
					//System.out.println("False" + index + " " + this.theBigInt.get(index) + " " + b.theBigInt.get(index));
					return isGreater;
				}
				if ( this.theBigInt.get(index) > b.theBigInt.get(index))
				{
					isGreater = true; //here is a point where the second number is greater than the first
					//index = -1; //We know the answer no use in looking further
					//System.out.println("False" + index + " " + this.theBigInt.get(index) + " " + b.theBigInt.get(index));
					return isGreater;
				}
				index--;
			}
		}
		
		return isGreater;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public boolean getIsPositive()
	{
		return isPositive;
	}
	
	//Modifiers
	protected void setLength(int i)
	{
		this.length = i;
	}
	
	protected BigInt subtract( BigInt b)
	{
		
		
		return b;
	}
	
	protected ArrayList<Integer> subtractTwoNumbers( ArrayList<Integer> a, ArrayList<Integer> b)
	{
		int lengtha = a.size();  //Stores the length of the passed number
		int lengthb = b.size();
		int index = 0; //Stores the index we will use as we traverse the two numbers
		int borrow = 0;  //Stores the borrow from the previous number
		int number = 0;  //Stores the number inserted into the new array
		ArrayList<Integer> temp = new ArrayList<> (); // Create a local array to hold the number 
		
		
		while ( ( index < lengtha) || ( index < lengthb))
		{
			
			if ( index < lengtha)
			{
				//The method is designed that the calling method will have Array a as the larger array
				// this is of course ignoring the sign of the arrays for the time being
				//In this case the lengtha has to be greater that lengthb
				if ( index < lengthb)
				{
					if ( a.get(index) < b.get(index))
					{
						//the current element in a is smaller than the current element in b
						//we will have to borrow form the N+1 position to do the subtraction
						borrow = -1;
						number = number + 10 + this.theBigInt.get(index);  
						number = number - a.get(index);
					}
					if ( a.get(index) > b.get(index))
					{
						number = this.theBigInt.get(index);
						number = number - a.get(index);
						borrow = 0;
					}
					if ( a.get(index) == 0)
					{
						borrow = -1;
						  
						number = 9 - a.get(index);
					}
				}
				temp.add(number);
				number = borrow;
				index++;
					
				
			}
			
			
		}
		
		//System.out.println(temp.toString()); //Remove Used to add the numbers together by hand and verify input to the class
		return temp;
		
		
	}
	
	protected void setTheBigInt(String s)
	{
		this.parseUserString(s);
		int tempLength = theBigInt.size();
		this.setLength(tempLength);
	}
	
	private void parseUserString(String s)
	{
		//Reading the string from front to back to make sure the syntax is correct
		//Also reading form the front to the back allows for better exception handling
		int index = 0;
		int number = 0;
		
		try 
		{
			while ( ( s.charAt(index) == ' ') && (index < s.length()))
			{
				index++; //Eliminate the leading blank spaces
			}
			if ( (s.charAt(index) == '-') && ( index < s.length()))
			{
				this.isPositive = false;  //Process the negative sign
				index++; // Move to the next element
			}
			if ( (s.charAt(index) == '+') && (index < s.length()))
			{
				index++; //Move to the next character in the string
			}
			while ( index < s.length())
			{
				if (Character.isDigit(s.charAt(index)))
				{
					//Reuse of Code from CSC 200
					number *= 10;
					number += s.charAt(index) - '0';
					index++;
					tempInt.add(number);
					number = 0;
					
				}
				else
				{
					throw new Exception("Invalid string data");
				}
			}
			
		}
		catch ( Exception e)
		{
			System.out.println(e);
		}
		this.createTheBigInt();
		
	}
	
	protected void setTheSign( boolean b)
	{
		this.isPositive = b;
	}
	
	protected String parseNumberToString(ArrayList<Integer> a)
	{
		int index = 0;
		char letter;
		String temp ="";
		int number = 0;
		while ( index < a.size())
		{
			number = a.get(index);
			letter = (char)(number + '0');
			temp += letter;
			index++;
			
		}
		//System.out.println(temp);
		//Now we need to flip the array to the correct order so we are leading with the LSD
		String returnString = "";
		index = temp.length();
		index--;
		while (index >=0)
		{
			returnString += temp.charAt(index);
			index--;
		}
		return returnString;
	}
	
	private void createTheBigInt()
	{
		int index = this.tempInt.size();
		index--;
		while (index >=0)
		{
			theBigInt.add(tempInt.get(index));
			index--;
		}
	}
	
	//Math Functions
	
	public BigInt add( BigInt b)
	{
		boolean otherBigIntSign = true;  //Used in the comparison of the two numbers
		boolean finalIsPositive = true; //Hold the sign of the final number;
		
		ArrayList<Integer> tempNumber = new ArrayList<Integer>();
		String test = "";
		/**
		 * The easiest way to view the math is if the signs are the same we are adding the numbers
		 * If the numbers are different we are subtracting the smaller number from the larger and keeping the 
		 * sign of the larger number.
		 */
		otherBigIntSign = b.getIsPositive();
		if (otherBigIntSign == this.isPositive)
		{
			tempNumber = this.addTwoDigits( b.theBigInt );
			test = this.parseNumberToString(tempNumber);
			if ( !this.isPositive)
			{
				finalIsPositive = false; // Both numbers were negative.
			}
		}
		else
		{
			if ( this.greaterThan(b))
			{
				System.out.println("Subtraction Time A");
				test = "987654321";
			}
			else
			{
				System.out.println("Subtraction Time B");
				test = "987654321";
			}
		}
		BigInt temp = new BigInt(test);
		temp.setTheSign(finalIsPositive);
		return temp;
	}
	
	public ArrayList<Integer> addTwoDigits( ArrayList<Integer> b)
	{
		int lengthPassed = 0;  //Stores the length of the passed number
		int index = 0; //Stores the index we will use as we traverse the two numbers
		int carry = 0;  //Stores the carry over form the addition
		int number = 0;  //Stores the number inserted into the new array
		ArrayList<Integer> temp = new ArrayList<> (); // Create a local array to hold the number 
		
		lengthPassed = b.size();
		while ( ( index < lengthPassed) || ( index < this.length))
		{
			number = carry; // add any carryover from the previous addition
			if (index < lengthPassed)
			{  // Check to see if the index ref is a valid location in the array, else skip the array
				number = number + b.get(index);  //Add the element at the nth location of the first array
			}
			if ( index < this.length)
			{  // Check to see if the index ref is a valid location in the array, else skip the array
				number = number + theBigInt.get(index);  //Add the element in the nth location
				
			}
			carry = number / 10; //Handle the cases where the addition is larger than 10 ie. 9+9 = 18 
			//This will be a 1;
			number = number % 10; // The remainder will be the number we insert into the array.
			temp.add(number);
			index++;
			//System.out.println("Number = " + number + " Carry = " + carry); //Testing the input
			number = 0;
			
		}
		if ( carry > 0)
		{
			temp.add(carry);
		}
		//System.out.println(temp.toString()); //Remove Used to add the numbers together by hand and verify input to the class
		return temp;
	}
	//Output
	
	@Override
	public String toString()
	{
		String stringOutput = "";
		
		int index = 0;
		while ( index < this.length)
		{
			stringOutput += theBigInt.get(index);
			index++;
		}
		if (!isPositive)
		{
			stringOutput += '-';
			
		}
		return stringOutput;
	}
	
	

}
