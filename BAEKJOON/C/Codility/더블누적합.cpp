// 60퍼, 시간복잡도에서 걸림 O(N2)

int solution(vector<int> &a) {
    int max=0;
    vector<int> sum(100002,0);

    sum[0]=0;
    for(int i=0 ; i<a.size(); i++){
        sum[i]=sum[i-1]+a[i];
    }

    for(int i=0; i<a.size(); i++){
        for(int j=i+1; j<a.size(); j++){
            for(int k=j+1; k<a.size(); k++){
                int cur = (sum[j-1]-sum[i]) + (sum[k-1]-sum[j]);
                // if(i==0 && j==3 && k==6)
                // cout << sum[j] << " " << sum[i+1] << " " << sum[k] << " " << sum[j+1] << '\n';
                // cout << cur << " " << i << " " << j << " " << k << '\n';
                if(max<cur) {
                    max=cur;
                    // cout << max << " " << i << " " << j << " " << k << '\n';
                }
            }
        }
    } 
    return max;
}

// 100프로, 왼쪽에서의 누적합과 오른쪽부터의 누적합을 구해준다. O(N)
int solution(vector<int> &A) {
    int len = A.size();
    int result = 0;
    vector<int> left_max(len);
    vector<int> right_max(len);
    
    if(A.size() < 4) return 0;
    
    for(int i = 1;  i < len - 1; i++)
        left_max[i] = max(left_max[i - 1] + A[i] , 0);
    
    for(int i = len - 1; i > 1; i--)
        right_max[i - 1] = max(right_max[i] + A[i - 1], 0);
        
    for(int i = 1; i < len - 1; i++)    //max값 위치를 i-1, i+1하는 이유는 Y값을 기준으로 더해야 되기 떄문에.
        result = max(left_max[i - 1] + right_max[i + 1], result);
    
    return result;
}