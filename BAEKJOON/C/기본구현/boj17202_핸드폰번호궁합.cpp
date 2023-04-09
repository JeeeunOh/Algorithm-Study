#include <stdio.h>

int main(){
    char n[17];
    int i,j,r=15;
    for(i=0; i<16; i+=2) {
        scanf(" %c", &n[i]);
        n[i]-=48;
    }
    for(i=1; i<16; i+=2) {
        scanf(" %c", &n[i]);
        n[i]-=48;
    }
    for(i=0; i<14; i++) {
        for(j=0; j<r; j++) {
            n[j]=(n[j]+n[j+1])%10;
        }
        r--;
    }
    printf("%d%d",n[0],n[1]);
}