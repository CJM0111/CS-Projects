import java.util.*;
import java.math.*;

public class log
{
	public static void main(String [] args)
	{
		BigInteger x = BigInteger.valueOf(1);
		BigInteger y = BigInteger.valueOf(2);
		BigInteger z = BigInteger.ZERO;
		BigInteger i = BigInteger.ZERO;
		BigInteger temp = BigInteger.valueOf(2);
		// brute force approach to the discrete log problem
		do
		{
			// raise 2 to an exponent with a Big Integer value
			for(;i.compareTo(x) <= 0;i = i.add(BigInteger.ONE))
			{
				if(i.equals(BigInteger.valueOf(1))){}
				else{y= y.multiply(temp);}
			}
			i = BigInteger.ONE;
			z = y.mod(BigInteger.valueOf(61));
			if(z.equals(BigInteger.valueOf(3))){}
			else{x = x.add(BigInteger.valueOf(1)); y = BigInteger.valueOf(2);}
		}while(!z.equals(BigInteger.valueOf(3)));
		System.out.println("For 2^x = 3 mod 61, where y is 2^x and z is y mod 61:");
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("z: " + z);
	}
}