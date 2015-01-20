import java.io.*;
import java.util.*;

/*
The ESP program calculates the average, median, max and min scores from a
selected text file and displays the letter grade each score received
Author - Chris McDonald
*/

class exam
{
    public static void main(String [] args)
        throws IOException
    {
        
        String stat;
        int[] letter;
        letter = new int[5];
        int[] test;
        test = new int[100000];
        // allows user inputs
        Scanner cin= new Scanner(System.in);
        System.out.println("Welcome to the Exam Statistics Program!");
        System.out.println("Please enter the name of your data file: ");
        // user inputs the text file
        stat= cin.nextLine();
        // scanner reads in the text file
        Scanner file= new Scanner(new FileReader(stat));
        int n = -1;
        int size = 0;
        // loop that places the integer values into an array/ counts # of integers
        while(file.hasNextInt())
        {
            n=n+1;
            test[n]=file.nextInt();
            size++;
        }
        // places the integer values into a new array with correct size
        int[] data;
        data = new int[size];
        for(int i=0; i<size; i++)
        {
            data[i] = test[i];
        }
        // calculates the average, median, min and max for the scores
        double sum = 0;
        double total = 0;
        double median;
        // method
        calculate(sum, total, data, size);
        // loop adds one to the letter grade according to the score value
        for(int i=0; i<size; i++)
        {
        
            if(data[i]<59)
            {
                letter[0]=letter[0]+1;
            }
            if(data[i]>59 && data[i]<70)
            {
                letter[1]=letter[1]+1;
            }
            if(data[i]>69 && data[i]<80)
            {
                letter[2]=letter[2]+1;
            }
            if(data[i]>79 && data[i]<90)
            {
                letter[3]=letter[3]+1;
            }
            if(data[i]>89)
            {
                letter[4]=letter[4]+1;
            }
        }
        // displays the letter grades
        System.out.println("Number of scores by letter grade:");
        System.out.println("A: " + letter[4]);
        System.out.println("B: " + letter[3]);
        System.out.println("C: " + letter[2]);
        System.out.println("D: " + letter[1]);
        System.out.println("F: " + letter[0]);
        // displays amount of scores
        System.out.println("The number of scores is: " + size);
    }
    //method to calculate the average, median, min and max scores
    static void calculate(double sum, double total, int [] data, int size)
    {
        
        // adds the scores together
        for(int i=0; i<size; i++)
        {
            total = total+data[i];
        }
        // averages the scores
        sum=total/size;
        // sorts the array in descending order
        Arrays.sort(data);
        double median;
        // if divisible by two, takes the average of the two middle numbers
        if(data.length % 2 == 0)
        {
            median = (data[data.length/2]+data[data.length/2-1])/2.0;
        }
        // else use the middle number
        else
        {
            median = data[data.length/2];
        }
        System.out.println("The average score is: " + sum);
        System.out.println("The median score is: " + median);
        System.out.println("The maximum score is: " + data[data.length-1]);
        System.out.println("The minimum score is: " + data[0]);
        
    }
    
}