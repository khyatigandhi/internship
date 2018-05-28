package college;
import java.util.*;
public class Teacher extends Person
{
	
	private double mSalary;

	public Teacher(String name, double salary){
		super(name);
		mSalary = salary;
	}

	public Teacher(String name)
	{
		this(name, 0);
	}
	public void setSalary(double salary)
	{
		mSalary=salary;
	}
	public double getSalary()
	{
		return mSalary;
	}
	 
	
}
