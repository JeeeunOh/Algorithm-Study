#include <iostream>
using namespace std;

int main(){
    int arr[3]={300,60,10};
    int cnt[3]={0};
    int T;
    cin >> T;

    for(int i=0 ; i<3 ; i++ ){
        if(T>=arr[i]){
            cnt[i]=T/arr[i];
            T-=cnt[i]*arr[i];
        }
    }

    if(T>0) cout << -1 << endl;
    else {
        for(int i=0 ;i<3 ; i++){
            cout << cnt[i] << " ";
        }
        cout << endl;
    }

}