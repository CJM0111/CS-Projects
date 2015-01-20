import java.io.*;
import java.util.*;

class guess
{
  public static void main(String [] args)
  {
  	do
  	{
  	int x;
    int number;
    number = (int)(1+100*Math.random());
    do
    {
	Scanner cin=new Scanner(System.in);
	
	System.out.println("Guess a number between 1 and 100: ");
	System.out.println(number);
	x=cin.nextInt();
	
	if(x<number)
	{
	System.out.println("Too low ");
	}
	if(x>number)
	{
	System.out.println("Too high ");
	}
	if(x==number)
	{
	System.out.println("You win! " + "Play again? (Y or N) ");
	char play=cin.next().charAt(0);
	}
	}
	while(x!=number);
	}
	while(play == 'Y');
  }
}