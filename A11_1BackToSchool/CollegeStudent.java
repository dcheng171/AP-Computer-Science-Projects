/**
 * Creates a class CollegeStudent that extends Student class TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author David Cheng
 * @version Oct 22, 2018
 * @author Period: 4
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: N/A
 */
public class CollegeStudent extends Student
{
    private String myMajor; //i.e. "Computer Science"

    private int myYear; //1 = Freshman, 2 =  Sophomore...


    /**
     * Constructor for CollegeStudent
     * 
     * @param name of student
     * @param age of student
     * @param gender of student 
     * @param idNum of student
     * @param gpa of student
     * @param year of student
     * @param major of student
     */
    public CollegeStudent(
        String name,
        int age,
        String gender,
        String idNum,
        double gpa,
        int year,
        String major )
    {
        super( name, age, gender, idNum, gpa );
        myYear = year;
        myMajor = major;

    }


    /**
     * returns major
     * 
     * @return major
     */
    public String getMajor()
    {
        return myMajor;
    }


    /**
     * returns year of student
     * 
     * @return year
     */
    public int getYear()
    {
        return myYear;
    }


    /**
     * changes major
     * 
     * @param major of student
     */
    public void setMajor( String major )
    {
        myMajor = major;
    }


    /**
     * changes year
     * 
     * @param year of student
     */
    public void setYear( int year )
    {
        myYear = year;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: " + myMajor;
    }
}
