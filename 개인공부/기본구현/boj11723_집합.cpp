#include <iostream>
using namespace std;

int arr[21]={0};

void add(int x){
    if(arr[x]==0) arr[x]=1; 
}

void remove(int x){
    arr[x]=0;
}

void check(int x){
    cout << arr[x] << '\n';
}

void toggle(int x){
    if(arr[x]) arr[x]=0;
    else arr[x]=1;
}

void all(){
    for(int i=1 ; i<=20 ; i++) arr[i]=1;
}

void empty(){
    for(int i=1 ; i<=20 ; i++) arr[i]=0;
}

int main(){
    int t;
    cin >> t;
    while(t--){
        string input;
        int x;
        cin >> input >> x;
        if(input=="add") add(x);
        else if (input == "check") check(x);
        else if (input == "remove") remove(x);
        else if (input == "toggle") toggle(x);
        else if (input =="all") all();
        else if (input =="empty") empty();
    }

}