#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int dx[4]={-1, 1, 0, 0};
int dy[4]={0,0,-1,1};

int main(){
    int n,l,r;
    cin >> n >> l >> r;
    vector<int> per(n+1, vector<int> v(n+1, 0));
    vector<int> visited(n+1, vector<int> v(n+1, -1));

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
            cin >> per[i][j];
        }
    }

    queue<pair<int, int>> q;

    int day=0;

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
            q.push({i,j});

            while(!q.empty()){
                auto cur = q.front();
                q.pop();
                int cx = cur.first;
                int cy = cur.second;
            }

        }
    }

    cout << day << '\n';


}