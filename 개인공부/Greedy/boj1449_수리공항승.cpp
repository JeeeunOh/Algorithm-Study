#include <iostream>
#include <algorithm>
using namespace std;

int N, L;
int pipe[1001];
bool taped[1001];

int main(void){
    cin >> N >> L;
    
    int result = 0;
    
    for (int i = 0; i < N; i++) cin >> pipe[i];
    
    sort(pipe, pipe + N); // 새는 파이프 오름차순
    
    for(int i=0; i<N; i++){
        if (!taped[pipe[i]]){
            for (int j = pipe[i]; j < min(pipe[i] + L, 1001); j++) taped[j] = true;
            result++;
        }
    }

    cout << result << "\n";
    return 0;
}