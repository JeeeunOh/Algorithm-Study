#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
	int N;
	vector< pair<int, int> > v;
	vector<int> v1, v2;
	vector<vector<int> flag; //flag[i][0] = j, flag[i][1] = k ..  -> i 좌표에서 j, k .. 좌표로 갈 수 있다.
	
	cin >> N;

	if(N==1) {
		cout << "권병장님, 중대장님이 찾으십니다." << endl;
		return 0;
	}

	// 위치
	for(int i=1; i<=N; i++) {
		int a;
		cin>> a;
		v1.push_back(a);
	}

	// 사거리
	for(int i=1; i<=N-1; i++) {
		int a;
		cin>> a;
		v2.push_back(a);
	}

	// 위치 & 사거리 정렬
	for(int i=0; i<N-1; i++) v.push_back(make_pair(v1[i], v2[i])); 
	v.push_back(make_pair(v1[N-1], -1)); // N번째는 사거리 입력받지 않음.

	// 좌표 오름차순 정렬
	sort(v.begin(), v.end());

	int x=1; 

	while(x<N){ //N번째 사람에 도착할 때까지 반복
		vector<int> arr; // 현재 위치부터 도달할 수 있는 위치들 저장하기
		for(int i=x+1 ; i<=N ; i++ ){
		if(v[0][i]-v[0][x] <= v[1][x]){ // x -> i 까지 거리가 x의 사거리보다 작거나 같다면
		arr.push_back(i); // i를 x가 갈 수 있는 위치에 추가함.
		} else break; 
	}

}