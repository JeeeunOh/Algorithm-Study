#include <iostream>
using namespace std;

int main()
{
    int a, b, c;        //입력받을 3가지 변수 
    int arr[10] = { 0 };    //0으로 초기화 

    cin >> a >> b >> c;    // 숫자 3가지를 받습니다. 

    int result = a * b * c;

    //1의 자리를 얻어 옵니다.
    //resutl 가 0 이 되면 while문을 빠져나갑니다. 
    while (result != 0) {
        arr[result % 10] += 1;
        result /= 10;
    }

    //출력. 
    for (int i = 0; i < 10; i++) {
        cout << arr[i] << endl;
    }
    return 0;
}