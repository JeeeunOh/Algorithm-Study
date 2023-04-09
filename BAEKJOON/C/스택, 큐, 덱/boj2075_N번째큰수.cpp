#include<iostream>
#include<queue>
#include<functional>
using namespace std;
int n,a;
//큐에 있는 모든 원소 중에서 가장 큰 값이 Top을 유지하도록 설계되어있음.
// 내부적으로 Heap
// 함수 -> push, pop, top, empty, size

priority_queue<long long> q;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin>>n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin>>a;
            q.push(-a);
            if(q.size()>n) q.pop();
        }
    }
    cout<<-q.top();
}

