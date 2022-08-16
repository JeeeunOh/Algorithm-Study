#include <iostream>
using namespace std;

int main(){
    int l,p,v;
    int i=1;
    while(true){
        int res=0;
        cin >> l >> p >> v; //p일 중 l일만 사용가능. 휴가 v일
        if(l==0 && p==0 && v==0) break;

        while(v){
            if(v>=p){
                res+=l;
                v-=p;
            } else if(v<l){
                res+=v;
                v=0;
            } else if(v<p){
                res+=l;
                v=0;
            }
        }

        cout << "Case " << i << ": "<< res << '\n';
        i++;
    }
}