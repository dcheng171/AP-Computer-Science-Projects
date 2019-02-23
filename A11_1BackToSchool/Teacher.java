/**
 * Creates class Teacher with same parameters as person, but also with subject
 * and salary.
 *
 * @author David Cheng
 * @version Oct 22, 2018
 * @author Period: 4
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: N/A
 */
public class Teacher extends Person
{
    private String mySubject; // i.e. "Computer Science"

    private double mySalary; // i.e. 500000.0


    /**
     * Constructor for Teacher
     * 
     * @param name of teacher
     * @param age of teacher
     * @param gender of teacher
     * @param subject of teacher
     * @param salary of teacher
     */
    public Teacher( String name, int age, String gender, 
        String subject, double salary )
    {
        super( name, age, gender );
        mySubject = subject;
        mySalary = salary;
    }


    /**
     * returns subject
     * 
     * @return subject
     */
    public String getSubject()
    {
        return mySubject;
    }


    /**
     * returns salary
     * 
     * @return salary
     */
    public double getSalary()
    {
        return mySalary;
    }


    /**
     * changes subject
     * 
     * @param subject of teacher
     */
    public void setSubject( String subject )
    {
        mySubject = subject;
    }


    /**
     * changes salary
     * 
     * @param salary of teacher
     */
    public void setSalary( double salary )
    {
        mySalary = salary;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject
                        + ", salary: " + mySalary;
    }
}
