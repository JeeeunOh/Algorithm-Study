#include <iostream>
#include <vector>
using namespace std;

long long solution(int n, vector<int> dist, vector<int> price) {
	// 도시 수, 도로 길이, 도로 리터당 가격, 
	long long ans = 0;
	long long min = price[0];
	for (int i = 0; i < n - 1; i++) {
		if (min > price[i]) min = price[i];
		ans += min * dist[i];
	}
	return ans;
}