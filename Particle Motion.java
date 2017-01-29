# Physics_Kinematics
Kinematics Library For University Physics

import java.math.*;

public class ProjectileMotion {
	
	//Data Members
	private double velocityFinal;
	private double velocityInitial;
	private double acceleration;
	private double initialPosition;
	private double finalPosition;
	private double time;
	
	//Constructors
	ProjectileMotion()
	{
		clearVelocityFinal();
		clearVelocityInitial();
		clearAcceleraton();
		clearIntialPosition();
		clearFinalPostion();
		clearTime();
	}
	
	ProjectileMotion( double Vf, double Vi, double A, double Ip, double Fp, double T)
	{
		loadVelocityFinal( Vf);
		loadVelocityInitial( Vi);
		loadAcceleraton( A);
		loadIntialPosition(Ip);
		loadFinalPostion(Fp);
		loadTime(T);
	}
	
	//Accesors
	public void printVelocityFinal()
	{
		System.out.println("Velocity final is: " + velocityFinal);
	}
	
	public void printVelocityInitial()
	{
		System.out.println("The initial velocity is:" + velocityInitial);
	}
	
	public void printAcceleration()
	{
		System.out.println("The acceleration of the object is:" + acceleration);
	}
	
	public void printInitialPosition()
	{
		System.out.println("The initial postion of the projectile is: " + initialPosition);
	}
	
	public void printFinalPosition()
	{
		System.out.println("The final postion of the projectile is: ");
	}
	
	//Modfiers
	private void clearVelocityFinal()
	{
		velocityFinal = 0;
	}
	
	private void clearVelocityInitial()
	{
		velocityInitial = 0;
	}

	private void clearAcceleraton()
	{
		acceleration = 0;
		
	}
	
	private void clearIntialPosition()
	{
		initialPosition = 0;
	}

	private void clearFinalPostion()
	{
		finalPosition = 0;
	}

	private void clearTime()
	{
		time = 0;
	}
	
	/*
	 * Methods for the initial loading of data
	 */
	
	public void loadVelocityFinal(double Vf)
	{
		velocityFinal = Vf;
	}
	
	public void loadVelocityInitial( double Vi)
	{
		velocityFinal = Vi;
	}
	
	public void loadAcceleraton(double A)
	{
		acceleration = A;
	}
	
	public void loadIntialPosition( double Ip)
	{
		initialPosition = Ip;
	}
	
	public void loadFinalPostion( double Fp)
	{
		finalPosition = Fp;
	}
	
	public void loadTime( double T)
	{
		time = T;
	}
	
	/*
	 * Methods involving equation 1:  Vf = Vi + AT
	 * We assume only on of the four variables is the unknown.
	 */
	
	public double calcUnknownVeloctyFinal1()
	{
		double temp = 0;
		temp = acceleration * time;
		temp = temp + velocityInitial;
		velocityFinal = temp;
		return temp;
		
		
	}
	
	public double calcUnknownVelocityInitial1()
	{
		double temp = 0;
		temp = velocityFinal;
		temp = temp - ( acceleration * time);
		velocityInitial = temp;
		return temp;
	}
	
	public double calcUnknownAcceleration1()
	{
		double temp;
		temp = ( velocityFinal - velocityInitial);
		temp = ( temp / time);
		acceleration = temp;
		return temp;
	}
		
	public double calcUnknownTime1()
	{
		double temp;
		temp = ( velocityFinal - velocityInitial);
		temp = ( temp / acceleration);
		time = temp;
		return temp;
	}

	public double CalculateDisplacement1()
	{
		double displacement;
		displacement = acceleration * time;
		return displacement;
	}
	
	/*
	 * Methods for the calculation of motion using the second form equation
	 */
	
	public double calcUnknownPositionFinal2()
	{
		double temp = 0;
		temp = time * time;
		temp = temp * acceleration;
		temp = temp / 2;
		temp = temp + ( velocityInitial * time);
		temp = temp + initialPosition;
		finalPosition = temp;
		return temp;
		
	}
	
	public double calcUnknownPositionInitial2()
	{
		double temp = 0;
		temp = time * time;
		temp = temp * acceleration;
		temp = temp / 2;
		temp = temp + ( velocityInitial * time);
		temp = finalPosition - temp;
		initialPosition = temp;
		return temp;
	}
	
