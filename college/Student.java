package college;
import java.util.*;
public class Student extends Person
{
	private double mCpi;
	private double mFees;

	public Student(String name){
		super(name);
		mCpi=0;
		mFees=0;
	}

	public void setResult(double cpi)
	{
		mCpi=cpi;
	}
	public double getResult()
	{
		return mCpi;
	}
	public void setFees(double fees)
	{
		mFees=fees;
	}
	public double getFees()
	{
		return mFees;
	}
	
}
