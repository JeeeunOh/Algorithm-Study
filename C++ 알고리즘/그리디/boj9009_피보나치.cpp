#include <iostream>
#include <vector>
using namespace std;


int main(){
    int pibo[43] = {1, 2};
	for (int i = 2; i < 43; ++i) pibo[i] = pibo[i - 1] + pibo[i - 2];

    int T, num;
	cin >> T ;

    for(int i=0 ; i<T ; i++){
        vector<int> ans; // 결과 반환
        cin >> num ;

        for(int j=42 ; j>=0 ; j--){ // 벡터 맨 뒷자리부터 탐색
            if(pibo[j]<=num) {
                num-=pibo[j];
                ans.push_back(pibo[j]);
            }
            if(num<0) break; // 합이 num이 되는 수열 다 찾았으므로 반복문 종료
        }

        // k=0에는 0값 들어있으므로 k=1까지 탐색해줌
        for(int k=ans.size()-1 ; k>=0 ; k--) cout<<ans[k]<<" "; 
        cout<<endl;
    }
    return 0;
}