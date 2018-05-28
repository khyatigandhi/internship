package college;
import java.util.*;
public abstract class Person
{
	private String mName;
	private List<Subject> mSubject;
	public Person(String name)
	{
		mName=name;
		mSubject = new ArrayList<Subject>();
	}

	public void addSubject(Subject subject)
	{
		mSubject.add(subject);
	}
	public void addSubjects(List<Subject> subject)
	{
		mSubject.addAll(subject);
		
	}
	public void removeSubject(String subjectName)
	{
		int indexToRemove = -1;
		for(int i=0;i<mSubject.size();i++)
		{
			if(mSubject.get(i).getName().equals(subjectName)){
				indexToRemove = i;
				break;
			}
		}

		if(indexToRemove >= 0){
			mSubject.remove(indexToRemove);
		}
	}
	public void removeSubject(Subject subject)
	{
		mSubject.remove(subject);
	}
	public List<Subject> getAllSubjects()
	{
		return mSubject;
	}
	public void removeAllSubjects()
	{
		mSubject.removeAll(mSubject);
	}
	public String getName()
	{
		return mName;
	}

	



	   
	  
}

