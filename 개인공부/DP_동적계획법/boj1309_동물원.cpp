#include<iostream>
using namespace std;
 
#define MAX 100000 + 1
#define Moduler 9901

int N;
int DP[MAX][3];

int main(){
    cin >> N;
    
     DP[1][0] = DP[1][1] = DP[1][2] = 1;
 
    for(int i = 2; i <= N; i++)
    {
        DP[i][0] = (DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2]) % Moduler;
        DP[i][1] = (DP[i - 1][0] + DP[i - 1][2]) % Moduler;
        DP[i][2] = (DP[i - 1][0] + DP[i - 1][1]) % Moduler;
    }
 
    cout << (DP[N][0] + DP[N][1] + DP[N][2]) % Moduler << endl;
 
    return 0;
}