#include <iostream>
#include <cmath>
using namespace std;

int dx[]={-2,-1,1,2};
int dy[]={1,2,2,1};

int main(){
    int n,m;
    cin >> n >> m;
    
    // 세로 길이 1 이면 경우의 수 하나. 못 움직임
    if(n==1) cout << 1 << endl;
    else if (n==2) cout << min(4, (m+1)/2) << endl;
    else if (m<7) cout << min(4,m) << endl;
    else cout << m-7+5 << endl;
}