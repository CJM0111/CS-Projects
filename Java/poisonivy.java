import java.io.*;
import java.util.*;

public class poisonivy
{
    // data
    static camp camper;
    static camp camper2;
    static camp camper3;
    static camp name;
    static char command;
    static double sum;
    static double total;
    static double avg;
    static int boy;
    static int girl;
    
public static void main(String [] args)
throws IOException
{
    Scanner campfile=new Scanner(new FileReader("camp.txt"));
    Scanner cin=new Scanner(System.in);
    // creates an object for the binary search tree
    BST tree=new BST();
    System.out.println("Welcome to Camp Posanivee!!");
    // loops until the Q command is given and then terminates the program
    while(command != 'Q')
    {
        // reads in the command and prints it out
        command = campfile.next().charAt(0);
        System.out.print("\nCommand: " + command);
        // functions based on the command
        help();
        enroll(campfile, tree);
        withdraw(campfile, tree);
        display(campfile, tree);
        average();
        list(tree);
        gender(tree);
        preorder(tree);
    }
    System.out.println("\nEnd of program.");
    System.out.println("Bring plenty of calomine!");
}
    // methods
    /**
     displays the help command
     @param the help command
     */
    public static void help()
    {
        if(command == 'H')
        {
            System.out.println("Here is a list of commands: ");
            System.out.println("H = Help: print a list of commands");
            System.out.println("E = Enroll a new camper(insert)");
            System.out.println("W = Withdraw a camper(delete)");
            System.out.println("D = Display the age and gender of a camper");
            System.out.println("A = Print the average age of the campers");
            System.out.println("L = List all campers names in alphabetical order");
            System.out.println("S = Print the number of boy and girl campers");
            System.out.println("P = List all campers names in preorder");
            System.out.println("Q = Quit");
        }
    }
    /**
     enrolls the new campers in the camp
     @param enrolls the new camper
     */
    public static void enroll(Scanner campfile, BST tree)
    {
        if(command == 'E')
        {
        camper = new camp(campfile);
        tree.insert(camper);
        sum = sum + camper.getAge();
        total++;
        System.out.println(camper);
        System.out.println("New camper added.");
        }
    }
    /**
     withdraws the campers already enrolled in the camp
     @param withdraws a camper
     */
    public static void withdraw(Scanner campfile, BST tree)
    {
        if(command == 'W')
        {
            camper = new camp(campfile);
            tree.delete(camper);
            sum = sum - camper.getAge();
            total--;
            System.out.println(" " + camper.getCamper());
            System.out.println("Camper withdrawn.");
        }
    }
    /**
     displays the name, age and gender of a camper
     @param diplays name, age and gender
     */
    public static void display(Scanner campfile, BST tree)
    {
        if(command == 'D')
        {
            name = new camp(campfile);
            System.out.print(" " + name.getCamper());
            camper3 = (camp)tree.lookup(name);
            if(camper3 == null)
            {
                System.out.println("Camper not found.");
            }
            else
            {
                System.out.println("\nName: " + camper3.getCamper() + "\nAge: " + camper3.getAge() + "\nGender: " + camper3.getGender());
            }
        }
    }
    /**
     calculates and displays the average age of the campers enrolled
     @param calculates and displays the average age
     */
    public static void average()
    {
        if(command == 'A')
        {
            if(total == 0)
            {
                System.out.println("\nThere are no campers.");
            }
            else
            {
                avg = sum/total;
                System.out.println("\nAverage age = " + avg + ".");
            }
        }
    }
    /**
     displays the camper in alphbetical order by first their name
     @param displays campers in alphabetical order
     */
    public static void list(BST tree)
    {
        if(command == 'L')
        {
            System.out.println("\nAlphabetical List of Campers:");
            tree.reset(BST.INORDER);
            while(tree.hasNext())
            {
                System.out.println(((camp)tree.getNext()).getCamper());
            }
        }
    }
    /**
     displays the # of campers based on gender
     @param displays the # of M/F campers
     */
    public static void gender(BST tree)
    {
        if(command == 'S')
        {
            tree.reset(BST.POSTORDER);
            while(tree.hasNext())
            {
                camper2 = ((camp)tree.getNext());
                if(camper2.getGender().charAt(0) == 'M')
                {
                    boy++;
                }
                if(camper2.getGender().charAt(0) == 'F')
                {
                    girl++;
                }
            }
            System.out.println("\nCamper count by gender: ");
            System.out.println("Boys = " + boy);
            System.out.println("Girls = " + girl);
        }
    }
    /**
     displays the campers in a preorder traversal of the tree they are located in
     @param does a preorder traversal of the tree
     */
    public static void preorder(BST tree)
    {
        if(command == 'P')
        {
            System.out.println("\nPreorder Traversal: ");
            tree.reset(BST.PREORDER);
            while(tree.hasNext())
            {
                System.out.println(((camp)tree.getNext()).getCamper());
            }
        }
    }
}