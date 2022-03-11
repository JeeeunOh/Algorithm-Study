#include <iostream>
using namespace std;

int main(){
    int N, kim, lim;
    cin >> N >> kim >> lim;

    int res=0;
    int flag=0;

    while(true){
        int arr[100001]={0}; // 매번 토너먼트 리셋
        res++; // res번째 대결
        int d = 1 << res;
        int cnt=0;

        for(int i=0 ; i<N; i++){
            if(i%d==0) cnt++;
            arr[i]=cnt;
        }

        if(arr[kim-1]==arr[lim-1] && arr[kim-1]!=0) {
            flag=1;
            break;
        }
    }
    if(flag) cout << res << endl;
    else cout << -1 << endl;
}