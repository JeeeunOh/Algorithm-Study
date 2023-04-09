#include <vector>
#include <iostream>
using namespace std;

int main(){
    int inputE, inputS, inputM;
    cin >> inputE >> inputS >> inputM;

    int answer=1;

    while(true){
        if((answer-inputE)%15==0 && (answer-inputS)%28==0 && (answer-inputM)%19==0){ 
            break;
        }
        answer++;
    }

    cout << answer << endl;

}