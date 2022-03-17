#include <iostream>
#include <queue>
#include <functional> 
using namespace std;



int main(void){
    priority_queue<int, vector<int>, greater<int> > pq;
    int N, n;
    int sum = 0;

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> n;
        pq.push(n);  
    }

    while(pq.size() > 1) {
        int n1, n2;

        n1 = pq.top(), pq.pop();
        n2 = pq.top(), pq.pop();
        sum += (n1 + n2);
        pq.push(n1 + n2);
    }

    cout << sum << endl;
    return 0;
}