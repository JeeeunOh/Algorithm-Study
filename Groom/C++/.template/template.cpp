#include <iostream>
#include <queue>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;

// pair의 second를 기준으로 정렬
bool compare(const pair<int, int> &a, const pair<int, int> &b)
{
    // a가 b보다 작으면 true여서 스왑X
    return (a.second < b.second); // 오름차순
    // return (a.second > b.second); // 내림차순
}

int main()
{
    int n, m, res = 0;
    // 큐
    queue<pair<int, int>> q;
    q.push(pair<int, int>(1, 1));
    cout << q.front() << q.back() << q.empty() << q.size();
    q.pop();

    // 스택
    stack<pair<int, int>> st;
    st.push(pair<int, int>(1, 1));
    cout << st.empty() << ' ' << st.size() << st.top() << endl;
    st.pop();

    // 벡터
    vector<pair<int, int>> v;
    v.push_back(make_pair(1, 2));

    cout << v.front() << v.back();
    v.clear();
    v.push_back();
    v.pop_back();
    v.at(1);

    sort(v.begin(), v.end(), less<>());    // 오름차순
    sort(v.begin(), v.end(), greater<>()); // 내림차순
    sort(v.begin(), v.end(), compare);
    min_element(v.begin(), v.end());
    max_element(v.begin(), v.end());
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