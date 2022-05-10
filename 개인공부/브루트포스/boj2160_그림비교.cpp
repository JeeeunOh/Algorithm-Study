#include <iostream>
using namespace std;

int main(){
    int N;
    int min=35; // 모든 칸이 다 다르다고 가정
    char picture[51][5][7]; // k번째 그림들 받기
    int a,b;
    cin >> N;

    for(int k=0 ; k<N ; k++){
        for(int i=0 ; i<5 ; i++){
            string s;
            cin >> s;
            for(int j=0 ; j<7; j++){
                picture[k][i][j]=s[j];
            }
        }
    }

    for(int k=0 ; k<N-1 ; k++){ // k번째 그림과
        for(int i=k+1 ; i<N ; i++){ // i번째 그림 비교히기
            int temp=0;
            for(int x=0 ; x<5 ; x++){
                for(int y=0 ; y<7 ; y++){
                    if(picture[k][x][y]!=picture[i][x][y]) temp++;
                }
            }
            if(temp<=min) {
                min = temp;
                a=k+1; 
                b=i+1;
            }
        }
    }

    cout << a << " " << b << '\n';
}