#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;
int main() {
	int n;
	int arr[10][10];
	cin >> n;
	for(int i=0 ; i<n ; i++){
		for(int j=0 ; j<n ; j++){
			cin>> arr[i][j];
		}
	}
	
	vector<int> ans;
	int dx[4] = {-1, 1, 0, 0};
	int dy[4] = {0, 0, -1, 1};
	
	for(int i=0 ; i<n ; i++){
		for(int j=0 ; j<n ; j++){
			if(arr[i][j]){
				queue<pair<int, int>> q;
				q.push(pair<int,int>(i,j));
				int size = 0;
				while(!q.empty()){
					int cx = q.front().first;
					int cy = q.front().second;
					q.pop();
					
					for(int k=0; k<4; k++){
						int nx = cx+dx[k];
						int ny = cy+dy[k];
						
						if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]){
							q.push(pair<int,int>(nx,ny));
							size++;
							arr[nx][ny]=0;
						}
					}
				}
				ans.push_back(size);
			}
		}
	}
	
	cout << ans.size() << endl ;
	
	sort(ans.begin(), ans.end());
	
	for(int i=0 ; i<ans.size(); i++){
		cout << ans[i] << ' ';
	}
	
	return 0;
}