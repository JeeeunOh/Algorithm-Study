#include <iostream>
#include <map>
using namespace std;

int main(){
    int n;
    cin >> n;

    map<string, int> front;
    map<string, int> rear;

    for(int i=0 ; i<n ; i++){
        string s;
        cin >> s;
        front.insert({s,i});
    }
    
    for(int i=0 ; i<n ; i++){
        string s;
        cin >> s;
        rear.insert({s,i});
    }

    int res=0;

    for(auto iter : front){
         int f = front[iter.first];
         int r = rear[iter.first];
         if(f-r>0) res++;
    }
    cout << res << '\n';
}