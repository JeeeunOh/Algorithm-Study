#include<iostream>
#include<queue>
#include<functional>
using namespace std;
int n,a;
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
            if(q.size()>n)
                q.pop();
        }
    }
    cout<<-q.top();
}

