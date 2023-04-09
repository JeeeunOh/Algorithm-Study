int solution(vector<int> &a) {
    int headsum[a.size()+1];
    int tailsum[a.size()+1];

    headsum[0]=0;
    tailsum[a.size()]=0;

    for(int i=1 ; i<=a.size() ; i++){
        headsum[i]=headsum[i-1]+a[i-1];
        // cout << headsum[i] << " ";
    }
    // cout << '\n';

    for(int i=a.size()-1; i>=0 ; i--){
        tailsum[i]=tailsum[i+1]+a[i];
    }

    // for(int i=1 ; i<=a.size() ; i++){
    //     cout << tailsum[i] << " ";
    // }
    // cout << '\n';

    int min=100000000;
    
    for(int i=1; i<a.size(); i++){
        int temp = headsum[i]-tailsum[i];
        if(temp<0) temp*=(-1);
        if(min>temp) {
            // cout << i << " " << headsum[i] <<  " " << tailsum[i] << '\n';
            min = temp;
        }
    }
    
    return min;
}