import java.io.*;
import java.util.*;
import java.math.*;
import java.security.SecureRandom;

/** 
 * RSA Encryption Program -
 * Manages RSA encryption/decryption and key generation
 * @author Chris McDonald
*/

public class rsaC
{
static int size;
static int lengthN;
static char EDchar;
static char block;
static char skip;
static char skip2;
static int hold;
static String messageToE;
static String stringOut;
static PrintWriter pout;
static BigInteger messageToD;
static BigInteger bigIntOut;
static BigInteger p, q;
static BigInteger n;
static BigInteger Phi;
static BigInteger e, d;
static BigInteger r1;
static BigInteger r2;
static SecureRandom random = new SecureRandom();
/** 
 * This method reads in a text file to be encrypted/decrypted
 * if the file contains blocked ciphertext, the method will 
 * read in the keys, decrypt the message and then store the 
 * decrypted text to the desired file
 */
public static void readIn()
throws IOException, FileNotFoundException
{
	System.out.print("Enter the name of your file. ");
	System.out.print("(The format should be /Users/name/~): ");
	Scanner jin= new Scanner(System.in);
	String fileName= jin.nextLine();
	Scanner fileIn=new Scanner(new FileReader(fileName));
	System.out.println("Encrypt or Decrypt?(E/D) ");
	String EDstring = jin.next();
	EDchar = EDstring.charAt(0);
	if(EDchar == 'E' || EDchar == 'e')
	{
		messageToE = fileIn.nextLine();
		while(fileIn.hasNextLine()){messageToE += fileIn.nextLine();};
		// removes all non-characters
		messageToE = messageToE.replaceAll("\\s","");
		messageToE = messageToE.replaceAll("\\W","");
		System.out.println("Plaintext: " + messageToE);
	}
	else
	{
	if(EDchar == 'D' || EDchar == 'd')
	{
		messageToE = fileIn.nextLine();
		if(fileIn.hasNextLine())
		{
			System.out.println("Ciphertext: " + messageToE);
			messageToD = new BigInteger("0");
			// converts into a BigInteger
			messageToD = messageToD.add(new BigInteger(messageToE));
			skip2 = 'Y';
			hold++;
			if(hold == 1){ readInKeys(); }
			block = 'B';
			encryptordecrypt();
			// if the ciphertext is seperated into blocks
			while(fileIn.hasNextLine())
			{
				messageToE = fileIn.nextLine();
				System.out.println("Ciphertext: " + messageToE);
				messageToD = new BigInteger("0");
				messageToD = messageToD.add(new BigInteger(messageToE));
				encryptordecrypt();
			}
		}
		else
		{
			System.out.println("Ciphertext: " + messageToE);
			System.out.println(messageToE);
			messageToD = new BigInteger("0");
			messageToD = messageToD.add(new BigInteger(messageToE));
		}
	}
	else
	{ System.out.println("INVALID INPUT."); }
	}
	
}
/** 
 * This method reads in a text file with the public/private keys
 * and then calls the block method if the length of the message is
 * greater than n
 */
public static void readInKeys()
throws IOException, FileNotFoundException
{
	String end = "";
	do
	{
    end = "yes"; 
	System.out.print("Load your key here~ ");
	System.out.print("Enter the name of your file. ");
	System.out.print("(The format should be /Users/name/~): ");
	Scanner jin= new Scanner(System.in);
	String fileN= jin.nextLine();
	Scanner fileIn=new Scanner(new FileReader(fileN));
	System.out.println("Is the key public(0) or private(1)?");
	int key = jin.nextInt();
	String tempN, tempE, tempD, tempP, tempQ = " ";
	if(key == 0)
	{
		tempN = fileIn.nextLine();
		System.out.println("N:" + tempN);
		tempE = fileIn.nextLine();
		System.out.println("E:" + tempE);
		// converts to BigInteger
		n = (new BigInteger(tempN));
		e = (new BigInteger(tempE));
		lengthN = tempN.length();
		// computes the private key from the public key
		System.out.println("Do you want to generate the private key from the public key? Yes(0)/No(1)");
		int y = jin.nextInt();
		if(y == 0)
		{
			long time1 = new Date().getTime();
		    System.out.println("N: " + n);
		    rsaC x = new rsaC();
		    x.fermat(n);
		    long time2 = new Date().getTime();
			long runtime = (time2-time1)/1000;
			System.out.println("Run time: " + runtime);
			System.out.println("How many digits are p/q?");
			size = jin.nextInt();
			int z = (int) (Math.log(10)/ Math.log(2));
			int bits = size * z;
			p = r1; q = r2;
			n = p.multiply(q);
			Phi = p.subtract(BigInteger.valueOf(1));
			Phi = Phi.multiply( q.subtract( BigInteger.valueOf(1)));
			d = e.modInverse(Phi);
			System.out.println("D: " + d);
			System.out.println("N: " + n);
			end ="yes";
		}
	}
	if(key == 1)
	{
		tempN = fileIn.nextLine();
		System.out.println("n:" + tempN);
		tempD = fileIn.nextLine();
		System.out.println("d:" + tempD);
		tempP = fileIn.nextLine();
		System.out.println("p:" + tempP);
		tempQ = fileIn.nextLine();
		System.out.println("q:" + tempQ);
		n = (new BigInteger(tempN));
		d = (new BigInteger(tempD));
		p = (new BigInteger(tempP));
		q = (new BigInteger(tempQ));
		lengthN = tempN.length();
	}
	System.out.println("Load the other key? Yes(0)/No(1)");
	int again = jin.nextInt();
	if(again == 0){ end = "no"; }
	}while(end=="no");
	block();
}
/** 
 * This method writes the encrypted/decrypted text to a file
 */
public static void store()
throws IOException, FileNotFoundException
{
	if(skip != 'Y')
	{
	System.out.print("Store your message. ");
	System.out.print("Enter the name of your file. ");
	System.out.print("(The format should be /Users/name/~): ");
	Scanner jin= new Scanner(System.in);
	String fileOut = jin.nextLine();
	pout=new PrintWriter(fileOut);
	}
	if(EDchar == 'E' || EDchar == 'e')
	{
		if(block == 'B')
		{
			String bigInt = bigIntOut.toString();
			pout.println(bigInt);
			skip = 'Y';
		}
		else
		{
		String bigInt = bigIntOut.toString();
		pout.println(bigInt);
		}
	}
	if(EDchar == 'D' || EDchar == 'd')
	{
		if(block == 'B')
		{
			pout.println(stringOut);
			skip = 'Y';
		}
		else{ pout.print(stringOut); }
	}
}
/** 
 * This method writes the public/private keys to a text file
 */
public static void storeKeys()
throws IOException, FileNotFoundException
{
	String end = "";
	do
	{
    end = "yes"; 
	System.out.print("Store your key here~ ");
	System.out.print("Enter the name of your file. ");
	System.out.print("(The format should be /Users/name/~): ");
	Scanner jin= new Scanner(System.in);
	String fileOut = jin.nextLine();
	PrintWriter output=new PrintWriter(fileOut);
	System.out.println("Is the key public(0) or private(1)?");
	int key = jin.nextInt();
	String tempN, tempE, tempD, tempP, tempQ = " ";
	if(key == 0)
	{
		System.out.println("The keys: "); 
		System.out.println("N: " + n);
		System.out.println("E: " + e);
		tempN = n.toString();
		tempE = e.toString();
		output.println(tempN);
		output.println(tempE);
		output.close();
	}
	if(key == 1)
	{
		System.out.println("The keys: ");
		System.out.println("N: " + n); 
		System.out.println("D: " + d);
		System.out.println("P: " + p);
		System.out.println("Q: " + q);
		tempN = n.toString();
		tempD = d.toString();
		tempP = p.toString();
		tempQ = q.toString();
		output.println(tempN);
		output.println(tempD);
		output.println(tempP);
		output.println(tempQ);
		output.close();
	}
	System.out.println("Store the other key?(Yes(0)/No(1)");
	int again = jin.nextInt();
	if(again == 0){ end = "no"; }
	}while(end=="no");
}
/** 
 * This method calculates p, q, n, Phi, e, and d 
 * and then calls the function to store the keys in a text file
 * After calculating n, the block method is called to determine
 * whether or not to separate the text into blocks
 */
public static void generateKeys()
throws IOException, FileNotFoundException
{
	Scanner jin= new Scanner(System.in);
	System.out.println("Enter your desired size for the prime numbers: ");
	size = jin.nextInt();
	// calculates the bit size for the desired digit size
	int x = (int) (Math.log(10)/ Math.log(2));
	int bits = size * x;
	p = BigInteger.probablePrime(bits, random);
	q = BigInteger.probablePrime(bits, random);
	n = p.multiply(q);
	System.out.println("N: " + n);
	String tempN = n.toString();
	lengthN = tempN.length();
	Phi = p.subtract(BigInteger.valueOf(1));
	Phi = Phi.multiply( q.subtract( BigInteger.valueOf(1)));
	do
	{ e = new BigInteger(2*bits, new Random()); }
	while( (e.compareTo(Phi) != 1)
	|| (e.gcd(Phi).compareTo(BigInteger.valueOf(1)) != 0));
	d = e.modInverse(Phi);
	storeKeys();
	block();
}
// separates the plain/cipher text into blocks
// if the message length > N
public static void block()
throws IOException, FileNotFoundException
{
	if(lengthN < messageToE.length())
	{
		block = 'B';
		String tempN = n.toString();
		lengthN = tempN.length();
		int sizeBlock = (lengthN-1)/2;
		int numofB = messageToE.length()/sizeBlock;
		if(messageToE.length()%sizeBlock != 0){ numofB++; }
		String currentBlock = "";
		String tempMessage = messageToE;
		for(int i=0;i<numofB; i++)
		{
			if((i+1) == numofB){ currentBlock=tempMessage.substring((i*sizeBlock)); }
			else
			{
				int upperLimit = (i+1)*sizeBlock;
				currentBlock = tempMessage.substring((i*sizeBlock), upperLimit);
			}
			messageToE = currentBlock;
			encryptordecrypt();
			store();
		}
	}
}
/**
 * Method to calculate the square root of a Big Integer
 * and then produce the next integer
 */
public BigInteger calcSQR(BigInteger N)
{
    if(N == BigInteger.ZERO || N == BigInteger.ONE) { return N; }
    BigInteger two = BigInteger.valueOf(2L);
    BigInteger x;
    // starting with x = N / 2 avoids magnitude issues with x squared
    for(x = N.divide(two);
        x.compareTo(N.divide(x)) > 0;
        x = ((N.divide(x)).add(x)).divide(two));
    if(N.compareTo(x.multiply(x)) == 0) {return x;} 
    else{ return x.add(BigInteger.ONE); }
}
/** 
 * Fermat's factorization method
 */
public void fermat(BigInteger N)
{
    BigInteger a = calcSQR(N);
    BigInteger b2 = (a.multiply(a).subtract(N));
    while(Square(b2) == false)
    {
    	a = a.add(BigInteger.valueOf(1));
        b2 = (a.multiply(a).subtract(N));
    }
    r1 = a.subtract(calcSQR(b2));
    r2 = N.divide(r1);
    System.out.println("Roots = ("+ r1 +") , ("+ r2 +")");
}
/** 
 * Method to check if N is a perfect square or not 
 */
public boolean Square(BigInteger N)
{
    BigInteger sqRoot = calcSQR(N);
    if(sqRoot.multiply(sqRoot).equals(N)){return true;}
    else{return false;}
}
/** 
 * This method acts as the menu for the program
 * Here the user may start fresh and begin by encrypting and go from there
 * or he/she may load known data and encrypt/decrypt
 */
public static void menu()
throws IOException, FileNotFoundException
{
	System.out.println("Create(0) or Load Keys(1)");
	Scanner jin= new Scanner(System.in);
	int choice = jin.nextInt();
	if(choice == 0)
	{
		generateKeys();
		if(block != 'B')
		{ encryptordecrypt(); }
	}
	if(choice == 1)
	{
		readInKeys();
		if(block != 'B')
		{ encryptordecrypt(); }
	}
}
/** 
 * This method performs the encryption/decryption algorithm on the given text
 */
public static void encryptordecrypt()
throws IOException, FileNotFoundException
{
BigInteger plaintextBig, ciphertextBig;
if(EDchar == 'E' || EDchar == 'e')
{
	plaintextBig = new BigInteger(messageToE, 36);
	ciphertextBig = plaintextBig.modPow(e,n);
	System.out.println("Ciphertext: " + 
	ciphertextBig.toString());
	bigIntOut = ciphertextBig;
}
if(EDchar == 'D' || EDchar == 'd')
{
	plaintextBig = messageToD.modPow(d,n);
	System.out.println("Plaintext After Decryption: " + plaintextBig.toString(36));
	stringOut = plaintextBig.toString(36);
	if(block == 'B'){ store(); }
}
}
public static void main(String[] args) 
throws IOException, FileNotFoundException
{
	readIn();
	if(skip2 != 'Y'){ menu(); }
	if(block != 'B'){ store(); }
	pout.close();
}
}