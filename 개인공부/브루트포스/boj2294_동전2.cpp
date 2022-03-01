#include <iostream>
#define MAX 110
using namespace std;
 
int N, K;
int Arr[MAX];
int DP[100001];
// F[K] = Min(F[K] , F[K - X] + 1)
 
int Min(int A, int B) { 
    return A<B? A:B;
}
 
int main(){
    cin >> N >> K;
    for (int i = 1; i <= N; i++)cin >> Arr[i];

    for (int i = 1; i <= K; i++) DP[i] = 100001;

    for (int i = 1; i <= N; i++) DP[Arr[i]] = 1;

    DP[0] = 0;

    for (int i = 1; i <= N; i++)
        for (int j = Arr[i]; j <= K; j++)
            DP[j] = Min(DP[j], DP[j - Arr[i]] + 1); 
 
    if (DP[K] == 100001) cout << -1 << endl;
    else cout << DP[K] << endl;
 
    return 0;
}