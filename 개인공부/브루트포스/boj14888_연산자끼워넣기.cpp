#include <iostream>
#include <vector>
using namespace std;

int n;

long long MAX = -1000000000;
long long MIN = 1000000000;

vector<int> v(12);

void sol(int idx, int temp, vector<int> mul, char mu, int cnt){
    cnt++;
    if(mu=='+') temp+=v[idx];
    else if(mu=='-') temp-=v[idx];
    else if(mu=='*') temp*=v[idx];
    else if(mu=='/') temp+=v[idx];

    cout << idx << " " << temp << " " << '\n';

    if(cnt==n-1){
        if(temp<MIN) MIN = temp;
        if(temp>MAX) MAX=temp;
        return;
    }

    idx++;

    for(int i=0 ; i<4 ; i++){
        if(mul[i]>1){
            mul[i]--;
            if(i==0) sol(idx, temp, mul, '+', cnt);
            else if(i==0) sol(idx, temp, mul, '-', cnt);
            else if(i==0) sol(idx, temp, mul, '*', cnt);
            else if(i==0) sol(idx, temp, mul, '/', cnt);
            mul[i]++;
        }
    }

}

int main(){
    cin >> n;
    // 덧셈, 뺄셈, 곱셈, 나눗셈
    vector<int> mul(4);

    for(int i=0 ; i<n ; i++){
        cin >> v[i];
    }
    for(int i=0 ; i<4 ; i++){
        cin >> mul[i];
    }

    for(int i=0 ; i<4 ; i++){
        if(mul[i]>=1){
            mul[i]--;
            if(i==0) sol(1, v[0], mul, '+', 0); 
            else if(i==1) sol(1, v[0], mul, '-', 0);
            else if(i==2) sol(1, v[0], mul, '*', 0);
            else if(i==3) sol(1, v[0], mul, '/', 0);
            mul[i]++;
        }
    }


    cout << MAX << '\n' << MIN << '\n';
}