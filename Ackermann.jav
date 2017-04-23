
import java.awt.Graphics;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Ack {
	
	private int m;
	private int n;
	private int result = 0;
	private int trace = 0;
	
	private int[][] table = new int[4][20000];  //Changed the array size so there would be a direct
	// addressing between the values being searched for and the array.
	
	//Construstors
	Ack()
	{
		this.initializeArray();  //initialize the arrays to a defined state
	}
	
	Ack( int m, int n)
	{
		this.setM(m);
		this.setN(n);
		this.initializeArray(); //initialize the arrays to a defined state
		//this.ackCalc(m, n);
	}
	
	//Setters
	
	private void initializeArray()
	{
		for ( int a = 0; a < 4; a++)
		{
			for ( int b = 0; b < 20000; b++)
			{
				table[a][b] = -1;  //Using a negative number since the Ackermann function is always positive
			}
		}
	}
	
	private void setM ( int M)
	{
		m = M;
	}
	
	private void setN ( int N)
	{
		n = N;
	}
	
	//Getters
	
	public int ackCalc( int M, int N)
	{
		if (M==0)
			return N + 1;
		if ( N == 0)
			return (ackCalc( M - 1, 1));
		else
			return ( ackCalc( M - 1, (ackCalc( M, N - 1))));
		
		
	}
	
	public int ackCalcTrace( int M, int N)
	{
		int number = 0;
		trace++;
		System.out.println(" Count= " + trace + "  M= " + M + "  N= " + N);
		if (M==0)
		{
			//trace++;
			//System.out.println(" Count= " + trace + "  M= " + M + "  N= " + N);
			number = N + 1;
			return number;
		}
			
		if ( N == 0)
		{
			//trace++;
			//System.out.println(" Count= " + trace + "  M= " + M + "  N= " + N); 
			number = ackCalcTrace( M - 1, 1);
			return number;
			
		}
			
		else
		{
			//trace++;
			//System.out.println(" Count= " + trace + "  M= " + M + "  N= " + N); 
			number = (ackCalcTrace( M - 1, (ackCalcTrace( M, N - 1))));
			return number;
			
		}
			
	}
	
	public int ackTable( int M, int N)
	{
		int number = 0;
		int temp =0;  //Holds the temporary value of N
		trace++;  //Still tracking the calls to the method to see if there is an improvement in the calls
		System.out.println(" Count= " + trace + "  M= " + M + "  N= " + N);
		if (M==0)
		{
			//There would be no gain to use a table lookup since this is not a recursive call
			number = N + 1;
			return number;
		}
			
		if ( N == 0)
		{
			//Now We will do a table lookup to see if we can eliminate a recursive call
			if ( table[M-1][1] >= 0)
			{
				number = table[M-1][1];
				//We have already calculated the value and do not need to call the method.
			}
			else
			{
				table[M-1][1] = ackTable( M - 1, 1);
				//We have not calculated the number, call the method again
				number = table[M-1][1];
				//Add this element to the table
			}
			
			return number;
			
		}
			
		else
		{
			//This is the start of the third case of the Ackermann Algorithm
			
			//Start Working from the inside out
			// Check for the value of ackTable(M, N-1)
			if ( table[M][N-1] >= 0)
			{
				temp = (table[M][N-1]);
				//Case of we have calculated the inside value
				if ( table[M-1][temp] >= 0)
				{
					number = table[M-1][temp];
					//The outer value has been calculated and can be used
				}
				else
				{
					//table[M-1][(table[M][N-1])] = ;  //The outer value has to be calculated
					number = ackTable( M-1, temp);  // Add this to the table
					table[M-1][temp] = number;
					//number = (ackCalcTrace( M - 1, (ackCalcTrace( M, N - 1))));
				}
				return number;
				
			}
			else
			{
				//number = (ackCalcTrace( M - 1, (ackCalcTrace( M, N - 1))));
				table[M][N-1] = ackTable( M, N-1);
				//Case of we need need to calculate the inside value
				temp = table[M][N-1];
				//Add the value to the table
				if ( table[M-1][(table[M][N-1])] >= 0)
				{
					number = table[M-1][(table[M][N-1])];
					//The outer value has been calculated and can be used
				}
				else
				{
					table[M-1][(table[M][N-1])] = ackTable( M-1, table[M][N-1]);  //The outer value has to be calculated
					number = table[M-1][(table[M][N-1])];  // Add this to the table
					//number = (ackCalcTrace( M - 1, (ackCalcTrace( M, N - 1))));
				}
			}
			//;
			return number;
			
		}
	}
	
	private void methodSelection( int choice)
	{
		int MChoice = 0;
		int NChoice = 0;
		Scanner keyboard = new Scanner(System.in);
		
		if ( choice != 4)
		{
			System.out.println( "Enter the value of m:");
			MChoice = keyboard.nextInt();
			System.out.println("Enter the value of n:");
			NChoice = keyboard.nextInt();
		}
		
		
		
		
		switch ( choice)
		{
		case 1:		
					System.out.println(" Value is: " + this.ackCalc(MChoice, NChoice));
					break;
		case 2:		System.out.println(this.ackCalcTrace(MChoice, NChoice));
					break;
		case 3:		System.out.println(this.ackTable(MChoice, NChoice));
					this.initializeArray();
					break;
		case 4:		System.out.println("Exiting Program");
					break;
		case 5:		System.out.println(this.ackGraph(MChoice, NChoice));
					break;
		default:	System.out.println("ERROR");
		}
		trace = 0;
		
		if ( choice != 4)
		{
			System.out.println( );
			
		}
		
	}
	
	//Display
	private int ackGraph( int M, int N)
	{
		StudentExampleActionListener test = new StudentExampleActionListener();
		int number = 0;
		Graphics page = null;
		trace++;
		System.out.println(" Count= " + trace + "  M= " + M + "  N= " + N);
		if (M==0)
		{
			//trace++;
			//System.out.println(" Count= " + trace + "  M= " + M + "  N= " + N);
			number = N + 1;
			//test.inputLineNumber1(trace, number, page);
			return number;
		}
			
		if ( N == 0)
		{
			//trace++;
			//System.out.println(" Count= " + trace + "  M= " + M + "  N= " + N); 
			number = ackCalcTrace( M - 1, 1);
			//this.drawLines(trace, number, page);
			return number;
			
		}
			
		else
		{
			//trace++;
			//System.out.println(" Count= " + trace + "  M= " + M + "  N= " + N); 
			number = (ackCalcTrace( M - 1, (ackCalcTrace( M, N - 1))));
			//this.drawLines(trace, number, page);
			return number;
			
		}
	}
	
	public void displayMenu ()
	{
		int choice = 0;
		Scanner keyboard = new Scanner(System.in);
		while ( choice != 4)
		{
			System.out.println("This program allows you to call the Ackermann function");
			System.out.println("Please choose a version of Ackermann Function.");
			System.out.println("\t 1) Ackermann value");
			System.out.println("\t 2) Ackermann trace");
			System.out.println("\t 3) Ackermann table lookup");
			System.out.println("\t 4) Quit playing with the Ackermann Function");
			System.out.println("\t 5) Ackermann Graph");
			System.out.println("Please choose one of the 4 choices");
			choice = keyboard.nextInt();
			this.methodSelection(choice);
		}
		
	}
	
	



}
