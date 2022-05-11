#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// 부등호 검사
bool check(vector<int> &perm, vector<char> &vec){
    for(int i=0; i<vec.size(); i++){
        if(vec[i]=='<' && perm[i] > perm[i+1]) return false;
        if(vec[i]=='>' && perm[i] < perm[i+1]) return false;
    }
    return true;
}

int main(void){
    int k;
    cin >> k;
    
    vector<char> vec(k); // 부등호 저장
    for(int i=0; i<k; i++){
        cin >> vec[i];
    }
    
    vector<int> small(k+1); // 가장 작은 수 k+1 개 저장 : 0,1,2, ..
    vector<int> big(k+1); // 가장 큰 수 k+1 개 저장 : 9,8,7, ..
    
    for(int i=0; i<=k; i++){
        small[i] = i;
        big[i] = 9-i;
    }
    
    // 작은 수 순열 구하기
    do{
        if(check(small, vec)) break;
    }while(next_permutation(small.begin(),small.end()));
    
    // 큰 수 순열 구하기
    do{
        if(check(big, vec)) break;
    }while(prev_permutation(big.begin(), big.end()));
    
    // 최대 정수 출력
    for(int i=0; i<big.size(); i++){
        cout << big[i];
    }
    cout << '\n';
    
    // 최소 정수 출력
    for(int i=0; i<small.size(); i++){
        cout << small[i];
    }
}