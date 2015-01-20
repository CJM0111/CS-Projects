import java.io.*;
import java.util.*;
import java.math.*;

public class prime
{
	public static void main(String [] args)
	{
		BigInteger prime = new BigInteger("1000000000");
		do
		{
		prime = prime.add(BigInteger.valueOf(1));
		if(prime.isProbablePrime(100))
		{
			System.out.println("Smallest prime p larger than one billion: p = " + prime);
		}
		else
		{
			System.out.println("Composite integer: " + prime);
		}
		}
		while(prime.isProbablePrime(100) == false);
	}
}