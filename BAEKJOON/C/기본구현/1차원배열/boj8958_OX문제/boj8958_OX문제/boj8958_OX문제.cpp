#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int p;
        cin >> p;
        float arr[1000];
        float sum = 0, cnt = 0;
        for (int i = 0; i < p; i++) {
            cin >> arr[i];
            sum += arr[i];
        }
        sum /= p;
        
        for (int i = 0; i < p; i++) {
            if (arr[i] > sum) cnt++;
        }
        float ans = cnt / p *100;

        cout << fixed;
        cout.precision(3);
        cout << ans <<"%"<<  endl;
    }
}
