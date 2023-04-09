#include <iostream>
using namespace std;

int main()
{
    int n=0;
    int max = 0;
    cin >> n;
    float arr[1000];
    float sum = 0;
    float avg;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        if (max < arr[i]) max = arr[i];
        sum += arr[i];
    }
    avg = (sum / max * 100) / n;

    cout << fixed;
    cout.precision(6);
    cout << avg << endl;
}
