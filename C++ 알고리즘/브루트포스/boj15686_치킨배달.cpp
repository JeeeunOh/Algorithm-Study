#include <iostream>
using namespace std;

int abs(int a, int b){
    return a>b? a-b:b-a;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int arr[51][51];
    int dp[51][51]; // 치킨집 매출 저장
    int N,M;

    cin >> N >> M;

    for(int i=1 ; i<=N ; i++){
        for(int j=1 ; j<=N ; j++){
            cin >> arr[i][j];
            if(arr[i][j]==2) dp[i][j]=0;
        }
    }

    for(int i=1 ; i<=N ; i++){
        for(int j=1 ; j<=N ; j++){
            if(arr[i][j]==1){ // 집 기준으로
                int d=200;
                int x=0, y=0;
                for(int k=1 ; k<=N ; k++){
                    for(int p=1 ; p<=N; p++){
                        if(arr[k][p]==2){
                            int dist=abs(i-k, j-p);
                            if(d<dist){
                                d=dist;
                                x=k; y=p;
                            }
                        }

                    }
                }
                dp[x][y]++;
            }
        }
    }
}
