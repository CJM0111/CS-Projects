/** 
 Class for Date objects to be used by the Year3000 driver program.
 The Dating Game program
 @author Chris McDonald
 */
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;

public class MyDate implements DateInterface
{
    int m=0;
    int d=0;
    int y=0;
    int dow=0;
    /** @return the day of the month (1-31) */
    public int getDay()
    {
        return d;
    }
    /** @return the day of the week (0-6) */
    public int getDow()
    {
        return dow;
    }
    /** @return the month of the year (1-12) */
    public int getMonth()
    {
        return m;
    }
    /** @return the year (four digits) */
    public int getYear()
    {
        return y;
    }
    /** sets the date
     @param m the month of the year (1-12)
     @param d the day of the mongth (1-31)
     @param y the year (four digits)
     @param dow the day of the week (0-6) */
    public void set(int m, int d, int y, int dow)
    {
        
    }
    /** moves the date forward by exactly one day */
    public void tomorrow()
    {
        /** @param month[] the month of february */
        int [] month;
        month = new int[1];
        month[0] = 28;
        /** adds one to the date after using the yesterday function */
        if(m==12 && d==31)
        {
            d=0;
            m=1;
            y++;
        }
        d++;
        dow++;
        /** accounts for leap year */
        if(y%4==0 && y%100!=0 || y%100==0 && y%400==0)
        {
            month[0] = 29;
        }
        /** creates a loop for the days of the week */
        if(dow==6)
        {
            dow=0;
        }
        if(m==1 && d==month[0])
        {
            d=1;
            m++;
        }
        else
        {
            if(m==0 && d==31 || m==2 && d==31 || m==4 && d==31 || m==6 && d==31|| m==7 && d==31 || m==9 && d==31 || m==11 && d==31)
            {
                d=1;
                m++;
                if(m==12)
                {
                    m=1;
                    y++;
                }
            }
            else
            {
                if(m==3 && d==30 || m==5 && d==30 || m==8 && d==30 || m==10 && d==30)
                {
                    d=1;
                    m++;
                }
            }
        }
    }
    public void yesterday()
    {
        /** @param month[] the month of february */
        int [] month;
        month = new int[1];
        month[0] = 28;
        d--;
        dow--;
        /** accounts for leap year */
        if(y%4==0 && y%100!=0 || y%100==0 && y%400==0)
        {
            month[0] = 29;
        }
        /** creates a loop for the days of the week */
        if(dow==0)
        {
            dow=6;
        }
        if(m==3 && d==1)
        {
            d=month[0];
            m--;
        }
        else
        {
            if(m==1 && d==1 || m==2 && d==1 || m==4 && d==1 || m==6 && d==1|| m==8 && d==1 || m==9 && d==1 || m==11 && d==1)
            {
                d=31;
                m--;
                if(m==0)
                {
                    m=12;
                    y--;
                }
            }
            else
            {
                if(m==5 && d==1 || m==7 && d==1 || m==10 && d==1 || m==12 && d==1)
                {
                    d=30;
                    m--;
                }
            }
        }
    }
    /** @return the date as a String in the format "Monday March 18, 2002" */
    public String toString()
    {
        String week = Integer.toString(dow);
        String mon = Integer.toString(m);
        String day = Integer.toString(d);
        String year = Integer.toString(y);

        if(dow==0){week="Sunday";}
        if(dow==1){week="Monday";}
        if(dow==2){week="Tuesday";}
        if(dow==3){week="Wednesday";}
        if(dow==4){week="Thursday";}
        if(dow==5){week="Friday";}
        if(dow==6){week="Saturday";}
        //if(dow==7){week="Monday";}
        if(m==1){mon="January";}
        if(m==2){mon="February";}
        if(m==3){mon="March";}
        if(m==4){mon="April";}
        if(m==5){mon="May";}
        if(m==6){mon="June";}
        if(m==7){mon="July";}
        if(m==8){mon="August";}
        if(m==9){mon="September";}
        if(m==10){mon="October";}
        if(m==11){mon="November";}
        if(m==12){mon="December";}
        return "The date is " + week + " " + mon + " " + day + ", " + year;
    }
    public void today()
    {
        
    }
}