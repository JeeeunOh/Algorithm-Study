//8:46 -> 9:02
#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int abs(int a, int b){ // 절댓값 구하는 함수
    return a>b? a-b:b-a;
}

int main(){
    int arr[8];
    int N, m=0;
    cin >> N;
    for(int i=0 ; i<N ; i++) cin >> arr[i]; 

    sort(arr, arr+N);

    do{
        int temp=0;
        for(int i=0 ; i<N-1 ; i++){
            temp+=abs(arr[i], arr[i+1]);
        }
        if(m<temp) m=temp;

	} while(next_permutation(arr, arr+N));

    cout << m;
}