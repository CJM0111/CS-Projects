import java.io.*;
import java.util.*;
/**
 The Sorting of Sorts Program ~
 Calculates/Displays the running times of 5 different sorting algorithms
 @author Chris McDonald MainSort class
 */

public class MainSort implements Comparable
{
    // sorting algorithms
    public static void select(Comparable []A)
    {
        for(int n=A.length; n>1; n--)
        {
            int maxpos=findmax(A,n);
            swap(A,maxpos,n-1);
        }
    }
    private static void swap(Object [] A, int x, int y)
    {
        Object temp=A[x];
        A[x]=A[y]; A[y]=temp;
    }
    private static int findmax(Comparable [] A,
                               int n)
    {
        int maxsofar=0;
        for(int i=1; i<n; i++)
            if(A[i].compareTo(A[maxsofar])>0)
                maxsofar=i;
        return maxsofar;
    }
    public static void bubble(Comparable [] A)
    {
        // loop for passes
        for(int i=0; i<A.length; i++)
            // loop to swap items out of order
            for(int j=0; j+1<A.length; j++)
                if(A[j].compareTo(A[j+1])>0)
                    swap(A,j,j+1);
    }
    public static void insertion(Comparable [] A)
    {
        for(int toinsert=1; toinsert<A.length;
            toinsert++)
        {  // copy stuff over
            Comparable save=A[toinsert];
            int j;
            for(j=toinsert; j>0 &&
                A[j-1].compareTo(save)>0; j--)
                A[j]=A[j-1];
            A[j]=save;
        }
    }
    public static void insert(Comparable [] A, int offset, int gap)
    {
        for(int toinsert=offset+gap;
            toinsert<A.length; toinsert+=gap)
        {  // copy stuff over
            Comparable save=A[toinsert];
            int j;
            for(j=toinsert; j>=gap &&
                A[j-gap].compareTo(save)>0; j-=gap)
            { A[j]=A[j-gap]; }
            A[j]=save;
        }
    }
    public static void shell(Comparable [] A)
    {
        int gap=A.length/4;
        while(gap>1)
        {
            // sort groups
            for(int offset=0; offset<gap; offset++)
                insert(A,offset,gap);
            // reduce the gap
            //System.out.println("gap="+gap);
            gap=(int)(gap/2.2);
            // see what happened
            
            //for(int i=0; i<A.length; i++)
                //System.out.println(A[i]);
            //System.out.println("");
        }
        insertion(A);
    }
    public static void quick(Comparable [] A)
    {
        quick(A,0,A.length-1);
    }
    private static void quick(Comparable [] A, int start, int stop)
    {
        // base cases
        // length 0 or 1:
        if(stop<=start) return;
        // length 2
        if(start+1==stop)
        {
            if(A[start].compareTo(A[stop])>0)
                swap(A,start,stop);
            return;
        }
        // recursive case
        int pivot=partition(A,start,stop);
        quick(A,start,pivot-1);
        quick(A,pivot+1,stop);
    }
    private static int partition(Comparable [] A, int start, int stop)
    {
        Comparable pivot=A[stop];
        int right=stop-1;
        int left=start;
        while(left<right)
        {
            // move left to find large items
            while(A[left].compareTo(pivot)<0)
                left++;
            // move right to find small items
            while(right>=start &&
                  A[right].compareTo(pivot)>=0)
                right--;
            // swap
            if(left<right)
                swap(A,left,right);
        }
        swap(A,left,stop);
        return left;
    }
    public static void merge(Comparable [] A)
    {
        mergesort(A,0,A.length-1);
    }
    private static void mergesort(Comparable [] A,int start, int stop)
    {
        // base cases
        // length 0 or 1:
        if(stop<=start) return;
        // length 2
        if(start+1==stop)
        {
            if(A[start].compareTo(A[stop])>0)
                swap(A,start,stop);
            return;
        }
        // recursive case
        int mid=(start+stop)/2;
        mergesort(A,start,mid);
        mergesort(A,mid+1,stop);
        domerge(A,start,stop);
    }
    private static void domerge(Comparable [] A, int start, int stop)
    {
        int mid=(start+stop)/2;
        Comparable [] B=new Comparable[stop-start+1];
        int left=start;
        int right=mid+1;
        for(int i=0; i<B.length; i++)
        {
            // does it come from the left?
            if(right>stop // right is empty
               || (left<=mid && // left is not empty
                   A[left].compareTo(A[right])<0))
                B[i]=A[left++];
            else
                B[i]=A[right++];
        }
        for(int i=0; i<B.length; i++)
            A[start+i]=B[i];
    }
    // data
    static Integer [] data;
    static int i;
    static int x;
    static int y;
    static int z;
    static int n;
    static char go;
    static char enter;
    
    public static void main(String [] args)
    throws IOException
    {
        Scanner cin=new Scanner(System.in);
        // loop to reset data and compare algorithms again
        do
        {
            input(cin, n);
            // array for the random numbers to be sorted
            int [] sort = new int[n];
            // creates an object using the Integer wrapper class
            data = new Integer[sort.length];
            // loop fills the data object array with the random numbers, and prints if
            // there are less then 101 integers
            for(i=0; i<n; i++)
            {
                int number = (int)(1+n*Math.random());
                sort [i] = number;
                if(n<=100) { System.out.println(number); }
                data[i] = new Integer(sort[i]);
            }
            sort(cin, go, data, i, x, y, z);
            restart(cin, enter);
        }
        while(enter == 'y' || enter == 'Y');
    }
    // method for inputing the number of integers to sort
    public static void input(Scanner cin, int n)
    {
        System.out.println("Please enter the integer value you would like to use.");
        n = cin.nextInt();
        System.out.println("This is your integer: " + n + ".");
    }
    // method for sorting data; also uses time method
    public static void sort(Scanner cin, char go, Integer [] data, int i, int x, int y, int z)
    {
        System.out.println("Do you want to sort your data? (Y or N)");
        go = cin.next().charAt(0);
        if(go == 'y' || go == 'Y')
        {
            /*y = (int)System.currentTimeMillis();
             select(data);
             time(data, i, x, z);
             y = (int)System.currentTimeMillis();
             merge(data);
             time(data, i, x, z);*/
            int h = (int)System.currentTimeMillis();
            quick(data);
            int j = (int)System.currentTimeMillis();
            int u = j-h;
            System.out.println("This is your run time: " + u);
            //time(data, i, x, z);
            y = (int)System.currentTimeMillis();
            insertion(data);
            time(data, i, x, z);
            /*y= (int)System.currentTimeMillis();
             bubble(data);
             time(data, i, x, z);*/
        }
        
    }
    // method to call the time after the sorting algorithm takes place
    // and calculate/display what the run time is in milliseconds
    // also prints out sorted data if there are less than 101 integers
    public static void time(Integer [] data, int i, int x, int z)
    {
        z = (int)System.currentTimeMillis();
        x = z-y;
        System.out.println("The run time is: " + x);
        for(int pos=0; pos<data.length; pos++)
        {
            if(data.length<=100){ System.out.println(data[pos]); }
        }
        x = 0;
    }
    // method for user input to decide to use the program again
    public static void restart(Scanner cin, char enter)
    {
        System.out.println("Do you want to run this program again? (Y or N)");
        enter = cin.next().charAt(0);
    }
    // compareTo function uses the built-in Comparable interface to compare the objects
    public int compareTo(Object o)
    {
        Integer x = (Integer) o;
        return data[i].compareTo(data[i-1]);
    }
}