#include <iostream>
#include <algorithm>

using namespace std;
// 2-> 5 ,
//3 -> 9
//4 -> 13
int N;

void star(int num){
    if(num==1 || num==N){
        for(int i=0 ; i<N*4-3 ; i++){
            cout << '*';
        }
        cout << endl;
    }

}
int main(){
     cin >> N;
     for(int i=0 ; i<N*4-3 ; i++){
         star(i);
     }
     return 0;
}
