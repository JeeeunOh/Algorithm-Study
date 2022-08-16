int solution(vector<int> &A) {
    int prefix[A.size()];
    prefix[0]=A[0];
    for(int i=1 ; i<A.size(); i++){
        prefix[i]=prefix[i-1]+A[i];
        // cout << prefix[i] << " ";
    }
    // cout << '\n';
    long long min = 1000000000;
    int res=0;

    for(int i=0 ; i<A.size(); i++){
        for(int j=i+2; j<A.size(); j++){
            int presum = prefix[j]-prefix[i];
            if(presum/(j-i)<min){
                min = presum/(j-i);
                // cout << presum/(j-i) << " " << i << " " << j << " " << min << '\n';
                res=i+1;
            }
        }
    }

    return res;
}