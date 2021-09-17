#include <iostream>
using namespace std;

long solution(int N, int A[], int B, int C) {
	// 개의 시험장, 응시자 수, 총감독관 감독 응시자 수, 부감독관 감동 응시자 수
	long ans = 0;
	for (int i = 0; i < N; i++) {
		A[i] -= B;
		ans++;
		if (A[i] > 0) {
			ans += A[i] / C;
			if (A[i]%C != 0) ans++;
		}
	}
	return ans;
}