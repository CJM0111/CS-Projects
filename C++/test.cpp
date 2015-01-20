#include<iostream>
using namespace std;

int Oogway=5;

int Tigress(int TaiLung)
{
  return TaiLung*2;
}

int Viper(int Monkey)
{
  Oogway=3;
  return Monkey+2;
}

void MrPing(int & dumpling, int & noodle)
{
  noodle=noodle*5;
  dumpling=dumpling-2;
  Oogway=Oogway+1;
}

int main()
{
  int Po=1, Shifu=5;

  cout << Po << " " << Shifu << endl;
  Po=Tigress(Shifu);
  cout << Po << " " << Shifu << endl;
  Shifu=Viper(Po);
  cout << Po << " " << Shifu << endl;
  MrPing(Po,Shifu);
  cout << Po << " " << Shifu << endl;
  MrPing(Shifu,Po);
  cout << Po << " " << Shifu << endl;
  cout << Oogway << endl;

  return 0;
}