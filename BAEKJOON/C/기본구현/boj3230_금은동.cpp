#include <iostream>
#include <string>
using namespace std;

int main(){
    int N, M;
    int arrN[101], arrM[101];
    int first[101], last[101];
    
    cin >> N >> M;

    for(int i=1 ; i<=N ; i++) cin >> arrN[i]; 

    // 등수 재정립
    int cur=0;
    for(int i=1 ; i<=N; i++){
        first[i]=arrN[i];
        // 꼴등보다 순위 높으면
        if(first[i]<=cur){
            // 앞의 선수들 탐색해서
            for(int j=1 ; j<i ; j++){
                // 이 선수보다 등수가 같거나 뒤에있으면 한칸씩 등수 떨구기
                if(first[j]>=first[i]) first[j]++;
                if(cur<first[j]) cur=first[j];
            }
        } 
        // 꼴찌 갱신
        else cur=arrN[i]; 
    }

    // 2차전 시작
    for(int i=1 ; i<=M ; i++) cin >> arrM[i];

    fill(last, last+101, 0);  

    // 등수 재정립
    for(int cur=M; cur>=1 ; cur--){
        for(int i=1 ; i<=N ; i++){
            if(first[i]==cur){ // 타겟 등수 선수를 발견하면
                last[i]=arrM[M-cur+1]; // 순위 넣어주고
                for(int j=1 ; j<=N ; j++){ // 순위 밀리는 선수들 찾기
                    if( i!=j && last[j]!=0 && last[j]>=last[i]) last[j]++;
                }
                break;
            }
        }
    }

    int result=1;
    
    // 1등부터 호출
    while(result!=4){
        for(int i=1 ; i<=N ; i++){
            if(last[i]==result){
                result++;
                cout << i << endl;
            }
        }
    }
}