	public double calcUnknownInitialVelocity2()
	{
		double temp = 0;
		double temp2 = 0;
		temp = (finalPosition - initialPosition);
		temp2 = time * time;
		temp2 = temp2 * acceleration;
		temp2 = temp2 / 2;
		temp = temp - temp2;
		temp = temp / 2;
		velocityInitial = temp;
		return temp;
	}
	
	public double calcUnknownAcceleration2()
	{
		double temp = 0;
		temp = ( finalPosition - initialPosition - ( velocityInitial * time));
		temp = temp * 2;
		temp = temp / (time * time);
		acceleration = temp;
		return temp;
		
	}
	
	public double calcUnknownTime2()
	{
		//Using Quadratic equation to solve for time in the second form equations.
		double temp1 = 0;  //Gives two answers
		double temp2 = 0;
		temp1 = ( velocityInitial * velocityInitial) - 4 * ( acceleration / 2) * ( initialPosition - finalPosition);
		temp1 = Math.pow(temp1, 0.5);
		temp1 = ((-1 * velocityInitial) + temp1) / (2 * (acceleration / 2));
		temp2 = ( velocityInitial * velocityInitial) - 4 * ( acceleration / 2) * ( initialPosition - finalPosition);
		temp2 = Math.pow(temp2, 0.5);
		temp2 = ((-1 * velocityInitial) + temp2) / (2 * (acceleration / 2));
		if ( temp1 > 0)
		{
			time = temp1;
			return temp1;
			
		}
		else
		{
			time = temp2;
			return temp2;
		}
	}
	
	/*
	 * Methods for calculating motion using the third form equations
	 */
	
	public double calcUnknownVelocityFinal3()
	{
		double temp = 0;
		temp = (velocityInitial * velocityInitial) + ( 2 * acceleration * ( finalPosition - initialPosition));
		temp = Math.pow(temp, 0.5);
		velocityFinal = temp;
		return temp;
	}
	
	public double calcUnknownVelocityInitial3()
	{
		double temp;
		temp = (velocityInitial * velocityInitial) - ( 2 * acceleration * ( finalPosition - initialPosition));
		temp = Math.pow(temp, 0.5);
		velocityInitial = temp;
		return temp;
	}
	
	public double calcUnknownAcceleration3()
	{
		double temp1 = 0;
		double temp2 = 0;
		temp1 = Math.pow(velocityFinal, 2);
		temp2 = Math.pow(velocityInitial, 2);
		temp1 = temp1 - temp2;
		temp2 = 2 * ( finalPosition - initialPosition);
		temp1 = temp1 / temp2;
		acceleration = temp1;
		return temp1;
		
	}
	
	public double calcUnknownInitialPosition3()
	{
		double temp = 0;
		temp = (Math.pow(velocityFinal, 2) * Math.pow(velocityInitial, 2)) / ( 2 * acceleration);
		temp = temp + finalPosition;
		initialPosition = temp;
		return temp;
		
	}
	
	public double calcUnknownFinalPosition3()
	{
		double temp;
		temp = ( Math.pow(velocityFinal, 2) * Math.pow(velocityInitial, 2)) / ( 2 * acceleration);
		temp = initialPosition - temp;
		finalPosition = temp;
		return temp;
	}
	
	/*
	 * Methods for the calculation  of motion using the fourth form equation
	 * 
	 */
	
	public double calcFinalPosition4()
	{
		double temp = 0;
		temp = ( velocityInitial + velocityFinal) * time;
		temp = temp / 2;
		temp = temp - initialPosition;
		finalPosition = temp;
		return temp;
	}
	
	public double calcInitialPosition4()
	{
		double temp = 0;
		temp = ( velocityInitial + velocityFinal) * time;
		temp = temp / 2;
		temp = finalPosition - temp;
		initialPosition = temp;
		return temp;
	}
	
	public double calcInitialVelocity4()
	{
		double temp = 0;
		temp = 2 * ( finalPosition - initialPosition);
		temp = temp /2;
		temp = temp - velocityFinal;
		velocityInitial = temp;
		return temp;
	}
	
	public double calcFinalVelocity4()
	{
		double temp = 0;
		temp = 2 * ( finalPosition - initialPosition);
		temp = temp /2;
		temp = temp - velocityInitial;
		velocityFinal = temp;
		return temp;
	}
	
	public double calcTime4()
	{
		double temp = 0;
		temp = 2 * ( ( finalPosition - initialPosition) / ( velocityInitial + velocityFinal));
		time = temp;
		return temp;
	}
	
	
}
