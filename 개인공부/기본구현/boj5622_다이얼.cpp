#include <iostream>
#include <string>
using namespace std;

int change(char a){
    if(a=='A' || a=='B' || a=='C') return 3;
    else if(a=='D' || a=='E' || a=='F') return 4;
    else if(a=='G' || a=='H' || a=='I') return 5;
    else if(a=='J' || a=='K' || a=='L') return 6;
    else if(a=='M' || a=='N' || a=='O') return 7;
    else if(a=='P' || a=='Q' || a=='R' || a=='S') return 8;
    else if(a=='T' || a=='U' || a=='V') return 9;
    else if(a=='W' || a=='X' || a=='Y' || a=='Z') return 10;

    return 0;
}

int main(){
    string input;
    cin >> input;
    int sum=0;
    for(int i=0 ; i<input.length(); i++){
        sum+=change(input[i]);
    }
    cout << sum << endl;
}