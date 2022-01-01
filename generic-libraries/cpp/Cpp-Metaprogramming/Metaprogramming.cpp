#include <iostream>
#include <chrono>
using namespace std;

// with C++ we can have the compiler do logic for us at compile time, without the need to calculate such things
// at runtime

// You will notice that the programming style is functional and declarative after a fashion and you always start
// with the tail of your calculation. so in principle you can't do everything with it, but it can come in handy

template <int n> struct fibonacci {
	const static long long value = fibonacci<n-1>::value + fibonacci<n-2>::value;
};

template <> struct fibonacci<0> {
	const static long long value = 0;
};

template <> struct fibonacci<1> {
	const static long long value = 1;
};

template<bool condition, int Then, int Else>
struct If{
  const static int value = Then;
};

template<int Then,int Else>
struct If<false, Then, Else>{
 const static int value = Else;
};

template <int n1, int n2>
struct isHigher {
	const static bool value = n1>n2?true:false;
};

//no matter how many numbers we calculate, the runtime stays constant, the compile time however, does not.
#define FIB_N 50

int main(int argc, char **argv) {
	auto begin= chrono::system_clock::now();
	cout << FIB_N << "th Fibonacci number: " << fibonacci<FIB_N>::value << endl;
	auto end= chrono::system_clock::now();

    std::chrono::duration<double> diff = end - begin;
	cout << "Calc took " << diff.count()*1000 << "ms"<<endl;

	//its also possible to have the compiler evaluate conditions at compiletime
	cout << If<isHigher<FIB_N,10>::value, 1, -1>::value << endl;
}
