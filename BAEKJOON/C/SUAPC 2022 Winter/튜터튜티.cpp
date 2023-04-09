#include <iostream>
#include <vector>
using namespace std;

int ans=1;

int main(){
    vector<vector<int>> v;
    int arr[200001];
    int level[200001];

    int N,M;
    cin >> N >> M; // 교육생 수, 친분관계수

    fill(arr, arr+200001, -1);

    for(int i=0 ; i<M ; i++){
        int a,b;
        int flag=0;

        cin >> a >> b;

        if(arr[a]>=0){ //a와 연결된 벡터 있으면
            v[arr[a]].push_back(b);
            arr[b]=arr[a];
        } else if(arr[b]>=0){ //b와 연결된 벡터 있으면
            v[arr[b]].push_back(a);
            arr[b]=arr[a];
        } else { //a, b와 연결된 벡터가 없으면
            vector<int> v1;
            v1.push_back(a);
            v1.push_back(b);
            
            v.push_back(v1);
            arr[a]=v.size()-1;
            arr[b]=v.size()-1;
        }
    }

    for(int i=0 ; i<v.size(); i++){
        ans*=v[i].size();
    }

    ans%=1000000007;

    cout << ans << endl;
}