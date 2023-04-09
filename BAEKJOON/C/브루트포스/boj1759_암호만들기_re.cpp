#include <iostream>
#include <algorithm>
using namespace std;

int l,c;
int res[50];
char arr[50];

void dfs(int idx,int len){

    if(len==l){
        int mo=0;
        int ja=0;

        for(int i=0;i<len;i++){
            if(arr[res[i]]=='a'||arr[res[i]]=='e'||arr[res[i]]=='i'||arr[res[i]]=='o'||arr[res[i]]=='u') mo++;
            else ja++;
        }

        if(mo>=1&&ja>=2){
            for(int i=0;i<len;i++){
                printf("%c",arr[res[i]]);
            }
            printf("\n");
        }
        else return;
    }

    else{
        for(int i=idx;i<c;i++){
            res[len]=i;
            dfs(i+1,len+1);
        }
    }
}


int main() {
    cin >> l >> c;

    for(int i=0;i<c;i++) cin >> arr[i];

    sort(arr,arr+c);
    dfs(0,0);

    return 0;
}