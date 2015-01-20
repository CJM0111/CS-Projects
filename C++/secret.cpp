// Chris McDonald
// Program 5; Secret Message Program
// Allows user to encrypt/decrypt messages

#include <iostream>
#include <cstring>
#include <fstream>
#include <cctype>
// used for the isalpha statement

using namespace std;

// function for encrypting the message
void masterE(char p[], int i, int Z[])
{

	// for loop to go through every character, the length is dependent on array value
	for(i=0; i<strlen(p); i=i+1)
	{
		// ignores spaces
		if(p[i]== ' ')
			{
			p[i]= ' ';
			}
		else
			{
			// determines if it's a letter
			if(isalpha(p[i]))
				{
				// used to wrap around
				if(p[i]=='x' || p[i]== 'X' || p[i]== 'y' || p[i]=='Y' || p[i]=='z' || p[i]=='Z')
					{
					p[i]=p[i]-23;
					}
				else
					{
					// Caesar's cipher
					p[i]=p[i]+3;
					}
				}
			else
				{
				// ignores all non-letters
				p[i]=p[i];
				}
		}
	}
	cout << p << endl;
}

// function to decrypt
void masterD(char p[], int i, int Z[])
{

	// same as for loop above
	for(i=0; i<strlen(p); i=i+1)
	{
		if(p[i]== ' ')
			{
			p[i]= ' ';
			}
		else
			{
			if(isalpha(p[i]))
				{
				// decryption
				p[i]=p[i]-3;

				// if it is not a letter
				if(isalpha(p[i])==false)
					{
					// decrypts using -3 and the wrap around -23
					p[i]=p[i]+26;
					}
				}
				else
					{
					p[i]=p[i];
					}
			}
	}
	cout << p << endl;
}

// function to open a file
void open(char file[], char p[])
{
	cout << "Enter your file name: " << endl;
	cin >> file;

	ifstream message(file);

	message.getline(p, 100);

	cout << "This is your file: " << p << endl;
}

// function to save to a file
void store(char document[],char p[])
{

	cout << "What file do you wish to save your secret message to? " << endl;
	cin >> document;
	
	ofstream store(document);
	
	store << p << endl;

	// closes file
	store.close();

	cout << "Thank you for using this classified program. " << endl;
}


int main()
{
char p[100];
char file[100];
char document[100];
char an;
int Z[25];
int i;

cout << "Welcome, You know what to do. " << endl;

// opens file for user
open (file, p);


cout << "Would you like to encrypt or decrypt your message? (E or D): " << endl;
cin >> an;
	if(an=='E' || an=='e')
		{
			cout << "The encrypted form of your message is: " << endl;
			// encrypts message
			masterE(p, i, Z);

			// saves to desired file
			store(document, p);
		}

	if(an=='D' || an=='d')
		{

			cout << "The decrypted form of your message is: " << endl;

			// decrypts message
			masterD(p, i, Z);
		}

return 0;
}
