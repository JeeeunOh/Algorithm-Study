#include <string>
#include <vector>
#include <algorithm>
#include <climits> // long long의 최댓값을 이용합니다.
using namespace std;

long long solution(int n, vector<int> times) {
	long long answer = LLONG_MAX; // 자료형의 최댓값
	sort(times.begin(), times.end()); // 최대 심사 시간 구하기 위하여 정렬 함수를 실행합니다.
	long long start = 1;
	long long end = (long long)n * (long long)times[times.size() - 1]; // 최대 심사 시간 * n명
	long long mid, temp = 0;
	while (start <= end)
	{
		mid = (start + end) / 2; // 이분 탐색을 이용합니다.
		temp = 0; // mid 시간 동안 심사 가능한 사람 수
		for (int i = 0; i < times.size(); i++) {
		// 전체 시간/심사위원 각각 심사 시간의 합들이 심사 가능한 인원 수 입니다.
			temp += mid / times[i];
		}
		if (temp >= n) { // n명 이상 심사 가능한 시간일 때
			// 가능한 시간들 중 최솟값을 저장합니다.
			answer = min(answer, mid);
			end = mid - 1;
		}
		else start = mid + 1; 
	}
	return answer;
}