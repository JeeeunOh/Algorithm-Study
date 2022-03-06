#include <iostream>
using namespace std;

int main(){
    int arr[5];
    int min=100;
    for(int i=0 ; i<5 ; i++){
        cin >> arr[i];
        if(min>arr[i]) min = arr[i];
    }
    while(true){
        int count=0;
        for(int i=0 ; i<5 ; i++){
            if(min%arr[i]==0) count++;
        }
        if(count>=3) break;
        min++;
    }
    cout << min << endl;
}