#include <string>
#include <algorithm>
#include <unordered_set>
#include <cmath>

using namespace std;

int checkPrime(int n){
    if(n==0 || n==1) return 0;
    for(int i=2; i<=sqrt(n); i++) 
        if(n%i == 0) return 0;
    return 1;
}

int solution(string numbers){
    
    unordered_set<int> uos;
    int x=0;
    
    sort(numbers.begin(), numbers.end());
    do{
        for(int i=1 ; i<numbers.size()+1 ; i++){
            x=stoi(numbers.substr(0,i));
            if(checkPrime(x)) uos.insert(x);
        }
    } while(next_permutation(numbers.begin(), numbers.end()));
    
    return uos.size();
}