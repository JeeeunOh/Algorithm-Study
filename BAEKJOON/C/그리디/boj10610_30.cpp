#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(){
    string input;
    int arr[100001];
    cin >> input;
    int flag=0;

    int i=0;

    for(int i=0 ; i<input.length(); i++){
        arr[i] = input[i]-'0';
        flag+=arr[i];
    }

    sort(arr, arr+input.length());

    if(flag%3!=0 || arr[0]!=0) {
        cout << -1 << endl;
        return 0;
    }
    else{
        for(int i=input.length()-1 ; i>=0 ; i--){
            cout << arr[i];
        }
        cout << endl;
    }
}