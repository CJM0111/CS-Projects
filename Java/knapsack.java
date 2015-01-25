import java.io.*;
import java.util.*;

/** 
 * The Knapsack Class creates an object for one item in the knapsack
 * @author Chris McDonald
 */

public class knapsack
{
    double price;
    double weight;
    
    /**
     Constructor to read from a file
     @param r Scanner object to read from
     */
    public knapsack(Scanner r)
    {
        price = r.nextInt();
        weight = r.nextInt();
    }
    // print - observer
    // @return a string representing the knapsack
    public String toString()
    {
        return "Here is the item: " + price + " " + weight;
    }
    // get the price - observer
    // @return the price
    public double getPrice()
    { return price; }
    // get the weight - observer
    // @return the weight
    public double getWeight()
    { return weight; }
}
