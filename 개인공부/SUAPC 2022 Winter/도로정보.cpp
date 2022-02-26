#include <iostream>
using namespace std;

int abs(int a, int b){
    return a>b? a-b: b-a;
}


int main(){
    int N;
    string s;
    cin >> N;
    cin >> s;

    int res=0;

    int dpT[100001];
    int dpG[100001];
    int dpF[100001];
    int dpP[100001];

    dpT[0]=0;
    dpG[0]=0;
    dpF[0]=0;
    dpP[0]=0;

    for(int i=1 ; i<=s.length(); i++){
        char ch = s[i-1]; // 현재 탐색할 문자
        if(ch=='T') {
            dpT[i]=dpT[i-1]+1;
            dpG[i]=dpG[i-1];
            dpF[i]=dpF[i-1];
            dpP[i]=dpP[i-1];
        }
        if(ch=='G') {
            dpT[i]=dpT[i-1];
            dpG[i]=dpG[i-1]+1;
            dpF[i]=dpF[i-1];
            dpP[i]=dpP[i-1];
        }
        if(ch=='F') {
            dpT[i]=dpT[i-1];
            dpG[i]=dpG[i-1];
            dpF[i]=dpF[i-1]+1;
            dpP[i]=dpP[i-1];
        }
        if(ch=='P') {
            dpT[i]=dpT[i-1];
            dpG[i]=dpG[i-1];
            dpF[i]=dpF[i-1];
            dpP[i]=dpP[i-1]+1;
        }

        int j=1;

        while(j<i){
            if(abs(dpT[i], dpT[j-1])%3==0 && abs(dpG[i], dpG[j-1])%3==0 && abs(dpF[i], dpF[j-1])%3==0 && abs(dpP[i], dpP[j-1])%3==0) {
                    res++;
            }
            j+=3;
        }

    }

    cout << res;

}