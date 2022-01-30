#include<bits/stdc++.h>
using namespace std;

map<string, int> mp;
vector<string> v;
int N, M;

int main() {
    cin.tie(nullptr); ios::sync_with_stdio(false);
    cin >> N >> M;
    for(int i=0;i<N;++i) {
        string s; cin >> s;
        if(s.size() < M) continue;
        if(mp.find(s) == mp.end()) {
            mp[s] = 0;
            v.push_back(s);
        }
        mp[s]++;
    }
    sort(v.begin(), v.end(), [] (const string &a, const string &b) {
        if(a.size() == b.size() && mp[a] == mp[b]) return a<b;
        else if(mp[a] == mp[b]) return a.size() > b.size();
        return mp[a] > mp[b];
    });
    for(string &s:v) cout << s << '\n';
    return 0;
}