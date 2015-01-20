// Chris McDonald
// The Pi Program
// Efficiently calculates the value of pi using parallel programming 

#include <iostream>
#include "mpi.h"
#include <cmath>

using namespace std;

int main(int argc, char* argv[])
{
  // initialize MPI
  MPI_Init(&argc,&argv);
  
  // determines id number
  int id;
  MPI_Comm_rank(MPI_COMM_WORLD,&id);
  
  // determines the total number of processes
  int np;
  MPI_Comm_size(MPI_COMM_WORLD,&np);

  // user inputs a value for N
  MPI_Status status;
  int N;
  int target;
  if(id==0)
  {
    cout << "Let's solve for the true value of pi, shall we? " << endl;
    cout << "Please enter N (The larger the number, the better the approximation): ";
	cin >> N;
	
	// share N with other processors
	for(target=1; target<np;
	  target=target+1)
	  {
		MPI_Send(&N,1,MPI_INT,target,0,MPI_COMM_WORLD);
	  }
  }
  else // obtain N from processor #0
  {
    MPI_Recv(&N,1,MPI_INT,0,0,
	  MPI_COMM_WORLD,&status);
  }
  
  // computes the values for starting and stoping
  int size=N/np;
  int start=1+id*size;
  int stop=(id+1)*size;
    
  // implies last
  if(id+1==np) 
     {stop=N;}
	
  // computes the sum
  double sum=0;
  double i;
  for(i=start; i<=stop; i=i+1)
  {
    sum=sum+1.0/(pow (i, 2.0));
  }
  
  // for testing purposes
  //cout << "ID=" << id
    //<< " start=" << start
	//<< " stop=" << stop
	//<< " sum=" << sum
    //<< " N=" << N << endl;
	//cout << "Answer=" << sumofsums << endl;
	
  // sends sum to processor #0	
  if(id!=0) 
  {
    MPI_Send(&sum,1,MPI_DOUBLE,0,1,MPI_COMM_WORLD);
  }
  // when id is 0
  else
  {
    double sumofsums=sum;
	double sumin;
	int src;
    for(src=1; src<np; src=src+1)
	{
	  MPI_Recv(&sumin,1,MPI_DOUBLE,src,1,MPI_COMM_WORLD,&status);
	  
	  sumofsums=sumofsums+sumin;
	}
	//cout << "Answer=" << sumofsums << endl;
	  
	// compute and display the value of pi
	double pi;
	pi=sqrt(6*sumofsums);
	cout << "Pi=" << pi << endl;
  }
 
  // stop MPI
  MPI_Finalize();
  
  return 0;
}