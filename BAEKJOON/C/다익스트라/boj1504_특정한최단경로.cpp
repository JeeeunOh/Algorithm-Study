#include <iostream>
#include <vector>
#include <queue>
using namespace std;
typedef pair<int, int> pii;

int n, m;
const int INF = 2e6;
vector<vector<pii> > adj;

vector<int> dijkstra(int s) {
    vector<int> dist(n+1, INF);
    priority_queue<pii, vector<pii>, greater<pii> > pq;
    dist[s] = 0;
    pq.push({dist[s], s});
    while (!pq.empty()) {
        auto [d, u] = pq.top(); pq.pop();
        if (d > dist[u]) continue;
        for (auto [v, w]: adj[u]) {
            if (dist[v] > dist[u] + w) {
                dist[v] = dist[u] + w;
                pq.push({dist[v], v});
            }
        }
    }
    return dist;
}

int main(void) {
    cin >> n >> m;
    adj.resize(n+1);

    while (m--) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }
    int a, b;
    cin >> a >> b;
    vector<int> dist1 = dijkstra(a);
    vector<int> dist2 = dijkstra(b);
    int ret = dist1[b] + min(dist1[1] + dist2[n], dist1[n] + dist2[1]);
    cout << (ret >= INF ? -1 : ret);
    return 0;
}