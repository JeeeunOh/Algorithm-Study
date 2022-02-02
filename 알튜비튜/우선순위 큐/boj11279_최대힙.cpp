#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> heap;

//empty
bool empty() { return heap.size() == 1; }

//push
void push(int num) {
    int idx = heap.size(); //이번에 push할 데이터의 인덱스
    heap.push_back(num);

    while (idx != 1 && heap[idx] > heap[idx / 2]) {
        swap(heap[idx], heap[idx / 2]); //하위노드와 상위노드의 값을 바꿈
        idx /= 2; //상위노드로 이동
    }
}

//pop
int pop() {
    int item = heap[1];
    swap(heap[1], heap[heap.size() - 1]); //힙의 맨 마지막 값과 바꿈
    heap.pop_back(); //데이터 제거

    int parent = 1, child = 2;
    while (child < heap.size()) {
        //만약 오른쪽 하위노드가 존재하면 왼쪽 하위노드와 값을 비교하고, 상위노드와 비교할 하위노드 갱신
        if (child + 1 < heap.size() && heap[child] < heap[child + 1])
            child++;
        if (heap[parent] >= heap[child]) //나보다 큰 하위노드가 없다
            break;
        swap(heap[parent], heap[child]); //상위노드와 하위노드의 값을 바꿈
        parent = child;
        child = parent * 2;
    }
    return item;
}

int main() {
    //입출력 속도 향상
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, x;
    priority_queue<int> pq;
    heap.push_back(0); //인덱스가 1부터 시작하도록

    cin >> n;
    while (n--) {
        cin >> x;
        if (x == 0) {
            if (pq.empty())
                cout << 0 << '\n';
            else {
                cout << pq.top() << '\n';
                pq.pop();
            }
        } else
            pq.push(x);
    }
}