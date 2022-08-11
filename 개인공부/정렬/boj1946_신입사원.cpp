#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct person{
    int score1;
    int score2;
};

// 첫번째 시험 등수 작은 순서 ( 높은 순서 ) 대로 정렬
bool compare(person a, person b){
    if(a.score1!=b.score1) return a.score1 < b.score1;
}

int main(){
    int n;
    cin >> n;
    while(n--){
        int t;
        cin >> t;

        vector<person> v(t);

        for(int i=0 ; i<t ; i++){
            cin >> v[i].score1 >> v[i].score2;
        }

        sort(v.begin(), v.end(), compare);

        int res=1;
        int rank = v[0].score2;

        for(int i=0 ; i<t ; i++){
            if(v[i].score2 < rank ){
                res++;
                rank = v[i].score2;
            }
        }

        cout << res << '\n';
    }
}