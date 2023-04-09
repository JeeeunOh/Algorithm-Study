#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
    int T, N;
    cin >> T;

    for(int i=0 ; i<T ; i++){
        cin >> N;
        pair<int, int> per[100000];

        for(int j=0 ; j<N ; j++)
            cin >> per[j].first >> per[j].second;

        sort(per, per+N);

        int result = 1 ;
        int rank = per[0].second;

        for(int j=0 ; j<N ; j++){
            if(per[j].second < rank){
                result++;
                rank = per[j].second;
            }
        }
        cout << result << endl;
    }
    return 0;
}