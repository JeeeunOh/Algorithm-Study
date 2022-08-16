#include <iostream>
using namespace std;

long long N,M;
long long arr[2000000001]={0};
long long res=9;
long long cnt=0;

int main(){
    cin >> N >> M;

    for(int i=N ; i<=M; i++){
        int temp=i;
        while(temp){
            if(temp%10==8) arr[i]++;
            temp/=10;
        }
        if(res>arr[i]) res=arr[i];

    }

    for(int i=N ; i<=M; i++){
        if(res==arr[i]) cnt++;
    }

    cout << cnt << endl;
}