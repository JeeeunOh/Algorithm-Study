#include <iostream> 
using namespace std; 
int N, K; 

int main(void) { 
    ios_base::sync_with_stdio(0); 
    cin.tie(0); 
    cin >> N >> K; // N은 주어진 물병의 개수
    if (N <= K) { 
        cout << 0 << "\n"; 
        return 0; 
    } 

    int result; // result: 상점에서 구매한 물병의 개수
    
    for (result = 0; ; result++) { // 5. 4번에서 조건이 성립하지 않을 경우 1 ~ 4번을 반복해줍니다.
        int cnt = 0; // cnt: 들고 가는 물병
        int tempN = N; 
        while (tempN) { // 3. N이 0이 될 때까지 1번과 2번을 반복해줍니다.
            if (tempN % 2) cnt++; // 2. 1번에서 나머지가 발생한다면 합쳐지지 않은 물병이 존재한다는 것이므로 cnt를 1 추가해줍니다.
            tempN /= 2; // 1. 주어진 물병을 최대한 합칩니다. 즉, N을 2로 나눕니다.
        } 
        if (cnt <= K) break;  // 4. cnt의 개수가 K 이하일 경우 조건이 성립하므로 result를 출력해주고 프로그램을 종료합니다.
        N++; 
    } 
    
    cout << result << "\n"; 
    return 0; 
}

