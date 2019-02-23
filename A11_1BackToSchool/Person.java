/**
 * Creates a class Person with parameters of the basic info of a person
 *
 * @author David Cheng
 * @version Oct 22, 2018
 * @author Period: 4
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: N/A
 */
public class Person
{
    private String myName; // name of the person

    private int myAge; // person's age

    private String myGender; // 'M' for male, 'F' for female


    /**
     * Constructor for Person
     * 
     * @param name
     * @param age
     * @param gender
     */
    public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }


    /**
     * returns name
     * 
     * @return name
     */
    public String getName()
    {
        return myName;
    }


    /**
     * returns age
     * 
     * @return age
     */
    public int getAge()
    {
        return myAge;
    }


    /**
     * returns gender
     * 
     * @return gender
     */
    public String getGender()
    {
        return myGender;
    }


    /**
     * changes name
     * 
     * @param name
     */
    public void setName( String name )
    {
        myName = name;
    }


    /**
     * changes age
     * 
     * @param age
     */
    public void setAge( int age )
    {
        myAge = age;
    }


    /**
     * changes gender
     * 
     * @param gender
     */
    public void setGender( String gender )
    {
        myGender = gender;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}