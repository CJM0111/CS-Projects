//*******************************************************************
// Guessing Game - Program 03
// Chris McDonald 19 September, 2013
// Game: guessing a number 1-100 generated randomly by the computer
//*******************************************************************
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <cmath>

using namespace std;

// this function generates a random number 
double numR(double numberR)
{
srand(time(NULL));
numberR = 1 + rand() % 100;
return numberR;
}

int main()
{
  char play;
  // starts a new game if user wants to play again (loop)
  do
    {
      int num;
      double numberR;
      int guess;
      
      
      // uses function to generate random number
      num = numR(numberR);
      cout << "**Welcome to the Guessing Game** " << endl;
      cout << "I have a number between 1 and 100. Can you guess it?" << endl;
      
       // loops game until the correct guess is made
       do
       {
         cout << "Enter your guess: ";
         cin >> guess ;
         // calculates absolute value
		 int ab;
         ab = num-guess;
      
         if(ab<0)
         {
           ab = ab*-1;
         }
         // tells whether the guess is high, low or correct
         if(ab>=30 && guess>num)
         {
           cout << "You look like Frankenstein, WAY too high " << endl;
         }
         if(ab>=10 && ab<30 && guess>num)
         {
           cout << "You resemble Big Foot, too high" << endl;
         }
         if(ab<10 & guess>num)
         {
           cout << "You are definitely a hobbit, barley too high " << endl;
         }
         if(ab>=30 && guess<num)
         {
           cout << "You're a pig, WAY too low " << endl;
         }
         if(ab>=10 && ab<30 && guess<num)
         {
           cout << "You're a cow, too low" << endl;
         }
         if(ab<10 && guess<num)
         {
           cout << "You're a dog, barley too low" << endl;
         }
         // gives option to play again after winning
	     if(guess==num)
         {
         cout << "You Win!!!  " << endl;
         cout << "Play again? (Y or N) " << endl;
         cin >> play;
         }
        }    
        while(guess!=num);
    }
    while(play == 'y' || play== 'Y');

  return 0;
}

