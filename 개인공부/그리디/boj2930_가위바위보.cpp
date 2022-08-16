#include <iostream>
#include <string>
using namespace std;

int main(){
    int n,r;
    char arr[3]={'S', 'P', 'R'}; // 가위 0, 보 1, 바위 2
    string sang, frd; // 상근이, 친구
    cin >> r >> sang >> n ; // 라운드 수, 상근이 조합, 친구 수

    int final=0;
    int MAX=0;

    while(n--){
        int temp=0;
        string frd;
        cin >> frd;
        
        for(int i=0 ; i<sang.length(); i++){
            int sangN, frdN;
            for(int j=0 ; j<3 ; j++){
                if(arr[j]==sang[i]) sangN=j;
                if(arr[j]==frd[i]) frd=j;
            }
            if(sangN-frdN==-1 || sangN-frdN==2) temp+=2;
            else if(sangN==frdN) temp+=1;
        }
        final+=temp;
        if(MAX<temp) MAX=temp; 
    }
    
    cout << final << '\n' << MAX << '\n';
}