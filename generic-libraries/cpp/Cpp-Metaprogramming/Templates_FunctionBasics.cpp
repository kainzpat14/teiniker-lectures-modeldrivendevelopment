#include <iostream>
using namespace std;

// Generics or Templates as they are called in C++ are not only present at compile time, instead
// the compiler really generates a copy of a generic method or class for each type combination it is used with
// so our compare method below would actually exist 3 times in the program since its called via int, double and const char*
// in the main method
template <typename T> int compare(const T& one, const T& two) {
	if(one < two) {
		return -1;
	}
	if(two < one) {
		return 1;
	}
	return 0;
}

template <typename T> int compare2(const T& one, const T& two) {
	if(one < two) {
		return -1;
	}
	if(two < one) {
		return 1;
	}
	return 0;
}

int compare2(const char* one, const char* two) {
	return strcmp(one,two);
}


//its also possible to provide nontype templates, these templates are simply replaced by the compiler
// with concrete values, so for each different value of count, this method is copied and can then be optimized
// by the compiler to that exact count
template <int count> void outputNTimes(const char* text) {
	for(int i = 0;i<count; i++) {
		cout << text;
	}
	cout<<endl;
}

template <typename T> void print(const T& current) {
	cout << current << endl;
}

// With C++ 11 its even possible to provide a variable list of type parameters.
// keep in mind that the compiler still uses code generation, so this is not a recursive call
// but instead the compiler will generate sizeof(Args) - 1 implmentations of this method
// which will call each other
template <typename T, typename... Args> void print(const T& current, const Args&... args) {
	cout << current << ", ";
	print(args...);
}



struct coordinate {
	int x;
	int y;
};

int main(int argc, char **argv) {
	// our compare method can be used with all kinds of different types now:
	cout << "comparing 1 and 2: " << compare(1,2) << endl;
	cout << "comparing 1.0 and 2.0: " << compare(2.0,1.0) << endl;
	// since our method uses the > operator on the calling class and strings in c are const char pointers, this
	// simply compares pointers
	cout << "comparing pointers b and a: " << compare("b","a") << endl; //incorrect result: 1, expected -1
	struct coordinate p1 = {1,2};
	struct coordinate p2 = {3,4};
	// since code is generated and no inheritance schema like in Java is in place, using such a method with
	// an incompatible type, causes compiler errors within the method:
	//cout << compare(p1,p2) << endl;

	// furthermore autoconversion of parameters is not possible for templates, as the compiler does not know
	// whether to convert both to int or both to long
	//cout << compare(1L,1) << endl;

	// if we provide the type explicitely however, the compiler can automatically convert the values
	cout << "Comparing long and int: " << compare<int>(1L,1) << endl;

	// we can overload templates methods with nontemplated ones, as a result we can perform a correct
	// comparison between char arrays by providing as separate method for char arrays:
	cout << "comparing specialized 1 and 2: " << compare2(1,2) << endl;
	cout << "comparing specialized b and a: " << compare2("b","a") << endl;

	outputNTimes<2>(">");

	print("abc", 1, 3.0, false);
	return 0;
}
