package college;
public class Subject
{
       private String mName;
       private int mCredit;
       private int mSyllabus;

    public Subject()
    {
        this("java", 6, 10);
    }
    public Subject(String name,int credits,int syllabus)
    {
        mName=name;
        mCredit=credits;
         mSyllabus=syllabus;
    }
    public String getName()
     {
        return mName;
    }
    public int getCridet()
    {
        return mCredit;
    }
    public int getSyllabus()
    {
        return mSyllabus;
    }
    public String toString()
    {
        return ("name= "+mName+" credit= "+mCredit+ "Syllabus= "+mSyllabus);
    }
}
