#include <iostream>
using namespace std;

int main(){
    int arr[1000][2]; // 0: 입력받은배열 , 1:현재까지 증가수열 길이 최대값
    int n;
    int max=1; // 증가수열 길이 최대값 1로 초기화
    cin >> n;

    for(int i=0 ; i<n; i++){
        cin >> arr[i][0]; // 배열 입력받기
        arr[i][1]=1;
        if(i>=1){// 두번째 입력 받은 수부터
            for(int j=0 ; j<i ; j++){ // 바로 이전 수의 증가 수열 탐색
                if(arr[j][0] < arr[i][0]){ // 탐색하는 수가 현재 수보다 작으면서
                    if(arr[j][1]+1 > arr[i][1]) { // 탐색 수가 자신의 최대증가수열에 포함된다면
                        arr[i][1] = arr[j][1]+1; // 증가수열 길이를 탐색수+1로 정정해줌.
                    }
                }
            }
        }
        if(max<arr[i][1]) max=arr[i][1];
    }
    cout << max << endl;
    //커밋용로그
}