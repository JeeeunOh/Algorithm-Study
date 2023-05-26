#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(pair<int, int>a, pair<int, int>b){
    if (a.second == b.second) {
		return  a.first < b.first;
	}
	else {
		return a.second < b.second;
	}
}

int main(){
    int n;
    vector<pair<int, int>> v;

    cin >> n;

    for(int i=0 ; i<n ; i++){
        int a,b;
        cin >> a >> b;
        v.push_back(make_pair(a, b));
    }

    sort(v.begin(), v.end(), compare);

    cout << v;

    int fin = v[0].second;
    int ans=1;

    for(int i=1 ; v.size(); i++){
        if(fin <= v[i].first+1){
            fin = v[i].second;
            ans++;
        }
    }

    cout << ans << endl;
}