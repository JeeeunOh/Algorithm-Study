int solution(int k, vector<int> &a) {
    int temp=0;
    int res=0;

    for(int i=0 ; i<a.size(); i++){
        temp+=a[i];
        if(temp>=k){
            res++;
            temp=0;
        }
    }
    return res;
}