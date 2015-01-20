//*************************************************************************
// Program 2 - The Tuition Bill Program
// Chris McDonald 01, September 10, 2013
// Calculates the tuition bill based on the credit hours
//*************************************************************************
#include <iostream>

using namespace std;

int main()
{
  int credits;
  int bill;
  // make sure it runs
  cout << "** Welcome to the Tuition Bill Program! ** " << endl;
  cout << " How many credits? (-1 to exit): " << endl; 
  cin >> credits;
  if(credits>=0 && credits<= 11)
  {
    bill = credits*1410;
  }
  if(credits>=12 && credits<=20)
  {
    bill = 16745;
  }
  if(credits>=21)
  {
    bill = 16745 + 1410*(credits-20);
  }
  cout << "The tuition bill is " << bill << endl;
  return 0;
}
