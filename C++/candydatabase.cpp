//*******************************************************************
// Candy Database - Program 04
// Chris McDonald 8 October, 2013
// A simple C++ program that will display a menu for the user
// with various options such as trick or treating
// or inventory tracking and storing data in a specific text file
//*******************************************************************
#include <iostream>
#include <fstream>

using namespace std;

//function to display command
char getcommand()
{
	char command;
		cout << "Command-> ";
		cin >> command;
	return command;
}
//function to display menu
void menu()
{
	cout << "Here is a list of commands: " << endl;
	cout << "E - Eat a piece of candy " << endl;
	cout << "T - Trick or Treat: get a piece of candy " << endl;
	cout << "I - Inventory listing " << endl;
	cout << "C - List candy types " << endl;
	cout << "M - Print this menu of commands " << endl;
	cout << "S - Save to the file candy.dat " << endl;
	cout << "L - Load from the file candy.dat " << endl;
	cout << "Q - Quit this program" << endl;
}

//function to display candy type
void type()
{
	cout << "Candy Types: " << endl;
	cout << "1 Candy Corn " << endl;
	cout << "2 Licorice " << endl;
	cout << "3 Jaw Breakers " << endl;
	cout << "4 Peanut Butter Cups " << endl;
	cout << "5 M&Ms " << endl;
	cout << "6 Other " << endl;
}

//function to trick or treat by adding 1 to the correct candy type
void trick(int candy[], int i)
{
	cout << "Pick a candy type (1-6): " << endl;
	cin >> i;
	candy[i]=candy[i]+1;
}

// function to eat candy by subtracting 1 if there is candy of that type
void eat(int candy[], int i)
{
  	cout << "Pick a candy type (1-6): " << endl;
  	cin >> i;
  	if(candy[i]>0)
  	{
  		candy[i]=candy[i]-1;
	}  
	else
	{
		cout << "You don't have any candy of that type! " << endl;
	}
}

// function to display inventory
void inventory(int candy[])
{
int sum;
int i;
sum=0;
	cout << "Candy Inventory: " << endl;
	cout << "Candy Corn: " << candy[1] << endl;
	cout << "Licorice: " << candy[2] << endl;
	cout << "Jaw Breakers: " << candy[3] << endl;
	cout << "Peanut Butter Cups: " << candy[4] << endl;
	cout << "M&Ms: " << candy[5] << endl;
	cout << "Other: " << candy[6] << endl;

//for loop to calculate the sum of the candy
	for (i=0; i<7; i=i+1)
	{
		sum+=candy[i];
	}
	cout << "Candy Total: " << sum << endl;
}

//main function
int main()
{
char command;
int i;
int candy [7] = {0,0,0,0,0,0,0};
int sum;

//tells the user how to begin using the program
	cout << "** Welcome to the Candy Database Program! **" << endl;
	cout << "Here is a list of commands: " << endl;
	cout << "E - Eat a piece of candy " << endl;
	cout << "T - Trick or Treat: get a piece of candy " << endl;
	cout << "I - Inventory listing " << endl;
	cout << "C - List candy types " << endl;
	cout << "M - Print this menu of commands " << endl;
	cout << "S - Save to the file candy.dat " << endl;
	cout << "L - Load from the file candy.dat " << endl;
	cout << "Q - Quit this program" << endl;

//loop that runs program through commands
do
{
//calls command to decide which function to call
command=getcommand();

//decides what to do based on command
	if(command == 'M' || command == 'm')
	{
		menu();
	}
	if(command == 'C' || command == 'c')
	{
		type();
	}
	if(command == 'T' || command == 't')
	{
		trick(candy, i);
	}
	if(command == 'E' || command == 'e')
	{
		eat(candy, i);
	}
	if(command == 'I' || command == 'i')
	{
		inventory(candy);
	}
	if(command == 'S' || command == 's')
	{
		//opens file
		ofstream treatbag("treatbag4.txt");

		//writes to file
		treatbag << candy[1] << " " << candy[2] << " " << candy[3] << " " << candy[4] 
		<< " " << candy[5] << " " << candy[6] << endl;

		//close the file
		treatbag.close();
	}
	if(command == 'L' || command == 'l')
	{
		//opens the file
		ifstream goods("treatbag4.txt");
		
		//reads in file
		goods >> candy[1] >> candy[2] >> candy[3] >> candy[4] >> candy[5] >> candy[6];

		//close the file
		goods.close();
	}
}

	//ends program if command is 'q' or 'Q'
	while (command != 'q' && command != 'Q');

return 0;
}
