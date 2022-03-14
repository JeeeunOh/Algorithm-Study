#include <stdio.h>
 
int main() {
    
    int N;
    int Dp[1001]={0,};
    Dp[1]=1;
    scanf("%d",&N);
    
    for(int i=1;i<=N;i++){
        int num;
        scanf("%d",&num);
        
        if(Dp[i]==0)
            continue;
            
        for(int j=1;(j<=num) && (i+j<=1000);j++){
            if(Dp[i+j]>Dp[i]+1 || Dp[i+j]==0)
                Dp[i+j]=Dp[i]+1;
        }        
    }    
    
    if(Dp[N]==0) printf("-1\n");
    else printf("%d\n",Dp[N]-1);
 
    return 0;
}
