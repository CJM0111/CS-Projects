import java.io.*;
import java.util.*;

public class camp implements Comparable
{
    // data
    char command;
    String camper;
    int age;
    String gender;
    String blank;
    
    /** 
     Constructor to read form a file
     @param r Scanner object to read from
     */
    public camp(Scanner r)
    {
        if(r.hasNext())
        {
            camper = r.next();
            if(r.hasNextInt())
            {
                age = r.nextInt();
                if(r.hasNext())
                {
                gender = r.next();
                blank = r.nextLine();
                }
            }
        }
        else
        {
            blank = r.nextLine();
        }
        
    }
    /**
     print - observer
     @return a string representing the info
     */
    public String toString()
    {
        return command + " " + camper + " " + age + " " + gender;
    }
    /**
     get the command - observer
     @return the command
     */
    public char getCommand()
    { return command; }
    /**
     get the camper's name - observer
     @return the camper's name
     */
    public String getCamper()
    { return camper; }
    /**
     get the age of the camper - observer
     @return the camper's age
     */
    public int getAge()
    { return age; }
    /**
     get the gender of the camper - observer
     @return the camper's gender
     */
    public String getGender()
    { return gender; }
    /**
     CompareTo function
     Uses built-in comparable interface
     */
    public int compareTo(Object x)
    {
        camp b=(camp) x;
        return camper.compareTo(b.camper);
    }
}