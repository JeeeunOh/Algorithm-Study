#include <iostream>
#include <vector>
using namespace std;

int ans=1;

int main(){
    vector<vector<int>> v;
    int N,M;
    cin >> N >> M; // 교육생 수, 친분관계수

    int arr[200001];

    for(int i=0 ; i<M ; i++){ // 기존 벡터 탐색해 나감.
        int a,b;
        int flag=0;
        cin >> a >> b;

        for(int i=0 ; i<v.size(); i++){
            for(int j=0 ; j<v[i].size(); j++){
                if(v[i][j]==a){
                    v[i].push_back(b);
                    flag=1;
                    break;
                } else if(v[i][j]==b){
                    v[i].push_back(a);
                    flag=1;
                    break;
                }
            }
        }

        if(flag==0) { // 새로운 줄기 만들기
            vector<int> v1;
            v1.push_back(a);
            v1.push_back(b);
            v.push_back(v1);
        }

    }

    for(int i=0 ; i<v.size(); i++){
        ans*=v[i].size();
    }

    ans%=1000000007;

    cout << ans << endl;
}