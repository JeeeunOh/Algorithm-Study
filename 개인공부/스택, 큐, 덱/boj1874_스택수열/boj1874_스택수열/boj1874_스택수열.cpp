#include <iostream>
#include <stack>
#include <vector>
using namespace std;
//push연산은 +로, pop 연산은 -

int main() {
    stack<int> s;
    vector<char> result;
    int cnt = 1;
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        while (cnt <= x) {
            s.push(cnt);
            cnt += 1;
            result.push_back('+');
        }
        if (s.top() == x) {
            s.pop();
            result.push_back('-');
        }
        else {
            cout << "NO";
            return 0;
        }
    }
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << '\n';
    }
}

/* 오른쪽으로 숫자 들어옴, 나갈때도 오른쪽부터 나감
+ 1 2 3 4
+  
+
+
- 1 2  /  3 4
-
+ 1 2 5 6  /  3 4
+
- 1 2 5  /  6  /  3 4
+ 1 2 5 7 8  /  6  / 3 4
+
- 
-
-
-
-*/