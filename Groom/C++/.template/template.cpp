#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main(){
    int n, m, res=0;
    queue<pair<int, int>> q;

    q.push(pair<int,int>(1,1));

    vector<pair<int, int>> v;
    v.push_back(make_pair(a, b));

    cin >> n >> m;
    cout << q.front() ;
    cout << res << '\n';
}

// #include <algorithm>

// unique(v.begin(), v.end()) , v.end()) : 중복 제거하고 난 후 끝 주소
// find(v.begin(), v.end()) : 값이 있다면, 찾기
// min_element(시작 주소, 종료 주소); / max_element(시작 주소, 종료 주소) : 가장 작거나 가장 큰 값
// reverse(시작 주소, 종료 주소); : 객체 거꾸로 만들기
// prev_permutation(시작 주소 , 종료 주소); next_permutation(시작 주소 , 종료 주소); : 이전, 다음 순열 구하기

// #include <bitset>

// to_string() : bitset 변수를 string으로 변환
// count() : 1의 개수 return

// #include <numeric>

// accumulate() : 배열의 모든 합 구하기