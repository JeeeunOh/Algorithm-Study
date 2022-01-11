#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int v[1<<20];
int N, k;

//ex.N=8, k=2

int main(){
    cin >> N ;
    for(int i=0 ; i<N ; i++) cin >> v[i];

    cin >> k;

    int person=N/2; // 시작 사람수 -> 4

    // person>=k까지 person/=2 하면서 반복
    while(person>=k){
        int d = N/person; // 정렬하는 거리는 ' 전체 치킨집 수 / 사람수 ' 로 할당 -> 8/4=2
        // i=0,2,4,6
        for(int i=0; i<N ; i+=d) sort(v+i,v+i+d);
        person/=2;
    }

    for(int i=0 ; i<N; i++){
        cout << v[i] <<" ";
    }

    return 0;
}