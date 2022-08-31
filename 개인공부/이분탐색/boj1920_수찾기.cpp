#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n,m, input;

bool sol(int left, int right, int target, vector<int> &arr){
    while(left<=right){
        int mid = (left+right)/2;

        if(arr[mid] == target){
            return true;
        } 
        if(arr[mid] < target){
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return false;
}

int main(){
    cin >> n;
    vector<int> a(n);

    for(int i=0 ; i<n ; i++) cin >> a[i];

    sort(a.begin(), a.end());

    cin >> m;

    while(m--){
        cin >> input;
        cout << sol(0, n-1, input, a) << '\n';
    }
}