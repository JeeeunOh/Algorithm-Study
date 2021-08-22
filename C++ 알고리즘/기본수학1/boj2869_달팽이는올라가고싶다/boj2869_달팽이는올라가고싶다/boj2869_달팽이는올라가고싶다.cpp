#include <iostream>
using namespace std;

int main()
{
	int a, b, v;
	cin >> a >> b >> v;
	int i = 0; 
	int cnt = 0;
	
	if ((v - a) % (a - b) == 0) cnt = (v - a) / (a - b);
	else cnt = (v - a) / (a - b) + 1;
	cout << cnt+1 << endl;
}