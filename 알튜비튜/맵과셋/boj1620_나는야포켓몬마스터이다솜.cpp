#include <iostream>
#include <map>

using namespace std;

int main(){
    int N,M;
    string input;
    map<string, int> name;
    map<int, string> number;

    cin >> N >> M;
    for(int i=1; i<=N ; i++){
        cin >> input;
        name[input] = i;
        number[i] = input;
    }
    for(int i=0 ; i<M ; i++){
        cin >> input;
        if(isdigit(input[0])) // 숫자 판단하는 함수
            cout << number[stoi(input)] << endl;
        else cout << name[input] << endl;
    }

}
