#include <iostream>
#include <stack>
using namespace std;

int main(){
    int n;
    int arr[101];
    stack<int> input;
    stack<int> temp;
    cin >> n ;
    for(int i=1 ; i<=n ; i++){
        int a;
        cin >> a;

        while(a--){
            int t = input.top();
            temp.push(t);
            input.pop();
        }
        input.push(i);
        while(!temp.empty()){
            int t = temp.top();
            temp.pop();
            input.push(t);
        }
    }
    int i=n;

    while(!input.empty()){
        int t = input.top();
        arr[i]=t;
        input.pop();
        i--;
    }

    for(int i=1 ; i<=n ; i++){
        cout << arr[i] << " ";
    }
}