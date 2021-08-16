#include <iostream>
using namespace std;

int main()
{
    int h, m;
    cin >> h >> m;
    if (m >= 45) {
        m -= 45;
    }
    else {
        h -= 1;
        m = 60 - (45 - m);
    }
    cout << h << " " << m;

}
