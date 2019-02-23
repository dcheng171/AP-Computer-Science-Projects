/**
 * Creates class student with same parameters as Person, but with idNum and gpa.
 *
 * @author David Cheng
 * @version Oct 22, 2018
 * @author Period: 4
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: N/A
 */
public class Student extends Person
{
    private String myIdNum; // Student Id Number

    private double myGPA; // grade point average


    /**
     * Constructor for Student
     * 
     * @param name
     * @param age
     * @param gender
     * @param idNum
     * @param gpa
     */
    public Student( String name, int age, String gender, String idNum, double gpa )
    {
        // use the super class' constructor
        super( name, age, gender );

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }


    /**
     * returns idNum
     * 
     * @return idNum
     */
    public String getIdNum()
    {
        return myIdNum;
    }


    /**
     * returns gpa
     * 
     * @return gpa
     */
    public double getGPA()
    {
        return myGPA;
    }


    /**
     * changes idNum
     * 
     * @param idNum
     */
    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }


    /**
     * changes GPA
     * 
     * @param gpa
     */
    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " + myIdNum + ", gpa: " + myGPA;
    }
}
