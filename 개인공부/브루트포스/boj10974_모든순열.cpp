#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int main(){
    int N;
    cin >> N;
    int arr[8];
    for(int i=0 ; i<N ; i++){
        arr[i]=i+1;
    }
    do{
        for(int i=0 ; i<N; i++){
            cout << arr[i] << " ";
        }
        cout << endl;
    }while(next_permutation(arr, arr+N));
}