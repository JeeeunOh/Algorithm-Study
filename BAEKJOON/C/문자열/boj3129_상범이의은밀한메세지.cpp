#include <iostream>
#include <string>
using namespace std;

// b - ? => a
// 

int main(){
    string a,b;
    string answer;
    int numA[1000], numB[1000];
    // p는 16
    cin >> a >> b;

    for(int i=0 ; i<a.length(); i++){
        numA[i]=a[i]-'0';
        numA[i]-=49;
        cout << numA[i]<< " " << endl;
    }

    for(int i=0 ; i<b.length(); i++){
        numB[i]=b[i]-'0';
        numB[i]-=49;
        cout << numB[i]<< " ";
    }

    int idx=0; // b의 0번째부터 탐색
    int len=b.length();

    int d = numA[0]+numB[0];

    for(int i=1 ; i<a.length(); i++){
        int temp=numA[i]+numB[idx];
        if(d==temp)

        idx++;
        if(idx==len) break;
    }
}