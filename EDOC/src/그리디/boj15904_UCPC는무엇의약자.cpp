#include <iostream>
#include <cstring>
using namespace std;

int main(){
    char input[1000];
    scanf("%[^\n]s", input);

    char ans[] = {"UCPC"};
    int j=0; // UCPC 의 0 index부터 탐색해보자
    int cnt=0;

    for(int i=0 ; i<strlen(input); i++){
        if(input[i]==ans[j]){
            j++; cnt++;
        }
    }
    if(cnt==4) cout << "I love UCPC" << endl;
    else cout << "I hate UCPC" << endl;

    return 0;
}
