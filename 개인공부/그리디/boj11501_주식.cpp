#include <iostream>
using namespace std;



int main(){
    int T, N;

    cin >> T ;

    while(T--){
        cin >> N;

        int arr[1000001];
        for(int i=0 ; i<N ; i++) cin >> arr[i]; 

        int max[1000001]; // 뒤에서부터 주식 최댓값 정하기
        for(int i=N-1; i>=0 ; i--){
            if(i==N-1) max[N-1]=arr[N-1];
            else{
                if(max[i+1]<arr[i]) max[i]=arr[i];
                else max[i]=max[i+1];
            }
        }

        long long res=0;
        int count=0; // 현재보유주식갯수

        for(int i=0 ; i<N ; i++){
            if(arr[i]<max[i]) {
                res-=arr[i]; // 주식사기
                count++;
            }
            else if(arr[i]==max[i]){ // 주식 다 팔고 count 0 초기화
                res+=arr[i]*count;
                count=0;
            } 
        }

        cout << res << endl;
    }
}