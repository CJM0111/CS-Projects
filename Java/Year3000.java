import java.io.*;

/**
 Driver class for The Dating Game programming assignment.
 @author Jon Sorenson
 */
public class Year3000
{
    public static void main(String [] args) throws IOException
    {
        DateInterface d = new MyDate();
        d.set(1,29,2006,0);  // sets the date to Sunday, January 29th, 2006
        while(d.getYear()<3000)
        {
            d.tomorrow();
        }
        // at this point, d represents January 1, 3000
        System.out.println(d);
        d.set(1,29,2006,0);
        while(d.getYear()>=1800)
        {
            d.yesterday();
        }
        d.tomorrow();
        // at this point, d represents January 1, 1800
        System.out.println(d);
    }
}