#include <iostream>
using namespace std;

bool solution(int input) {
	int original = input;
	int reverse = 0;

	while (input > 0) {
		reverse = reverse * 10 + input % 10;
		input /= 10;
	}

	return original == reverse;

}