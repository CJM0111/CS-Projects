//*************************************************************************
// Program 1 - The Weather Program
// Chris McDonald, September 3, 2013
// Converts the temperature from degrees fahrenheit to degrees centigrade
//*************************************************************************
#include <iostream>

using namespace std;

int main()
{
// title
double fahrenheit;
cout << "** Welcome to the UNWEDGE Weather Program **" << endl;
cout << "Please enter the temperature in degrees Fahrenheit:";
cin >> fahrenheit;

// tells whether it's hot or cold
if(fahrenheit>85)
{
  cout << "It is hot. " << endl;
}
if(fahrenheit<20)
{
  cout << "It is cold. " << endl;
}

// convert to Centigrade
double centigrade;
centigrade = ((fahrenheit-32)*5)/9;

// display new temperature
cout << "The temperature is " << centigrade << " degrees centigrade" << endl;
cout << "Have a nice day!" << endl;

return 0;
}
