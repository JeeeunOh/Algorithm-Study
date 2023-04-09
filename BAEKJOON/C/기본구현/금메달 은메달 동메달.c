#include <stdio.h>
#define MAX 100

int main(){
    int N, M;
    int i, j;
    int now;
    int first[MAX+1], last[MAX+1];
    
    scanf("%d %d", &N, &M);
    
    for(i=1;i<=N;++i){
        scanf("%d", &now);
        for(j=i;j>now;—j){
            first[j]=first[j-1];
        }
       first[now]=i;
    }
    
    for(i=1;i<=N;++i){
        last[i]=first[i];
    }
    
    for(i=1;i<=M;++i){
        scanf("%d", &now);
        for(j=i;j>now;—j){
            last[j]=last[j-1];
        }
      last[now]=last[i];
    }
    printf("%d\n%d\n%d\n", last[1], last[2], last[3]);
    return 0;
}