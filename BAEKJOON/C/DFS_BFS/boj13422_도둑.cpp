#include <iostream>
#include <vector>
using namespace std;


int main(){
    int t;
    cin >> t;

    while(t--){

        int n,m,k;
        cin >> n >> m >> k; // 집 개수, 도둑 연속된 집개수, 자동방범장치
        vector<int> v(n+m, 0);
        
        for(int i=0 ; i<n ; i++){
            cin >> v[i];
        }
        
        int res=0, sum=0;
        
        for(int i=0 ; i<m ; i++){
            sum+=v[i];
        }

        if(sum<k) res++;

        if(n!=m){
            for(int i=0 ; i<n-1 ; i++){
                sum-=v[i];
                int next = i+m;
                if(next>=n) next-=n;
                sum+=v[next];
                if(sum<k) res++;
            }
        } 
        
        cout << res << '\n';

    }

}