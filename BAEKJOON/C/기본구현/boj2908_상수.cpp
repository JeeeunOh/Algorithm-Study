#include <iostream>
#include <string>
using namespace std;

int main(){
    string a,b;
    string newA="", newB="";
    cin >> a >> b;

    for(int i=a.length()-1 ; i>=0 ; i--){
        newA+=a[i];
    }

    for(int i=b.length()-1 ; i>=0 ; i--){
        newB+=b[i];
    }

    if(newA>newB) cout << newA << endl;
    else cout << newB << endl;
}